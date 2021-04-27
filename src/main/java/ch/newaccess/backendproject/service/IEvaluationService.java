package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.Evaluation;

public interface IEvaluationService {
	public Optional<Evaluation> findEvaluation(Long idEvaluation);
	public Evaluation addEvaluation(Evaluation d);
	public List<Evaluation> listeEvaluation();
	public Evaluation updateEvaluation(Evaluation d);
	public void deleteEvaluation(Long idEvaluation);
}
