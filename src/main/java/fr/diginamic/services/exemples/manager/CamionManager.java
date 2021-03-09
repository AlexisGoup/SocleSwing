package fr.diginamic.services.exemples.manager;

import javax.persistence.EntityManager;

import fr.diginamic.services.exemples.dao.CamionDao;
import fr.diginamic.services.exemples.entite.Camion;

public class CamionManager {
	
	// Camion DAO
	private CamionDao camionDao;
	
	/***
	 * Constructeur
	 * @param em
	 */
	public CamionManager(EntityManager em) {
		this.camionDao = new CamionDao(em);
	}
	
	/***
	 * Insere un camion en base
	 * 
	 * @param Camion a inserer
	 */
	public boolean insertionCamion(Camion c) {
		
		// On apelle la methode de persistance
		// Et on transmet un boolean en fonction du retour du DAO
		if (camionDao.insert(c)) {
			
			return true;
		} 
			
		return false;
						
	}
	
	/***
	 * Retourne un camion en base a partir de son id 
	 * @param id
	 * @return Camion
	 */
	public Camion findCamion(Long id) {
		return camionDao.findById(id);	
	}
	
	/***
	 * Update un camion en base 
	 * A partir d'une instance de camion
	 * @param Camion
	 * @return boolean 
	 */
	public boolean updateCamion(Camion camion) {
		
		// On apelle la methode update
		// Et on transmet un boolean en fonction du retour du DAO
		if (camionDao.update(camion)) {
			
			return true;
		}
		
		return false;		
	}
}
