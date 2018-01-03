package dev.sgpwebapi.listener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import dev.sgpwebapi.entite.BanqueInfo;
import dev.sgpwebapi.entite.Collaborateur;
import dev.sgpwebapi.entite.Departement;
import dev.sgpwebapi.repository.CollaborateurRepository;
import dev.sgpwebapi.repository.DepartementRepository;


@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	DepartementRepository depRepo;
	@Autowired
	CollaborateurRepository collabRepo;

	/**
	 * This event is executed as late as conceivably possible to indicate that the
	 * application is ready to service requests.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		Departement dep1 = new Departement("Informatique");
		Departement dep2 = new Departement("Administration");
		Departement dep3 = new Departement("Ressources Humaines");
		Departement dep4 = new Departement("Comptabilité");
		Departement dep5 = new Departement("Direction");
		List<Departement> departements = new ArrayList<>();
		departements.add(dep1);
		departements.add(dep2);
		departements.add(dep3);
		departements.add(dep4);
		departements.add(dep5);
		depRepo.save(departements);
		
		BanqueInfo banqueInfo1 = new BanqueInfo();
		banqueInfo1.setBanque("Société Générale");
		banqueInfo1.setBic("SOGEFRPP");
		banqueInfo1.setIban("IBAN 1234 5678 9012");
		Collaborateur collab1 = new Collaborateur("Tower","Bill");
		collab1.setMatricule("BT1");
		collab1.setBanqueInfo(banqueInfo1);
		collab1.setDepartement(dep1);
		collabRepo.save(collab1);
		
		BanqueInfo banqueInfo2 = new BanqueInfo();
		banqueInfo2.setBanque("Crédit Mutuel");
		banqueInfo2.setBic("CMFRPP");
		banqueInfo2.setIban("IBAN 9999 9999 9999");
		Collaborateur collab2 = new Collaborateur("Power","Tag");
		collab2.setMatricule("TP1");
		collab2.setBanqueInfo(banqueInfo2);
		collab2.setDepartement(dep4);
		collabRepo.save(collab2);
		
		BanqueInfo banqueInfo3 = new BanqueInfo();
		banqueInfo3.setBanque("Crédit Mutuel");
		banqueInfo3.setBic("CMFRPP");
		banqueInfo3.setIban("IBAN 1111 1111 1111");
		Collaborateur collab3 = new Collaborateur("Tables","Bobby");
		collab3.setMatricule("BT2");
		collab3.setBanqueInfo(banqueInfo3);
		collab3.setDepartement(dep4);
		collabRepo.save(collab3);
		
		return;
	}

}