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
@Entity
public class Competence{
	@Id	@GeneratedValue
	private Long id;
	private String type;
	private String nomCompetence;
	
	@OneToMany(mappedBy = "competence")
	private Collection<Evaluation> evaluation =new ArrayList<Evaluation>();
	@OneToMany(mappedBy = "competences")
	private Collection<SousCompetence> sousCompetences =new ArrayList<SousCompetence>();
	@ManyToOne
	private PlanDeCarriere planDeCarriere;
	
	
	public Competence(Long id, String type, String nomCompetence, Collection<Evaluation> evaluation,
			Collection<SousCompetence> sousCompetences, PlanDeCarriere planDeCarriere) {
		super();
		this.id = id;
		this.type = type;
		this.nomCompetence = nomCompetence;
		this.evaluation = evaluation;
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
	public Collection<Evaluation> getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Collection<Evaluation> evaluation) {
		this.evaluation = evaluation;
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
	
	
}
