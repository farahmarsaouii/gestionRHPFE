package ch.newaccess.backendproject.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AppUser implements Serializable{
	@Id @GeneratedValue
private Long id;
	@Column(unique = true)
	private String userName;
	private String password;
	private String photo;
	private String email;
	private int cin;
	private String repassword;
	
@ManyToOne
	private AppRole role ;
@ManyToOne
private Oragnigramme organigramme;

@OneToMany(mappedBy = "emplyee")
@JsonIgnore
private Collection<PlanDeCarriere> planDeCarriere =new ArrayList<PlanDeCarriere>();

@OneToMany(mappedBy = "emplyee")
@JsonIgnore
private Collection<DemandeDocument> demandeDocument =new ArrayList<DemandeDocument>();

@OneToMany(mappedBy = "drh")
private Collection<DocumentAdministratif> documentAdministratif =new ArrayList<DocumentAdministratif>();



public void setRoles(AppRole role) {
	this.role = role;
}
public AppUser(Long id, String userName, String password, AppRole role) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.role = role;
}
public AppUser(String userName, String password) {
	super();

	this.userName = userName;
	this.password = password;
	
}
public AppUser(Long id, String userName, String password, AppRole role, Oragnigramme organigramme,
		Collection<DemandeDocument> demandeDocument, Collection<DocumentAdministratif> documentAdministratif) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.role = role;
	this.organigramme = organigramme;
	this.demandeDocument = demandeDocument;
	this.documentAdministratif = documentAdministratif;
	
}


public AppUser(Long id, String userName, String password, String photo, String email, int cin, String repassword,
		AppRole role, Oragnigramme organigramme, Collection<PlanDeCarriere> planDeCarriere,
		Collection<DemandeDocument> demandeDocument, Collection<DocumentAdministratif> documentAdministratif) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.photo = photo;
	this.email = email;
	this.cin = cin;
	this.repassword = repassword;
	this.role = role;
	this.organigramme = organigramme;
	this.planDeCarriere = planDeCarriere;
	this.demandeDocument = demandeDocument;
	this.documentAdministratif = documentAdministratif;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public AppUser() {
	super();
	
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public AppRole getRole() {
	return role;
} 
public Oragnigramme getOrganigramme() {
	return organigramme;
}
public void setOrganigramme(Oragnigramme organigramme) {
	this.organigramme = organigramme;
}
public Collection<DemandeDocument> getDemandeDocument() {
	return demandeDocument;
}
public void setDemandeDocument(Collection<DemandeDocument> demandeDocument) {
	this.demandeDocument = demandeDocument;
}
public Collection<DocumentAdministratif> getDocumentAdministratif() {
	return documentAdministratif;
}
public void setDocumentAdministratif(Collection<DocumentAdministratif> documentAdministratif) {
	this.documentAdministratif = documentAdministratif;
}

public void setRole(AppRole role) {
	this.role = role;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public int getCin() {
	return cin;
}
public void setCin(int cin) {
	this.cin = cin;
}
public String getRepassword() {
	return repassword;
}
public void setRepassword(String repassword) {
	this.repassword = repassword;
}
public Collection<PlanDeCarriere> getPlanDeCarriere() {
	return planDeCarriere;
}
public void setPlanDeCarriere(Collection<PlanDeCarriere> planDeCarriere) {
	this.planDeCarriere = planDeCarriere;
}


}
