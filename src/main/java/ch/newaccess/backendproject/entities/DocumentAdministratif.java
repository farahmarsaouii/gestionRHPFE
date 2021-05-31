package ch.newaccess.backendproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class DocumentAdministratif{
@Id	@GeneratedValue
private Long id;
private String nomDocument;
private String type;
private Date dateCreation;
private Date dateModf;

private String titreDocument;
@Lob 
@Column(name="contenuDocument", length=512)
private String contenuDocument;
private String headerDocument;
private String footerDocument;


@OneToMany(mappedBy = "documentAdministratif")
@JsonIgnore
private Collection<DemandeDocument> demandeDocument =new ArrayList<DemandeDocument>();
@ManyToOne
@JsonIgnore
private AppUser drh;
public DocumentAdministratif(Long id, String nomDocument, String type, Date dateCreation, Date dateModf,
		Collection<DemandeDocument> demandeDocument, AppUser drh) {
	super();
	this.id = id;
	this.nomDocument = nomDocument;
	this.type = type;
	this.dateCreation = dateCreation;
	this.dateModf = dateModf;
	this.demandeDocument = demandeDocument;
	this.drh = drh;
}
public DocumentAdministratif() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNomDocument() {
	return nomDocument;
}
public void setNomDocument(String nomDocument) {
	this.nomDocument = nomDocument;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public Date getDateModf() {
	return dateModf;
}
public void setDateModf(Date dateModf) {
	this.dateModf = dateModf;
}
public Collection<DemandeDocument> getDemandeDocument() {
	return demandeDocument;
}
public void setDemandeDocument(Collection<DemandeDocument> demandeDocument) {
	this.demandeDocument = demandeDocument;
}
public AppUser getDrh() {
	return drh;
}
public void setDrh(AppUser drh) {
	this.drh = drh;
}

public String getTitreDocument() {
	return titreDocument;
}
public void setTitreDocument(String titreDocument) {
	this.titreDocument = titreDocument;
}
public String getContenuDocument() {
	return contenuDocument;
}
public void setContenuDocument(String contenuDocument) {
	this.contenuDocument = contenuDocument;
}
public String getHeaderDocument() {
	return headerDocument;
}
public void setHeaderDocument(String headerDocument) {
	this.headerDocument = headerDocument;
}
public String getFooterDocument() {
	return footerDocument;
}
public void setFooterDocument(String footerDocument) {
	this.footerDocument = footerDocument;
}


}
