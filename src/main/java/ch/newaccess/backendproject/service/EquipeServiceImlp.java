package ch.newaccess.backendproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Equipe;
import ch.newaccess.backendproject.repository.IEquipeRepository;
@Service
public class EquipeServiceImlp implements IEquipeService{
	@Autowired
	public IEquipeRepository equipeRepository;

	@Override
	public List<Equipe> listeEquipe() {
		return equipeRepository.findAll();
	}

}
