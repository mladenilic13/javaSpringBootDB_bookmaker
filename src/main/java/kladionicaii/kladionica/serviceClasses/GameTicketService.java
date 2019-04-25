package kladionicaii.kladionica.serviceClasses;

import java.util.List;

import kladionicaii.kladionica.pojoClasses.GameTicket;

public interface GameTicketService {
	
	public List<GameTicket> findAll();
	  
	public GameTicket findById(Integer id);

	public GameTicket save(GameTicket gameTicket);

	public GameTicket update(GameTicket gameTicket);

	public void deleteById(Integer id);
	
	public void deleteByObject(GameTicket gameTicket);

}
