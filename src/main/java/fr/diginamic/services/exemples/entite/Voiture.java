package fr.diginamic.services.exemples.entite;

import javax.persistence.Entity;

@Entity
public class Voiture extends Vehicule {
	private int nbPlaces;
	
	public Voiture() {}
	
	public Voiture(String immatriculation, TypeVehicule typeVehicule, int kilometrage, int nbPlaces, String marque, String modele) {
		this.immatriculation = immatriculation;
		this.typeVehicule = typeVehicule;
		this.kilometrage = kilometrage;
		this.statutVehicule = StatutVehicule.DISPONIBLE;
		this.nbPlaces = nbPlaces;
		this.marque = marque;
		this.modele = modele;
	}
	
	public Voiture(String immatriculation, TypeVehicule typeVehicule, int kilometrage, StatutVehicule statutVehicule, int nbPlaces, String marque, String modele) {
		this.immatriculation = immatriculation;
		this.typeVehicule = typeVehicule;
		this.kilometrage = kilometrage;
		this.statutVehicule = statutVehicule;
		this.nbPlaces = nbPlaces;
		this.marque = marque;
		this.modele = modele;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
}
