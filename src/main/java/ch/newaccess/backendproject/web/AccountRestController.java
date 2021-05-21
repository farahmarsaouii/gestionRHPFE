package ch.newaccess.backendproject.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import java.util.Map;
import java.util.Optional;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FilenameUtils;
import javax.servlet.ServletContext;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.newaccess.backendproject.domaine.Response;
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
	@Autowired  ServletContext context;
	
	@PostMapping("/register")
//public ResponseEntity<Response> register(@RequestParam("user") String user,@RequestParam("file") MultipartFile file)throws JsonParseException , JsonMappingException , Exception{
	public AppUser register(@RequestBody AppUser userForm){	
		/*if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("you must confirm your password");
		AppUser user=accountService.findUserByUsername(userForm.getUserName());
		if(user!=null) throw new RuntimeException("this user already exists");*/
		
	
		
		
		
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

/*
		System.out.println("Ok .............");
		AppUser utilisateur = new ObjectMapper().readValue(user, AppUser.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
        	new File (context.getRealPath("/Images/")).mkdir();
        	System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
        	System.out.println("Image");
        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        	 
        }catch(Exception e) {
        	e.printStackTrace();
        }

       
        utilisateur.setFileName(newFileName);
        AppUser u = accountService.saveUser(utilisateur);
        if (u != null)
        {
        	
        return	new ResponseEntity<Response>(new Response(), HttpStatus.OK);
        }
        else
        {
        	return new ResponseEntity<Response>(new Response("Article not saved"),HttpStatus.BAD_REQUEST);	
        }
*/

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