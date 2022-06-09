package com.rcarorder.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.rcar.model.RcarVO;

import utils.MysqlJDBC;
import utils.ReDay;

public class RcarOrderDAOImpl implements RcarOrderDAO {
	private static DataSource ds;
	private final String CAR_ORDER = "SELECT " //取得門市所有車輛訂單 用於配車表上
			+ "    EXTRACT(DAY FROM RCARO_PPICKTIME) AS start, "
			+ "    EXTRACT(DAY FROM RCARO_PPRETTIME) As end, "
			+ "    (MONTH(RCARO_PPICKTIME) + MONTH(RCARO_PPRETTIME)) as total, " // 開始月份 + 結束月份 來判斷 開始或結束日期不再 你要查詢的月份
			+ "    RCAR_NO "
			+ "FROM "
			+ "    RCAR_ORDER "
			+ "WHERE "
			+ "    RCAR_NO like ? and (MONTH(RCARO_PPICKTIME) + MONTH(RCARO_PPRETTIME)) in ( ? , ? , ? ) "
			+ "ORDER BY start;";
	
	private final String All = "SELECT * FROM RCAR_ORDER";
	
	private final String MONTHALL = "SELECT " //取得特定月份所有訂單
			+ "    RCARO_NO,"
			+ "    MEB_NO,"
			+ "    MODEL_NO,"
			+ "    RCAR_NO,"
			+ "    RCARO_PPICKTIME,"
			+ "    RCARO_PPRETTIME,"
			+ "    RCARO_RPICKTIME,"
			+ "    RCARO_RRETTIME,"
			+ "    RCARO_PICKUPLOC,"
			+ "    RCARO_RETURNLOC,"
			+ "    RCARO_RETURNLOC_ACTUAL,"
			+ "    RCARO_DATE,"
			+ "    RCARO_PAY,"
			+ "    RCARO_EXTRA_PAY,"
			+ "    RCARO_EXTRA_PAY_STATUS,"
			+ "    CONSUME_POINT,"
			+ "    EARN_POINT,"
			+ "    EVENT_NO,"
			+ "    RCARO_STATUS,"
			+ "    RCARO_NOTE,"
			+ "    LESSEE_NAME "
			+ "FROM "
			+ "    CGA102G4.RCAR_ORDER "
			+ "WHERE "
			+ "    MONTH(RCARO_PPICKTIME) = ? "
			+ "OR  MONTH(RCARO_PPRETTIME) = ? ";
	
	private final String INSERT = "INSERT INTO `CGA102G4`.`RCAR_ORDER` (`MEB_NO`, `MODEL_NO`, `RCARO_PPICKTIME`, `RCARO_PPRETTIME`, `RCARO_PICKUPLOC`, `RCARO_RETURNLOC`, `RCARO_PAY`, `CONSUME_POINT`, `EVENT_NO`, `RCARO_NOTE`, `LESSEE_NAME`) "
			+ " VALUES ( ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? ,  ? );";
	static {
		ds = MysqlJDBC.getInstance().getDataSource();
	}



