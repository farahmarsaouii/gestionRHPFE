package ch.newaccess.backendproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Notification;
import ch.newaccess.backendproject.repository.INotificationRepository;

@Service
public class NotificationServiceImpl implements INotificationService{
@Autowired
public INotificationRepository notificationRepository;
	@Override
	public Notification addNotification(Notification d) {
		return notificationRepository.save(d);
	}

	@Override
	public List<Notification> listeNotification() {
		return notificationRepository.findAll();
	}

	@Override
	public List<Notification> listeNotificationByDestinataire(AppUser destinataire) {
		return notificationRepository.findByDestinataire(destinataire);
	}

}
