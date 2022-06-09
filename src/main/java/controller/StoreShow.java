package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcar.model.RcarDAOImpl;
import com.rcar.model.RcarVO;
import com.rcarorder.model.RcarOrderDAOImpl;
import com.store.model.StoreDAOImpl_hib;
import com.store.model.StoreService;
import com.store.model.StoreVO;
import com.store.model.Store_hib;

import utils.ReDay;

@WebServlet("/storeshow")
public class StoreShow extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String click = req.getParameter("click");
//		HttpSession session = req.getSession();
		ServletContext context = getServletContext();
		if (click == null) {
			//重新整理會經過
			StoreService sc = new StoreService();
			List<Store_hib> all_hib = sc.getAll_hib();
//			List<StoreVO> all = sc.getAll();
			//先將所有門市車輛訊息存入ServletContext 以便切換調用 可以不用一直呼叫連線池 
			if(context.getAttribute("TPE") == null) {
				for (Store_hib store : all_hib) {
					RcarDAOImpl rcarDAOImpl = new RcarDAOImpl();
					List<RcarVO> list = rcarDAOImpl.getSt_noAll(store.getSt_no());
					context.setAttribute(store.getSt_no(), list);
				}
			}
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(all_hib);
			resp.getWriter().write(json);
			return;
		}else {
			//切換門市,秀出該門市所有車輛
			String city = req.getParameter("city");
			int month = Integer.parseInt(req.getParameter("changemonth"));
			RcarOrderDAOImpl orderDAOImpl = new RcarOrderDAOImpl();
//			RcarDAOImpl rcarDAOImpl = new RcarDAOImpl();
//			List<RcarVO> list = rcarDAOImpl.getAll(city);
			
			//取出相對應的ServletContext 可以不用調用連線池
			@SuppressWarnings("unchecked")
			List<RcarVO> list = (List<RcarVO>) context.getAttribute(city);
			List<ReDay> getallday = orderDAOImpl.getallday(list,month);
			/// 轉json
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(getallday);
			resp.getWriter().write(json);
//			System.out.println(json);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);

	}
}
