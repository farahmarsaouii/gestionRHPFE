package ch.newaccess.backendproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.ImageModel;

public interface IimageRepository extends JpaRepository<ImageModel,Long>  {
	Optional<ImageModel> findByName(String name);
	
}
