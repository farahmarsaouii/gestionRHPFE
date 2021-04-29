package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.Poste;

public interface IPosteService {
	public Poste findPoste(Long idPoste);
	public Poste addPoste(Poste d);
	public List<Poste> listePoste();
	public Poste updatePoste(Poste d);
	public void deletePoste(Long idPoste);
}
