package kladionicaii.kladionica.serviceClasses;

import java.util.List;

import kladionicaii.kladionica.pojoClasses.Account;

public interface AccountService {
	
	public List<Account> findAll();
	  
	public Account findById(Integer id);

	public Account save(Account account);

	public Account update(Account account);

	public void deleteById(Integer id);
	
	public void deleteByObject(Account account);

}
