package kladionicaii.kladionica.serviceImplementationClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kladionicaii.kladionica.daoClasses.GameDao;
import kladionicaii.kladionica.pojoClasses.Game;
import kladionicaii.kladionica.serviceClasses.GameService;

@Service
public class GameServiceImpl implements GameService {

	private GameDao gameRepository;
	
	@Autowired
	public GameServiceImpl(GameDao gameRepository) {
		this.gameRepository = gameRepository;
	}

	@Override
	public List<Game> findAll() {
		return gameRepository.findAll();
	}

	@Override
	public Game findById(Integer id) {
		Optional<Game> result = gameRepository.findById(id);
		Game game = null;
		if (result.isPresent()) {
			game = result.get();
		} else {
			System.out.println("no result");
		}
		return game;
	}
	
	@Override
	public Game save(Game game) {
		gameRepository.save(game);
		return game;
	}

	@Override
	public Game update(Game game) {
		Integer tempid = game.getId();
		Optional<Game> result = gameRepository.findById(tempid);
		Game updateGame = null;
		if (result.isPresent()) {
			updateGame = result.get();
			updateGame.setDesignation(game.getDesignation());
			updateGame.setFlag(game.getFlag());
			updateGame.setTime(game.getTime());
			updateGame.setOperater(game.getOperater());
			gameRepository.save(updateGame);
		} else {
			System.out.println("no result");
		}
		return updateGame;
	}
	
	@Override
	public void deleteById(Integer id) {
		gameRepository.deleteById(id);
	}

	@Override
	public void deleteByObject(Game game) {
		gameRepository.delete(game);
	}

}
