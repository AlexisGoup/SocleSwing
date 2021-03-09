package fr.diginamic.services.exemples.manager;

import javax.persistence.EntityManager;

import fr.diginamic.services.exemples.dao.VoitureDao;
import fr.diginamic.services.exemples.entite.Voiture;

public class VoitureManager {
	
	// Voiture DAO 
	private VoitureDao voitureDao;
	
	/***
	 * Constructeur 
	 * 
	 * @param em 
	 */
	public VoitureManager(EntityManager em) {
		this.voitureDao = new VoitureDao(em);
	}
	
	/***
	 * Insere l'entite en base de donnees 
	 * 
	 * @param entite a inserer 
	 */
	public boolean insertionVoiture(Voiture v) {
		
		if (voitureDao.insert(v)) {
			
			return true;
		} 
			
		return false;
						
	}
	
	/***
	 * Retourne une voiture en base a partir de son id 
	 * @param id
	 * @return Voiture 
	 */
	public Voiture findVoiture(Long id) {
		return voitureDao.findById(id);	
	}
	
	/***
	 * Update une voiture en base 
	 * A partir d'une instance de voiture 
	 * @param voiture
	 * @return boolean 
	 */
	public boolean updateVoiture(Voiture voiture) {
		
		// On apelle la methode update
		// Et on transmet un boolean en fonction du retour du DAO
		if (voitureDao.update(voiture)) {
			
			return true;
		}
		
		return false;		
	}
}
