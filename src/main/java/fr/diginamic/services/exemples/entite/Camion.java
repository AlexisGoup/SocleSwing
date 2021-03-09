package fr.diginamic.services.exemples.entite;

import javax.persistence.Entity;

@Entity
public class Camion extends Vehicule{
	private int volume;
	
	public Camion() {}
	
	public Camion(String immatriculation, TypeVehicule typeVehicule, int kilometrage, StatutVehicule statutVehicule, int volume, String marque, String modele) {
		this.immatriculation = immatriculation;
		this.typeVehicule = typeVehicule;
		this.kilometrage = kilometrage;
		this.statutVehicule = statutVehicule;
		this.volume = volume;
		this.marque = marque;
		this.modele = modele;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
