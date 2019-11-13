package kladionicaii.kladionica.serviceSecurityClasses;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kladionicaii.kladionica.daoClasses.UserDao;
import kladionicaii.kladionica.daoClasses.OperaterDao;
import kladionicaii.kladionica.pojoClasses.User;
import kladionicaii.kladionica.pojoClasses.Operater;

@Service
public class LoginService {

	public static String key = "somepassword";
	
	UserDao userRepository;
	OperaterDao operaterRepository;
	
	@Autowired
	public LoginService(UserDao userRepository, 
			OperaterDao operaterRepository) {
		this.userRepository = userRepository;
		this.operaterRepository = operaterRepository;
	}
	
	public String allowAccessUser(User user) {
		User user2 = userRepository.findByNameAndPass(user.getName(), 
				user.getPass());
		if(user2!=null) {
			String jwts = Jwts.builder()
					.setIssuer(user.getName())
					.claim("id", user.getId())
					.claim("scope", "customer")
					.setSubject("booking")
					.setAudience("bookmaker")
//					.setExpiration(new Date(2145819380))
					.setIssuedAt(Date.from(Instant.now()))
					.signWith(SignatureAlgorithm.HS512, key)
					.compact();
			return jwts;
		} else {
			return null;
		}
	}
	
	public String allowAccessOperater(Operater operater) {
		Operater operater2 = operaterRepository.findByNameAndPass(operater.getName(), 
				operater.getPass());
		if(operater2!=null) {
			String jwts = Jwts.builder()
					.setIssuer(operater.getName())
					.claim("id", operater.getId())
					.claim("scope", "admin")
					.setSubject("booking")
					.setAudience("bookmaker")
//					.setExpiration(new Date(2145819380))
					.setIssuedAt(Date.from(Instant.now()))
					.signWith(SignatureAlgorithm.HS512, key)
					.compact();
			return jwts;
		} else {
			return null;
		}
	}
	
	public Jws<Claims> checkToken(String token) {
		Jws<Claims> jws = Jwts.parser().setSigningKey(LoginService.key).parseClaimsJws(token);
		return jws;
	}
	
}
