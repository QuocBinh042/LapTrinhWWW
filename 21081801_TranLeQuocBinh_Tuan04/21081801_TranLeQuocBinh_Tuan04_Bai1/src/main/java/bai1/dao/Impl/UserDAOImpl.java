package bai1.dao.Impl;

import java.util.List;

import bai1.dao.UserDAO;
import bai1.models.User;
import jakarta.enterprise.lang.model.types.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

@SuppressWarnings ("unchecked")
public class UserDAOImpl implements UserDAO{

	private EntityManager em;
	
	public UserDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public User save(User user) {
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}

	
}
