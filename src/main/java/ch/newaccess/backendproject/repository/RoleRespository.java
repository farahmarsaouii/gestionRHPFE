package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.AppRole;

public interface RoleRespository extends JpaRepository<AppRole, Long> {
	public AppRole findByrole(String roleName);
	//public AppRole findByRole(String roleName);
}
