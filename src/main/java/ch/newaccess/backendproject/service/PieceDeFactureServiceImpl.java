package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.PieceDeCaisse;
import ch.newaccess.backendproject.repository.IPieceDePaiementRepository;
@Service
public class PieceDeFactureServiceImpl implements IPieceDeFactureService{
	@Autowired
	public IPieceDePaiementRepository factureRepository;

	@Override
	public Optional<PieceDeCaisse> findPieceDeCaisse(Long id) {
		return factureRepository.findById(id);
	}

	@Override
	public PieceDeCaisse addPieceDeCaisse(PieceDeCaisse d) {
		return factureRepository.save(d);
	}

	@Override
	public List<PieceDeCaisse> listePieceDeCaisse() {
		return factureRepository.findAll();
	}

	@Override
	public PieceDeCaisse updatePieceDeCaisse(PieceDeCaisse d) {
		PieceDeCaisse pieceDeCaisse =factureRepository.findById(d.getId()).get();
		pieceDeCaisse.setBeneficier(d.getBeneficier());
		pieceDeCaisse.setCategoriePieceDeCaisse(d.getCategoriePieceDeCaisse());
		pieceDeCaisse.setDate(d.getDate());
		pieceDeCaisse.setDetails(d.getDetails());
		pieceDeCaisse.setModedepaiement(d.getModedepaiement());
		pieceDeCaisse.setMontant(d.getMontant());
		pieceDeCaisse.setNumCheque(d.getNumCheque());
		return factureRepository.save(pieceDeCaisse);
	}

	@Override
	public void deletePieceDeCaisse(Long idFacture) {
		factureRepository.deleteById(idFacture);
	}

}
