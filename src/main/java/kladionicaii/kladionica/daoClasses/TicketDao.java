package kladionicaii.kladionica.daoClasses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kladionicaii.kladionica.pojoClasses.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Integer>{
	
	 List<Ticket> findByProcessed(Integer processed);

}
