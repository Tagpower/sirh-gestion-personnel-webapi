package dev.sgpwebapi.entite;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="collaborateur")
public class Collaborateur {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(name="matricule", unique=true)
	private String matricule;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@ManyToOne
	@JoinColumn(name="id_dept")
	private Departement departement;
	@Embedded
	private BanqueInfo banqueInfo;
	
	public Collaborateur() {
		
	}

	public Collaborateur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public BanqueInfo getBanqueInfo() {
		return banqueInfo;
	}

	public void setBanqueInfo(BanqueInfo banqueInfo) {
		this.banqueInfo = banqueInfo;
	}

	
	
	
	
	
	
	

}
