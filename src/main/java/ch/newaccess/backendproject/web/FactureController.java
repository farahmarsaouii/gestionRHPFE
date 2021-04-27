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

import ch.newaccess.backendproject.entities.Facture;

import ch.newaccess.backendproject.service.IFactureService;

@RestController
public class FactureController {
	@Autowired
	public IFactureService factureService;
	@GetMapping("/facture")
	public Optional<Facture> listDocumentsAdministratif(@RequestParam("facture-id") Long id){
		return factureService.findFacture(id);
	}
	@PostMapping("/add-facture")
	public Facture addfacture(@RequestBody Facture d) {
		return factureService.addFacture(d);
	}
	@GetMapping("/factures")
	public List<Facture> listerfacture(){
		return factureService.listeFacture();
	}
	@DeleteMapping("/removeFactures/{facture-id}")
	public void deletefacture(@PathVariable("facture-id") Long id){
		factureService.deleteFacture(id);
	}
	@PutMapping("/updateFacture")
	public Facture updatefacture(@RequestBody Facture d) {
		return factureService.updateFacture(d);
	}
}
