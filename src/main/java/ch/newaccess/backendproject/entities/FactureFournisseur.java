package ch.newaccess.backendproject.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class FactureFournisseur {
	@Id @GeneratedValue
private Long id;
private String bonDeCommande;
private String details;
private Date dateReceptionFacture;
private float montantHT;
private float montantTTC;
private float montantAPayer;
private float revenueAlaSource;
private Date datePaiement;
private Boolean modepaiement;


@OneToOne
private Cheque numeroCheque;

@ManyToOne
private Fournisseur fournisseur;

@ManyToOne
private AppUser rhFactureFournisseur;


public FactureFournisseur() {
	super();
}


public FactureFournisseur(Long id, String bonDeCommande, String details, Date dateReceptionFacture, float montantHT,
		float montantTTC, float montantAPayer, float revenueAlaSource, Date datePaiement,
		Fournisseur fournisseur) {
	super();
	this.id = id;
	this.bonDeCommande = bonDeCommande;
	this.details = details;
	this.dateReceptionFacture = dateReceptionFacture;
	this.montantHT = montantHT;
	this.montantTTC = montantTTC;
	this.montantAPayer = montantAPayer;
	this.revenueAlaSource = revenueAlaSource;
	this.datePaiement = datePaiement;
	this.fournisseur = fournisseur;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getBonDeCommande() {
	return bonDeCommande;
}


public void setBonDeCommande(String bonDeCommande) {
	this.bonDeCommande = bonDeCommande;
}


public String getDetails() {
	return details;
}


public void setDetails(String details) {
	this.details = details;
}


public Date getDateReceptionFacture() {
	return dateReceptionFacture;
}


public void setDateReceptionFacture(Date dateReceptionFacture) {
	this.dateReceptionFacture = dateReceptionFacture;
}


public float getMontantHT() {
	return montantHT;
}


public void setMontantHT(float montantHT) {
	this.montantHT = montantHT;
}


public float getMontantTTC() {
	return montantTTC;
}


public void setMontantTTC(float montantTTC) {
	this.montantTTC = montantTTC;
}


public float getMontantAPayer() {
	return montantAPayer;
}


public void setMontantAPayer(float montantAPayer) {
	this.montantAPayer = montantAPayer;
}


public float getRevenueAlaSource() {
	return revenueAlaSource;
}


public void setRevenueAlaSource(float revenueAlaSource) {
	this.revenueAlaSource = revenueAlaSource;
}

public Date getDatePaiement() {
	return datePaiement;
}


public void setDatePaiement(Date datePaiement) {
	this.datePaiement = datePaiement;
}


public Fournisseur getFournisseur() {
	return fournisseur;
}


public void setFournisseur(Fournisseur fournisseur) {
	this.fournisseur = fournisseur;
}




public Boolean getModepaiement() {
	return modepaiement;
}


public void setModepaiement(Boolean modepaiement) {
	this.modepaiement = modepaiement;
}


public Cheque getNumeroCheque() {
	return numeroCheque;
}


public void setNumeroCheque(Cheque numeroCheque) {
	this.numeroCheque = numeroCheque;
}


public AppUser getRhFactureFournisseur() {
	return rhFactureFournisseur;
}


public void setRhFactureFournisseur(AppUser rhFactureFournisseur) {
	this.rhFactureFournisseur = rhFactureFournisseur;
}



}
