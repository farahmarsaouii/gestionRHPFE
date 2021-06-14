package ch.newaccess.backendproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.FactureFournisseur;
import ch.newaccess.backendproject.repository.IFactureFournisseurRepository;
@Service
public class FactureFournisseurServiceImpl implements IFactureFournisseurService{
@Autowired
public IFactureFournisseurRepository fournisseurRepository;
	@Override
	public FactureFournisseur addFactureFournisseur(FactureFournisseur c) {
	
		return fournisseurRepository.save(c);
	}

	@Override
	public List<FactureFournisseur> listeFactureFournisseur() {

		return fournisseurRepository.findAll();
	}

	@Override
	public FactureFournisseur updateFactureFournisseur(FactureFournisseur c) {
	FactureFournisseur factureFournisseur=fournisseurRepository.findById(c.getId()).get();
	factureFournisseur.setBonDeCommande(c.getBonDeCommande());
	factureFournisseur.setDatePaiement(c.getDatePaiement());
	factureFournisseur.setDateReceptionFacture(c.getDateReceptionFacture());
	factureFournisseur.setDetails(c.getDetails());
	factureFournisseur.setFournisseur(c.getFournisseur());
	factureFournisseur.setModepaiement(c.getModepaiement());
	factureFournisseur.setMontantAPayer(c.getMontantAPayer());
	factureFournisseur.setMontantHT(c.getMontantHT());
	factureFournisseur.setMontantTTC(c.getMontantTTC());
	factureFournisseur.setRevenueAlaSource(c.getRevenueAlaSource());
	factureFournisseur.setRhFactureFournisseur(c.getRhFactureFournisseur());
	
		return fournisseurRepository.save(factureFournisseur);
	}

	@Override
	public void deleteFactureFournisseur(Long idFactureFournisseur) {
		fournisseurRepository.deleteById(idFactureFournisseur);
		
	}

	@Override
	public FactureFournisseur findById(Long id) {

		return fournisseurRepository.findById(id).get();
	}

}
