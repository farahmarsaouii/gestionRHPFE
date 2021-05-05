package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.SousCompetence;



public interface ISousCompetenceRepository extends JpaRepository<SousCompetence,Long> {
public List<SousCompetence> findByCompetences(Competence competences);
public List<SousCompetence> findByEmployee(AppUser employee);
}
