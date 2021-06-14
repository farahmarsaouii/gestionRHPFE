package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import ch.newaccess.backendproject.entities.Beneficier;


public interface IBeneficierService {
	public Optional<Beneficier> findBeneficier(Long id);
	public Optional<Beneficier> findBeneficierByName(String nom);
	public Beneficier addBeneficier(Beneficier d);
	public List<Beneficier> listeBeneficier();
	public Beneficier updateBeneficier(Beneficier d);
	public void deleteBeneficier(Long id);
}
