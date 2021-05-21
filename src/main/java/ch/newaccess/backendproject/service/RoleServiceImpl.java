package ch.newaccess.backendproject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppPrivilege;
import ch.newaccess.backendproject.entities.AppPrivilegeDto;
import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppRoleDto;
import ch.newaccess.backendproject.entities.DocumentAdministratif;
import ch.newaccess.backendproject.repository.RoleRespository;
@Service
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private RoleRespository roleRespository;
	
	
	@Override
	public AppRole findRoleById(Long idRole) {
		return roleRespository.findById(idRole).get();
	}

	@Override
	public AppRole addRole(AppRole role) {
		return roleRespository.save(role);
	}

/*	@Override
	public List<AppRoleDto> listeRole() {
		List<AppRoleDto> rolesDto = new ArrayList<AppRoleDto>();
		List<AppRole> roles = new ArrayList<AppRole>();
		List<AppPrivilege> privileges = new ArrayList<AppPrivilege>();
		List<AppPrivilegeDto> privilegesDto = new ArrayList<AppPrivilegeDto>();
		
		roles=roleRespository.findAll();
		for(AppRole r:roles) {
			AppRoleDto roledto=new AppRoleDto();
			roledto.setId(r.getId());
			roledto.setRole(r.getRole());
			roledto.setUsers(r.getUsers());
			
	for(AppPrivilege p:privileges) {
				AppPrivilegeDto privilegedto=new AppPrivilegeDto();
				privilegedto.setId(p.getId());
				privilegedto.setPrivilege(p.getPrivilege());
				privilegesDto.add(privilegedto);
			}
				
			roledto.setPrivileges(privilegesDto);
			
			rolesDto.add(roledto);
		}
		return rolesDto;
	}

	@Override
	public AppRole updateRole(AppRole role) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public void deleteRole(Long id) {
		roleRespository.deleteById(id);
		
	}

@Override
public List<AppRole> listeRole() {
	// TODO Auto-generated method stub
	return roleRespository.findAll();
}

@Override
public AppRole updateRole(AppRole role) {
	AppRole r=roleRespository.findById(role.getId()).get();
	r.setprivileges(role.getprivileges());
	r.setRole(role.getRole());
	return roleRespository.save(r);
}



}
