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

import ch.newaccess.backendproject.entities.DemandeDocument;
import ch.newaccess.backendproject.service.IDemandeDocumentService;
@RestController
public class DemandeDocumentController {
	@Autowired
public IDemandeDocumentService demandeDocumentService;
	
	@PostMapping("/add-demandeDocument")
	public DemandeDocument addDemandeDocument(@RequestBody DemandeDocument d) {
		System.out.println("farahadddd"+d.getCommentaire()+"   "+d.getRaisonDocument());
		return demandeDocumentService.addDemandeDocument(d);
	}
	
	@GetMapping("/demandeDocumentsbyuser")
	public List<DemandeDocument> listerDemandeDocumentbyEmployee(@RequestParam("username") String username){
		return demandeDocumentService.findDemandeByEmplyee(username);
	}
	@GetMapping("/demandeDocuments")
	public List<DemandeDocument> listerDemandeDocument(){
		return demandeDocumentService.listeDemandeDocument();
	}
	@DeleteMapping("/remove/{demandeDocument-id}")
	public void deleteDemandeDocument(@PathVariable("demandeDocument-id") Long id){
		demandeDocumentService.deleteDemandeDocument(id);
	}
	@PutMapping("/updateDemandeDocument")
	public DemandeDocument updateDemandeDocument(@RequestBody DemandeDocument d) {
		return demandeDocumentService.updateDemandeDocument(d);
	}
}
