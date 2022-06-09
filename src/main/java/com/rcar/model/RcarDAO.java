package com.rcar.model;

import java.util.List;


public interface RcarDAO {

	// 新增
	boolean insert(RcarVO RcarVO);

	// 修改
	boolean update(RcarVO RcarVO);

	// 預覽門市全車輛
	List<RcarVO> getSt_noAll(String st_no);
	
	// 預覽全車輛
	List<RcarVO> getAll();
}
