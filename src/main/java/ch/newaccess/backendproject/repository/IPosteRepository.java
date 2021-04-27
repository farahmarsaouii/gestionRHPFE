package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.Poste;



public interface IPosteRepository extends JpaRepository<Poste,Long> {

}
