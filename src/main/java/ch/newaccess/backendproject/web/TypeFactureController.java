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

import ch.newaccess.backendproject.entities.TypeFacture;
import ch.newaccess.backendproject.service.ITypeFactureService;

@RestController
public class TypeFactureController {
	@Autowired
	public ITypeFactureService typeFactureService;
	@GetMapping("/typeFacture")
	public Optional<TypeFacture> listDocumentsAdministratif(@RequestParam("typeFacture-id") Long id){
		return typeFactureService.findTypeFacture(id);
	}
	@PostMapping("/add-typesFactures")
	public TypeFacture addTypeFacture(@RequestBody TypeFacture d) {
		return typeFactureService.addTypeFacture(d);
	}
	@GetMapping("/typesFactures")
	public List<TypeFacture> listerTypeFacture(){
		return typeFactureService.listeTypeFacture();
	}
	@DeleteMapping("/removeTypeFacture/{typeFacture-id}")
	public void deleteTypeFacture(@PathVariable("typeFacture-id") Long id){
		typeFactureService.deleteTypeFacture(id);
	}
	@PutMapping("/updateTypeFacture")
	public TypeFacture updateTypeFacture(@RequestBody TypeFacture d) {
		return typeFactureService.updateTypeFacture(d);
	}

}
