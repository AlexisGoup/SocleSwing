package fr.diginamic.services.exemples.entite;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	private LocalDateTime dateDebut;
	
	private LocalDateTime dateFin;
	
	private int kilometrageDebut;
	
	private int kilometrageFin;
	
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="ID_VHL")
	private Vehicule vehicule;
	
	@OneToOne
	@JoinColumn(name="ID_FACT")
	@NotFound(action=NotFoundAction.IGNORE)
	private Facture facture;
	
	public Reservation() {}
	
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDateTime getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}
	public int getKilometrageDebut() {
		return kilometrageDebut;
	}
	public void setKilometrageDebut(int kilometrageDebut) {
		this.kilometrageDebut = kilometrageDebut;
	}
	public int getKilometrageFin() {
		return kilometrageFin;
	}
	public void setKilometrageFin(int kilometrageFin) {
		this.kilometrageFin = kilometrageFin;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
}
