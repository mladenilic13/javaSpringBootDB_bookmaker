package kladionicaii.kladionica.serviceImplementationClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.dsl.BooleanExpression;

import kladionicaii.kladionica.daoClasses.UserDao;
import kladionicaii.kladionica.exceptions.UserNotFoundException;
import kladionicaii.kladionica.pojoClasses.QUser;
import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.serviceClasses.UserService;
import kladionicaii.kladionica.utility.CollectionConversion;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userRepository;
	
	@Autowired
	public UserServiceImpl(UserDao userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer id) {
		Optional<User> result = userRepository.findById(id);
		
		// exception handling
		User user = null;
		if (result.isPresent()) {
			user = result.get();
		} else {
			// pass some data if needed id in this case
			throw new UserNotFoundException(id);
		}
		return user;
	}
	
	@Override
	public User save(User user) {
		userRepository.save(user);
		return user;
	}
	
	@Override
	public User update(User user) {
		Integer tempid = user.getId();
		Optional<User> result = userRepository.findById(tempid);
		User updateUser = null;
		if (result.isPresent()) {
			updateUser = result.get();
			updateUser.setName(user.getName());
			updateUser.setEmail(user.getEmail());
			updateUser.setPass(user.getPass());
			userRepository.save(updateUser);
		} else {
			System.out.println("no result");
		}
		return updateUser;
	}
	
	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public void deleteByObject(User user) {
		userRepository.delete(user);
		
	}
	
	// querydsl content
	public Iterable<User> findAllQdsl() {
		QUser user = QUser.user;
		BooleanExpression name = user.name.eq("mladen");
		BooleanExpression pass = user.pass.eq("sekira");
		Iterable<User> users =  userRepository.findAll(name.and(pass));
		return users;
	}
	
}
