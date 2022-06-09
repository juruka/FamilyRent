package com.store.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class StoreService {
	private StoreDAO dao;
	private StoreDAOImpl_hib dao_hib;
	private Session session;

	public StoreService() {
		dao = new StoreDAOImpl();
		dao_hib = new StoreDAOImpl_hib();
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public List<StoreVO> getAll(){
		return dao.getAll();
	}
	
	public List<Store_hib> getAll_hib() {
		
		Transaction transaction = session.beginTransaction();
		List<Store_hib> all = dao_hib.getAll();
		transaction.commit();
		return all;
	}
	
}
