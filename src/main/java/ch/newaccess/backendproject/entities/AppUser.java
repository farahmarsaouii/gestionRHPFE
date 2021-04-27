package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AppUser{
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
@ManyToOne
private Poste poste;

@OneToMany(fetch = FetchType.LAZY,mappedBy = "emplyee")
@JsonIgnore
private Collection<DemandeDocument> demandeDocument =new ArrayList<DemandeDocument>();
@OneToMany(mappedBy = "drh")
private Collection<DocumentAdministratif> documentAdministratif =new ArrayList<DocumentAdministratif>();
@OneToMany(mappedBy = "competenceEmplyee")
private Collection<Evaluation> evaluation =new ArrayList<Evaluation>();



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
public AppUser(Long id, String userName, String password, AppRole role, Oragnigramme organigramme, Poste poste,
		Collection<DemandeDocument> demandeDocument, Collection<DocumentAdministratif> documentAdministratif,
		Collection<Evaluation> evaluation) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.role = role;
	this.organigramme = organigramme;
	this.poste = poste;
	this.demandeDocument = demandeDocument;
	this.documentAdministratif = documentAdministratif;
	this.evaluation = evaluation;
}
public Oragnigramme getOrganigramme() {
	return organigramme;
}
public void setOrganigramme(Oragnigramme organigramme) {
	this.organigramme = organigramme;
}
public Poste getPoste() {
	return poste;
}
public void setPoste(Poste poste) {
	this.poste = poste;
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
public Collection<Evaluation> getEvaluation() {
	return evaluation;
}
public void setEvaluation(Collection<Evaluation> evaluation) {
	this.evaluation = evaluation;
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


}
