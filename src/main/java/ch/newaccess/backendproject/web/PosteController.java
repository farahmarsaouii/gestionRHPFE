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

import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.service.IPosteService;

@RestController
public class PosteController {
	@Autowired
	public IPosteService posteService;

	@GetMapping("/poste")
	public Poste findposte(@RequestParam("poste-id") Long id){
		return posteService.findPoste(id);
	}
	@PostMapping("/add-poste")
	public Poste addPoste(@RequestBody Poste d) {
		return posteService.addPoste(d);
	}
	@GetMapping("/postes")
	public List<Poste> findPostes(){
		return posteService.listePoste();
	}
	@DeleteMapping("/removePoste/{poste-id}")
	public void deletePoste(@PathVariable("poste-id") Long id){
		posteService.deletePoste(id);
	}
	@PutMapping("/updatePoste")
	public Poste updatePoste(@RequestBody Poste d) {
		return posteService.updatePoste(d);
	}
}
