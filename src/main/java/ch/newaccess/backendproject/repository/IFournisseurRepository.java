package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur, Long>{

}
