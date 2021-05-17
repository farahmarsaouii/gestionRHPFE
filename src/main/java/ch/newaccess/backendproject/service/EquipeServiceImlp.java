package ch.newaccess.backendproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Equipe;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.repository.IEquipeRepository;
@Service
public class EquipeServiceImlp implements IEquipeService{
	@Autowired
	public IEquipeRepository equipeRepository;

	@Override
	public List<Equipe> listeEquipe() {
		return equipeRepository.findAll();
	}

	@Override
	public Equipe findEquipe(Long idEquipe) {

		return equipeRepository.findById(idEquipe).get();
	}

	@Override
	public Equipe addEquipe(Equipe e) {

		return equipeRepository.save(e);
	}

	@Override
	public Equipe updateEquipe(Equipe equipe) {
		Equipe e= equipeRepository.findById(equipe.getId()).get();
		e.setNomEquipe(equipe.getNomEquipe());
	
		return equipeRepository.save(e);

	}

	@Override
	public void deleteEquipe(Long idEquipe) {
		equipeRepository.deleteById(idEquipe);
		
	}

}
