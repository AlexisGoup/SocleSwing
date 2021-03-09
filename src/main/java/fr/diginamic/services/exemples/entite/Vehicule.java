package fr.diginamic.services.exemples.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected String immatriculation;
	
	protected String marque;
	
	protected String modele;

	@ManyToOne
	@JoinColumn(name="TypeVehicule_ID")
	protected TypeVehicule typeVehicule;
	
	protected Integer kilometrage;
	
	protected StatutVehicule statutVehicule;
	
	protected String commentaire;
	
	@OneToMany(mappedBy="vehicule")
	@NotFound(action=NotFoundAction.IGNORE)
	protected List<OperationMtnc> operationMtnc = new ArrayList<OperationMtnc>();
	
	public Vehicule() {}
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public TypeVehicule getTypeVehicule() {
		return typeVehicule;
	}

	public void setTypeVehicule(TypeVehicule typeVehicule) {
		this.typeVehicule = typeVehicule;
	}

	public Integer getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Integer kilometrage) {
		this.kilometrage = kilometrage;
	}

	public StatutVehicule getStatutVehicule() {
		return statutVehicule;
	}

	public void setStatutVehicule(StatutVehicule statutVehicule) {
		this.statutVehicule = statutVehicule;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public List<OperationMtnc> getOperationMtnc() {
		return operationMtnc;
	}

	public void setOperationMtnc(List<OperationMtnc> operationMtnc) {
		this.operationMtnc = operationMtnc;
	}
	
}
