package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import ch.newaccess.backendproject.entities.Competence;

public interface ICompetenceRepository extends JpaRepository<Competence,Long>  {

}
