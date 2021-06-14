package ch.newaccess.backendproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.DemandeDocument;
import ch.newaccess.backendproject.repository.IDemandeDocumentRepository;
import ch.newaccess.backendproject.repository.UserRespository;

@Service
public class DemandeDocumentServiceImpl implements IDemandeDocumentService {
	@Autowired
public IDemandeDocumentRepository demandeDocumentRepository;
	@Autowired
	private UserRespository userRespository;

	@Override
	public DemandeDocument addDemandeDocument(DemandeDocument d) {
		
		return demandeDocumentRepository.save(d);
	}

	@Override
	public List<DemandeDocument> listeDemandeDocument() {
		
		return demandeDocumentRepository.findAll();
	}

	@Override
	public DemandeDocument updateDemandeDocument(DemandeDocument d) {
	DemandeDocument demandeDoc =demandeDocumentRepository.findById(d.getId()).get();
	demandeDoc.setCommentaire(d.getCommentaire());
	demandeDoc.setDate(d.getDate());
	demandeDoc.setRaisonDocument(d.getRaisonDocument());
		return demandeDocumentRepository.save(demandeDoc);
	}

	@Override
	public void deleteDemandeDocument(Long idDemandeDocument) {
		demandeDocumentRepository.deleteById(idDemandeDocument);
		
	}

	@Override
	public List<DemandeDocument> findDemandeByEmplyee(String name) {
		AppUser user= userRespository.findByUserName(name);
		return demandeDocumentRepository.findByEmplyee(user);
	}
}
