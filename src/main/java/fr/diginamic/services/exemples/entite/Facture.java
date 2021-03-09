package fr.diginamic.services.exemples.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numeroFacture;
	
	private String recapitulatif;
	
	private int cout;
	
	private boolean statut;
	
	@OneToOne
	@JoinColumn(name="ID_RESA")
	@NotFound(action=NotFoundAction.IGNORE)
	private Reservation reservation;
	
	public Facture() {
		this.statut = false;
	}
	
	public int getNumeroFacture() {
		return numeroFacture;
	}
	public void setNumeroFacture(int numeroFacture) {
		this.numeroFacture = numeroFacture;
	}
	public String getRecapitulatif() {
		return recapitulatif;
	}
	public void setRecapitulatif(String recapitulatif) {
		this.recapitulatif = recapitulatif;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}
