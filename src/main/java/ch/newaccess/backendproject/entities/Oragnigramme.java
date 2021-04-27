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
public class Oragnigramme{
	@Id	@GeneratedValue
	private Long id;
	private String nomOrganigramme;
	@OneToMany(mappedBy = "organigramme")
	private Collection<AppUser> Users =new ArrayList<AppUser>();
	public Oragnigramme(Long id, String nomOrganigramme, Collection<AppUser> users) {
		super();
		this.id = id;
		this.nomOrganigramme = nomOrganigramme;
		Users = users;
	}
	public Oragnigramme() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomOrganigramme() {
		return nomOrganigramme;
	}
	public void setNomOrganigramme(String nomOrganigramme) {
		this.nomOrganigramme = nomOrganigramme;
	}
	public Collection<AppUser> getUsers() {
		return Users;
	}
	public void setUsers(Collection<AppUser> users) {
		Users = users;
	}
	 
}
