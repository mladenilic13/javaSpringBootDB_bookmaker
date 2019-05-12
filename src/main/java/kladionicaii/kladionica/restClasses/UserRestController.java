package kladionicaii.kladionica.restClasses;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.serviceClasses.UserService;
import kladionicaii.kladionica.serviceImplementationClasses.UserServiceImpl;
import kladionicaii.kladionica.serviceSecurityClasses.LoginService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	// only for querydsl (can go through service interface also if needed)
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserService userService;
	@Autowired
	private LoginService loginService;

	@GetMapping("/user")
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/user/{userid}")
	public User getUser(@PathVariable Integer userid) {
		User user = userService.findById(userid);
		return user;
	}
	
	// @Valid or @Validated
	@PostMapping("/user/save")
	public User addUser(@Validated @RequestBody User user) {
		userService.save(user);
		return user;
	}
	
	// validation using BindingResult
	@PostMapping("/user/save2")
	public String addUser2(@Valid @RequestBody User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "error";
        } else {
        	userService.save(user);
            return "ok";
        }
	}
	
	// validation using ResponseEntity
	@PostMapping("/user/save3")
	public ResponseEntity<String> addUser3(@Valid @RequestBody User user) {
		userService.save(user);
		return ResponseEntity.ok("User is valid");
	}
	
	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user) {
		User updateUser = userService.update(user);
		return updateUser;
	}
	
	@DeleteMapping("/user/delete/{userid}")
	public void deleteUser(@PathVariable Integer userid) {
		userService.deleteById(userid);
	}
	
	@DeleteMapping("/user/delete")
	public void deleteUserObject(@RequestBody User user) {
		userService.deleteByObject(user);
	}
	
	@PostMapping("/user/login")
	public String getToken(@RequestBody User user) {
		return loginService.allowAccessUser(user);
	}
	
	// querydsl
	@GetMapping("/user/findallqdsl")
	public Iterable<User> findAllQdsl() {
		return userServiceImpl.findAllQdsl();
	}
	
}
