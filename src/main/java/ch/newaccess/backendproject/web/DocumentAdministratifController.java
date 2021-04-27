package ch.newaccess.backendproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.DocumentAdministratif;
import ch.newaccess.backendproject.service.IDocumentAdministratifService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DocumentAdministratifController {
	@Autowired
	private IDocumentAdministratifService documentAdministratifService;
	@GetMapping("/document")
	public Optional<DocumentAdministratif> listDocumentsAdministratif(@RequestParam("id") Long id){
		System.out.println("farah");
		return documentAdministratifService.findDocumentAdministratif(id);
	}
	@PostMapping("/add-document")
	public DocumentAdministratif addDocumentAdministratif(@RequestBody DocumentAdministratif d) {
		return documentAdministratifService.addDocumentAdministratif(d);
	}
	@GetMapping("/documents")
	public List<DocumentAdministratif> listerDocumentAdministratif(){
		return documentAdministratifService.listeDocumentAdministratif();
	}
	@DeleteMapping("/removedocument/{document-id}")
	public void deleteDocumentAdministratif(@PathVariable("document-id") Long id){
		documentAdministratifService.deleteDocumentAdministratif(id);
	}
	@PutMapping("/updateDocument")
	public DocumentAdministratif updateDocumentAdministratif(@RequestBody DocumentAdministratif d) {
		return documentAdministratifService.updateDocumentAdministratif(d);
	}
}
