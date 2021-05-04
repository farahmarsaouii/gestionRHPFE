package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.Competence;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.entities.SousCompetence;

public interface ICompetenceService {
public Competence addCompetence(Competence c);
public List<Competence> listeCompetence();
public Competence updateCompetence(Competence c);
public void deleteCompetence(Long idcompetence);
public List<Competence> findByPostes(Poste postes);
public Competence findById(Long id);



}
