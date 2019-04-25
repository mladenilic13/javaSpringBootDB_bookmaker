package kladionicaii.kladionica.daoClasses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kladionicaii.kladionica.pojoClasses.Ticket;
import kladionicaii.kladionica.pojoClasses.GameTicket;

public interface GameTicketDao extends JpaRepository<GameTicket, Integer>{
	
	List<GameTicket> findByTicket(Ticket ticket);
	
}
