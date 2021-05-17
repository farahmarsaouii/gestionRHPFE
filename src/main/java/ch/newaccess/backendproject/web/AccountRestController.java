package ch.newaccess.backendproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.Equipe;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.entities.RegisterForm;
import ch.newaccess.backendproject.repository.IEquipeRepository;
import ch.newaccess.backendproject.repository.RoleRespository;
import ch.newaccess.backendproject.service.AccountService;
import ch.newaccess.backendproject.service.UserDetailsServiceImpl;

@RestController
public class AccountRestController {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private RoleRespository roleRespository;
	@Autowired
	private IEquipeRepository equipeRespository;
	@Autowired
	private AccountService accountService;
	@PostMapping("/register")
public AppUser register(@RequestBody AppUser userForm) {
	
		if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("you must confirm your password");
		AppUser user=accountService.findUserByUsername(userForm.getUserName());
		if(user!=null) throw new RuntimeException("this user already exists");
		
	
		
		
		//AppRole r=new AppRole();
		AppUser appUser =new AppUser();
		appUser.setUserName(userForm.getUserName());
		appUser.setPoste(userForm.getPoste());
		appUser.setPassword(userForm.getPassword());
		appUser.setRepassword(userForm.getRepassword());
		appUser.setEmail(userForm.getEmail());
		appUser.setCin(userForm.getCin());
		appUser.setRole(userForm.getRole());
		appUser.setEquipe(userForm.getEquipe());
		System.out.println(appUser.getRole());
accountService.saveUser(appUser);

//accountService.affectRoleToUser(userForm.getUserName(), "USER");
//accountService.addPrivilegeToRole("accessToData", "USER");
//accountService.addPrivilegeToRole("updateData", "USER");


return appUser;
}
	
	@GetMapping("/userbyUsername/{usernameu}")
	public AppUser userByName(@PathVariable("usernameu") String userName){
		return userDetailsService.findUserByName(userName);
	
}
	@GetMapping("/users")
	public List<AppUser> getUsers(){
		return userDetailsService.findUsers();	
     }
	
	@GetMapping("/getUserById")
	public AppUser getUser(@RequestParam("user-id") Long idUser){
		return userDetailsService.findUserByid(idUser);	
     }
	
	@DeleteMapping("/removeUser/{user-id}")
	public void deleteUser(@PathVariable("user-id") Long id){
		userDetailsService.deleteUserById(id);
	}
	@PutMapping("/updateUser")
	public AppUser updateUser(@RequestBody AppUser user) {
		return userDetailsService.updateUser(user);
	}
	
	@GetMapping("/getByEquipeAndRole")
	public List<AppUser> getByEquipeAndRole(@RequestParam("idequipe") Long idequipe){
		AppRole role = roleRespository.findByrole("USER");
	Equipe equipe = equipeRespository.findById(idequipe).get();
		
		return accountService.findByEquipeAndRole(equipe, role);
		
	
}
	@GetMapping("/getRoles")
	public List<AppRole> findRoles(){
		return accountService.findRoles() ;}
	
}