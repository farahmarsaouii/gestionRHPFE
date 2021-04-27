package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.Facture;

public interface IFactureRepository extends JpaRepository<Facture,Long> {

}
