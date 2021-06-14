package ch.newaccess.backendproject.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class PieceDeCaisse{
	@Id	@GeneratedValue
	private Long id;
	private String details;
	private Date date;
	@ManyToOne
private Beneficier beneficier;
private String montant;
private Boolean modedepaiement;


@OneToOne
private Cheque numCheque;

@ManyToOne
private CategoriePieceDeCaisse categoriePieceDeCaisse;
public PieceDeCaisse(Long id, String details, Date date, Beneficier beneficier, String montant) {
	super();
	this.id = id;
	this.details = details;
	this.date = date;
	this.beneficier = beneficier;
	this.montant = montant;
	
}
public PieceDeCaisse(String details, Date date, Beneficier beneficier, String montant) {
	super();
	this.details = details;
	this.date = date;
	this.beneficier = beneficier;
	this.montant = montant;

}


public PieceDeCaisse(Long id, String details, Date date, Beneficier beneficier, String montant,
		 CategoriePieceDeCaisse categoriePieceDeCaisse) {
	super();
	this.id = id;
	this.details = details;
	this.date = date;
	this.beneficier = beneficier;
	this.montant = montant;

	this.categoriePieceDeCaisse = categoriePieceDeCaisse;
}
public PieceDeCaisse() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Beneficier getBeneficier() {
	return beneficier;
}
public void setBeneficier(Beneficier beneficier) {
	this.beneficier = beneficier;
}
public String getMontant() {
	return montant;
}
public void setMontant(String montant) {
	this.montant = montant;
}

public CategoriePieceDeCaisse getCategoriePieceDeCaisse() {
	return categoriePieceDeCaisse;
}
public void setCategoriePieceDeCaisse(CategoriePieceDeCaisse categoriePieceDeCaisse) {
	this.categoriePieceDeCaisse = categoriePieceDeCaisse;
}
public Boolean getModedepaiement() {
	return modedepaiement;
}
public void setModedepaiement(Boolean modedepaiement) {
	this.modedepaiement = modedepaiement;
}
public Cheque getNumCheque() {
	return numCheque;
}
public void setNumCheque(Cheque numCheque) {
	this.numCheque = numCheque;
}



}