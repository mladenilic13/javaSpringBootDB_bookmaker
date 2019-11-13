
package kladionicaii.kladionica.servicezDTOImplementationClasses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kladionicaii.kladionica.daoClasses.UserDao;
import kladionicaii.kladionica.daoClasses.AccountDao;
import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.pojoClasses.Account;
import kladionicaii.kladionica.servicezDTOClasses.RegistrationServiceDTO;

@Service
public class RegistrationServiceDTOImpl implements RegistrationServiceDTO {

	private UserDao userRepository;
	private AccountDao accountRepository;
	
	@Autowired
	public RegistrationServiceDTOImpl(UserDao userRepository,
			AccountDao accountRepository) {
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
	}
	
	@Override
	@Transactional
	public User save(User userRegistration) {
		User user = new User(userRegistration.getName(), userRegistration.getEmail(), userRegistration.getPass());
		userRepository.save(user);
		Account account = new Account("registration", BigDecimal.valueOf(5), LocalDateTime.now(), user);
		accountRepository.save(account);
		return userRegistration;
	}

}
