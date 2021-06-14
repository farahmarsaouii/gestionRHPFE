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

import ch.newaccess.backendproject.entities.Cheque;
import ch.newaccess.backendproject.entities.FactureChequeDto;
import ch.newaccess.backendproject.entities.FactureFournisseur;
import ch.newaccess.backendproject.entities.FactureFournisseurChequedto;
import ch.newaccess.backendproject.entities.PieceDeCaisse;
import ch.newaccess.backendproject.service.IChequeService;
import ch.newaccess.backendproject.service.IFactureFournisseurService;

@RestController
public class FactureFournisseurController {
@Autowired
public IFactureFournisseurService factureFournisseurService;
@Autowired
public IChequeService chequeService;

Cheque chequeFacture=new Cheque();

@GetMapping("/factureFournisseur")
public FactureFournisseur findFactureFournisseur(@RequestParam("factureFournisseur-id") Long id){
	return factureFournisseurService.findById(id);
}
@PostMapping("/add-factureFournisseur")
public FactureFournisseur addFactureFournisseur(@RequestBody FactureFournisseur d) {
	return factureFournisseurService.addFactureFournisseur(d);
}
@GetMapping("/factureFournisseurs")
public List<FactureFournisseur> listerFactureFournisseur(){
	return factureFournisseurService.listeFactureFournisseur();
}
@DeleteMapping("/removeFactureFournisseur/{factureFournisseur-id}")
public void deleteFactureFournisseur(@PathVariable("factureFournisseur-id") Long id){
	factureFournisseurService.deleteFactureFournisseur(id);
}
@PutMapping("/updateFactureFournisseur")
public FactureFournisseur updateFactureFournisseur(@RequestBody FactureFournisseur d) {
	return factureFournisseurService.updateFactureFournisseur(d);
}
@PostMapping("/addFactureFournisseurCheque")
public FactureFournisseur addFactureFournisseurCheque(@RequestBody FactureFournisseurChequedto dto) {
	Cheque c=new Cheque(dto.getCheque()) ;   
	chequeService.addCheque(c);
	FactureFournisseur pc=dto.getFacture();
	pc.setNumeroCheque(c);
	return factureFournisseurService.addFactureFournisseur(pc);
}
@PutMapping("/updateFactureFournisseurCheque")
public FactureFournisseur updateFactureFournisseurCheque(@RequestBody FactureFournisseurChequedto dto) {
	Cheque c=new Cheque(dto.getCheque()) ;   
	chequeService.addCheque(c);
	FactureFournisseur pc=dto.getFacture();
	pc.setNumeroCheque(c);
	return factureFournisseurService.updateFactureFournisseur(pc);
}
}
