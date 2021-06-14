package ch.newaccess.backendproject.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private AppUser idSuperieurhierarchique;
	@OneToMany(mappedBy = "idSuperieurhierarchique")
   private List<AppUser> employees;

	
	@OneToOne(mappedBy = "user")
	private ImageModel image ;
	
	@ManyToMany
	@JsonIgnore
	private Collection<Notification> notificationDestinataire =new ArrayList<Notification>();
	
			@OneToMany(mappedBy = "expediteur")
	@JsonIgnore
	private Collection<Notification> notificationExpediteur =new ArrayList<Notification>();
@ManyToOne
private AppRole role ;

@ManyToOne
private Equipe equipe ;

@OneToOne(mappedBy = "emplyee")
private PlanDeCarriere planDeCarriere;

@ManyToOne
private Poste poste;

@OneToMany(mappedBy = "emplyee")
@JsonIgnore
private Collection<DemandeDocument> demandeDocument =new ArrayList<DemandeDocument>();

@OneToMany(mappedBy = "drh")
private Collection<DocumentAdministratif> documentAdministratif =new ArrayList<DocumentAdministratif>();

@OneToMany(mappedBy = "rh")
@JsonIgnore
private Collection<Competence> competence =new ArrayList<Competence>();

@OneToMany(mappedBy = "manager")
@JsonIgnore
private Collection<SousCompetence> sousCompetence =new ArrayList<SousCompetence>();

@OneToMany(mappedBy = "employee")
@JsonIgnore
private Collection<SousCompetence> sousCompetenceEmployee =new ArrayList<SousCompetence>();

@OneToMany(mappedBy = "rhFactureFournisseur")
@JsonIgnore
private Collection<FactureFournisseur> facturesFournisseurs;

@OneToMany(mappedBy = "rhFournisseur")
@JsonIgnore
private Collection<Fournisseur> fournisseurs;

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
public AppUser(Long id, String userName, String password, AppRole role,
		Collection<DemandeDocument> demandeDocument, Collection<DocumentAdministratif> documentAdministratif) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.role = role;
	
	this.demandeDocument = demandeDocument;
	this.documentAdministratif = documentAdministratif;
	
}




public AppUser(Long id, String userName, String password, String photo, String email, int cin, String repassword,
		AppUser idSuperieurhierarchique, AppRole role, Equipe equipe, PlanDeCarriere planDeCarriere, Poste poste,
		Collection<DemandeDocument> demandeDocument, Collection<DocumentAdministratif> documentAdministratif,
		Collection<Competence> competence, Collection<SousCompetence> sousCompetence,
		Collection<SousCompetence> sousCompetenceEmployee) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.photo = photo;
	this.email = email;
	this.cin = cin;
	this.repassword = repassword;
	this.idSuperieurhierarchique = idSuperieurhierarchique;
	this.role = role;
	this.equipe = equipe;
	this.planDeCarriere = planDeCarriere;
	this.poste = poste;
	this.demandeDocument = demandeDocument;
	this.documentAdministratif = documentAdministratif;
	this.competence = competence;
	this.sousCompetence = sousCompetence;
	this.sousCompetenceEmployee = sousCompetenceEmployee;
}
public AppUser(Long id, String userName, String password, String photo, String email, int cin, String repassword,
		AppUser idSuperieurhierarchique, AppRole role, Equipe equipe,
		PlanDeCarriere planDeCarriere, Poste poste, Collection<DemandeDocument> demandeDocument,
		Collection<DocumentAdministratif> documentAdministratif, Collection<Competence> competence,
		Collection<SousCompetence> sousCompetence) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.photo = photo;
	this.email = email;
	this.cin = cin;
	this.repassword = repassword;
	this.idSuperieurhierarchique = idSuperieurhierarchique;
	this.role = role;
	this.equipe = equipe;

	this.planDeCarriere = planDeCarriere;
	this.poste = poste;
	this.demandeDocument = demandeDocument;
	this.documentAdministratif = documentAdministratif;
	this.competence = competence;
	this.sousCompetence = sousCompetence;
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
public PlanDeCarriere getPlanDeCarriere() {
	return planDeCarriere;
}
public void setPlanDeCarriere(PlanDeCarriere planDeCarriere) {
	this.planDeCarriere = planDeCarriere;
}


public Equipe getEquipe() {
	return equipe;
}
@JsonIgnore
@JsonProperty("idSuperieurhierarchique") 
public AppUser getIdSuperieurhierarchique() {
	return idSuperieurhierarchique;
}

public void setIdSuperieurhierarchique(AppUser idSuperieurhierarchique) {
	this.idSuperieurhierarchique = idSuperieurhierarchique;
}
public void setEquipe(Equipe equipe) {
	this.equipe = equipe;
}

public Poste getPoste() {
	return poste;
}
public void setPoste(Poste poste) {
	this.poste = poste;
}
public Collection<Competence> getCompetence() {
	return competence;
}
public void setCompetence(Collection<Competence> competence) {
	this.competence = competence;
}
public Collection<SousCompetence> getSousCompetence() {
	return sousCompetence;
}
public void setSousCompetence(Collection<SousCompetence> sousCompetence) {
	this.sousCompetence = sousCompetence;
}
public Collection<SousCompetence> getSousCompetenceEmployee() {
	return sousCompetenceEmployee;
}
public void setSousCompetenceEmployee(Collection<SousCompetence> sousCompetenceEmployee) {
	this.sousCompetenceEmployee = sousCompetenceEmployee;
}

@JsonIgnore
@JsonProperty("employees") 
public List<AppUser> getEmployees() {
	return employees;
}
public void setEmployees(List<AppUser> employees) {
	this.employees = employees;
}
public ImageModel getImage() {
	return image;
}
public void setImage(ImageModel image) {
	this.image = image;
}
public Collection<Notification> getNotificationDestinataire() {
	return notificationDestinataire;
}
public void setNotificationDestinataire(Collection<Notification> notificationDestinataire) {
	this.notificationDestinataire = notificationDestinataire;
}
public Collection<Notification> getNotificationExpediteur() {
	return notificationExpediteur;
}
public void setNotificationExpediteur(Collection<Notification> notificationExpediteur) {
	this.notificationExpediteur = notificationExpediteur;
}



}
