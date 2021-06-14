package ch.newaccess.backendproject.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class CategoriePieceDeCaisse {
	@Id	@GeneratedValue
	private Long id;
	private String nomCategorie;
	private String descriptionCategorie;
	
	@OneToMany(mappedBy = "categoriePieceDeCaisse")
	@JsonIgnore
	private Collection<PieceDeCaisse> pieceDeCaisse=new ArrayList<PieceDeCaisse>();

	public CategoriePieceDeCaisse() {
		super();
	}

	public CategoriePieceDeCaisse(Long id, String nomCategorie, String descriptionCategorie,
			Collection<PieceDeCaisse> pieceDeCaisse) {
		super();
		this.id = id;
		this.nomCategorie = nomCategorie;
		this.descriptionCategorie = descriptionCategorie;
		this.pieceDeCaisse = pieceDeCaisse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescriptionCategorie() {
		return descriptionCategorie;
	}

	public void setDescriptionCategorie(String descriptionCategorie) {
		this.descriptionCategorie = descriptionCategorie;
	}

	public Collection<PieceDeCaisse> getPieceDeCaisse() {
		return pieceDeCaisse;
	}

	public void setPieceDeCaisse(Collection<PieceDeCaisse> pieceDeCaisse) {
		this.pieceDeCaisse = pieceDeCaisse;
	}
	
	
	
}
