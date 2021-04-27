package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.PlanDeCarriere;

public interface IPlanDeCarriereService {
	public Optional<PlanDeCarriere> findPlanDeCarriere(Long idPlanDeCarriere);
	public PlanDeCarriere addPlanDeCarriere(PlanDeCarriere d);
	public List<PlanDeCarriere> listePlanDeCarriere();
	public PlanDeCarriere updatePlanDeCarriere(PlanDeCarriere d);
	public void deletePlanDeCarriere(Long idPlanDeCarriere);
}
