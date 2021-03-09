package fr.diginamic.services.exemples.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.diginamic.services.exemples.entite.Voiture;

public class VoitureDao extends AbstractDao {

	public VoitureDao(EntityManager em) {
		super(em);
	}
	
	/***
	 * Trouve et retourne une voiture en base a partir de son id 
	 * @param id
	 * @return Voiture
	 */
	public Voiture findById(Long id) {	
		return em.find(Voiture.class, id);
	}
	
	/***
	 * Insere une voiture en base de donnees 
	 * 
	 * @param voiture
	 * @return boolean
	 */
	public boolean insert(Voiture voiture) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		// Si l'operation plante, on annule la transaction
		try {
			em.persist(voiture);
			transaction.commit();
			
			return true;
		}catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
			
			return false;
		} 
		
		
	}
	
	/***
	 * Modifie les parametres => Immatriculation / Commentaire / Kilometrage 
	 * D'une voiture en base de donnees 
	 * @param voiture avec nouvelles valeurs
	 * @return boolean
	 */
	public boolean update(Voiture voiture) {
		// Recuparation de l'etat actuel du vehicule en base
		Voiture voitureBase = findById(voiture.getId());
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		// Si l'operation plante, on annule la transaction
		try {
			// Modification du vehicule en base a partir de celui passe en parametre 
			voitureBase.setImmatriculation(voiture.getImmatriculation());
			voitureBase.setCommentaire(voiture.getCommentaire());
			voitureBase.setKilometrage(voiture.getKilometrage());
			
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			
			transaction.rollback();
			return false;
		}		
	}
	
}
