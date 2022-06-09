package com.carmodel.model;


import java.util.List;

public class CarModelService {
	
	private CarModelDAO dao;
	
	public CarModelService() {
		dao = new CarModelDAOImpl();
	}
	
	public boolean insert(CarModelVO carModelVO) {
		return dao.insert(carModelVO);
	}
	
	public boolean update(CarModelVO carModelVO) {
		return dao.update(carModelVO);
	}
	
	//查詢所有
	public List<CarModelVO> getAll() {
		return dao.getAll();
	}
	
	//顯示圖片
	public byte[] getImges(String model_no) {
		return dao.getImage(model_no);
	}

}
