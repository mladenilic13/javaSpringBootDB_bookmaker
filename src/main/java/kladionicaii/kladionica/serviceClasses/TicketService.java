package kladionicaii.kladionica.serviceClasses;

import java.util.List;

import kladionicaii.kladionica.pojoClasses.Ticket;

public interface TicketService {
	
	public List<Ticket> findAll();
	  
	public Ticket findById(Integer id);

	public Ticket save(Ticket ticket);

	public Ticket update(Ticket ticket);

	public void deleteById(Integer id);
	
	public void deleteByObject(Ticket ticket);

}
