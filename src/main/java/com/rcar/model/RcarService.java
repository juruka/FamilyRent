package com.rcar.model;

import java.util.List;

public class RcarService {
	private RcarDAO dao;
	
	public RcarService() {
		dao = new RcarDAOImpl();
	}
	
	public boolean insert(RcarVO RcarVO) {
		return dao.insert(RcarVO);
	}
	
	public boolean update(RcarVO RcarVO) {
		return dao.update(RcarVO);
	}
	
	public List<RcarVO> getSt_noAll(String st_no) {
		return dao.getSt_noAll(st_no);			
	}
	
	public List<RcarVO> getAll() {
		return dao.getAll();
	}
}
