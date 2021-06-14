package ch.newaccess.backendproject.service;

import java.util.List;

import ch.newaccess.backendproject.entities.FactureFournisseur;


public interface IFactureFournisseurService {
	public FactureFournisseur addFactureFournisseur(FactureFournisseur c);
	public List<FactureFournisseur> listeFactureFournisseur();
	public FactureFournisseur updateFactureFournisseur(FactureFournisseur c);
	public void deleteFactureFournisseur(Long idFactureFournisseur);
	public FactureFournisseur findById(Long id);
}
