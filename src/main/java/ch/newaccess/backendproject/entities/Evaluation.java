package ch.newaccess.backendproject.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation{
	@Id	@GeneratedValue
	private Long id;
	@ManyToOne
	private Competence competence;
	@ManyToOne
	private AppUser competenceEmplyee;
	public Evaluation(Long id, Competence competence, AppUser competenceEmplyee) {
		super();
		this.id = id;
		this.competence = competence;
		this.competenceEmplyee = competenceEmplyee;
	}
	public Evaluation() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	public AppUser getCompetenceEmplyee() {
		return competenceEmplyee;
	}
	public void setCompetenceEmplyee(AppUser competenceEmplyee) {
		this.competenceEmplyee = competenceEmplyee;
	}
	
	
}
