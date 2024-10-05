package bai3.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Lab4_bai3");
		entityManager = entityManagerFactory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
