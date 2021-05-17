package ch.newaccess.backendproject.service;

import java.util.List;

import ch.newaccess.backendproject.entities.AppPrivilege;


public interface IPrivilegeService {
	public AppPrivilege findPrivilegeById(Long idPrivilege);
	public AppPrivilege addPrivilege(AppPrivilege privilege);
	public List<AppPrivilege> listePrivilege();
	public AppPrivilege updatePrivilege(AppPrivilege privilege);
	public void deletePrivilege(Long id);
	public AppPrivilege findPrivilegeByName(String privilegeName);
}
