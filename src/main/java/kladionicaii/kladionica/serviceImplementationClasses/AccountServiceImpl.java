package kladionicaii.kladionica.serviceImplementationClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kladionicaii.kladionica.daoClasses.AccountDao;
import kladionicaii.kladionica.pojoClasses.Account;
import kladionicaii.kladionica.serviceClasses.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountDao accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(Integer id) {
		Optional<Account> result = accountRepository.findById(id);
		Account account = null;
		if (result.isPresent()) {
			account = result.get();
		} else {
			System.out.println("no result");
		}
		return account;
	}
	
	@Override
	public Account save(Account account) {
		accountRepository.save(account);
		return account;
	}

	@Override
	public Account update(Account account) {
		Integer tempid = account.getId();
		Optional<Account> result = accountRepository.findById(tempid);
		Account updateAccount = null;
		if (result.isPresent()) {
			updateAccount = result.get();
			updateAccount.setPurpose(account.getPurpose());
			updateAccount.setAmount(account.getAmount());
			updateAccount.setTime(account.getTime());
			updateAccount.setUser(account.getUser());
			updateAccount.setCurrency(account.getCurrency());
			updateAccount.setRate(account.getRate());
			accountRepository.save(updateAccount);
		} else {
			System.out.println("no result");
		}
		return updateAccount;
	}
	
	@Override
	public void deleteById(Integer id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void deleteByObject(Account account) {
		accountRepository.delete(account);
	}

}
