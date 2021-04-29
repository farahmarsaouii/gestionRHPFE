package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.Poste;



public interface IPosteRepository extends JpaRepository<Poste,Long> {
}
