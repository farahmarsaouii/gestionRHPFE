package ch.newaccess.backendproject.entities;

public class FactureChequeDto {
private String cheque;
private PieceDeCaisse facture;
public String getCheque() {
	return cheque;
}
public void setCheque(String cheque) {
	this.cheque = cheque;
}
public PieceDeCaisse getFacture() {
	return facture;
}
public void setFacture(PieceDeCaisse facture) {
	this.facture = facture;
}


}
