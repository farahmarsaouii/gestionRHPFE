package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PlanDeCarriere{
	@Id	@GeneratedValue
	private Long id;
	@OneToMany(mappedBy = "planDeCarriere")
	private Collection<Competence> competences =new ArrayList<Competence>();
	public PlanDeCarriere(Long id, Collection<Competence> competences) {
		super();
		this.id = id;
		this.competences = competences;
	}
	public PlanDeCarriere() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Collection<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(Collection<Competence> competences) {
		this.competences = competences;
	}
	
	
}
