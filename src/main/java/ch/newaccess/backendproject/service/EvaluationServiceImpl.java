package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Evaluation;
import ch.newaccess.backendproject.repository.IEvaluationRepository;

@Service
public class EvaluationServiceImpl implements IEvaluationService{
	@Autowired
public IEvaluationRepository evaluationRepository;

	@Override
	public Optional<Evaluation> findEvaluation(Long idEvaluation) {
		return evaluationRepository.findById(idEvaluation);
	}

	@Override
	public Evaluation addEvaluation(Evaluation d) {
		return evaluationRepository.save(d);
	}

	@Override
	public List<Evaluation> listeEvaluation() {
		return evaluationRepository.findAll();
	}

	@Override
	public Evaluation updateEvaluation(Evaluation d) {
		return evaluationRepository.save(d);
	}

	@Override
	public void deleteEvaluation(Long idEvaluation) {
		evaluationRepository.deleteById(idEvaluation);
	}
}
