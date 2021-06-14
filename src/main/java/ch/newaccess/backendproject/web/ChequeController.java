package ch.newaccess.backendproject.web;

import java.util.List;

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
import ch.newaccess.backendproject.service.IChequeService;

@RestController
public class ChequeController {
	@Autowired
	public IChequeService chequeService;
	
	@GetMapping("/cheque")
	public Cheque findCheque(@RequestParam("cheque-id") Long id){
		return chequeService.findById(id);
	}
	@PostMapping("/add-cheque")
	public Cheque addcheque(@RequestBody Cheque c) {
		return chequeService.addCheque(c);
	}
	@GetMapping("/cheques")
	public List<Cheque> findcheques(){
		return chequeService.listeCheque();
	}
	@DeleteMapping("/removeCheque/{cheque-id}")
	public void deleteCheque(@PathVariable("cheque-id") Long id){
		chequeService.deleteCheque(id);
	}
	@PutMapping("/updateCheque")
	public Cheque updateCheque(@RequestBody Cheque c) {
		return chequeService.updateCheque(c);
	}
}
	

