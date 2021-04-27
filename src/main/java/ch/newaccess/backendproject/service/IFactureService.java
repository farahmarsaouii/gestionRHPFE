package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.Facture;

public interface IFactureService {
	public Optional<Facture> findFacture(Long idFacture);
	public Facture addFacture(Facture d);
	public List<Facture> listeFacture();
	public Facture updateFacture(Facture d);
	public void deleteFacture(Long idFacture);
}
