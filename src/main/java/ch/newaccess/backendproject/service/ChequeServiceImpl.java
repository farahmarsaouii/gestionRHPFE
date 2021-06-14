package ch.newaccess.backendproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Cheque;
import ch.newaccess.backendproject.repository.IChequeRepository;

@Service
public class ChequeServiceImpl implements IChequeService{
	@Autowired
public IChequeRepository chequeRepository;
	@Override
	public Cheque addCheque(Cheque c) {
		return chequeRepository.save(c);
	}

	@Override
	public List<Cheque> listeCheque() {
		return chequeRepository.findAll();
	}

	@Override
	public Cheque updateCheque(Cheque c) {
		Cheque cheque=chequeRepository.findById(c.getId()).get();
		cheque.setNumeroCheque(cheque.getNumeroCheque());
		return chequeRepository.save(cheque);
	}

	@Override
	public void deleteCheque(Long idCheque) {
		chequeRepository.deleteById(idCheque);
		
	}

	@Override
	public Cheque findById(Long id) {
		return chequeRepository.findById(id).get();
	}

}
