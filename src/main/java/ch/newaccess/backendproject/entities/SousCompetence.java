package ch.newaccess.backendproject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class SousCompetence{
	@Id	@GeneratedValue
	private Long id;
	private String nomSousCompetence;
	@ManyToOne
	private Competence competences;
	public SousCompetence(Long id, String nomSousCompetence, Competence competences) {
		super();
		this.id = id;
		this.nomSousCompetence = nomSousCompetence;
		this.competences = competences;
	}
	public SousCompetence() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomSousCompetence() {
		return nomSousCompetence;
	}
	public void setNomSousCompetence(String nomSousCompetence) {
		this.nomSousCompetence = nomSousCompetence;
	}
	public Competence getCompetences() {
		return competences;
	}
	public void setCompetences(Competence competences) {
		this.competences = competences;
	}
	
	
}
