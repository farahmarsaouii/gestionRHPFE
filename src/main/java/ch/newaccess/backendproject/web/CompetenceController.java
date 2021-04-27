package ch.newaccess.backendproject.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.Competence;

import ch.newaccess.backendproject.service.ICompetenceService;

@RestController
public class CompetenceController {
	@Autowired
public ICompetenceService competenceServiceImpl;
	
	@PostMapping("/add-competence")
	public Competence addCompetence(@RequestBody Competence d) {
		return competenceServiceImpl.addCompetence(d);
	}
	@GetMapping("/competences")
	public List<Competence> listerCompetence(){
		return competenceServiceImpl.listeCompetence();
	}
	@DeleteMapping("/removeCompetence/{competence-id}")
	public void deleteCompetence(@PathVariable("competence-id") Long id){
		competenceServiceImpl.deleteCompetence(id);
	}
	@PutMapping("/updateCompetence")
	public Competence updateCompetence(@RequestBody Competence d) {
		return competenceServiceImpl.updateCompetence(d);
	}
}
