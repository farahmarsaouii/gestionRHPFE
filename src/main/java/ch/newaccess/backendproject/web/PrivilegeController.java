package ch.newaccess.backendproject.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.AppPrivilege;

import ch.newaccess.backendproject.service.IPrivilegeService;



@RestController
public class PrivilegeController {
	@Autowired
	IPrivilegeService privilegeService;
	
	@GetMapping("/Privilege")
	public AppPrivilege listPrivilege(@RequestParam("Privilege-id") Long id){
		return privilegeService.findPrivilegeById(id);
	}
	@PostMapping("/add-Privilege")
	public AppPrivilege addPrivilege(@RequestBody AppPrivilege d) {
		return privilegeService.addPrivilege(d);
	}
	@GetMapping("/Privileges")
	public List<AppPrivilege> listerPrivilege(){
		return privilegeService.listePrivilege();
	}
	@GetMapping("/PrivilegeByName")
	public AppPrivilege PrivilegeByName(@RequestParam("privilege-name") String privilegeName){
		return privilegeService.findPrivilegeByName(privilegeName);
	}
	
	@GetMapping("/PrivilegeByNames/{names}")
	public List<AppPrivilege> PrivilegeByNames(@PathVariable("names") List<String> privilegeNames){
		List<AppPrivilege> liste= new ArrayList<AppPrivilege>();
		AppPrivilege privilege=new AppPrivilege();
		for(String b : privilegeNames){
			privilege=privilegeService.findPrivilegeByName(b);
			liste.add(privilege);
		};
		return liste;
	}
	
	@DeleteMapping("/removePrivileges/{Privilege-sid}")
	public void deletePrivilege(@PathVariable("Privilege-id") Long id){
		privilegeService.deletePrivilege(id);
	}
	@PutMapping("/update-Privilege")
	public AppPrivilege updatePrivilege(@RequestBody AppPrivilege d) {
		return privilegeService.updatePrivilege(d);
	}
}
