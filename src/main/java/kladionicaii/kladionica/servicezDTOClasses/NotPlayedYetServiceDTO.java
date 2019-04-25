
package kladionicaii.kladionica.servicezDTOClasses;

import java.util.List;

import kladionicaii.kladionica.pojoDTOClasses.NotPlayedYetDTO;

public interface NotPlayedYetServiceDTO {
	
	// transferring from db to user
	public List<NotPlayedYetDTO> notPlayedYet();
	  
}
