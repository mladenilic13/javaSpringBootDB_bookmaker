
package kladionicaii.kladionica.servicezDTOClasses;

import java.util.List;

import kladionicaii.kladionica.pojoDTOClasses.SearchInputDTO;
import kladionicaii.kladionica.pojoDTOClasses.SearchOutputDTO;

public interface SearchTransactionsServiceDTO {
	
	public List<SearchOutputDTO> search(SearchInputDTO searchInputDTO);

	public SearchInputDTO customInput();
	
}
