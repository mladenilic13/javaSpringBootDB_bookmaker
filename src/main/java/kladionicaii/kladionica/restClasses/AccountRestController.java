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

import kladionicaii.kladionica.pojoClasses.Account;
import kladionicaii.kladionica.serviceClasses.AccountService;

@RestController
@RequestMapping("/api")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;

	@GetMapping("/account")
	public List<Account> findAll() {
		return accountService.findAll();
	}
	
	@GetMapping("/account/{accountid}")
	public Account getAccount(@PathVariable Integer accountid) {
		Account account = accountService.findById(accountid);
		return account;
	}
	
	@PostMapping("/account/save")
	public Account addAccount(@RequestBody Account account) {
		accountService.save(account);
		return account;
	}
	
	@PutMapping("/account/update")
	public Account updateAccount(@RequestBody Account account) {
		Account updateAccount = accountService.update(account);
		return updateAccount;
	}
	
	@DeleteMapping("/account/delete/{accountid}")
	public void deleteAccount(@PathVariable Integer accountid) {
		accountService.deleteById(accountid);
	}
	
	@DeleteMapping("/account/delete")
	public void deleteAccountObject(@RequestBody Account account) {
		accountService.deleteByObject(account);
	}
	
}
