package com.employee.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import utils.MysqlJDBC;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static DataSource ds;
	
	private final String INSERT = "INSERT INTO `CGA102G4`.`EMPLOYEE` (`EMP_NO`, `EMP_NAME`, `EMP_PASS`, `ST_NO`, `EMP_GENDER`, `EMP_BIR`, `EMP_TEL`, `EMP_ADRS`, `EMP_MAIL`, `EMP_TITLE`) "
								+ " VALUES ( ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? )";
	
	private final String UPDATE = "UPDATE `CGA102G4`.`EMPLOYEE` "
			+ "SET "
			+ "    `EMP_NAME` = ? ,"
			+ "    `EMP_PASS` = ? ,"
			+ "    `ST_NO` = ? ,"
			+ "    `EMP_GENDER` = ? ,"
			+ "    `EMP_BIR` = ? ,"
			+ "    `EMP_TEL` = ? ,"
			+ "    `EMP_ADRS` = ? ,"
			+ "    `EMP_MAIL` = ? ,"
			+ "    `EMP_TITLE` = ? ,"
			+ "    `EMP_STATUS` = ?  "
			+ "WHERE "
			+ "    (`EMP_NO` = ? );";
	
	private final String ALL = "SELECT EMP_NO, EMP_NAME, EMP_PASS, ST_NO, EMP_GENDER, EMP_BIR, EMP_TEL, EMP_ADRS, EMP_MAIL, EMP_TITLE, EMP_STATUS "
			+ "FROM CGA102G4.EMPLOYEE;";
	
	private final String EMP = "SELECT EMP_NO, EMP_NAME, EMP_PASS, ST_NO, EMP_GENDER, EMP_BIR, EMP_TEL, EMP_ADRS, EMP_MAIL, EMP_TITLE, EMP_STATUS "
			+ "FROM CGA102G4.EMPLOYEE WHERE EMP_MAIL = ? ;";
	static {
		ds = MysqlJDBC.getInstance().getDataSource();
	}
	
	@Override
	public boolean insert(EmployeeVO EmployeeVO) {
		Connection ct = null;
		PreparedStatement ps = null;
		try {
			ct = ds.getConnection();
			ps = ct.prepareStatement(INSERT);
			ps.setString(1, EmployeeVO.getEmp_no());
			ps.setString(2, EmployeeVO.getEmp_name());
			ps.setString(3,EmployeeVO.getEmp_pass());
			ps.setString(4, EmployeeVO.getSt_no());
			ps.setInt(5, EmployeeVO.getEmp_gender());
			ps.setDate(6, EmployeeVO.getEmp_bir());
			ps.setString(7, EmployeeVO.getEmp_tel());
			ps.setString(8, EmployeeVO.getEmp_adrs());
			ps.setString(9, EmployeeVO.getEmp_mail());
			ps.setString(10, EmployeeVO.getEmp_title());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(ct != null) {
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public boolean update(EmployeeVO EmployeeVO) {
		Connection ct = null;
		PreparedStatement ps = null;
		try {
			ct = ds.getConnection();
			ps = ct.prepareStatement(UPDATE);
			ps.setString(1, EmployeeVO.getEmp_name());
			ps.setString(2,EmployeeVO.getEmp_pass());
			ps.setString(3, EmployeeVO.getSt_no());
			ps.setInt(4, EmployeeVO.getEmp_gender());
			ps.setDate(5, EmployeeVO.getEmp_bir());
			ps.setString(6, EmployeeVO.getEmp_tel());
			ps.setString(7, EmployeeVO.getEmp_adrs());
			ps.setString(8, EmployeeVO.getEmp_mail());
			ps.setString(9, EmployeeVO.getEmp_title());
			ps.setInt(10, EmployeeVO.getEmp_status());
			ps.setString(11, EmployeeVO.getEmp_no());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			if(ps != null) {
				try {
					ps.cancel();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(ct != null) {
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public List<EmployeeVO> getAll() {
		List<EmployeeVO> list = new ArrayList<>();
		try (Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(ALL);){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmp_no(rs.getString("EMP_NO"));
				vo.setEmp_name(rs.getString("EMP_NAME"));
				vo.setSt_no(rs.getString("ST_NO"));
				vo.setEmp_gender(rs.getInt("EMP_GENDER"));
				vo.setEmp_bir(rs.getDate("EMP_BIR"));
				vo.setEmp_tel(rs.getString("EMP_TEL"));
				vo.setEmp_adrs(rs.getString("EMP_ADRS"));
				vo.setEmp_mail(rs.getString("EMP_MAIL"));
				vo.setEmp_title(rs.getString("EMP_TITLE"));
				vo.setEmp_status(rs.getInt("EMP_STATUS"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public EmployeeVO emp(String mail) {
		try (Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(EMP);){
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			rs.next();
			EmployeeVO vo = new EmployeeVO();
			vo.setEmp_no(rs.getString("EMP_NO"));
			vo.setEmp_name(rs.getString("EMP_NAME"));
			vo.setSt_no(rs.getString("ST_NO"));
			vo.setEmp_gender(rs.getInt("EMP_GENDER"));
			vo.setEmp_bir(rs.getDate("EMP_BIR"));
			vo.setEmp_tel(rs.getString("EMP_TEL"));
			vo.setEmp_adrs(rs.getString("EMP_ADRS"));
			vo.setEmp_mail(rs.getString("EMP_MAIL"));
			vo.setEmp_title(rs.getString("EMP_TITLE"));
			vo.setEmp_status(rs.getInt("EMP_STATUS"));
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
