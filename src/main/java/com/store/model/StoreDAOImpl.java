package com.store.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import utils.MysqlJDBC;

public class StoreDAOImpl implements StoreDAO{
	
	String allsql= "SELECT * FROM STORE";
	
	private static DataSource ds;
	
	static {
		ds = MysqlJDBC.getInstance().getDataSource();
	}
	
	@Override
	public void insert(StoreVO StoreVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(StoreVO StoreVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StoreVO> getAll() {
		ArrayList<StoreVO> list = new ArrayList<>();
		
		try (Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(allsql);){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StoreVO vo = new StoreVO();
				vo.setSt_no(rs.getString("st_no"));
				vo.setSt_name(rs.getString("st_name"));
				vo.setSt_adrs(rs.getString("st_adrs"));
				vo.setSt_tel(rs.getString("st_tel"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
