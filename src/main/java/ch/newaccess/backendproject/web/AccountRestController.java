package ch.newaccess.backendproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.RegisterForm;
import ch.newaccess.backendproject.service.AccountService;
import ch.newaccess.backendproject.service.UserDetailsServiceImpl;

@RestController
public class AccountRestController {
	@Autowired
	private UserDetailsServiceImpl b;

	@Autowired
	private AccountService accountService;
	@PostMapping("/register")
public AppUser register(@RequestBody RegisterForm userForm) {
	
		if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("you must confirm your password");
		AppUser user=accountService.findUserByUsername(userForm.getUserName());
		if(user!=null) throw new RuntimeException("this user already exists");
		
		//AppRole r=new AppRole();
		AppUser appUser =new AppUser();
		appUser.setUserName(userForm.getUserName());
		appUser.setPassword(userForm.getPassword());
accountService.saveUser(appUser);

accountService.affectRoleToUser(userForm.getUserName(), "USER");
accountService.addPrivilegeToRole("accessToData", "USER");
accountService.addPrivilegeToRole("updateData", "USER");


return appUser;
}
	
	@GetMapping("/userbyUsername/{usernameu}")
	public AppUser userByName(@PathVariable("usernameu") String userName){
		return b.findUserByName(userName);
	
}}