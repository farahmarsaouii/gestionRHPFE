package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Oragnigramme;
import ch.newaccess.backendproject.repository.IOrganigrammeRepository;
@Service
public class OragnigrammeServiceImpl implements IOrganigrammeService{
	@Autowired
	public IOrganigrammeRepository organigrammeRepository;

	@Override
	public Optional<Oragnigramme> findOragnigramme(Long idOragnigramme) {
		return organigrammeRepository.findById(idOragnigramme);
	}

	@Override
	public Oragnigramme addOragnigramme(Oragnigramme d) {
		return organigrammeRepository.save(d);
	}

	@Override
	public List<Oragnigramme> listeOragnigramme() {
		return organigrammeRepository.findAll();
	}

	@Override
	public Oragnigramme updateOragnigramme(Oragnigramme d) {
		return organigrammeRepository.save(d);
	}

	@Override
	public void deleteOragnigramme(Long idOragnigramme) {
		organigrammeRepository.deleteById(idOragnigramme);
	}

}
