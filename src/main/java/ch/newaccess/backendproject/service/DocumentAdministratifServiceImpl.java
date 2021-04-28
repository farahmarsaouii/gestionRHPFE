package ch.newaccess.backendproject.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.DocumentAdministratif;

import ch.newaccess.backendproject.repository.IDocumentAdministratifRepository;
@Service
public class DocumentAdministratifServiceImpl implements IDocumentAdministratifService{
	@Autowired
 public IDocumentAdministratifRepository documentAdministratifRepository ;


@Override
public Optional<DocumentAdministratif> findDocumentAdministratif(Long id) {
	return  documentAdministratifRepository.findById(id);
}

@Override
public DocumentAdministratif addDocumentAdministratif(DocumentAdministratif d) {
	return documentAdministratifRepository.save(d);
}

@Override
public List<DocumentAdministratif> listeDocumentAdministratif() {
	return documentAdministratifRepository.findAll();
}

@Override
public DocumentAdministratif updateDocumentAdministratif(DocumentAdministratif d) {
	DocumentAdministratif document=documentAdministratifRepository.findById(d.getId()).get();
	document.setContenuDocument(d.getContenuDocument());
	document.setDateCreation(d.getDateCreation());
	document.setDateModf(d.getDateModf());
	document.setFooterDocument(d.getFooterDocument());
	document.setHeaderDocument(d.getHeaderDocument());
	document.setTitreDocument(d.getTitreDocument());
	document.setNomDocument(d.getNomDocument());
	document.setType(d.getType());
	document.setDateModf(new Date());
	
	
	return documentAdministratifRepository.save(document);
}

@Override
public void deleteDocumentAdministratif(Long idDocumentAdministratif) {
	documentAdministratifRepository.deleteById(idDocumentAdministratif);
}


	

}
