package com.scar.model;
import java.util.List;

public interface ScarDAO {
	
	//新增
	void insert( ScarVO ScarVO);
	//修改
	void update(ScarVO ScarVO);
	//預覽ALL
	List<ScarVO> getAll();
	
}
