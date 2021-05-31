package ch.newaccess.backendproject.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.CompetenceDto;
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
	List<SousCompetence> listeSousCompetence = new ArrayList<SousCompetence>();

	@GetMapping("/sousCompetence")
	public Optional<SousCompetence> listDocumentsAdministratif(@RequestParam("sousCompetence-id") Long id) {
		return sousCompetenceService.findSousCompetence(id);
	}

	@PostMapping("/add-sousCompetence")
	public SousCompetence addSousCompetence(@RequestBody SousCompetence d) {
		return sousCompetenceService.addSousCompetence(d);
	}

	@GetMapping("/sousCompetences")
	public List<SousCompetence> listerSousCompetence() {
		return sousCompetenceService.listeSousCompetence();
	}

	@DeleteMapping("/removeSousCompetence/{sousCompetence-id}")
	public void deleteSousCompetence(@PathVariable("sousCompetence-id") Long id) {
		sousCompetenceService.deleteSousCompetence(id);
	}

	@PutMapping("/updateSousCompetence")
	public SousCompetence updateSousCompetence(@RequestBody SousCompetence d) {
		return sousCompetenceService.updateSousCompetence(d);
	}
	
	
	/*
	 * @GetMapping("/sousCompetencesparCompetence") public List<SousCompetence>
	 * getSousCompetencesparCompetence(@RequestParam("idCompetence") Long
	 * idCompetence){ Competence
	 * competence=competenceServiceImpl.findById(idCompetence); return
	 * sousCompetenceService.findByCompetences(competence); }
	 */

	@GetMapping("/sousCompetencesparUser")
	public List<SousCompetence> getSousCompetenceParUser(@RequestParam("idUser") Long idUser) {
		System.out.println(idUser);
//		AppUser user = userService.findUserByid(idUser);
		return sousCompetenceService.findByEmployee(idUser);

	}

/*	@GetMapping("/getSousCompetenceParCompetenceparUser")
	public Map<String, List<CompetenceDto>> getSousCompetenceParCompetenceparUser(
			@RequestParam("idUser") Long idUser) {
		System.out.print(idUser);
		System.out.print(userService.findUserByid(idUser));
		AppUser user = userService.findUserByid(idUser);

		listeSousCompetence = sousCompetenceService.findByEmployee(idUser);
		List<Competence> competences = competenceServiceImpl.findByPostes(posteServiceImpl.findByUsers(user));
		if(competences != null && competences.size()>0) {
			
		}
		Map<Competence, List<SousCompetence>> hashMap = new HashMap<Competence, List<SousCompetence>>();
		Map<String, List<CompetenceDto>> hashMap2 = new HashMap<String, List<CompetenceDto>>();
		
		for (SousCompetence sousCompetence : listeSousCompetence) {
			if (hashMap.get(sousCompetence.getCompetences()) == null) {
				List<SousCompetence> listcompetencesparsousCompetences = new ArrayList<SousCompetence>();
				listcompetencesparsousCompetences.add(sousCompetence);
				hashMap.put(sousCompetence.getCompetences(), listcompetencesparsousCompetences);
			} else {
				hashMap.get(sousCompetence.getCompetences()).add(sousCompetence);
			}
		}
		if(hashMap.size()>0) {
			for(Entry<Competence, List<SousCompetence>> entry : hashMap.entrySet()) {
				CompetenceDto dto = new CompetenceDto();
				dto.setCompetence(entry.getKey());
				dto.setSousCompetences(entry.getValue());
				if (hashMap2.get(entry.getKey().getNiveau()) == null) {
					List<CompetenceDto> dtos = new ArrayList<>();
					dtos.add(dto);
					hashMap2.put(entry.getKey().getNiveau(), dtos);
				} else {
					hashMap2.get(entry.getKey().getNiveau()).add(dto);
				}
			}
		}

		return hashMap2;
	}*/
 
}
