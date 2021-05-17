package ch.newaccess.backendproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppRoleDto;
import ch.newaccess.backendproject.service.IRoleService;

@RestController
public class RoleController {
	@Autowired
	IRoleService roleService;
	
	@GetMapping("/getRoleById")
	public AppRole listRole(@RequestParam("role-id") Long id){
		return roleService.findRoleById(id);
	}
	@PostMapping("/add-role")
	public AppRole addrole(@RequestBody AppRole d) {
		return roleService.addRole(d);
	}
	@GetMapping("/roles")
	public List<AppRole> listerrole(){
		return roleService.listeRole();
	}
	@DeleteMapping("/removeroles/{role-id}")
	public void deleterole(@PathVariable("role-id") Long id){
		roleService.deleteRole(id);
	}
	@PutMapping("/update-role")
	public AppRole updaterole(@RequestBody AppRole d) {
		return roleService.updateRole(d);
	}
}