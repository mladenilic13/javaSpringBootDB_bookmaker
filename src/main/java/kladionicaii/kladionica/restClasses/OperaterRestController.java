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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kladionicaii.kladionica.pojoClasses.Operater;
import kladionicaii.kladionica.serviceClasses.OperaterService;
import kladionicaii.kladionica.serviceSecurityClasses.LoginService;

// @RestController combines @Controller and @ResponseBody annotations 
// that results in web requests returning data rather than a view
// @ResponseBody means the returned String is the response, not a view name
@RestController
// url start
@RequestMapping("/api")
public class OperaterRestController {
	
	@Autowired
	private OperaterService operaterService;
	@Autowired
	private LoginService loginService;
	
	// equivalent to @RequestMapping(value="/orders", method=RequestMethod.GET)
	@GetMapping("/operater")
	public List<Operater> findAll() {
		return operaterService.findAll();
	}
	
	@GetMapping("/operater/{operaterid}")
	public Operater getOperater(@PathVariable Integer operaterid) {
		Operater operater = operaterService.findById(operaterid);
		return operater;
	}
	
	// equivalent to @RequestMapping(value="/orders", method=RequestMethod.POST)
	@PostMapping("/operater/save")
	// @RequestBody indicates method parameter should be bound to the body of the
	// web request, method expects the following content from request in JSON format
	public Operater addOperater(@RequestBody Operater operater) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
//		operater.setId(0);
		operaterService.save(operater);
		return operater;
	}

	//????
	// equivalent to @RequestMapping(value="/orders{id}", method=RequestMethod.PUT)
	@PutMapping("/operater/update/{operaterid}/{operatername}")
	public Operater updateOperater1(@PathVariable Integer operaterid, @PathVariable String operatername, @PathVariable String operaterpassword) {
		Operater updateOperater = operaterService.update1(operaterid, operatername, operaterpassword);
		return updateOperater;
	}
	
	@PutMapping("/operater/update")
	public Operater updateOperater2(@RequestBody Operater operater) {
		Operater updateOperater = operaterService.update2(operater);
		return updateOperater;
	}
	
	// equivalent to @RequestMapping(value="/orders{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/operater/delete/{operaterid}")
	public void deleteOperater(@PathVariable Integer operaterid) {
		operaterService.deleteById(operaterid);
	}
	
	@DeleteMapping("/operater/delete")
	public void deleteOperaterObject(@RequestBody Operater operater) {
		operaterService.deleteByObject(operater);
	}
	
	// localhost:8080/demo/add?name=sima&email=someemail
	// localhost:8080/demo/add?name=sima
	@PostMapping("/operater/saveonline")
	public Operater addOperaterOnline(@RequestParam String name) {
		Operater operater = new Operater();
		operater.setName(name);
		operaterService.save(operater);
		return operater;
	}
	
	@PostMapping("/operater/login")
	public String getToken(@RequestBody Operater operater) {
		return loginService.allowAccessOperater(operater);
	}

}
