package com.xxx.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.carlevel.model.CarLeveService;
import com.carlevel.model.CarLevelDAOImpl;
import com.carlevel.model.CarLevelVO;
import com.carmodel.model.CarModelService;
import com.carmodel.model.CarModelVO;
import com.employee.model.EmployeeService;
import com.employee.model.EmployeeVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.member.model.MemberDAOImpl;
import com.member.model.MemberVO;
import com.rcar.model.RcarDAOImpl;
import com.rcar.model.RcarService;
import com.rcar.model.RcarVO;
import com.rcarorder.model.RcarOrderDAOImpl;
import com.rcarorder.model.RcarOrderService;
import com.rcarorder.model.RcarOrderVO;
import com.store.model.StoreDAOImpl_hib;
import com.store.model.Store_hib;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;
import utils.ReDay;

@WebServlet("/test/tt")
//@MultipartConfig
public class test2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
//		RcarDAOImpl rcarDAOImpl = new RcarDAOImpl();
//		List<RcarVO> all = rcarDAOImpl.getSt_noAll("TPE");
//		RcarOrderDAOImpl orderDAOImpl = new RcarOrderDAOImpl();
//		List<ReDay> getallday2 = orderDAOImpl.getallday(all, 5);
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(getallday2);
//		resp.getWriter().write(json);
		
//		MemberVO vo = new MemberVO();
//		vo.setMeb_no("S12268175");
//		vo.setMeb_pass("123456");
//		vo.setMeb_name("qqqq");
//		vo.setMeb_gender(0);
//		Calendar myCalendar = new GregorianCalendar(1993, 0, 28);
//		long millis = myCalendar.getTimeInMillis();
//		LocalDate of = LocalDate.of(1993, 06, 29);
//		LocalDate parse = LocalDate.parse("1993-02-22");
//		Date valueOf = Date.valueOf(of);
//		vo.setMeb_bir(Date.valueOf(LocalDate.parse("1993-05-22")));
//		vo.setMeb_tel("123456789");
//		vo.setMeb_adrs("新竹市xxxxxx");
//		vo.setMeb_mail("ssssssg4@gmail.com");
//		vo.setMeb_bonus(10);
//		vo.setMeb_status(1);
//		MemberDAOImpl impl = new MemberDAOImpl();
//		impl.insert(vo);
//		impl.update(vo);
//		System.out.println(true);
		
		
//		Part part = req.getPart("img");
//		InputStream in = part.getInputStream();
//		byte[] buf = new byte[in.available()];
//		in.read(buf);
//		in.close();
//		vo.setMeb_profile(buf);
//		impl.imgupdate(vo);
		
//		CarLeveService service = new CarLeveService();
//		CarLevelVO vo = new CarLevelVO();
//		vo.setLevel_no("E");
//		vo.setLevel_name("aaaa");
//		List<CarLevelVO> all = service.getAll();
//		all.forEach((e)->{
//			System.out.println(e.toString());
//		});
//		CarModelService service = new CarModelService();
//		CarModelVO vo = new CarModelVO();
//		vo.setModel_no("xxx");
//		vo.setLevel_no("A");
//		vo.setModel_name("ccccccccccc");
//		vo.setModel_cc(2000);
//		vo.setModel_price(2500);
//		vo.setModel_oil("95");
//		vo.setModel_seats(5);
//		vo.setModel_baggage("xxxx");
//		vo.setCar_info("dddd");
//		service.insert(vo);
//		service.update(vo);
//		service.getAll().forEach((e)->{
//			System.out.println(e.toString());
//		});
		
//		EmployeeService service = new EmployeeService();
//		EmployeeVO vo = new EmployeeVO();
//		vo.setEmp_no("123xxxx");
//		vo.setEmp_name("opopop");
//		vo.setEmp_pass("zxcv");
//		vo.setSt_no("TPE");
//		vo.setEmp_gender(1);
//		vo.setEmp_bir(new Date(0));
//		vo.setEmp_tel("0988888");
//		vo.setEmp_adrs("ddddd");
//		vo.setEmp_mail("g4");
//		vo.setEmp_title("fdsafdsa");
//		vo.setEmp_status(0);
//		service.insert(vo);
//		service.update(vo);
//		service.getAll().forEach((e)->{
//			System.out.println(e.toString());
//		});
		
//		System.out.println(service.emp("g4").toString());
		
		
//		RcarService service = new RcarService();
//		RcarVO vo = new RcarVO();
//		vo.setRcar_no("xxxxx");
//		vo.setSt_no("KH");
//		vo.setModel_no("YARIS");
//		vo.setRcar_loc("KH");
//		vo.setMiles(0);
//		vo.setRcar_status(6);
//		service.insert(vo);
//		service.update(vo);
//		service.getAll().forEach((e)->{
//			System.out.println(e.toString());
//		});
		
//		RcarOrderService service = new RcarOrderService();
//		RcarOrderVO vo = new RcarOrderVO();
//		vo.setMeb_no("J122681375");
//		vo.setModel_no("ALTIS");
//		vo.setRcaro_ppicktime(new Timestamp(System.currentTimeMillis()));
//		vo.setRcaro_pprettime(new Timestamp(System.currentTimeMillis()));
//		vo.setRcaro_pickuploc("TPE");
//		vo.setRcaro_returnloc("TPE");
//		vo.setRcaro_date(new Timestamp(System.currentTimeMillis()));
//		vo.setRcaro_pay(0);
//		vo.setRcaro_extra_pay(222);
//		vo.setConsume_point(0);
//		vo.setEvent_no(1);
//		vo.setRcaro_note("ssss");
//		vo.setLessee_name("zou");
//		service.insert(vo);
//		service.getAll(4).forEach((e)->{
//			System.out.println(e.toString());
//		});
		
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = session.beginTransaction();
//		Store_hib store_hib = session.get(Store_hib.class, "TC");
//		store_hib.setSt_tel("sdfsdf");
//		session.update(store_hib);
////		session.get(Store_hib.class, "TC").setSt_tel("122345");
//		transaction.commit();
//		System.out.println(store_hib);
//		resp.getWriter().write(store_hib.toString());
//		HibernateUtil.shutdown();
		
		StoreDAOImpl_hib impl_hib = new StoreDAOImpl_hib();
		List<Store_hib> list = impl_hib.getAll();
		resp.getWriter().write(list.toString());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
