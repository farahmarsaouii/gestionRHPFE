package ch.newaccess.backendproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ch.newaccess.backendproject.entities.DemandeDocument;
import ch.newaccess.backendproject.entities.DocumentAdministratif;



public interface IDocumentAdministratifRepository extends JpaRepository<DocumentAdministratif,Long> {
public Optional<DocumentAdministratif> findById(Long id);

}
