package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Poste{
	@Id	@GeneratedValue
	private Long id;
	private String nomPoste;
	

	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "poste")
	private Collection<PlanDeCarriere> planDeCarriere =new ArrayList<PlanDeCarriere>();
	
	
	public Poste(Long id, String nomPoste,Collection<PlanDeCarriere> planDeCarriere) {
		super();
		this.id = id;
		this.nomPoste = nomPoste;
		this.planDeCarriere = planDeCarriere;
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
	public Collection<PlanDeCarriere> getPlanDeCarriere() {
		return planDeCarriere;
	}

	public void setPlanDeCarriere(Collection<PlanDeCarriere> planDeCarriere) {
		this.planDeCarriere = planDeCarriere;
	}
	
	
}
