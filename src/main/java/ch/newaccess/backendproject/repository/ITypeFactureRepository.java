package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.TypeFacture;



public interface ITypeFactureRepository extends JpaRepository<TypeFacture,Long> {

}
