package ch.newaccess.backendproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.Beneficier;

public interface IBeneficierRepository extends JpaRepository<Beneficier,Long>{
Optional<Beneficier> findByNomBeneficier(String nomBeneficier);
}
