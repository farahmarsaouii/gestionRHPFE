package ch.newaccess.backendproject.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppUser;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
private AccountService accountService;
	//public UserDetails loadUserByuserName(String userName) throws userNameNotFoundException {
		
	//	return null;
	//}

	@Override
	public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException {
		AppUser u=accountService.findUserByUsername(userName);
		if(u==null) throw new UsernameNotFoundException(userName);
	//	Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
	//	u.getRoles().forEach(r->{
	///		authorities.add(new SimpleGrantedAuthority(r.getRole()));
	//	});
	//	return  new User(u.getUserName(), u.getPassword(), authorities);
		Collection<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		u.getRole().getprivileges().forEach(r->{
		authorities.add(new SimpleGrantedAuthority(r.getPrivilege()));
			});
		return  new User(u.getUserName(), u.getPassword(), authorities);
		
	}
	public AppUser findUserByName(String userName) {
		return accountService.findUserByUsername(userName);
	}
	
	public AppUser findUserByid(Long id) {
		System.out.print("hello heloooooo");
		return accountService.findUserByid(id);
		
	}
}

