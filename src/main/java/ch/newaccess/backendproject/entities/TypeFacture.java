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

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class TypeFacture{
	@Id	@GeneratedValue
	private Long id;
	private String nomTypeFacture;
	//@OneToMany(mappedBy = "typeFacture")
	//@JsonIgnore
	//private Collection<PieceDeCaisse> factures =new ArrayList<PieceDeCaisse>();
	public TypeFacture(Long id, String nomTypeFacture) {
		super();
		this.id = id;
		this.nomTypeFacture = nomTypeFacture;
	
	}
	public TypeFacture() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomTypeFacture() {
		return nomTypeFacture;
	}
	public void setNomTypeFacture(String nomTypeFacture) {
		this.nomTypeFacture = nomTypeFacture;
	}
	
	
	
}
