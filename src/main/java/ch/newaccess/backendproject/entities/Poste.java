package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Poste{
	@Id	@GeneratedValue
	private Long id;
	private String nomPoste;
	private String descriptionPoste;
	

	
	@OneToMany(mappedBy = "poste")
	@JsonIgnore
	private Collection<AppUser> users =new ArrayList<AppUser>();
	
	@OneToMany(mappedBy = "poste")
	@JsonIgnore
	private Collection<Competence> competences= new ArrayList<Competence>();
	

	public Poste(Long id, String nomPoste, Collection<AppUser> users, Collection<Competence> competences) {
		super();
		this.id = id;
		this.nomPoste = nomPoste;
		this.users = users;
		this.competences = competences;
	}
	public Poste() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomPoste() {
		return nomPoste;
	}
	public void setNomPoste(String nomPoste) {
		this.nomPoste = nomPoste;
	}
	public Collection<AppUser> getUsers() {
		return users;
	}
	public void setUsers(Collection<AppUser> users) {
		this.users = users;
	}
	public Collection<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(Collection<Competence> competences) {
		this.competences = competences;
	}
	public String getDescriptionPoste() {
		return descriptionPoste;
	}
	public void setDescriptionPoste(String descriptionPoste) {
		this.descriptionPoste = descriptionPoste;
	}
	public Poste(Long id, String nomPoste, String descriptionPoste, Collection<AppUser> users,
			Collection<Competence> competences) {
		super();
		this.id = id;
		this.nomPoste = nomPoste;
		this.descriptionPoste = descriptionPoste;
		this.users = users;
		this.competences = competences;
	}

	
	
}
