package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.repository.IPosteRepository;
@Service
public class PosteServiceImpl implements IPosteService {
	@Autowired
public IPosteRepository posteRepository;
	
	@Override
	public Poste findPoste(Long idPoste) {
		return posteRepository.findById(idPoste).get();
	}

	@Override
	public Poste addPoste(Poste d) {
		return posteRepository.save(d);
	}

	@Override
	public List<Poste> listePoste() {
		return posteRepository.findAll();
	}

	@Override
	public Poste updatePoste(Poste poste) {
		Poste p= posteRepository.findById(poste.getId()).get();
		p.setNomPoste(poste.getNomPoste());
		p.setDescriptionPoste(poste.getDescriptionPoste());
		return posteRepository.save(p);
	}

	@Override
	public void deletePoste(Long idPoste) {
		posteRepository.deleteById(idPoste);
	}

	@Override
	public Poste findByUsers(AppUser users) {
		// TODO Auto-generated method stub
		return posteRepository.findByUsers(users);
	}

	@Override
	public Poste findById(Long id) {
		// TODO Auto-generated method stub
		return posteRepository.findById(id).get();
	}

}
