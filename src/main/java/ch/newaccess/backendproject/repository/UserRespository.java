package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ch.newaccess.backendproject.entities.AppUser;

public interface UserRespository extends JpaRepository<AppUser,Long> {
	public AppUser findByUserName(String userName);
}
