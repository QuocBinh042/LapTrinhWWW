package bai2.dao.impl;

import java.util.List;

import bai2.models.CartItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import bai2.dao.CartItemDAO;

public class CartItemImpl implements CartItemDAO {
	private EntityManager entityManager;

	public CartItemImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(cartItem);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(cartItem);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCartItem(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			CartItem cartItem = entityManager.find(CartItem.class, id);
			if (cartItem != null) {
				entityManager.remove(cartItem);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public CartItem getCartItemById(int id) {
		return entityManager.find(CartItem.class, id);
	}

	@Override
	public List<CartItem> getAllCartItems() {
		TypedQuery<CartItem> query = entityManager.createQuery("SELECT ci FROM CartItem ci", CartItem.class);
		return query.getResultList();
	}

	@Override
	public double getTotalCartValue() {
		Query query = entityManager.createQuery("SELECT SUM(c.quantity * c.unitCost) FROM CartItem c");
		Double total = (Double) query.getSingleResult();
		return (total != null) ? total : 0.0;
	}
}
