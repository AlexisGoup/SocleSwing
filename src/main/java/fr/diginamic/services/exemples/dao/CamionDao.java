package fr.diginamic.services.exemples.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.diginamic.services.exemples.entite.Camion;

public class CamionDao extends AbstractDao {

	public CamionDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	/***
	 * Trouve et retourne un camion en base a partir de son id 
	 * @param id
	 * @return Voiture
	 */
	public Camion findById(Long id) {	
		return em.find(Camion.class, id);
	}
	
	/***
	 * Insere un camion en base de donnees 
	 * 
	 * @param voiture
	 * @return boolean
	 */
	public boolean insert(Camion camion) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		// Si l'operation plante, on annule la transaction
		try {
			em.persist(camion);
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
	 * D'un camion en base de donnees 
	 * @param Camion avec nouvelles valeurs
	 * @return boolean
	 */
	public boolean update(Camion camion) {
		// Recuparation de l'etat actuel du vehicule en base
		Camion camionBase = findById(camion.getId());
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		// Si l'operation plante, on annule la transaction
		try {
			// Modification du vehicule en base a partir de celui passe en parametre 
			camionBase.setImmatriculation(camion.getImmatriculation());
			camionBase.setCommentaire(camion.getCommentaire());
			camionBase.setKilometrage(camion.getKilometrage());
			
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.out.println(e);
			
			transaction.rollback();
			return false;
		}		
	}
	

}
