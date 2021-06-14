package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.CategoriePieceDeCaisse;
import ch.newaccess.backendproject.repository.ICategoriePieceDePaiement;
@Service
public class CategoriePieceDePaiementServiceImpl implements ICategoriePieceDePaiementService{
	@Autowired
	public ICategoriePieceDePaiement categoriePieceDePaiement;

	@Override
	public Optional<CategoriePieceDeCaisse> findCategoriePieceDeCaisse(Long id) {
	
		return categoriePieceDePaiement.findById(id);
	}

	@Override
	public CategoriePieceDeCaisse addCategoriePieceDeCaisse(CategoriePieceDeCaisse d) {
	
		return categoriePieceDePaiement.save(d);
	}

	@Override
	public List<CategoriePieceDeCaisse> listeCategoriePieceDeCaisse() {

		return categoriePieceDePaiement.findAll();
	}

	@Override
	public CategoriePieceDeCaisse updateCategoriePieceDeCaisse(CategoriePieceDeCaisse d) {
	CategoriePieceDeCaisse c= categoriePieceDePaiement.findById(d.getId()).get();
	c.setDescriptionCategorie(d.getDescriptionCategorie());
	c.setNomCategorie(d.getNomCategorie());
		return categoriePieceDePaiement.save(c);
	}

	@Override
	public void deleteCategoriePieceDeCaisse(Long id) {
		categoriePieceDePaiement.deleteById(id);
		
	}

}
