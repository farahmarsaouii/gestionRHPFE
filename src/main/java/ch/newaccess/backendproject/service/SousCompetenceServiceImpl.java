package ch.newaccess.backendproject.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.DocumentAdministratif;
import ch.newaccess.backendproject.entities.SousCompetence;
import ch.newaccess.backendproject.repository.ISousCompetenceRepository;
@Service
public class SousCompetenceServiceImpl implements ISousCompetenceService{
	@Autowired
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
		SousCompetence sc=sousCompetenceRepository.findById(d.getId()).get();

		sc.setNomSousCompetence(d.getNomSousCompetence());
		sc.setCommentaireSC(d.getCommentaireSC());
		sc.setDateSC(d.getDateSC());
		sc.setEvaluation(d.getEvaluation());
		sc.setManager(d.getManager());
		System.out.println("hello****"+sc);
		
		return sousCompetenceRepository.save(sc);
	}

	@Override
	public void deleteSousCompetence(Long idSousCompetence) {
		sousCompetenceRepository.deleteById(idSousCompetence);
	}

	@Override
	public List<SousCompetence> findByCompetences(Competence competences) {
	
		return sousCompetenceRepository.findByCompetences(competences);
	}

	@Override
	public List<SousCompetence> findByEmployee(Long employeeId) {
		return sousCompetenceRepository.findByEmployeeId(employeeId);
	}

	

}
