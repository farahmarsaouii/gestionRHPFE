package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.PlanDeCarriere;
import ch.newaccess.backendproject.entities.Poste;



public interface IPlanDeCarriereRepository extends JpaRepository<PlanDeCarriere,Long> {
//public PlanDeCarriere findByPoste(Poste poste);
public PlanDeCarriere findByEmplyee(AppUser emplyee);
}
