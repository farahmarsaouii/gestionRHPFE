package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.List;

public class CompetenceParNiveauDto implements Serializable {

	private String niveau;
	
	private List<CompetenceDto> competences;

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public List<CompetenceDto> getCompetences() {
		return competences;
	}

	public void setCompetences(List<CompetenceDto> competences) {
		this.competences = competences;
	}
	
	
}
