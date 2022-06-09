package com.member.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import utils.MysqlJDBC;

public class MemberDAOImpl implements MemberDAO {
//	Calendar myCalendar = new GregorianCalendar(1993, 0, 28); //注意一月從'0'開始
//	long millis = myCalendar.getTimeInMillis(); //使用GregorianCalendar 設定日期 再轉long放入 Date內
	
//	Date.valueOf(LocalDate.of(1993, 06, 29)); //使用LocalDate指定日期 再用Date.valueOf 存入 LocalDate
//  Date.valueOf(LocalDate.parse("1993-05-22")) //使用LocalDate.parse 可將自串日期放入 
	private static DataSource ds;
	private final String INSERT = "INSERT INTO `CGA102G4`.`MEMBER` "
			+ "(`MEB_NO`, `MEB_PASS`, `MEB_NAME`, `MEB_GENDER`, `MEB_BIR`, `MEB_TEL`, `MEB_ADRS`, `MEB_MAIL`) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	
	private final String UPDATE = "UPDATE `CGA102G4`.`MEMBER` "
			+ "SET "
			+ "    `MEB_PASS` = ?,"
			+ "    `MEB_NAME` = ?,"
			+ "    `MEB_GENDER` = ?,"
			+ "    `MEB_BIR` = ?,"
			+ "    `MEB_TEL` = ?,"
			+ "    `MEB_ADRS` = ?,"
			+ "    `MEB_MAIL` = ?,"
			+ "    `MEB_BONUS` = ?,"
			+ "    `MEB_STATUS` = ? "
			+ "WHERE `MEB_NO` = ? ;";

	private final String IMG_UPDATE = "UPDATE `CGA102G4`.`MEMBER` "
			+ "SET "
			+ "    MEB_PROFILE = ? "
			+ "WHERE `MEB_NO` = ? ;";
	
	private final String ALL = "SELECT * FROM MEMBER;";
	
	private final String MEMBER = "SELECT * FROM MEMBER WHERE `MEB_MAIL` = ? ;";
	
	private final String LOGIN = "SELECT * FROM MEMBER WHERE MEB_MAIL = ? and MEB_PASS = ? ;";
	static {
		ds = MysqlJDBC.getInstance().getDataSource();
	}

	@Override
	public boolean insert(MemberVO MemberVO) {
		try (Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(INSERT);){
			ps.setString(1, MemberVO.getMeb_no());
			ps.setString(2, MemberVO.getMeb_pass());
			ps.setString(3, MemberVO.getMeb_name());
			ps.setInt(4, MemberVO.getMeb_gender());
			ps.setDate(5, MemberVO.getMeb_bir());
			ps.setString(6, MemberVO.getMeb_tel());
			ps.setString(7, MemberVO.getMeb_adrs());
			ps.setString(8, MemberVO.getMeb_mail());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(MemberVO MemberVO) {
		try (Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(UPDATE);){
			ps.setString(1, MemberVO.getMeb_pass());
			ps.setString(2, MemberVO.getMeb_name());
			ps.setInt(3, MemberVO.getMeb_gender());
			ps.setDate(4, MemberVO.getMeb_bir());
			ps.setString(5,MemberVO.getMeb_tel());
			ps.setString(6, MemberVO.getMeb_adrs());
			ps.setString(7, MemberVO.getMeb_mail());
			ps.setInt(8,MemberVO.getMeb_bonus());
			ps.setInt(9, MemberVO.getMeb_status());
			ps.setString(10, MemberVO.getMeb_no());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean imgupdate(MemberVO MemberVO) {
		try {
			Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(IMG_UPDATE);
			ps.setBytes(1, MemberVO.getMeb_profile());
			ps.setString(2, MemberVO.getMeb_no());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<MemberVO> getAll() {
		MemberVO memberVO;
		ArrayList<MemberVO> list = new ArrayList<>();
		try (Connection ct = ds.getConnection(); 
			PreparedStatement ps = ct.prepareStatement(ALL);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMeb_no(rs.getString("meb_no"));
				memberVO.setMeb_name(rs.getString("meb_name"));
				memberVO.setMeb_gender(rs.getInt("meb_gender"));
				memberVO.setMeb_bir(rs.getDate("meb_bir"));
				memberVO.setMeb_tel(rs.getString("meb_tel"));
				memberVO.setMeb_adrs(rs.getString("meb_adrs"));
				memberVO.setMeb_mail(rs.getString("meb_mail"));
				memberVO.setMeb_profile(rs.getBytes("meb_profile"));
				memberVO.setMeb_bonus(rs.getInt("meb_bonus"));
				memberVO.setMeb_status(rs.getInt("meb_status"));
				list.add(memberVO);
			}
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured." + e.getMessage());// SQL語法錯誤
		}
		return list;
		
	}

	@Override
	public boolean login(String account, String password) {
		try (Connection ct = ds.getConnection();
				PreparedStatement ps = ct.prepareStatement(LOGIN);){
			ps.setString(1, account);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
//			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MemberVO member(String account) {
		MemberVO memberVO = null;
		try(Connection ct = ds.getConnection();
				PreparedStatement ps = ct.prepareStatement(MEMBER);) {
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			rs.next();
			memberVO = new MemberVO();
			memberVO.setMeb_no(rs.getString("meb_no"));
			memberVO.setMeb_name(rs.getString("meb_name"));
			memberVO.setMeb_pass(rs.getString("meb_pass"));
			memberVO.setMeb_gender(rs.getInt("meb_gender"));
			memberVO.setMeb_bir(rs.getDate("meb_bir"));
			memberVO.setMeb_tel(rs.getString("meb_tel"));
			memberVO.setMeb_adrs(rs.getString("meb_adrs"));
			memberVO.setMeb_mail(rs.getString("meb_mail"));
			memberVO.setMeb_profile(rs.getBytes("meb_profile"));
			memberVO.setMeb_bonus(rs.getInt("meb_bonus"));
			memberVO.setMeb_status(rs.getInt("meb_status"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberVO;
	}




}
