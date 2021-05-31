package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.AppPrivilege;
import ch.newaccess.backendproject.entities.AppRole;

public interface RoleRespository extends JpaRepository<AppRole, Long> {
	public AppRole findByrole(String roleName);
	public List<AppRole> findByPrivileges(AppPrivilege privilege);
	//public AppRole findByRole(String roleName);
}
