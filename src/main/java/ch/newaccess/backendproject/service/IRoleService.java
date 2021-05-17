package ch.newaccess.backendproject.service;

import java.util.List;

import ch.newaccess.backendproject.entities.AppRole;


public interface IRoleService {
	public AppRole findRoleById(Long idRole);
	public AppRole addRole(AppRole role);
	public List<AppRole> listeRole();
	public AppRole updateRole(AppRole role);
	public void deleteRole(Long id);

}
