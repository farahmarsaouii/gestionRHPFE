package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Competence{
	@Id	@GeneratedValue
	private Long id;
	private String type;
	private String nomCompetence;
	private Boolean evaluation;
	public String niveau;
	
	
	@OneToMany(mappedBy = "competences")
	@JsonIgnore
	private Collection<SousCompetence> sousCompetences =new ArrayList<SousCompetence>();
	@ManyToOne
	@JsonIgnore
	private PlanDeCarriere planDeCarriere;
	
	
	public Competence(Long id, String type, String nomCompetence, Boolean evaluation, String niveau,
			Collection<SousCompetence> sousCompetences, PlanDeCarriere planDeCarriere) {
		super();
		this.id = id;
		this.type = type;
		this.nomCompetence = nomCompetence;
		this.evaluation = evaluation;
		this.niveau = niveau;
		this.sousCompetences = sousCompetences;
		this.planDeCarriere = planDeCarriere;
	}
	public Competence() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNomCompetence() {
		return nomCompetence;
	}
	public void setNomCompetence(String nomCompetence) {
		this.nomCompetence = nomCompetence;
	}
	
	public Collection<SousCompetence> getSousCompetences() {
		return sousCompetences;
	}
	public void setSousCompetences(Collection<SousCompetence> sousCompetences) {
		this.sousCompetences = sousCompetences;
	}
	public PlanDeCarriere getPlanDeCarriere() {
		return planDeCarriere;
	}
	public void setPlanDeCarriere(PlanDeCarriere planDeCarriere) {
		this.planDeCarriere = planDeCarriere;
	}
	public Boolean getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Boolean evaluation) {
		this.evaluation = evaluation;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	
}
