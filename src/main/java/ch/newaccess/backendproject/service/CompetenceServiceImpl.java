package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.entities.SousCompetence;
import ch.newaccess.backendproject.repository.ICompetenceRepository;

@Service
public class CompetenceServiceImpl implements ICompetenceService{
	@Autowired
	public ICompetenceRepository competenceRepository;

	@Override
	public Competence addCompetence(Competence c) {

		return competenceRepository.save(c);
	}

	@Override
	public List<Competence> listeCompetence() {

		return competenceRepository.findAll();
	}

	@Override
	public Competence updateCompetence(Competence c) {
		return competenceRepository.save(c);
	}

	@Override
	public void deleteCompetence(Long idcompetence) {
		competenceRepository.deleteById(idcompetence);
		
	}

	@Override
	public List<Competence> findByPostes(Poste postes) {
		
		return competenceRepository.findByPoste(postes);
	}

	@Override
	public Competence findById(Long id) {
		// TODO Auto-generated method stub
		return competenceRepository.findById(id).get();
	}

	



}
