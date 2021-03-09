package fr.diginamic.services.exemples.manager;

import javax.persistence.EntityManager;

import fr.diginamic.services.exemples.dao.TypeVehiculeDao;
import fr.diginamic.services.exemples.entite.TypeVehicule;

public class TypeVehiculemanager {
	
	// TypeVheicule DAO
	private TypeVehiculeDao tVehiculeDao;
	
	/***
	 * Constructeur
	 * @param em
	 */
	public TypeVehiculemanager(EntityManager em) {
		this.tVehiculeDao = new TypeVehiculeDao(em);
	}
	
	public boolean insertionTypeVehicule(TypeVehicule t) {
		
		// On apelle la methode de persistance
		// Et on transmet un boolean en fonction du retour du DAO
		if (tVehiculeDao.insert(t)) {
			
			return true;
		} 
			
		return false;
	}
}
