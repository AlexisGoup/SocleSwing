package fr.diginamic.services.exemples.entite;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OperationMtnc")
public class OperationMtnc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOperation;
	
	private LocalDateTime dateFinMtnc;
	
	private LocalDateTime dateDebutMtnc;
	
	private int coutOp;
	
	@ManyToOne
	@JoinColumn(name="ID_VHL")
	private Vehicule vehicule;
	
	public OperationMtnc() {}

	public int getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public LocalDateTime getDateFinMtnc() {
		return dateFinMtnc;
	}

	public void setDateFinMtnc(LocalDateTime dateFinMtnc) {
		this.dateFinMtnc = dateFinMtnc;
	}

	public LocalDateTime getDateDebutMtnc() {
		return dateDebutMtnc;
	}

	public void setDateDebutMtnc(LocalDateTime dateDebutMtnc) {
		this.dateDebutMtnc = dateDebutMtnc;
	}

	public int getCoutOp() {
		return coutOp;
	}

	public void setCoutOp(int coutOp) {
		this.coutOp = coutOp;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
}
