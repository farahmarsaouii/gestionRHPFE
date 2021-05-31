package ch.newaccess.backendproject.service;

import java.util.List;

import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Notification;

public interface INotificationService {
	public Notification addNotification(Notification d);
	public List<Notification> listeNotification();
	public List<Notification> listeNotificationByDestinataire(AppUser destinataire);
}
