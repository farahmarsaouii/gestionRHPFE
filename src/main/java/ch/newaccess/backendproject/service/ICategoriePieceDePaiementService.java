package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.CategoriePieceDeCaisse;


public interface ICategoriePieceDePaiementService {
	public Optional<CategoriePieceDeCaisse> findCategoriePieceDeCaisse(Long id);
	public CategoriePieceDeCaisse addCategoriePieceDeCaisse(CategoriePieceDeCaisse d);
	public List<CategoriePieceDeCaisse> listeCategoriePieceDeCaisse();
	public CategoriePieceDeCaisse updateCategoriePieceDeCaisse(CategoriePieceDeCaisse d);
	public void deleteCategoriePieceDeCaisse(Long id);
}
