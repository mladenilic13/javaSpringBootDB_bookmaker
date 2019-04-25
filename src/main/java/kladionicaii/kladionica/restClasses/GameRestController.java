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

import kladionicaii.kladionica.pojoClasses.Game;
import kladionicaii.kladionica.serviceClasses.GameService;

@RestController
@RequestMapping("/api")
public class GameRestController {
	
	@Autowired
	private GameService gameService;

	@GetMapping("/game")
	public List<Game> findAll() {
		return gameService.findAll();
	}
	
	@GetMapping("/game/{gameid}")
	public Game getGame(@PathVariable Integer gameid) {
		Game game = gameService.findById(gameid);
		return game;
	}
	
	@PostMapping("/game/save")
	public Game addGame(@RequestBody Game game) {
		gameService.save(game);
		return game;
	}
	
	@PutMapping("/game/update")
	public Game updateGame(@RequestBody Game game) {
		Game updateGame = gameService.update(game);
		return updateGame;
	}
	
	@DeleteMapping("/game/delete/{gameid}")
	public void deleteGame(@PathVariable Integer gameid) {
		gameService.deleteById(gameid);
	}
	
	@DeleteMapping("/game/delete")
	public void deleteGameObject(@RequestBody Game game) {
		gameService.deleteByObject(game);
	}
	
}
