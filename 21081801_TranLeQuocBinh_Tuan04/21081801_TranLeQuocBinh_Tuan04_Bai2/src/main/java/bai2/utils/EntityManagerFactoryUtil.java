package bai2.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public EntityManagerFactoryUtil() {
		emf = Persistence.createEntityManagerFactory("Lab4_bai2");
		em = emf.createEntityManager();
	}

	public EntityManager getEm() {
		return em;
	}	
	
	public void close() {
		// TODO Auto-generated method stub
		this.em.close();
		this.emf.close();
	}
}
