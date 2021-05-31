package ch.newaccess.backendproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Notification;

public interface INotificationRepository extends JpaRepository<Notification,Long>{
	List<Notification> findByDestinataire(AppUser user);
}
