package ch.newaccess.backendproject.web;

import java.util.List;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.awt.PageAttributes.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
import ch.newaccess.backendproject.entities.AppPrivilege;
import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.AppUserDto;
import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.Equipe;
import ch.newaccess.backendproject.entities.ImageModel;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.entities.RegisterForm;
import ch.newaccess.backendproject.entities.SousCompetence;
import ch.newaccess.backendproject.repository.IEquipeRepository;
import ch.newaccess.backendproject.repository.IimageRepository;
import ch.newaccess.backendproject.repository.RoleRespository;
import ch.newaccess.backendproject.service.AccountService;
import ch.newaccess.backendproject.service.IPrivilegeService;
import ch.newaccess.backendproject.service.UserDetailsServiceImpl;

@RestController
public class AccountRestController {
	@Autowired
	IPrivilegeService privilegeService;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Autowired
	private RoleRespository roleRespository;
	@Autowired
	private IEquipeRepository equipeRespository;
	@Autowired
	private AccountService accountService;
	@Autowired  ServletContext context;
	@Autowired
	IimageRepository imageRepository;
	List<AppUser> listeusers= new ArrayList<AppUser>();
	 List<AppUser> listef ;
	
	 public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			return outputStream.toByteArray();
		}
	
	 
	@PostMapping("/register")
//public AppUser register(@RequestParam("imageFile") MultipartFile file,@RequestParam("user") String userName) throws IOException{
		public AppUser register(@RequestBody AppUser userForm){	
	
		/*if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("you must confirm your password");
		AppUser user=accountService.findUserByUsername(userForm.getUserName());
		if(user!=null) throw new RuntimeException("this user already exists");*/
		
		/*ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()),user);
		imageRepository.save(img);
		AppUser appUser =new AppUser();
        appUser=user;
        accountService.saveUser(appUser);*/
		
		
	
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

	@GetMapping("/usersChart")
	public List<AppUserDto> getOrganigramUsers(){
		 List<AppUserDto> listeUsersDto =new ArrayList<AppUserDto>();
		 for(AppUser user :userDetailsService.findUsers()) {
			 
		AppUserDto	userDto=new AppUserDto();
		if(user.getId().equals(user.getIdSuperieurhierarchique().getId())) {
			 userDto.setId(user.getId());
			 userDto.setName(user.getUserName());
			 userDto.setTitle(user.getPoste().getNomPoste());
			 if(imageRepository.findByUser(user).isEmpty()) {userDto.setImg( "../../assets/img/pngjoy.com_gray-circle-login-user-icon-png-transparent-png_2750635.png");}else {
			 userDto.setImg("data:image/jpeg;base64,"+user.getImage().getPicByte());}
		}else {
				 userDto.setId(user.getId());
				 userDto.setName(user.getUserName());
				 userDto.setPid(user.getIdSuperieurhierarchique().getId());
				 userDto.setTitle(user.getPoste().getNomPoste());
				 if(imageRepository.findByUser(user).isEmpty()) {
					 
   userDto.setImg( "../../assets/img/pngjoy.com_gray-circle-login-user-icon-png-transparent-png_2750635.png");}
				 else {
				 userDto.setImg("data:image/jpeg;base64,"+user.getImage().getPicByte());}
				
				 
				
			 
		 }
		 listeUsersDto.add(userDto);
		 
     }
		 return listeUsersDto;
		 
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
		AppRole role = roleRespository.findByrole("employeeRole");
	Equipe equipe = equipeRespository.findById(idequipe).get();
		
		return accountService.findByEquipeAndRole(equipe, role);		
		
}
	
	@GetMapping("/getByPrivilege")
	public List<AppUser> getuserByPrivilege(){
		AppPrivilege p=privilegeService.findPrivilegeById(2L);
		List<AppRole> roles = roleRespository.findByPrivileges(p);		
		System.out.println(roles.size()+"****////////***");
		for(AppRole r :roles) {
	List<AppUser> users =accountService.findByRole(r);	
	 listeusers.addAll(users);
	 Set<AppUser> mySet = new HashSet<AppUser>(listeusers);

	   listef = new ArrayList<AppUser>(mySet);
		}
		return listef;
	}
	
	
	@GetMapping("/getRoles")
	public List<AppRole> findRoles(){
		return accountService.findRoles() ;}
	
	
	
}