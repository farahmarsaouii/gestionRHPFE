package ch.newaccess.backendproject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.newaccess.backendproject.entities.Equipe;
import ch.newaccess.backendproject.service.IEquipeService;



@RestController
public class EquipeController {
	@Autowired
	public IEquipeService equipeService;
	@GetMapping("/equipes")
	public List<Equipe> listEquipes(){
		return equipeService.listeEquipe();
	}
}
