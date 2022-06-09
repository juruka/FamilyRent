package com.rcarorder.model;

import java.util.List;

import com.rcar.model.RcarVO;

import utils.ReDay;

public interface RcarOrderDAO {
	
	// 新增
	boolean insert(RcarOrderVO rcarOrderVO);

	// 修改
	boolean update(RcarOrderVO rcarOrderVO);

	// 預覽全部訂單
	List<RcarOrderVO> getAll();
	// 可選月份
	List<RcarOrderVO> getAll(int month);
	// 取得指定門市當月所有訂單 用於配車表上
	public List<ReDay> getallday(List<RcarVO> rcar_no, int month);

}
