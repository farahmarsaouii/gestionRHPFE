package ch.newaccess.backendproject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Equipe;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
private AccountService accountService;

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
	
	public List<AppUser> findUsers() {
		return accountService.findUsers();
	}
	
	
	public AppUser findUserByid(Long id) {
		System.out.print("hello heloooooo");
		return accountService.findUserByid(id);
		
	}
	public List<AppUser> findByEquipeAndRole(Equipe equipe, AppRole role) {
		return accountService.findByEquipeAndRole(equipe,role) ;
	}
/*	public AppUser updateUser(AppUser user) {
		AppUser utilisateur=accountService.findUserByid(user.getId());
		return accountService.updateUser(utilisateur);
	}
*/
	
	public void deleteUserById(Long idUser) {
		accountService.deleteUser(idUser);
		
	}
}

