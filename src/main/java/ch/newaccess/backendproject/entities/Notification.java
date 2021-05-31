package ch.newaccess.backendproject.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Notification {
	@Id @GeneratedValue
private Long id;
private String titre;
private String commentaire;

@ManyToOne

private AppUser expediteur;

@ManyToMany(fetch = FetchType.EAGER) 

private Collection<AppUser> destinataire =new ArrayList<AppUser>();




public Notification() {

}
public Notification(String titre, String commentaire) {
	super();
	this.titre = titre;
	this.commentaire = commentaire;
}
public Notification(Long id, String titre, String commentaire) {
	super();
	this.id = id;
	this.titre = titre;
	this.commentaire = commentaire;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getCommentaire() {
	return commentaire;
}
public void setCommentaire(String commentaire) {
	this.commentaire = commentaire;
}
@JsonIgnore
@JsonProperty("expediteur") 
public AppUser getExpediteur() {
	return expediteur;
}
public void setExpediteur(AppUser expediteur) {
	this.expediteur = expediteur;
}
@JsonIgnore
@JsonProperty("destinataire") 
public Collection<AppUser> getDestinataire() {
	return destinataire;
}
public void setDestinataire(Collection<AppUser> destinataire) {
	this.destinataire = destinataire;
}


}
