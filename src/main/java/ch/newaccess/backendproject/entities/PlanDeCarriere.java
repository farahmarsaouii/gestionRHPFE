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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PlanDeCarriere{
	@Id	
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JsonIgnore
	private AppUser emplyee;

	
	public PlanDeCarriere(Long id, AppUser emplyee) {
		super();
		this.id = id;
		this.emplyee = emplyee;
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

	public AppUser getEmplyee() {
		return emplyee;
	}

	public void setEmplyee(AppUser emplyee) {
		this.emplyee = emplyee;
	}
	
}
