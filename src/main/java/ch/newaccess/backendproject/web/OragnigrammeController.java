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

import ch.newaccess.backendproject.entities.Oragnigramme;
import ch.newaccess.backendproject.service.IOrganigrammeService;

@RestController
public class OragnigrammeController {
	@Autowired
public IOrganigrammeService organigrammeService;
	
	@GetMapping("/organigramme/{organigramme-id}")
	public Optional<Oragnigramme> listOragnigrammes(@PathVariable("organigramme-id") Long id){
		return organigrammeService.findOragnigramme(id);
	}
	@PostMapping("/add-organigramme")
	public Oragnigramme addOragnigramme(@RequestBody Oragnigramme d) {
		return organigrammeService.addOragnigramme(d);
	}
	@GetMapping("/organigrammes")
	public List<Oragnigramme> listerOragnigramme(){
		return organigrammeService.listeOragnigramme();
	}
	@DeleteMapping("/remove/{organigramme-id}")
	public void deleteOragnigramme(@PathVariable("organigramme-id") Long id){
		organigrammeService.deleteOragnigramme(id);
	}
	@PutMapping("/updateOraganigramme")
	public Oragnigramme updateOragnigramme(@RequestBody Oragnigramme d) {
		return organigrammeService.updateOragnigramme(d);
	}
}
