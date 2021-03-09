package fr.diginamic.services.exemples.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.diginamic.services.exemples.entite.TypeVehicule;

public class TypeVehiculeDao extends AbstractDao {

	public TypeVehiculeDao(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	
	public boolean insert(TypeVehicule type) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		// Si l'operation plante, on annule la transaction
		try {
			em.persist(type);
			transaction.commit();
			
			return true;
		}catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
			
			return false;
		} 
	}
	
	public TypeVehicule findById(int id) {
		return em.find(TypeVehicule.class, id);
	}
	
}
