package ch.newaccess.backendproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.AppUser;

import ch.newaccess.backendproject.entities.Poste;



public interface IPosteRepository extends JpaRepository<Poste,Long> {
public Poste findByUsers(AppUser users);
public Optional<Poste> findById(Long id);
}
