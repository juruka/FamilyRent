package com.store.model;

import java.util.List;

import org.hibernate.Session;

import utils.HibernateUtil;

public class StoreDAOImpl_hib {

	
	public void insert(StoreVO StoreVO) {
		
		
	}

	
	public void update(StoreVO StoreVO) {
		
		
	}

	public List<Store_hib> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Store_hib> list = session.createQuery("FROM Store_hib",Store_hib.class).list();
		return list;
	}

}
