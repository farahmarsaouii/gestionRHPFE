package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.PlanDeCarriere;
import ch.newaccess.backendproject.entities.Poste;
import ch.newaccess.backendproject.repository.IPlanDeCarriereRepository;
@Service
public class PlanDeCarriereServiceImpl implements IPlanDeCarriereService{
	@Autowired
public IPlanDeCarriereRepository planDeCarriereRepository;
	@Override
	public Optional<PlanDeCarriere> findPlanDeCarriere(Long idPlanDeCarriere) {
		return planDeCarriereRepository.findById(idPlanDeCarriere);
	}

	@Override
	public PlanDeCarriere addPlanDeCarriere(PlanDeCarriere d) {
		return planDeCarriereRepository.save(d);
	}

	@Override
	public List<PlanDeCarriere> listePlanDeCarriere() {
		return planDeCarriereRepository.findAll();
	}

	@Override
	public PlanDeCarriere updatePlanDeCarriere(PlanDeCarriere d) {
		return planDeCarriereRepository.save(d);
	}

	@Override
	public void deletePlanDeCarriere(Long idPlanDeCarriere) {
		planDeCarriereRepository.deleteById(idPlanDeCarriere);
	}

	@Override
	public PlanDeCarriere findPlanDeCarriereByPoste(Poste poste) {
		
		return planDeCarriereRepository.findByPoste(poste);
	}

	@Override
	public PlanDeCarriere findPlanDeCarriereByEmplyee(AppUser emplyee) {

		return planDeCarriereRepository.findByEmplyee(emplyee);
	}

	

	

}
