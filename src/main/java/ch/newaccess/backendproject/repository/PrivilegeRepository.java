package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.AppPrivilege;


public interface PrivilegeRepository extends JpaRepository<AppPrivilege, Long> {
	public AppPrivilege findByprivilege(String privilegeName);
}
