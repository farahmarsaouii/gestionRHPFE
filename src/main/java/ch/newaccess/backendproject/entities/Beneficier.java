package ch.newaccess.backendproject.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Beneficier {
	@Id	@GeneratedValue
	private Long id;
	private String nomBeneficier;
	
	@OneToMany(mappedBy = "beneficier")
	@JsonIgnore
	private Collection<PieceDeCaisse> pieceDeCaisse=new ArrayList<PieceDeCaisse>();
	public Beneficier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beneficier(Long id, String nomBeneficier) {
		super();
		this.id = id;
		this.nomBeneficier = nomBeneficier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomBeneficier() {
		return nomBeneficier;
	}
	public void setNomBeneficier(String nomBeneficier) {
		this.nomBeneficier = nomBeneficier;
	}
	public Collection<PieceDeCaisse> getPieceDeCaisse() {
		return pieceDeCaisse;
	}
	public void setPieceDeCaisse(Collection<PieceDeCaisse> pieceDeCaisse) {
		this.pieceDeCaisse = pieceDeCaisse;
	}
	
	
}
