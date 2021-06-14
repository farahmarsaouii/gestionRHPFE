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

import ch.newaccess.backendproject.entities.Beneficier;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.service.IBeneficierService;

@RestController
public class BeneficierController {

	@Autowired
	public IBeneficierService beneficierService;
	Beneficier b=new Beneficier();
	@GetMapping("/beneficier")
	public Beneficier findBeneficier(@RequestParam("Beneficier-id") Long id){
		return beneficierService.findBeneficier(id).get();
	}
	
	@GetMapping("/beneficierByName")
	public Beneficier findBeneficierByName(@RequestParam("BeneficierName") String nom){
		if(beneficierService.findBeneficierByName(nom).isEmpty()){
			b.setNomBeneficier(nom);
			this.beneficierService.addBeneficier(b);
			return b;
		}else
		{return beneficierService.findBeneficierByName(nom).get();}
		
	}
	
	@PostMapping("/add-Beneficier")
	public Beneficier addBeneficier(@RequestBody Beneficier d) {
		return beneficierService.addBeneficier(d);
	}
	@GetMapping("/beneficiers")
	public List<Beneficier> findBeneficiers(){
		return beneficierService.listeBeneficier();
	}
	@DeleteMapping("/removeBeneficier/{Beneficier-id}")
	public void deleteBeneficier(@PathVariable("Beneficier-id") Long id){
		beneficierService.deleteBeneficier(id);
	}
	@PutMapping("/updateBeneficier")
	public Beneficier updateBeneficier(@RequestBody Beneficier p) {
		return beneficierService.updateBeneficier(p);
	}

}
