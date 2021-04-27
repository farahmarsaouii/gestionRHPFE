package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.Evaluation;



public interface IEvaluationRepository extends JpaRepository<Evaluation,Long> {

}
