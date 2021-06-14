package ch.newaccess.backendproject.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Cheque {
	@Id	@GeneratedValue
private Long id;
private String numeroCheque;

@OneToOne(mappedBy = "numCheque")
private PieceDeCaisse pieceDeCaisse;

@OneToOne(mappedBy = "numeroCheque")
private FactureFournisseur factureFournisseur;

public Cheque() {
	super();
}


public Cheque(String numeroCheque) {
	super();
	
	this.numeroCheque = numeroCheque;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
@JsonIgnore
@JsonProperty("numeroCheque") 
public String getNumeroCheque() {
	return numeroCheque;
}


public void setNumeroCheque(String numeroCheque) {
	this.numeroCheque = numeroCheque;
}

@JsonIgnore
@JsonProperty("pieceDeCaisse") 
public PieceDeCaisse getPieceDeCaisse() {
	return pieceDeCaisse;
}


public void setPieceDeCaisse(PieceDeCaisse pieceDeCaisse) {
	this.pieceDeCaisse = pieceDeCaisse;
}

@JsonIgnore
@JsonProperty("factureFournisseur") 
public FactureFournisseur getFactureFournisseur() {
	return factureFournisseur;
}


public void setFactureFournisseur(FactureFournisseur factureFournisseur) {
	this.factureFournisseur = factureFournisseur;
}

}
