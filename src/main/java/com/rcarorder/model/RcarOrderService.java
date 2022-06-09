package com.rcarorder.model;

import java.util.List;

import com.carmodel.model.CarModelVO;
import com.rcar.model.RcarVO;

import utils.ReDay;

public class RcarOrderService {
	private RcarOrderDAO dao;
	
	public RcarOrderService() {
		dao = new RcarOrderDAOImpl();
	}
	
	public List<ReDay> getallday(List<RcarVO> rcar_no, int month){
		return dao.getallday(rcar_no, month);
	}
	
	public boolean insert(RcarOrderVO rcarOrderVO) {
		return dao.insert(rcarOrderVO);
		
	}


	public void update(CarModelVO carModelVO) {
		// TODO Auto-generated method stub
		
	}


	public List<RcarOrderVO> getAll() {
		return dao.getAll();
	}
	
	public List<RcarOrderVO> getAll(int month) {
		return dao.getAll(month);
	}
}
