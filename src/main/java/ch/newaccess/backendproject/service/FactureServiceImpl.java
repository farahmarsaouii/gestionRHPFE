package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Facture;
import ch.newaccess.backendproject.repository.IFactureRepository;
@Service
public class FactureServiceImpl implements IFactureService{
	@Autowired
	public IFactureRepository factureRepository;

	@Override
	public Optional<Facture> findFacture(Long idFacture) {
		return factureRepository.findById(idFacture);
	}

	@Override
	public Facture addFacture(Facture d) {
		return factureRepository.save(d);
	}

	@Override
	public List<Facture> listeFacture() {
		return factureRepository.findAll();
	}

	@Override
	public Facture updateFacture(Facture d) {
		return factureRepository.save(d);
	}

	@Override
	public void deleteFacture(Long idFacture) {
		factureRepository.deleteById(idFacture);
	}

}
