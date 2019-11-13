package kladionicaii.kladionica.restClasses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kladionicaii.kladionica.pojoClasses.Ticket;
import kladionicaii.kladionica.serviceClasses.TicketService;

@RestController
@RequestMapping("/api")
public class TicketRestController {
	
	@Autowired
	private TicketService ticketService;

	@GetMapping("/ticket")
	public List<Ticket> findAll() {
		return ticketService.findAll();
	}
	
	@GetMapping("/ticket/{ticketid}")
	public Ticket getTicket(@PathVariable Integer ticketid) {
		Ticket ticket = ticketService.findById(ticketid);
		return ticket;
	}
	
	@PostMapping("/ticket/save")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		ticketService.save(ticket);
		return ticket;
	}
	
	@PutMapping("/ticket/update")
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		Ticket updateTicket = ticketService.update(ticket);
		return updateTicket;
	}
	
	@DeleteMapping("/ticket/delete/{ticketid}")
	public void deleteTicket(@PathVariable Integer ticketid) {
		ticketService.deleteById(ticketid);
	}
	
	@DeleteMapping("/ticket/delete")
	public void deleteTicketObject(@RequestBody Ticket ticket) {
		ticketService.deleteByObject(ticket);
	}
	
}
