package dev.sgpwebapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpwebapi.entite.BanqueInfo;
import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.repository.CollaborateurRepository;
import dev.sgpwebapi.repository.DepartementRepository;

@RestController
@RequestMapping("api/collaborateurs")
public class CollaborateurController {
	@Autowired private CollaborateurRepository collaborateurRepository;
	@Autowired private DepartementRepository departementRepository;
	
//	@GetMapping
//	public List<Collaborateur> listerCollaborateurs() {
//		return this.collaborateurRepository.findAll();
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Collaborateur> getCollaborateurByDepartement(
		@RequestParam(value="departement", required=false) Integer dep_id) {
		
		if (dep_id == null) {
			return this.collaborateurRepository.findAll();
		}
		return this.collaborateurRepository.findByDepartement(departementRepository.findOne(dep_id));
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{matricule}")
	public Collaborateur getCollaborateurByMatricule(@PathVariable String matricule) {
		return this.collaborateurRepository.findByMatricule(matricule).orElse(null);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{matricule}/banque")
	public BanqueInfo getBanqueInfoByMatricule(@PathVariable String matricule) {
		Optional<Collaborateur> collab = this.collaborateurRepository.findByMatricule(matricule);
		if (collab.isPresent()) {
			return collab.get().getBanqueInfo();
		} else {
			return null;
		}	
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{matricule}")
	public boolean modifyCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur collaborateur) {
		Optional<Collaborateur> collab = this.collaborateurRepository.findByMatricule(matricule);
		if (collab.isPresent()) {
			collaborateur.setId(collab.get().getId());
			collaborateurRepository.save(collaborateur);
			return true;
		} else {
			return false;
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{matricule}/banque")
	public boolean modifyBanqueInfo(@PathVariable String matricule, @RequestBody BanqueInfo banqueInfo) {
		Optional<Collaborateur> collab = this.collaborateurRepository.findByMatricule(matricule);
		if (collab.isPresent()) {
			Collaborateur collaborateur = collab.get();
			collaborateur.setBanqueInfo(banqueInfo);
			collaborateurRepository.save(collaborateur);
			return true;
		} else {
			return false;
		}
	}
}