package ch.newaccess.backendproject.service;

import java.util.List;
import ch.newaccess.backendproject.entities.Equipe;



public interface IEquipeService {
	public List<Equipe> listeEquipe();
	public Equipe findEquipe(Long idEquipe);
	
	public Equipe addEquipe(Equipe e);
	public Equipe updateEquipe(Equipe e);
	public void deleteEquipe(Long idEquipe);

}
