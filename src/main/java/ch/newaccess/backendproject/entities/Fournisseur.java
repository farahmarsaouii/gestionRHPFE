package ch.newaccess.backendproject.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Fournisseur {
	@Id @GeneratedValue
private Long id;
private String nomFournisseur;
private String description;
private String adresse;
private String num_tel;
private String matriculeFiscale;
private int rib;
private boolean ht;
private boolean ttc;
private boolean retenueAlaSource;

@ManyToOne
private AppUser rhFournisseur;



@OneToMany(mappedBy = "fournisseur")
@JsonIgnore
private Collection<FactureFournisseur> facturesFournisseurs;

public Fournisseur() {
	super();
}
public Fournisseur(Long id, String nom, String description) {
	super();
	this.id = id;
	this.nomFournisseur = nom;
	this.description = description;
}


public Fournisseur(Long id, String nomFournisseur, String description, String adresse, String num_tel,
		String matriculeFiscale, int rib, boolean ht, boolean ttc, boolean retenueAlaSource,
		Collection<FactureFournisseur> facturesFournisseurs) {
	super();
	this.id = id;
	this.nomFournisseur = nomFournisseur;
	this.description = description;
	this.adresse = adresse;
	this.num_tel = num_tel;
	this.matriculeFiscale = matriculeFiscale;
	this.rib = rib;
	this.ht = ht;
	this.ttc = ttc;
	this.retenueAlaSource = retenueAlaSource;
	this.facturesFournisseurs = facturesFournisseurs;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNomFournisseur() {
	return nomFournisseur;
}
public void setNomFournisseur(String nomFournisseur) {
	this.nomFournisseur = nomFournisseur;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getNum_tel() {
	return num_tel;
}
public void setNum_tel(String num_tel) {
	this.num_tel = num_tel;
}
public String getMatriculeFiscale() {
	return matriculeFiscale;
}
public void setMatriculeFiscale(String matriculeFiscale) {
	this.matriculeFiscale = matriculeFiscale;
}
public int getRib() {
	return rib;
}
public void setRib(int rib) {
	this.rib = rib;
}
public boolean isHt() {
	return ht;
}
public void setHt(boolean ht) {
	this.ht = ht;
}
public boolean isTtc() {
	return ttc;
}
public void setTtc(boolean ttc) {
	this.ttc = ttc;
}
public boolean isRetenueAlaSource() {
	return retenueAlaSource;
}
public void setRetenueAlaSource(boolean retenueAlaSource) {
	this.retenueAlaSource = retenueAlaSource;
}
public AppUser getRhFournisseur() {
	return rhFournisseur;
}
public void setRhFournisseur(AppUser rhFournisseur) {
	this.rhFournisseur = rhFournisseur;
}
public Collection<FactureFournisseur> getFacturesFournisseurs() {
	return facturesFournisseurs;
}
public void setFacturesFournisseurs(Collection<FactureFournisseur> facturesFournisseurs) {
	this.facturesFournisseurs = facturesFournisseurs;
}

}
