package ch.newaccess.backendproject.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import ch.newaccess.backendproject.entities.SousCompetence;
import ch.newaccess.backendproject.service.ICompetenceService;
import ch.newaccess.backendproject.service.IPosteService;
import ch.newaccess.backendproject.service.ISousCompetenceService;
import ch.newaccess.backendproject.service.UserDetailsServiceImpl;

@RestController
public class SousCompetenceController {
	@Autowired
	public ISousCompetenceService sousCompetenceService;
	@Autowired
public ICompetenceService competenceServiceImpl;
	@Autowired
	private UserDetailsServiceImpl userService;
	@Autowired
	public IPosteService posteServiceImpl;
	HashMap<Competence, List<SousCompetence>> hashMap = new HashMap<Competence, List<SousCompetence>>();
	
	@GetMapping("/sousCompetence")
	public Optional<SousCompetence> listDocumentsAdministratif(@RequestParam("sousCompetence-id") Long id){
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
	@DeleteMapping("/removeSousCompetence/{sousCompetence-id}")
	public void deleteSousCompetence(@PathVariable("sousCompetence-id") Long id){
		sousCompetenceService.deleteSousCompetence(id);
	}
	@PutMapping("/updateSousCompetence")
	public SousCompetence updateSousCompetence(@RequestBody SousCompetence d) {
		return sousCompetenceService.updateSousCompetence(d);
	}
	
	/*@GetMapping("/sousCompetencesparCompetence")
	public List<SousCompetence> getSousCompetencesparCompetence(@RequestParam("idCompetence") Long idCompetence){
		Competence competence=competenceServiceImpl.findById(idCompetence);
	return sousCompetenceService.findByCompetences(competence);
	}*/
	
	@GetMapping("/sousCompetencesparUser")
	public List<SousCompetence> getSousCompetenceParUser(@RequestParam("idUser") Long idUser){
			System.out.println(idUser);
			AppUser user=userService.findUserByid(idUser);
			return sousCompetenceService.findByEmployee(user);
		
	}
	@GetMapping("/getSousCompetenceParCompetenceparUser")
	public HashMap<Competence, List<SousCompetence>>  getSousCompetenceParCompetenceparUser(@RequestParam("idUser") Long idUser){
		System.out.print(idUser);
		System.out.print(userService.findUserByid(idUser));
		AppUser user=userService.findUserByid(idUser);
		List<SousCompetence> listcompetencesparsousCompetences = null;
		
		List<SousCompetence> listeSousCompetence=sousCompetenceService.findByEmployee(user);
		List<Competence> competences= competenceServiceImpl.findByPostes(posteServiceImpl.findByUsers(user));
		
		for (Competence competence : competences) {
			for (SousCompetence sousCompetence : listeSousCompetence) {
				if(competence.getId()==sousCompetence.getCompetences().getId())
					listcompetencesparsousCompetences.add(sousCompetence);
			}
			hashMap.put(competence, listcompetencesparsousCompetences);
		}
	
		return hashMap;
	}
	
}