	@Override
	public boolean insert(RcarOrderVO rcarOrderVO) {
		try (Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(INSERT);){ 
			ps.setString(1,rcarOrderVO.getMeb_no());
			ps.setString(2,rcarOrderVO.getModel_no());
			ps.setTimestamp(3, rcarOrderVO.getRcaro_ppicktime());
			ps.setTimestamp(4, rcarOrderVO.getRcaro_pprettime());
			ps.setString(5,rcarOrderVO.getRcaro_pickuploc());
			ps.setString(6, rcarOrderVO.getRcaro_returnloc());
//			ps.setTimestamp(7, rcarOrderVO.getRcaro_date()); //新版本自動更新
			ps.setInt(7,rcarOrderVO.getRcaro_pay()); //無使用給0
			ps.setInt(8,rcarOrderVO.getConsume_point());
			ps.setInt(9, rcarOrderVO.getEvent_no()); //無活動也要給值
			ps.setString(10, rcarOrderVO.getRcaro_note());
			ps.setString(11, rcarOrderVO.getLessee_name());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean update(RcarOrderVO rcarOrderVO) {
		return true;
	}


	@Override
	public List<RcarOrderVO> getAll() { //取得所有訂單
		List<RcarOrderVO> list = new ArrayList<>();
		try (Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(All);){
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RcarOrderVO orderVO = new RcarOrderVO();
				orderVO.setRcaro_no(rs.getInt("RCARO_NO"));
				orderVO.setMeb_no(rs.getString("MEB_NO"));
				orderVO.setModel_no(rs.getString("MODEL_NO"));
				orderVO.setRcar_no(rs.getString("RCAR_NO"));
				orderVO.setRcaro_ppicktime(rs.getTimestamp("RCARO_PPICKTIME"));
				orderVO.setRcaro_pprettime(rs.getTimestamp("RCARO_PPRETTIME"));
				orderVO.setRcaro_rpicktime(rs.getTimestamp("RCARO_RPICKTIME"));
				orderVO.setRcaro_rrettime(rs.getTimestamp("RCARO_RRETTIME"));
				orderVO.setRcaro_pickuploc(rs.getString("RCARO_PICKUPLOC"));
				orderVO.setRcaro_returnloc(rs.getString("RCARO_RETURNLOC"));
				orderVO.setRcaro_returnloc_actual(rs.getString("RCARO_RETURNLOC_ACTUAL"));
				orderVO.setRcaro_date(rs.getTimestamp("RCARO_DATE"));
				orderVO.setRcaro_pay(rs.getInt("RCARO_PAY"));
				orderVO.setRcaro_extra_pay(rs.getInt("RCARO_EXTRA_PAY"));
				orderVO.setRcaro_extra_pay_status(rs.getInt("RCARO_EXTRA_PAY_STATUS"));
				orderVO.setConsume_point(rs.getInt("CONSUME_POINT"));
				orderVO.setEarn_point(rs.getInt("EARN_POINT"));
				orderVO.setEvent_no(rs.getInt("EVENT_NO"));
				orderVO.setRcaro_status(rs.getInt("RCARO_STATUS"));
				orderVO.setRcaro_note(rs.getString("RCARO_NOTE"));
				orderVO.setLessee_name(rs.getString("LESSEE_NAME"));
				list.add(orderVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<RcarOrderVO> getAll(int month) { //取得特定月份所有訂單
		List<RcarOrderVO> list = new ArrayList<>();
		try (Connection ct = ds.getConnection();
			PreparedStatement ps = ct.prepareStatement(MONTHALL);){
			ps.setInt(1, month);
			ps.setInt(2, month);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RcarOrderVO orderVO = new RcarOrderVO();
				orderVO.setRcaro_no(rs.getInt("RCARO_NO"));
				orderVO.setMeb_no(rs.getString("MEB_NO"));
				orderVO.setModel_no(rs.getString("MODEL_NO"));
				orderVO.setRcar_no(rs.getString("RCAR_NO"));
				orderVO.setRcaro_ppicktime(rs.getTimestamp("RCARO_PPICKTIME"));
				orderVO.setRcaro_pprettime(rs.getTimestamp("RCARO_PPRETTIME"));
				orderVO.setRcaro_rpicktime(rs.getTimestamp("RCARO_RPICKTIME"));
				orderVO.setRcaro_rrettime(rs.getTimestamp("RCARO_RRETTIME"));
				orderVO.setRcaro_pickuploc(rs.getString("RCARO_PICKUPLOC"));
				orderVO.setRcaro_returnloc(rs.getString("RCARO_RETURNLOC"));
				orderVO.setRcaro_returnloc_actual(rs.getString("RCARO_RETURNLOC_ACTUAL"));
				orderVO.setRcaro_date(rs.getTimestamp("RCARO_DATE"));
				orderVO.setRcaro_pay(rs.getInt("RCARO_PAY"));
				orderVO.setRcaro_extra_pay(rs.getInt("RCARO_EXTRA_PAY"));
				orderVO.setRcaro_extra_pay_status(rs.getInt("RCARO_EXTRA_PAY_STATUS"));
				orderVO.setConsume_point(rs.getInt("CONSUME_POINT"));
				orderVO.setEarn_point(rs.getInt("EARN_POINT"));
				orderVO.setEvent_no(rs.getInt("EVENT_NO"));
				orderVO.setRcaro_status(rs.getInt("RCARO_STATUS"));
				orderVO.setRcaro_note(rs.getString("RCARO_NOTE"));
				orderVO.setLessee_name(rs.getString("LESSEE_NAME"));
				list.add(orderVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<ReDay> getallday(List<RcarVO> rcar_no, int month) { //取得門市當月訂單 用於配車表用

		ArrayList<ReDay> arrayList = new ArrayList<>();
		int summonth = month * 2; // 將月份 * 2 
		for (RcarVO no : rcar_no) { //將每台車 new 一個ReDay 存放出租日期
			ReDay re = new ReDay();
			re.setCar_no(no.getRcar_no());
			re.setCar_model(no.getModel_no());
			arrayList.add(re);
		}
		String plate = rcar_no.get(0).getRcar_no().substring(0, 3);//取得車牌 前面3個字做模糊查詢
		try (Connection ct = ds.getConnection(); 
				PreparedStatement ps = ct.prepareStatement(CAR_ORDER);) {
			ps.setString(1, "%"+plate+"%");
			ps.setInt(2, summonth-1);
			ps.setInt(3, summonth);
			ps.setInt(4, summonth+1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String car_no = rs.getString("RCAR_NO"); //取得查詢到的車牌
				for (ReDay no : arrayList) { // 將所有車輛進行比對
					if(no.getCar_no().equals(car_no)) {
						no.day(rs.getInt(1), rs.getInt(2),rs.getInt(3),month);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayList;
	}

}
