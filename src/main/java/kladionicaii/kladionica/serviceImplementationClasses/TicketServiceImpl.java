package kladionicaii.kladionica.serviceImplementationClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kladionicaii.kladionica.daoClasses.TicketDao;
import kladionicaii.kladionica.pojoClasses.Ticket;
import kladionicaii.kladionica.serviceClasses.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketDao ticketRepository;
	
	@Autowired
	public TicketServiceImpl(TicketDao ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket findById(Integer id) {
		Optional<Ticket> result = ticketRepository.findById(id);
		Ticket ticket = null;
		if (result.isPresent()) {
			ticket = result.get();
		} else {
			System.out.println("no result");
		}
		return ticket;
	}
	
	@Override
	public Ticket save(Ticket ticket) {
		ticketRepository.save(ticket);
		return ticket;
	}

	@Override
	public Ticket update(Ticket ticket) {
		Integer tempid = ticket.getId();
		Optional<Ticket> result = ticketRepository.findById(tempid);
		Ticket updateTicket = null;
		if (result.isPresent()) {
			updateTicket = result.get();
			updateTicket.setAmount(ticket.getAmount());
			updateTicket.setUser(ticket.getUser());
			ticketRepository.save(updateTicket);
		} else {
			System.out.println("no result");
		}
		return updateTicket;
	}
	
	@Override
	public void deleteById(Integer id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public void deleteByObject(Ticket ticket) {
		ticketRepository.delete(ticket);
	}

}
