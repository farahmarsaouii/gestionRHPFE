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
import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.DocumentAdministratif;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.service.ICompetenceService;
import ch.newaccess.backendproject.service.IPosteService;
import ch.newaccess.backendproject.service.UserDetailsServiceImpl;

@RestController
public class CompetenceController {
	@Autowired
public ICompetenceService competenceServiceImpl;
	@Autowired
	public IPosteService posteServiceImpl;
	@Autowired
	private UserDetailsServiceImpl userService;
	
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
/*	@GetMapping("/competencesParNiveau")
	public List<Competence> CompetenceParNiveau(@RequestParam("niveau") String niveau){
		return competenceServiceImpl.findPosteByNiveau(niveau);
	}*/
	
	@GetMapping("/competencesparpostparuser")
	public List<Competence> listerCompetenceparpostparUser(@RequestParam("idUser") Long idUser){
		System.out.println(idUser);
		AppUser user=userService.findUserByid(idUser);
		System.out.println("*************"+posteServiceImpl.findByUsers(user));
		return competenceServiceImpl.findByPostes(posteServiceImpl.findByUsers(user));
	}
	
	
	@GetMapping("/findCompetencesByPoste")
	public List<Competence> findByPostes(@RequestParam("poste-id") Long id) {
		Poste poste=posteServiceImpl.findById(id);
	return competenceServiceImpl.findByPostes(poste);
	}
	
}
