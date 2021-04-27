package ch.newaccess.backendproject.service;

import java.util.List;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.DemandeDocument;

public interface IDemandeDocumentService {
	public DemandeDocument addDemandeDocument(DemandeDocument d);
	public List<DemandeDocument> listeDemandeDocument();
	public DemandeDocument updateDemandeDocument(DemandeDocument d);
	public void deleteDemandeDocument(Long idDemandeDocument);
	public List<DemandeDocument> findDemandeByEmplyee (String name);
}
