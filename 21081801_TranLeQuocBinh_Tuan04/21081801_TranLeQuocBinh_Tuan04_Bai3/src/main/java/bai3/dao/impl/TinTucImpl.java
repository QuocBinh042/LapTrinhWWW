package bai3.dao.impl;

import java.util.List;

import bai3.dao.TinTucDAO;
import bai3.models.TinTuc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class TinTucImpl implements TinTucDAO{

	private EntityManager entityManager;

	public TinTucImpl(EntityManager entityManager) {
		// TODO Auto-generated constructor stub
		this.entityManager = entityManager;
	}

	@Override
	public List<TinTuc> getAllTinTuc() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from TinTuc", TinTuc.class).getResultList();
	}

	@Override
	public void addTinTuc(TinTuc tt) {
		// TODO Auto-generated method stub
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			this.entityManager.persist(tt);
			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
		}
	}

	@Override
	public void deleteTinTuc(int id) {
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			TinTuc tt = entityManager.find(TinTuc.class, id);
			if (tt != null) {
				entityManager.remove(tt);
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
		}
	}

	@Override
	public List<Integer> getDanhMucId() {
		// TODO Auto-generated method stub
		String hql = "SELECT dm.id FROM DanhMuc dm";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();
	}

	
}
