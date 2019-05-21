
package kladionicaii.kladionica.serviceSecurityClasses;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Component
public class FilterService implements Filter {

	@Autowired
	LoginService loginService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		// both
		if(httpRequest.getRequestURI().contains("/user/login")  
				|| httpRequest.getRequestURI().contains("/operater/login")
//				|| httpRequest.getRequestURI().contains("/loginkorisnik")
//				|| httpRequest.getRequestURI().contains("/loginoperater")
				|| httpRequest.getRequestURI().contains("/notplayedyet")
				|| httpRequest.getRequestURI().contains("/registration") )
		{
			chain.doFilter(request, response);
			return;
		}
		
		// add if token exists
		String token = httpRequest.getHeader("authorization");
		
		// user
		if(httpRequest.getRequestURI().contains("/deposit")
				|| httpRequest.getRequestURI().contains("/withdrawal")
				|| httpRequest.getRequestURI().contains("/buyticket")
				|| httpRequest.getRequestURI().contains("/searchtransactions") )
		{
			Jws<Claims> jws = loginService.checkToken(token);
			String scope = (String) jws.getBody().get("scope");
			if(scope.equals("customer")) {
				// check for what this is used for
//				String korisnikNaziv = jws.getBody().getSubject();
//				httpRequest.setAttribute("korisnikNaziv", korisnikNaziv);
				chain.doFilter(request, response);
				return;
			} else {
				httpResponse.setStatus(401);
				return;
			}
		}

		// operater
		if(httpRequest.getRequestURI().contains("/user")
				|| httpRequest.getRequestURI().contains("/operater")
				|| httpRequest.getRequestURI().contains("/account")
				|| httpRequest.getRequestURI().contains("/ticket")
				|| httpRequest.getRequestURI().contains("/game") )
		{
			Jws<Claims> jws = loginService.checkToken(token);
			String scope = (String) jws.getBody().get("scope");
			if(scope.equals("admin")) {
				// check for what this is used for
//				String korisnikNaziv = jws.getBody().getSubject();
//				httpRequest.setAttribute("korisnikNaziv", korisnikNaziv);
				chain.doFilter(request, response);
				return;
			} else {
				httpResponse.setStatus(401);
				return;
			}
		} 

	}

}
