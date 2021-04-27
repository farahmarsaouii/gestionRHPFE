package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.SousCompetence;

public interface ISousCompetenceService {
	public Optional<SousCompetence> findSousCompetence(Long idSousCompetence);
	public SousCompetence addSousCompetence(SousCompetence d);
	public List<SousCompetence> listeSousCompetence();
	public SousCompetence updateSousCompetence(SousCompetence d);
	public void deleteSousCompetence(Long idSousCompetence);
}
