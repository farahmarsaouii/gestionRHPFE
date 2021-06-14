package ch.newaccess.backendproject.entities;

public class FactureFournisseurChequedto {
	private String cheque;
	private FactureFournisseur facture;
	public FactureFournisseurChequedto(String cheque, FactureFournisseur facture) {
		super();
		this.cheque = cheque;
		this.facture = facture;
	}
	public FactureFournisseurChequedto() {
		super();
	}
	public String getCheque() {
		return cheque;
	}
	public void setCheque(String cheque) {
		this.cheque = cheque;
	}
	public FactureFournisseur getFacture() {
		return facture;
	}
	public void setFacture(FactureFournisseur facture) {
		this.facture = facture;
	}
	
	
}
