package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class SousCompetence{
	@Id	@GeneratedValue
	private Long id;
	private String nomSousCompetence;
	private Boolean evaluation;
	private String commentaireSC;
	private Date dateSC;
	@ManyToOne

	private Competence competences;
	
	@ManyToOne
	private AppUser manager;
	
	@ManyToOne
	private AppUser employee;

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
	@JsonIgnore
	@JsonProperty("competences") 
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
	public AppUser getEmployee() {
		return employee;
	}
	public void setEmployee(AppUser employee) {
		this.employee = employee;
	}
	public Boolean getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Boolean evaluation) {
		this.evaluation = evaluation;
	}
	public String getCommentaireSC() {
		return commentaireSC;
	}
	public void setCommentaireSC(String commentaireSC) {
		this.commentaireSC = commentaireSC;
	}
	public Date getDateSC() {
		return dateSC;
	}
	public void setDateSC(Date dateSC) {
		this.dateSC = dateSC;
	}
	
	
}
