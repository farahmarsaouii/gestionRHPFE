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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.PlanDeCarriere;
import ch.newaccess.backendproject.service.IPlanDeCarriereService;

@RestController
public class PlanDeCarriereController {
	@Autowired
public IPlanDeCarriereService planDeCarriereService;
	
	@GetMapping("/planDeCarriere")
	public Optional<PlanDeCarriere> listPlanDeCarriere(@RequestParam("planDeCarriere-id") Long id){
		return planDeCarriereService.findPlanDeCarriere(id);
	}
	@PostMapping("/add-planDeCarriere")
	public PlanDeCarriere addPlanDeCarriere(@RequestBody PlanDeCarriere d) {
		return planDeCarriereService.addPlanDeCarriere(d);
	}
	@GetMapping("/planDeCarrieres")
	public List<PlanDeCarriere> listerPlanDeCarriere(){
		return planDeCarriereService.listePlanDeCarriere();
	}
	@DeleteMapping("/removePlanDeCarriere/{planDeCarriere-id}")
	public void deletePlanDeCarriere(@PathVariable("planDeCarriere-id") Long id){
		planDeCarriereService.deletePlanDeCarriere(id);
	}
	@PutMapping("/updatePlanDeCarriere")
	public PlanDeCarriere updatePlanDeCarriere(@RequestBody PlanDeCarriere d) {
		return planDeCarriereService.updatePlanDeCarriere(d);
	}
}
