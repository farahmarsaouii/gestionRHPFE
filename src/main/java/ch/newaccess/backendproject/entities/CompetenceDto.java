package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.List;

public class CompetenceDto implements Serializable{

	private Competence competence;
	
	private List<SousCompetence> sousCompetences;

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public List<SousCompetence> getSousCompetences() {
		return sousCompetences;
	}

	public void setSousCompetences(List<SousCompetence> sousCompetences) {
		this.sousCompetences = sousCompetences;
	}
	
	
}
