package ch.newaccess.backendproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.Cheque;

public interface IChequeRepository extends JpaRepository<Cheque,Long>{

}
