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

import kladionicaii.kladionica.pojoClasses.GameTicket;
import kladionicaii.kladionica.serviceClasses.GameTicketService;

@RestController
@RequestMapping("/api")
public class GameTicketRestController {
	
	@Autowired
	private GameTicketService gameTicketService;

	@GetMapping("/gameticket")
	public List<GameTicket> findAll() {
		return gameTicketService.findAll();
	}
	
	@GetMapping("/gameticket/{gameticketid}")
	public GameTicket getGameTicket(@PathVariable Integer gameticketid) {
		GameTicket gameTiket = gameTicketService.findById(gameticketid);
		return gameTiket;
	}
	
	@PostMapping("/gameticket/save")
	public GameTicket addGameTicket(@RequestBody GameTicket gameticket) {
		gameTicketService.save(gameticket);
		return gameticket;
	}
	
	@PutMapping("/gameticket/update")
	public GameTicket updateGameTicket(@RequestBody GameTicket gameticket) {
		GameTicket updateGameTicket = gameTicketService.update(gameticket);
		return updateGameTicket;
	}
	
	@DeleteMapping("/gameticket/delete/{gameticketid}")
	public void deleteGameTicket(@PathVariable Integer gameticketid) {
		gameTicketService.deleteById(gameticketid);
	}
	
	@DeleteMapping("/gameticket/delete")
	public void deleteGameTicketObject(@RequestBody GameTicket gameticket) {
		gameTicketService.deleteByObject(gameticket);
	}
	
}
