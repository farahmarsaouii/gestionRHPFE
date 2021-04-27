package ch.newaccess.backendproject.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.newaccess.backendproject.entities.AppUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticatinFilter extends UsernamePasswordAuthenticationFilter {
private AuthenticationManager authenticationManager;


public JWTAuthenticatinFilter(AuthenticationManager authenticationManager) {
	super();
	this.authenticationManager = authenticationManager;
}
@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		AppUser appUser =null;
		/****************************** errrrrrrrrrreurr*/////
		try {
			ObjectMapper o =new ObjectMapper();
			o.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			//appUser=new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
			//
			appUser=o.readValue(request.getInputStream(), AppUser.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
			
		}
		System.out.println("********************");
		System.out.println("******************** username et password"+appUser.getUserName()+"    "+appUser.getPassword());
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getUserName(),appUser.getPassword()));
	}
@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
	
	System.out.println("********************s");
	User springUser=(User)authResult.getPrincipal();
	String jwtToken=Jwts.builder()
	.setSubject(springUser.getUsername())
	.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
	.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
	.claim("privileges", springUser.getAuthorities())
	.compact(); 
	response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwtToken); 
	System.out.println("++++++++++++++"+springUser.getAuthorities());}
	
}
