package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Facture{
	@Id	@GeneratedValue
	private Long id;
	private String nomFacture;
	private Date dateCreation;
	private Date dateModi;
	@ManyToOne
private TypeFacture typeFacture;
	public Facture(Long id, String nomFacture, Date dateCreation, Date dateModi, TypeFacture typeFacture) {
		super();
		this.id = id;
		this.nomFacture = nomFacture;
		this.dateCreation = dateCreation;
		this.dateModi = dateModi;
		this.typeFacture = typeFacture;
	}
	public Facture() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomFacture() {
		return nomFacture;
	}
	public void setNomFacture(String nomFacture) {
		this.nomFacture = nomFacture;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateModi() {
		return dateModi;
	}
	public void setDateModi(Date dateModi) {
		this.dateModi = dateModi;
	}
	public TypeFacture getTypeFacture() {
		return typeFacture;
	}
	public void setTypeFacture(TypeFacture typeFacture) {
		this.typeFacture = typeFacture;
	}
	
	
}
