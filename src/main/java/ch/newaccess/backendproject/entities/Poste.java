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
public class Poste{
	@Id	@GeneratedValue
	private Long id;
	private String nomPoste;
	@OneToMany(mappedBy = "poste")
	private Collection<AppUser> user =new ArrayList<AppUser>();
	
	public Poste(Long id, String nomPoste, Collection<AppUser> user) {
		super();
		this.id = id;
		this.nomPoste = nomPoste;
		this.user = user;
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
	public Collection<AppUser> getUser() {
		return user;
	}
	public void setUser(Collection<AppUser> user) {
		this.user = user;
	}
	
	
}
