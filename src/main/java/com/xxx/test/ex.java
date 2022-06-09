package com.xxx.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcar.model.RcarDAOImpl;
import com.rcar.model.RcarVO;
import com.rcarorder.model.RcarOrderDAOImpl;

import utils.ReDay;



@WebServlet("/test/ex")
public class ex extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DataSource ds;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
//		resp.getWriter().write("呼叫成功");
		System.out.println("呼叫成功");
//		System.out.println(req.getRequestURL());

//		MemberService service = new MemberService();
//
//		MemberDAOImpl impl = new MemberDAOImpl();
//		List<MemberVO> list = impl.getAll();

//		resp.getWriter().write(json);

//		String content = "123456哈哈";
//		byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
//		AES aes = SecureUtil.aes(key);
//
//		//加密
//		byte[] encrypt = aes.encrypt(content);
//		//解密
//		byte[] decrypt = aes.decrypt(encrypt);
//
//		//加密为16进制表示
//		String encryptHex = aes.encryptHex(content);
//		System.out.println(encryptHex);
//		//解密为原字符串
//		String decryptStr = aes.decryptStr(encryptHex);
//		System.out.println(decryptStr);

//		MemberVO vo = new MemberVO();
		
		//取得車輛當月訂單日期
//		String sql = "SELECT "
//				+ "    EXTRACT(DAY FROM RCARO_PPICKTIME) AS start,"
//				+ "    EXTRACT(DAY FROM RCARO_PPRETTIME),"
//				+ "    r.RCAR_NO "
//				+ "FROM "
//				+ "    RCAR_ORDER r "
//				+ "        JOIN "
//				+ "    RCAR c ON r.RCAR_NO = c.RCAR_NO "
//				+ "WHERE "
//				+ "    c.RCAR_NO = ? "
//				+ "ORDER BY start;";
//		ds = MysqlJDBC.getInstance().getDataSource();
//		ArrayList<ReDay> arrayList = new ArrayList<>();
////		for(int i = 1;i<=2;i++) {
//			ReDay re = new ReDay();
//			try (Connection ct = ds.getConnection();
//					PreparedStatement ps = ct.prepareStatement(sql);) {
//				ps.setString(1,"TPE");
//				ResultSet rs = ps.executeQuery();
//				while (rs.next()) {
//					re.setCar_no(rs.getString(3));
//					re.day(rs.getInt(1), rs.getInt(2));
//				}
//				arrayList.add(re);
////				vo.setMeb_bir(rs.getObject(1,LocalDate.class));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
		//將每輛車的訂單秀出
//		HttpSession session = req.getSession();
//		List<RcarVO> list= (List<RcarVO>)session.getAttribute("TPE");
		int month = Integer.parseInt(req.getParameter("month"));
		RcarOrderDAOImpl orderDAOImpl = new RcarOrderDAOImpl();
		RcarDAOImpl rcarDAOImpl = new RcarDAOImpl();
		List<RcarVO> list = rcarDAOImpl.getSt_noAll("TPE");
		List<ReDay> getallday = orderDAOImpl.getallday(list,month);

		/// 轉json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(getallday);
		resp.getWriter().write(json);
//		System.out.println(json);
		
//		StoreService sc = new StoreService();
//		
//		List<StoreVO> all = sc.getAll();
//		
//		for(StoreVO i : all) {
//			System.out.println(i);
//		}
		
	}
}
