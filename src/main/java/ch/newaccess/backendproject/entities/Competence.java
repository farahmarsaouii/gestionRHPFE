package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Competence implements Serializable{
	@Id	@GeneratedValue
	private Long id;
	private String type;
	private String nomCompetence;
	private Date dateModif;
	
	
	@ManyToOne
	private Poste poste;
	
	@OneToMany(mappedBy = "competences")

	private Collection<SousCompetence> sousCompetences =new ArrayList<SousCompetence>();
	
	@ManyToOne
	private AppUser rh;
	
	public Competence(Long id, String type, String nomCompetence,
			Collection<SousCompetence> sousCompetences, AppUser rh) {
		super();
		this.id = id;
		this.type = type;
		this.nomCompetence = nomCompetence;
	
		this.sousCompetences = sousCompetences;
		this.rh = rh;
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

	public AppUser getRh() {
		return rh;
	}
	public void setRh(AppUser rh) {
		this.rh = rh;
	}
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	
	public Date getDateModif() {
		return dateModif;
	}
	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}
	public Competence(Long id, String type, String nomCompetence, Poste poste,
			Collection<SousCompetence> sousCompetences, AppUser rh) {
		super();
		this.id = id;
		this.type = type;
		this.nomCompetence = nomCompetence;	
		this.poste = poste;
		this.sousCompetences = sousCompetences;
		this.rh = rh;
	}
	

	
	
}
