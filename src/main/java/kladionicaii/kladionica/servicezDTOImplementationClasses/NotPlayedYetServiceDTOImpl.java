
package kladionicaii.kladionica.servicezDTOImplementationClasses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kladionicaii.kladionica.daoClasses.GameDao;
import kladionicaii.kladionica.pojoClasses.Game;
import kladionicaii.kladionica.pojoDTOClasses.NotPlayedYetDTO;
import kladionicaii.kladionica.servicezDTOClasses.NotPlayedYetServiceDTO;

@Service
public class NotPlayedYetServiceDTOImpl implements NotPlayedYetServiceDTO {

	private GameDao gameRepository;
	
	@Autowired
	public NotPlayedYetServiceDTOImpl(GameDao gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	@Override
	public List<NotPlayedYetDTO> notPlayedYet() {
		List<Game> games = this.gameRepository.findAll();
		List<NotPlayedYetDTO> notPlayedYet = new ArrayList<>();
		for (Game game : games) {
			if (game.getFlag()==null) {
				NotPlayedYetDTO notPlayedYetDTO = new NotPlayedYetDTO();
				notPlayedYetDTO.setGameId(game.getId());
				notPlayedYetDTO.setDesignation(game.getDesignation());
				notPlayedYetDTO.setTime(game.getTime());
				notPlayedYet.add(notPlayedYetDTO);
			}
		}
		return notPlayedYet;
	}
	
}
