package kladionicaii.kladionica;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import kladionicaii.kladionica.daoClasses.UserDao;
import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.restClasses.UserRestController;
import kladionicaii.kladionica.serviceClasses.UserService;

// for junit 4
@RunWith(SpringRunner.class)
// seek main config class and starts the server
//@SpringBootTest
// for with server test with random port (usefull for testing environments)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// for without the server
//@AutoConfigureMockMvc
// for without the server but just the web layer
//@WebMvcTest
// for testing jpa
//@DataJpaTest
public class BasicTests {

	// for testing repository layer
//	@MockBean
	@Autowired
	private UserDao userDao;
	
	// for testing service layer
//	@MockBean
	@Autowired
	private UserService userService;
	
	// for testing controller layer
	@Autowired
    private UserRestController userRestController;
	
	// check if controllers are created
	@Test
	public void controllerTest() {
		assertThat(userRestController).isNotNull();
	}
	
	// for integration tests
	@Autowired
    private TestRestTemplate restTemplate;

	// gets port allocated at runtime
	@LocalServerPort
    private int port;
	
	// using basic json
	@Test
    public void returnUserTest() throws Exception {
		
		String address = "http://localhost:" + port + "/api/user/23";
		String actual = this.restTemplate.getForObject(address, String.class);
		
		String expected = "{\r\n" + 
				"    \"id\": 23,\r\n" + 
				"    \"name\": \"mladen\",\r\n" + 
				"    \"email\": \"mladenilic79@gmail.com\",\r\n" + 
				"    \"pass\": \"sekira\"\r\n" + 
				"}";
		
		JSONAssert.assertEquals(expected, actual, false);
    }
	
	// using jackson object mapper
	@Test
    public void returnUserTest2() throws Exception {
		
		String address = "http://localhost:" + port + "/api/user/23";
		String actual = this.restTemplate.getForObject(address, String.class);
		
		User user = new User(23, "mladen", "mladenilic79@gmail.com", "sekira");
		
		ObjectMapper mapper = new ObjectMapper();
		
		String expected1 = mapper.writeValueAsString(user);
		String expected2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		
		JSONAssert.assertEquals(expected1, actual, false);
		JSONAssert.assertEquals(expected2, actual, false);
    }
	
	// using basic json
	@Test
    public void returnUsersTest() throws Exception {
		
		String address = "http://localhost:" + port + "/api/user";
		String actual = this.restTemplate.getForObject(address, String.class);
		
		String expected = "[\r\n" + 
				"    {\r\n" + 
				"        \"id\": 23,\r\n" + 
				"        \"name\": \"mladen\",\r\n" + 
				"        \"email\": \"mladenilic79@gmail.com\",\r\n" + 
				"        \"pass\": \"sekira\"\r\n" + 
				"    }\r\n" + 
				"]";
		
		JSONAssert.assertEquals(expected, actual, false);
    }

	// using jackson object mapper
	@Test
    public void returnUsersTest2() throws Exception {
		
		String address = "http://localhost:" + port + "/api/user";
		String actual = this.restTemplate.getForObject(address, String.class);
		
		User user = new User(23, "mladen", "mladenilic79@gmail.com", "sekira");
		List<User> users = new ArrayList<>();
		users.add(user);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String expected1 = mapper.writeValueAsString(users);
		String expected2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
		
		JSONAssert.assertEquals(expected1, actual, false);
		JSONAssert.assertEquals(expected2, actual, false);
    }
	
	@Test
    public void addUserTest() throws Exception {
		
		String baseUrl = "http://localhost:" + port + "/api/user/save";
		URI uri = new URI(baseUrl);
		
		User alex = new User("alex", "sima@alex", "passbre");
		// request without header
        HttpEntity<User> request = new HttpEntity<>(alex);
        
        /*
        // or full with headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        // string
        HttpEntity<String> entity1 = new HttpEntity<String>("hello", headers);
        // or object
        HttpEntity<User> entity2 = new HttpEntity<User>(alex, headers);
        */
        
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
    }
	
	@Test
    public void updateUserTest() throws Exception {
		
		String baseUrl = "http://localhost:" + port + "/api/user/update";
		URI uri = new URI(baseUrl);
		
		User alex = new User(23, "mladen", "mladenilic79@gmail.com", "sekira");
		// request without header
        HttpEntity<User> request = new HttpEntity<>(alex);
		
        ResponseEntity<String> result = this.restTemplate.exchange(uri, HttpMethod.PUT, request, String.class);
        Assert.assertEquals(200, result.getStatusCodeValue());
        
	}

}
