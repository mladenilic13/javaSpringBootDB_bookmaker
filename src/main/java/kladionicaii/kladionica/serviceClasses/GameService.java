package kladionicaii.kladionica.serviceClasses;

import java.util.List;

import kladionicaii.kladionica.pojoClasses.Game;

public interface GameService {
	
	public List<Game> findAll();
	  
	public Game findById(Integer id);

	public Game save(Game game);

	public Game update(Game game);

	public void deleteById(Integer id);
	
	public void deleteByObject(Game game);

}
