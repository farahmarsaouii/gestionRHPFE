package ch.newaccess.backendproject.service;

import java.util.List;

import ch.newaccess.backendproject.entities.Fournisseur;


public interface IFournisseurService {
	public Fournisseur addFournisseur(Fournisseur f);
	public List<Fournisseur> listeFournisseur();
	public Fournisseur updateFournisseur(Fournisseur f);
	public void deleteFournisseur(Long idFournisseur);
	public Fournisseur findById(Long id);
}
