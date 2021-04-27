package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.DocumentAdministratif;

public interface IDocumentAdministratifService {
public Optional<DocumentAdministratif> findDocumentAdministratif(Long id);
public DocumentAdministratif addDocumentAdministratif(DocumentAdministratif d);
public List<DocumentAdministratif> listeDocumentAdministratif();
public DocumentAdministratif updateDocumentAdministratif(DocumentAdministratif d);
public void deleteDocumentAdministratif(Long idDocumentAdministratif);

}
