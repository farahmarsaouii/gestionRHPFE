package ch.newaccess.backendproject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class SousCompetence{
	@Id	@GeneratedValue
	private Long id;
	private String nomSousCompetence;
	@ManyToOne
	@JsonIgnore
	private Competence competences;
	
	@ManyToOne
	private AppUser manager;
	

	public SousCompetence(Long id, String nomSousCompetence, Competence competences, AppUser manager) {
		super();
		this.id = id;
		this.nomSousCompetence = nomSousCompetence;
		this.competences = competences;
		this.manager = manager;
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
	public AppUser getManager() {
		return manager;
	}
	public void setManager(AppUser manager) {
		this.manager = manager;
	}
	
	
}
