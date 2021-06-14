package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.PieceDeCaisse;

public interface IPieceDeFactureService {
	public Optional<PieceDeCaisse> findPieceDeCaisse(Long id);
	public PieceDeCaisse addPieceDeCaisse(PieceDeCaisse d);
	public List<PieceDeCaisse> listePieceDeCaisse();
	public PieceDeCaisse updatePieceDeCaisse(PieceDeCaisse d);
	public void deletePieceDeCaisse(Long idFacture);
}
