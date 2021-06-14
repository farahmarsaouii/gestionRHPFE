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
import ch.newaccess.backendproject.entities.PieceDeCaisse;
import ch.newaccess.backendproject.service.IChequeService;
import ch.newaccess.backendproject.service.IPieceDeFactureService;

@RestController
public class PieceDeCaisseController {
	@Autowired
	public IPieceDeFactureService pieceDeFactureService;
	@Autowired
	public IChequeService chequeService;
	
	Cheque chequeFacture=new Cheque();
	PieceDeCaisse pc=new PieceDeCaisse();
	@GetMapping("/facture")
	public Optional<PieceDeCaisse> listPieceDeCaisse(@RequestParam("facture-id") Long id){
		return pieceDeFactureService.findPieceDeCaisse(id);
	}
	@PostMapping("/add-facture")
	public PieceDeCaisse addPieceDeCaisse(@RequestBody PieceDeCaisse d) {
		return pieceDeFactureService.addPieceDeCaisse(d);
	}
	@GetMapping("/factures")
	public List<PieceDeCaisse> listerPieceDeCaisse(){
		return pieceDeFactureService.listePieceDeCaisse();
	}
	@DeleteMapping("/removeFactures/{facture-id}")
	public void deletePieceDeCaisse(@PathVariable("facture-id") Long id){
		pieceDeFactureService.deletePieceDeCaisse(id);
	}
	@PutMapping("/updateFacture")
	public PieceDeCaisse updatePieceDeCaisse(@RequestBody PieceDeCaisse d) {
		return pieceDeFactureService.updatePieceDeCaisse(d);
	}
	@PostMapping("/addFactureCheque")
	public PieceDeCaisse addPieceDeCaisseCheque(@RequestBody FactureChequeDto dto) {
		Cheque c=new Cheque(dto.getCheque()) ;   
		chequeService.addCheque(c);
		PieceDeCaisse pc=dto.getFacture();
		pc.setNumCheque(c);
		return pieceDeFactureService.addPieceDeCaisse(pc);
	}
	@PutMapping("/updateFactureCheque")
	public PieceDeCaisse updatePieceDeCaisseCheque(@RequestBody FactureChequeDto dto) {
		Cheque c=new Cheque(dto.getCheque()) ;   
		chequeService.addCheque(c);
		PieceDeCaisse pc=dto.getFacture();
		pc.setNumCheque(c);
		return pieceDeFactureService.updatePieceDeCaisse(pc);
	}
}
