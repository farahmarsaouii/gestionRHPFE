package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.SousCompetence;
import ch.newaccess.backendproject.repository.ISousCompetenceRepository;
@Service
public class SousCompetenceServiceImpl implements ISousCompetenceService{
public ISousCompetenceRepository sousCompetenceRepository;
	@Override
	public Optional<SousCompetence> findSousCompetence(Long idSousCompetence) {
		return sousCompetenceRepository.findById(idSousCompetence);
	}

	@Override
	public SousCompetence addSousCompetence(SousCompetence d) {
		return sousCompetenceRepository.save(d);
	}

	@Override
	public List<SousCompetence> listeSousCompetence() {
		return sousCompetenceRepository.findAll();
	}

	@Override
	public SousCompetence updateSousCompetence(SousCompetence d) {
		return sousCompetenceRepository.save(d);
	}

	@Override
	public void deleteSousCompetence(Long idSousCompetence) {
		sousCompetenceRepository.deleteById(idSousCompetence);
	}

}
