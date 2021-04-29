package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class DemandeDocument{
	@Id	@GeneratedValue
	private Long id;
private Date date;
private String raisonDocument;
private String commentaire;
	
	@ManyToOne
	private DocumentAdministratif documentAdministratif;
	@ManyToOne
	private AppUser emplyee;
	
	public DemandeDocument(Long id, Date date, String raisonDocument, String commentaire,
			DocumentAdministratif documentAdministratif, AppUser emplyee) {
		super();
		this.id = id;
		this.date = date;
		this.raisonDocument = raisonDocument;
		this.commentaire = commentaire;
		this.documentAdministratif = documentAdministratif;
		this.emplyee = emplyee;
	}
	public DemandeDocument(Long id, DocumentAdministratif documentAdministratif, AppUser emplyee) {
		super();
		this.id = id;
		this.documentAdministratif = documentAdministratif;
		this.emplyee = emplyee;
	}
	public DemandeDocument() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DocumentAdministratif getDocumentAdministratif() {
		return documentAdministratif;
	}
	public void setDocumentAdministratif(DocumentAdministratif documentAdministratif) {
		this.documentAdministratif = documentAdministratif;
	}
	public AppUser getEmplyee() {
		return emplyee;
	}
	public void setEmplyee(AppUser emplyee) {
		this.emplyee = emplyee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public DemandeDocument(Long id, Date date, DocumentAdministratif documentAdministratif, AppUser emplyee) {
		super();
		this.id = id;
		this.date = date;
		this.documentAdministratif = documentAdministratif;
		this.emplyee = emplyee;
	}
	public String getRaisonDocument() {
		return raisonDocument;
	}
	public void setRaisonDocument(String raisonDocument) {
		this.raisonDocument = raisonDocument;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	
}
