
package kladionicaii.kladionica.servicezDTOImplementationClasses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kladionicaii.kladionica.daoClasses.AccountDao;
import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.pojoClasses.Account;
import kladionicaii.kladionica.pojoDTOClasses.SearchInputDTO;
import kladionicaii.kladionica.pojoDTOClasses.SearchOutputDTO;
import kladionicaii.kladionica.servicezDTOClasses.SearchTransactionsServiceDTO;

@Service
public class SearchTransactionsServiceDTOImpl implements SearchTransactionsServiceDTO {

	private AccountDao accountRepository;
	
	@Autowired
	public SearchTransactionsServiceDTOImpl(AccountDao accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public List<SearchOutputDTO> search(SearchInputDTO searchInputDTO) {
		
		User user = searchInputDTO.getUser();
		LocalDateTime sinceTime = searchInputDTO.getSinceTime();
		LocalDateTime tillTime = searchInputDTO.getTillTime();
		
		List<Account> accountList = accountRepository.findByUserAndTimeBetween(user, sinceTime, tillTime);
		List<SearchOutputDTO> searchOutputDTOList = new ArrayList<>();
		
		for(Account account : accountList) {
			SearchOutputDTO searcOutputDTO = new SearchOutputDTO();
			searcOutputDTO.setAccountId(account.getId());
			searcOutputDTO.setAmount(account.getAmount());
			searcOutputDTO.setTime(account.getTime());
			searcOutputDTO.setPurpose(account.getPurpose());
			searcOutputDTO.setCurrency(account.getCurrency());
			searcOutputDTO.setRate(account.getRate());
			searchOutputDTOList.add(searcOutputDTO);
		}
		
		return searchOutputDTOList;
	}

	@Override
	public SearchInputDTO customInput() {
		User user = new User();
		user.setId(23);
		user.setEmail("mladenilic@gmail.com");
		user.setName("mladen");
		user.setPass("sekira");
		LocalDateTime time1 = LocalDateTime.now();
		LocalDateTime time2 = LocalDateTime.now();
		SearchInputDTO searchInputDTO = new SearchInputDTO();
		searchInputDTO.setUser(user);
		searchInputDTO.setSinceTime(time1);
		searchInputDTO.setTillTime(time2);
		return searchInputDTO;
	}

}
