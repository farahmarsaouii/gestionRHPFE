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
public class PlanDeCarriere{
	@Id	
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private AppUser emplyee;

	@ManyToOne
	@JsonIgnore
	private Poste poste;
	@OneToMany(mappedBy = "planDeCarriere")
	
	private Collection<Competence> competences =new ArrayList<Competence>();
	
	
	public PlanDeCarriere(Long id, Collection<Competence> competences) {
		super();
		this.id = id;
		this.competences = competences;
	}
	
	public PlanDeCarriere(Long id, AppUser emplyee, Poste poste, Collection<Competence> competences) {
		super();
		this.id = id;
		this.emplyee = emplyee;
		this.poste = poste;
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

	public AppUser getEmplyee() {
		return emplyee;
	}

	public void setEmplyee(AppUser emplyee) {
		this.emplyee = emplyee;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	
	
}
