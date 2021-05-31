package ch.newaccess.backendproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.AppPrivilege;
import ch.newaccess.backendproject.entities.AppRole;
import ch.newaccess.backendproject.entities.AppUser;
import ch.newaccess.backendproject.entities.Notification;
import ch.newaccess.backendproject.service.AccountService;
import ch.newaccess.backendproject.service.INotificationService;

@RestController
public class NotificationController {
@Autowired
public INotificationService notificationService;
@Autowired
private AccountService accountService;

@PostMapping("/add-notification")
public Notification addNotification(@RequestBody Notification n) {
	return notificationService.addNotification(n);
}

@GetMapping("/notificationByDestinataire")
public List<Notification> listerNotificationDestinataire(@RequestParam("username") String username){
	AppUser user=accountService.findUserByUsername(username);
	return notificationService.listeNotificationByDestinataire(user);
}
@GetMapping("/notifications")
public List<Notification> listerNotification(){
	return notificationService.listeNotification();
}


}
