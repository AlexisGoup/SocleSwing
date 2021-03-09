package fr.diginamic.services.exemples.entite;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="type_vehicule")
public class TypeVehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double tarifJournalier;
	
	private double mtntCaution;
	
	private String nom;
	
	@OneToMany(mappedBy="typeVehicule")
	private List<Vehicule> vehicules = new ArrayList<Vehicule>();
	
	public TypeVehicule() {}
	
	public TypeVehicule(double tarifJournalier, double mtntCaution, String nom) {
		this.tarifJournalier = tarifJournalier;
		this.mtntCaution = mtntCaution;
		this.setNom(nom);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTarifJournalier() {
		return tarifJournalier;
	}
	public void setTarifJournalier(double tarifJournalier) {
		this.tarifJournalier = tarifJournalier;
	}
	public double getMtntCaution() {
		return mtntCaution;
	}
	public void setMtntCaution(double mtntCaution) {
		this.mtntCaution = mtntCaution;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
