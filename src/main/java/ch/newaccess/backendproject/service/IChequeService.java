package ch.newaccess.backendproject.service;

import java.util.List;

import ch.newaccess.backendproject.entities.Cheque;



public interface IChequeService {
	public Cheque addCheque(Cheque c);
	public List<Cheque> listeCheque();
	public Cheque updateCheque(Cheque c);
	public void deleteCheque(Long idCheque);
	public Cheque findById(Long id);
}
