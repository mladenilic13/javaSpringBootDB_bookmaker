
package kladionicaii.kladionica.servicezDTOImplementationClasses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kladionicaii.kladionica.daoClasses.UserDao;
import kladionicaii.kladionica.daoClasses.AccountDao;
import kladionicaii.kladionica.daoClasses.TicketDao;
import kladionicaii.kladionica.daoClasses.GameDao;
import kladionicaii.kladionica.daoClasses.GameTicketDao;
import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.pojoClasses.Account;
import kladionicaii.kladionica.pojoClasses.Ticket;
import kladionicaii.kladionica.pojoClasses.Game;
import kladionicaii.kladionica.pojoClasses.GameTicket;
import kladionicaii.kladionica.pojoDTOClasses.BuyTicketDTO;
import kladionicaii.kladionica.servicezDTOClasses.BuyTicketServiceDTO;

@Service
public class BuyTicketServiceDTOImpl implements BuyTicketServiceDTO {

	private GameTicketDao gameTicketRepository;
	
	private AccountDao accountRepository;
	
	private TicketDao ticketRepository;
	
	private UserDao userRepository;
	
	private GameDao gameRepository;
	
	@Autowired
	public BuyTicketServiceDTOImpl(GameTicketDao gameTicketRepository,
			AccountDao accountRepository, TicketDao ticketRepository, UserDao userRepository,
			GameDao gameRepository) {
		this.gameTicketRepository = gameTicketRepository;
		this.accountRepository = accountRepository;
		this.ticketRepository = ticketRepository;
		this.userRepository = userRepository;
		this.gameRepository = gameRepository;
	}

	@Override
	@Transactional
	public BuyTicketDTO buyTicket(BuyTicketDTO buyTicketDTO) {
		
		// receive data
		Integer userId = buyTicketDTO.getUserId();
		BigDecimal amount = buyTicketDTO.getAmount();
		Integer[] arrayGameId = buyTicketDTO.getArrayGameId();
		Integer[] arrayPrediction = buyTicketDTO.getArrayPrediction();

		Optional<User> result = userRepository.findById(userId);
		User user = null;
		if (result.isPresent()) {
			user = result.get();
		} else {
			System.out.println("no result");
		}

		// array to arraylist
		ArrayList<Game> arrayListGames = new ArrayList<>();
		for (Integer gameId : arrayGameId) {
			Optional<Game> result2 = gameRepository.findById(gameId);
			Game game = null;
			if (result2.isPresent()) {
				game = result2.get();
				arrayListGames.add(game);
			} else {
				System.out.println("no result");
			}
		}

		// create ticket
		Ticket ticket = new Ticket(amount, user);
		ticketRepository.save(ticket);
		
		// create transfer for account
		Account account = new Account("buy", amount, LocalDateTime.now(), user);
		accountRepository.save(account);
		
		// create gameTicket objects
		for (int i=0; i<arrayListGames.size(); i++) {
			Game game = arrayListGames.get(i);
			Integer prediction = arrayPrediction[i];
			GameTicket gameTicket = new GameTicket(prediction, ticket, game);
			gameTicketRepository.save(gameTicket);
		}

		return buyTicketDTO;
	}

	

	// test
	@Override
	public BuyTicketDTO customOutput() {
		
		Integer userId = 1;
		BigDecimal bigDecimal = BigDecimal.valueOf(333);
		
		List<GameTicket> list = gameTicketRepository.findAll();
		
		Integer[] arrayIdGame = new Integer[3];
		arrayIdGame[0] = list.get(0).getGame().getId();
		arrayIdGame[1] = list.get(1).getGame().getId();
		arrayIdGame[2] = list.get(2).getGame().getId();
		
		Integer[] arrayPredictions = new Integer[3];
		arrayPredictions[0] = list.get(0).getPrediction();
		arrayPredictions[1] = list.get(1).getPrediction();
		arrayPredictions[2] = list.get(2).getPrediction();
		
		BuyTicketDTO buyTicketDTO = new BuyTicketDTO(userId, bigDecimal,
				arrayIdGame, arrayPredictions);
		
		return buyTicketDTO;
	}

}
