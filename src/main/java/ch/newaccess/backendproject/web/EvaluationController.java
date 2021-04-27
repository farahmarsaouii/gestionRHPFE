package ch.newaccess.backendproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.Evaluation;
import ch.newaccess.backendproject.service.IEvaluationService;

@RestController
public class EvaluationController {
	@Autowired
	public IEvaluationService evaluatonService;
	@GetMapping("/evaluation/{evaluation-id}")
	public Optional<Evaluation> listEvaluation(@PathVariable("evaluation-id") Long id){
		return evaluatonService.findEvaluation(id);
	}
	@PostMapping("/add-evaluation")
	public Evaluation addEvaluation(@RequestBody Evaluation d) {
		return evaluatonService.addEvaluation(d);
	}
	@GetMapping("/evaluations")
	public List<Evaluation> listerEvaluation(){
		return evaluatonService.listeEvaluation();
	}
	@DeleteMapping("/remove/{evaluation-id}")
	public void deleteEvaluation(@PathVariable("evaluation-id") Long id){
		evaluatonService.deleteEvaluation(id);
	}
	@PutMapping("/updateEvaluation")
	public Evaluation updateEvaluation(@RequestBody Evaluation d) {
		return evaluatonService.updateEvaluation(d);
	}
}
