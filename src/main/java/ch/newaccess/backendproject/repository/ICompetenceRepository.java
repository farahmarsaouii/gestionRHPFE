package ch.newaccess.backendproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.Poste;

public interface ICompetenceRepository extends JpaRepository<Competence,Long>  {
public List<Competence> findByPoste(Poste postes);
public Optional<Competence> findById(Long id);

}
