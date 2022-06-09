package com.employee.model;
import java.util.List;


public interface EmployeeDAO {
	//新增
	boolean insert(EmployeeVO EmployeeVO);
	//修改
	boolean update(EmployeeVO EmployeeVO);
	//預覽ALL
	List<EmployeeVO> getAll();
	//取得個人員工資料
	EmployeeVO emp(String mail);
}
