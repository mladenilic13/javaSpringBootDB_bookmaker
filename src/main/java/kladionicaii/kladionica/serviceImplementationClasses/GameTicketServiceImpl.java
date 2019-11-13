package kladionicaii.kladionica.serviceImplementationClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kladionicaii.kladionica.daoClasses.GameTicketDao;
import kladionicaii.kladionica.pojoClasses.GameTicket;
import kladionicaii.kladionica.serviceClasses.GameTicketService;

@Service
public class GameTicketServiceImpl implements GameTicketService {

	private GameTicketDao gameTicketRepository;

	@Autowired
	public GameTicketServiceImpl(GameTicketDao gameTicketRepository) {
		this.gameTicketRepository = gameTicketRepository;
	}

	@Override
	public List<GameTicket> findAll() {
		return gameTicketRepository.findAll();
	}

	@Override
	public GameTicket findById(Integer id) {
		Optional<GameTicket> result = gameTicketRepository.findById(id);
		GameTicket gameTicket = null;
		if (result.isPresent()) {
			gameTicket = result.get();
		} else {
			System.out.println("no result");
		}
		return gameTicket;
	}
	
	@Override
	public GameTicket save(GameTicket gameTicket) {
		gameTicketRepository.save(gameTicket);
		return gameTicket;
	}

	@Override
	public GameTicket update(GameTicket gameTicket) {
		Integer tempid = gameTicket.getId();
		Optional<GameTicket> result = gameTicketRepository.findById(tempid);
		GameTicket updateGameTicket = null;
		if (result.isPresent()) {
			updateGameTicket = result.get();
			updateGameTicket.setPrediction(gameTicket.getPrediction());
			updateGameTicket.setTicket(gameTicket.getTicket());
			updateGameTicket.setGame(gameTicket.getGame());
			gameTicketRepository.save(updateGameTicket);
		} else {
			System.out.println("no result");
		}
		return updateGameTicket;
	}
	
	@Override
	public void deleteById(Integer id) {
		gameTicketRepository.deleteById(id);
	}

	@Override
	public void deleteByObject(GameTicket gameTiket) {
		gameTicketRepository.delete(gameTiket);
	}

}
