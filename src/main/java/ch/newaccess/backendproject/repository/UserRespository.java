package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Equipe;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.entities.AppRole;

public interface UserRespository extends JpaRepository<AppUser,Long> {
	public AppUser findByUserName(String userName);
	public List<AppUser> findByEquipeAndRole(Equipe equipe,AppRole role);
	public AppUser findByPoste(Poste poste);
	public List<AppUser> findByRole(AppRole role);
}
