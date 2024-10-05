package bai2.dao.impl;

import bai2.dao.ProductDAO;
import bai2.models.Product;
import bai2.utils.EntityManagerFactoryUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class ProductImpl implements ProductDAO {
	private EntityManager entityManager;

	public ProductImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void addProduct(Product product) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive() && transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}

	@Override
	public List<Product> getAllProducts() {
		Query query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
		return query.getResultList();
	}

	@Override
	public void deleteProduct(int productId) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Product product = entityManager.find(Product.class, productId);
			if (product != null) {
				entityManager.remove(product);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive())
				transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive())
				transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public boolean isDatabaseEmpty() {
		long count = (long) entityManager.createQuery("SELECT COUNT(p) FROM Product p").getSingleResult();
		return count == 0;
	}

	// Method to insert initial data
	public void insertInitialData() {
        if (isDatabaseEmpty()) {
            addProduct(new Product(0, "Nokia Lumia", "", 10, 99000.0, "images/nokia-lumia.jpg"));
            addProduct(new Product(0, "BlackBerry Passport", "", 10, 48000, "images/blackberry-passport.jpg"));
            addProduct(new Product(0, "Sony Xperia Z5", "", 10, 52000, "images/sony-xperia-z5.jpg"));
            addProduct(new Product(0, "HTC One M9", "", 10, 83000, "images/htc-one-m9.jpg"));
            addProduct(new Product(0, "Samsung Galaxy Note 5", "", 10, 71000, "images/samsung-galaxy-note5.jpg"));
            addProduct(new Product(0, "iPhone 7 Jet Black Plus", "", 10, 120000, "images/iphone-7-jet-black-plus.jpg"));
        }
    }
}
