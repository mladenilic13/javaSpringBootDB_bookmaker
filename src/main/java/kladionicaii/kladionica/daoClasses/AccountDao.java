package kladionicaii.kladionica.daoClasses;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.pojoClasses.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{
	
	List<Account> findByUserAndTimeBetween(User user,
			LocalDateTime sinceTime, LocalDateTime tillTime);
	
}
