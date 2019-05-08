package kladionicaii.kladionica.customClasses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kladionicaii.kladionica.daoClasses.AccountDao;
import kladionicaii.kladionica.daoClasses.TicketDao;
import kladionicaii.kladionica.daoClasses.GameDao;
import kladionicaii.kladionica.daoClasses.GameTicketDao;
import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.serviceSEmailClasses.EmailService;
import kladionicaii.kladionica.pojoClasses.Account;
import kladionicaii.kladionica.pojoClasses.EmailObject;
import kladionicaii.kladionica.pojoClasses.Ticket;
import kladionicaii.kladionica.pojoClasses.Game;
import kladionicaii.kladionica.pojoClasses.GameTicket;

@Component
public class Scheduling {
	
	private GameDao gameRepository;
	private TicketDao ticketRepository;
	private GameTicketDao gameTicketRepository;
	private AccountDao accountRepository;
	private JavaMailSender javaMailSender;
	private EmailService emailService;
	
	@Autowired
	public Scheduling(GameDao utakmicaRepository, TicketDao tiketRepository,
			GameTicketDao utakmicaTiketRepository, AccountDao racunRepository, 
			JavaMailSender javaMailSender, EmailService emailService) {
		this.gameRepository = utakmicaRepository;
		this.ticketRepository = tiketRepository;
		this.gameTicketRepository = utakmicaTiketRepository;
		this.accountRepository = racunRepository;
		this.javaMailSender = javaMailSender;
		this.emailService = emailService;
	}
	
	// simple mail message
	private void sendSimple(String text, String email) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(email); 
        message.setSubject("results"); 
        message.setText(text);
        javaMailSender.send(message);
	}
	
	// mime mail message 
    private void sendMime(String text, String email) throws MessagingException {
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("results");
        helper.setFrom("mladenilic79@gmail.com");
        helper.setTo(email);
        helper.setText(text);
        javaMailSender.send(mimeMessage);
	}
	
    // mime mail message using template
    public void sendMimeTemplate(EmailObject emailObject) {
    	MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// MimeMessageHelper is decorator for MimeMessage
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
	            messageHelper.setFrom("electrohhh@gmail.com");
	            messageHelper.setTo(emailObject.getEmail());
	            messageHelper.setSubject(emailObject.getSubject());
	            String content = emailService.build(emailObject);
	            messageHelper.setText(content, true);
			}
    	};
    	javaMailSender.send(messagePreparator);
//    	this.javaMailSender.send(messagePreparator);
    }
    
	@Transactional
	public void reward(BigDecimal amount, User user) {
		Account account = new Account("reward", amount, LocalDateTime.now(), user);
		accountRepository.save(account);
	}
	
	// set flag to games
	@Scheduled(fixedDelay=1000)
	public void setFlag() {
		
		Random random = new Random();
		List<Game> games = gameRepository.findAll();
		
		for(Game game : games) {
			if(game.getTime().isBefore(LocalDateTime.now())) {
				if(game.getFlag() == null) {
					game.setFlag(random.nextInt(3));
			        gameRepository.save(game);
				}
			}
		}
	}

//	@Scheduled(cron=" 5 3 15 * * ?")
	@Scheduled(fixedDelay=30000)
	public void scheduleMethod() throws MessagingException {
		processing();
	}
	
	public void processing() throws MessagingException {
		
		// unprocessed tickets
		List<Ticket> tickets = ticketRepository.findByProcessed(0);
		
		System.out.println();
		System.out.println("list of unprocessed tickets " + tickets.toString());
		
		for(Ticket ticket : tickets) {

			System.out.println();
			System.out.println("    ticket in question " + ticket.toString());

			int ticketSize = 0;
			int numOfPlayedGames = 0;
			int numOfHits = 0;

			BigDecimal valueOfTicket = ticket.getAmount();
			BigDecimal reward = valueOfTicket;

			System.out.println("    basic ticket value " + reward);
			
			// all tips connected to this ticket
			List<GameTicket> gameTickets = gameTicketRepository.findByTicket(ticket);
			
			System.out.println("    all gameTickets for this tiket " + gameTickets.toString());
			
			for(GameTicket gameTicket : gameTickets) {
				
				System.out.println("        gameTicket in question " + gameTicket.getId());
				
				// count games on one ticket
				ticketSize++;
				
				System.out.println("        add to size of ticket");
				
				// check if game is played for this tip
				if(gameTicket.getGame().getFlag() != null) {
					numOfPlayedGames++;
					
					System.out.println("        add to number of played games");
					
					// check if it is a hit
					if(gameTicket.getPrediction()==gameTicket.getGame().getFlag()) {
						numOfHits++;
						// calculate reward
						reward = reward.multiply(BigDecimal.valueOf(1.5));
						
						System.out.println("        add to number of hits");
					}
				}
			}
		
			System.out.println("    ticket size total " + ticketSize);
			System.out.println("    number of played games " + numOfPlayedGames);
			System.out.println("    number of hits " + numOfHits);
			
			if(ticketSize == numOfPlayedGames) {
				
				// process game
				ticket.setProcessed(1);
				ticketRepository.save(ticket);
				
				System.out.println("    processing of ticket");
				
				// send emails
				
				if(ticketSize != numOfHits) {
					String text = "from total of " + ticketSize + 
							" of games you had " + numOfHits + 
							" hits. more like next time.";
//					sendSimple(text, ticket.getUser().getEmail());
//					sendMime(text, ticket.getUser().getEmail());
					
					EmailObject emailObject = 
							new EmailObject(ticket.getUser().getEmail(),
									"games results", text);
					sendMimeTemplate(emailObject);
					
					System.out.println("    " + text);
					
				} else if (ticketSize == numOfHits) {
					String text = "from total of " + ticketSize + 
							" of games you had " + numOfHits + " hits." +
							" Congratulations your reward is " + reward + " eura.";
//					sendSimplel(text, ticket.getUser().getEmail());
//					sendMime(text, ticket.getUser().getEmail());
					
					EmailObject emailObject = 
							new EmailObject(ticket.getUser().getEmail(),
									"games results", text);
					sendMimeTemplate(emailObject);
					
					System.out.println("    " + text);
					
					// pay reward
					reward(reward, ticket.getUser());
					
					System.out.println("    reward is payed " + reward);
				}	
			}	
		}
		System.out.println();
	}
}
