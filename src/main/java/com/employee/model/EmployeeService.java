package com.employee.model;

import java.util.List;

public class EmployeeService {
	private EmployeeDAO dao;
	
	public EmployeeService() {
		dao = new EmployeeDAOImpl();
	}
	
	public boolean insert(EmployeeVO EmployeeVO) {
		return dao.insert(EmployeeVO);
	}
	
	public boolean update(EmployeeVO EmployeeVO) {
		return dao.update(EmployeeVO);
	}
	
	public List<EmployeeVO> getAll() {
		return dao.getAll();
	}
	
	public EmployeeVO emp(String mail) {
		return dao.emp(mail);
	}
}
