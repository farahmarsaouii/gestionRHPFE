package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.Oragnigramme;

public interface IOrganigrammeService {
	public Optional<Oragnigramme> findOragnigramme(Long idOragnigramme);
	public Oragnigramme addOragnigramme(Oragnigramme d);
	public List<Oragnigramme> listeOragnigramme();
	public Oragnigramme updateOragnigramme(Oragnigramme d);
	public void deleteOragnigramme(Long idOragnigramme);
}
