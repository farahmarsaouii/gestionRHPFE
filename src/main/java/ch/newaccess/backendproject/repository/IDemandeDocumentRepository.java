package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.DemandeDocument;



public interface IDemandeDocumentRepository extends JpaRepository<DemandeDocument,Long> {
	public List<DemandeDocument> findByEmplyee(AppUser emplyee);
}
