package fr.diginamic.services.exemples.dao;

import javax.persistence.EntityManager;

public class AbstractDao {
protected static EntityManager em;
	
	protected AbstractDao(EntityManager em) {
		this.em = em;
	}
}
