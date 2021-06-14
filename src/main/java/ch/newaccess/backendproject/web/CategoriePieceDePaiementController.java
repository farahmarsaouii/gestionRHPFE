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

import ch.newaccess.backendproject.entities.CategoriePieceDeCaisse;
import ch.newaccess.backendproject.service.ICategoriePieceDePaiementService;

@RestController
public class CategoriePieceDePaiementController {
	@Autowired
	public ICategoriePieceDePaiementService categoriePieceDePaiementService;
	
	@GetMapping("/categoriePieceDeCaisse")
	public CategoriePieceDeCaisse findcategoriePieceDeCaisse(@RequestParam("categoriePieceDeCaisse-id") Long id){
		return categoriePieceDePaiementService.findCategoriePieceDeCaisse(id).get();
	}
	@PostMapping("/add-categoriePieceDeCaisse")
	public CategoriePieceDeCaisse addcategoriePieceDeCaisse(@RequestBody CategoriePieceDeCaisse d) {
		return categoriePieceDePaiementService.addCategoriePieceDeCaisse(d);
	}
	@GetMapping("/categoriePieceDeCaisses")
	public List<CategoriePieceDeCaisse> findcategoriePieceDeCaisses(){
		return categoriePieceDePaiementService.listeCategoriePieceDeCaisse();
	}
	@DeleteMapping("/removecategoriePieceDeCaisse/{categoriePieceDeCaisse-id}")
	public void deletecategoriePieceDeCaisse(@PathVariable("categoriePieceDeCaisse-id") Long id){
		categoriePieceDePaiementService.deleteCategoriePieceDeCaisse(id);
	}
	@PutMapping("/updatecategoriePieceDeCaisse")
	public CategoriePieceDeCaisse updatecategoriePieceDeCaisse(@RequestBody CategoriePieceDeCaisse d) {
		return categoriePieceDePaiementService.updateCategoriePieceDeCaisse(d);
	}

}
