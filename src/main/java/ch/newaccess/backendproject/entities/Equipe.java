package ch.newaccess.backendproject.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Equipe {
	@Id @GeneratedValue
	private Long id;
	private String nomEquipe;
	@OneToMany(mappedBy = "equipe")
	@JsonIgnore
	private Collection<AppUser> users =new ArrayList<AppUser>();
	public Equipe() {
		super();
	}
	public Equipe(Long id, String nomEquipe, Collection<AppUser> users) {
		super();
		this.id = id;
		this.nomEquipe = nomEquipe;
		this.users = users;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public Collection<AppUser> getUsers() {
		return users;
	}
	public void setUsers(Collection<AppUser> users) {
		this.users = users;
	}
	
}
