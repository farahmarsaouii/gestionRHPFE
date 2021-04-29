package ch.newaccess.backendproject.service;

import java.util.List;

import ch.newaccess.backendproject.entities.Competence;

public interface ICompetenceService {
public Competence addCompetence(Competence c);
public List<Competence> listeCompetence();
public Competence updateCompetence(Competence c);
public void deleteCompetence(Long idcompetence);
public List<Competence> findPosteByNiveau(String niveau);

}
