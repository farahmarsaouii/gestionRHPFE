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

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.PlanDeCarriere;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.service.IPlanDeCarriereService;
import ch.newaccess.backendproject.service.IPosteService;
import ch.newaccess.backendproject.service.UserDetailsServiceImpl;

@RestController
public class PlanDeCarriereController {
	@Autowired
public IPlanDeCarriereService planDeCarriereService;
	@Autowired
	public IPosteService posteService;
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@GetMapping("/planDeCarriere")
	public Optional<PlanDeCarriere> findPlanDeCarrierebyid(@RequestParam("planDeCarriere-id") Long id){
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
/*	@GetMapping("/planDeCarrieresParPoste")
	public PlanDeCarriere findPlanDeCarriereParPoste(@RequestParam("idPoste") Long idposte){
		Poste poste=posteService.findPoste(idposte);
		
		return planDeCarriereService.findPlanDeCarriereByPoste(poste);
}*/
	@GetMapping("/planDeCarrieresParUser")
	public PlanDeCarriere findPlanDeCarriereByEmplyee(@RequestParam("idUser") Long idUser) {
		
		AppUser user=userService.findUserByid(idUser);
		return planDeCarriereService.findPlanDeCarriereByEmplyee(user);
		
	}
}