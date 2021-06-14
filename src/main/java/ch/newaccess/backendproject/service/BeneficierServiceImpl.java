package ch.newaccess.backendproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.Beneficier;
import ch.newaccess.backendproject.repository.IBeneficierRepository;

@Service
public class BeneficierServiceImpl implements IBeneficierService{
	@Autowired
	public IBeneficierRepository beneficierRepository;
	@Override
	public Optional<Beneficier> findBeneficier(Long id) {
		return beneficierRepository.findById(id);
	}

	@Override
	public Beneficier addBeneficier(Beneficier d) {
		return beneficierRepository.save(d);
	}

	@Override
	public List<Beneficier> listeBeneficier() {
		return beneficierRepository.findAll();
	}

	@Override
	public Beneficier updateBeneficier(Beneficier d) {
		Beneficier b =beneficierRepository.findById(d.getId()).get();
		b.setNomBeneficier(d.getNomBeneficier());
		return beneficierRepository.save(b);
	}

	@Override
	public void deleteBeneficier(Long id) {
		beneficierRepository.deleteById(id);
		
	}

	@Override
	public Optional<Beneficier> findBeneficierByName(String nom) {
		return beneficierRepository.findByNomBeneficier(nom);
	}

}
