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

import ch.newaccess.backendproject.entities.SousCompetence;
import ch.newaccess.backendproject.service.ISousCompetenceService;

@RestController
public class SousCompetenceController {
	@Autowired
	public ISousCompetenceService sousCompetenceService;
	@GetMapping("/sousCompetence/{sousCompetence-id}")
	public Optional<SousCompetence> listDocumentsAdministratif(@PathVariable("sousCompetence-id") Long id){
		return sousCompetenceService.findSousCompetence(id);
	}
	@PostMapping("/add-sousCompetence")
	public SousCompetence addSousCompetence(@RequestBody SousCompetence d) {
		return sousCompetenceService.addSousCompetence(d);
	}
	@GetMapping("/sousCompetences")
	public List<SousCompetence> listerSousCompetence(){
		return sousCompetenceService.listeSousCompetence();
	}
	@DeleteMapping("/remove/{sousCompetence-id}")
	public void deleteSousCompetence(@PathVariable("sousCompetence-id") Long id){
		sousCompetenceService.deleteSousCompetence(id);
	}
	@PutMapping("/updateSousCompetence")
	public SousCompetence updateSousCompetence(@RequestBody SousCompetence d) {
		return sousCompetenceService.updateSousCompetence(d);
	}
}
