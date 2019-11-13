package kladionicaii.kladionica.serviceClasses;

import java.util.List;

import kladionicaii.kladionica.pojoClasses.User;

public interface UserService {
	
	public List<User> findAll();
	  
	public User findById(Integer id);

	public User save(User user);
	
	public User update(User user);

	public void deleteById(Integer id);
	
	public void deleteByObject(User user);

}
