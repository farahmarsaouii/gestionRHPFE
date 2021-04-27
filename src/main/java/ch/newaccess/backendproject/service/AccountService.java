package ch.newaccess.backendproject.service;

import ch.newaccess.backendproject.entities.AppPrivilege;
import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppUser;

public interface AccountService {
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public AppPrivilege savePrivilege(AppPrivilege privilege);
	public void affectRoleToUser(String userName,String roleName);
	public void addPrivilegeToRole(String privilegeName,String roleName);
	public AppUser findUserByUsername(String userName);
	public AppUser findUserByid(Long id);
	public AppUser findUserByName(String userName);


}
