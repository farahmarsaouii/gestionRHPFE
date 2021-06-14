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

import ch.newaccess.backendproject.entities.Fournisseur;
import ch.newaccess.backendproject.service.IFournisseurService;

@RestController
public class FournisseurController {
	@Autowired
	public IFournisseurService fournisseurService;
	
	@GetMapping("/fournisseur")
	public Fournisseur findFournisseur(@RequestParam("fournisseur-id") Long id){
		return fournisseurService.findById(id);
	}
	
	@PostMapping("/add-fournisseur")
	public Fournisseur addFournisseur(@RequestBody Fournisseur d) {
		return fournisseurService.addFournisseur(d);
	}
	@GetMapping("/fournisseurs")
	public List<Fournisseur> listerFournisseur(){
		return fournisseurService.listeFournisseur();
	}
	@DeleteMapping("/removeFournisseur/{fournisseur-id}")
	public void deleteFournisseur(@PathVariable("fournisseur-id") Long id){
		fournisseurService.deleteFournisseur(id);
	}
	@PutMapping("/updateFournisseur")
	public Fournisseur updateFournisseur(@RequestBody Fournisseur d) {
		return fournisseurService.updateFournisseur(d);
	}

}
