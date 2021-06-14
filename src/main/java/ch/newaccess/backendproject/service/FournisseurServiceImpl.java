package ch.newaccess.backendproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Fournisseur;
import ch.newaccess.backendproject.repository.IFournisseurRepository;
@Service
public class FournisseurServiceImpl implements IFournisseurService{

	@Autowired
	public IFournisseurRepository fournisseurRepository;
	@Override
	public Fournisseur addFournisseur(Fournisseur f) {	
		return fournisseurRepository.save(f);
	}

	@Override
	public List<Fournisseur> listeFournisseur() {
		return fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		Fournisseur fournisseur=fournisseurRepository.findById(f.getId()).get();
		fournisseur.setAdresse(f.getAdresse());
		fournisseur.setDescription(f.getDescription());
		fournisseur.setHt(f.isHt());
		fournisseur.setMatriculeFiscale(f.getMatriculeFiscale());
		fournisseur.setNomFournisseur(f.getNomFournisseur());
		fournisseur.setNum_tel(f.getNum_tel());
		fournisseur.setRetenueAlaSource(f.isRetenueAlaSource());
		fournisseur.setRhFournisseur(f.getRhFournisseur());
		fournisseur.setRib(f.getRib());
		fournisseur.setTtc(f.isTtc());
		
		return fournisseurRepository.save(fournisseur);
	}

	@Override
	public void deleteFournisseur(Long idFournisseur) {
		fournisseurRepository.deleteById(idFournisseur);
		
	}

	@Override
	public Fournisseur findById(Long id) {	
		return fournisseurRepository.findById(id).get();
	}

}
