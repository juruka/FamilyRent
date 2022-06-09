package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		System.out.println(account+" "+password);
		if (session.getAttribute("account") == null) {
			MemberService service = new MemberService();
			if (service.login(account, password)) {
				session.setAttribute("account", service.member(account));
//				resp.sendRedirect(req.getContextPath() + "/carModelServlet");
				resp.getWriter().print("1");
			} else {
				System.out.println("登入失敗");
				resp.getWriter().print("0");
				return;
//				resp.sendRedirect(req.getContextPath() + "/login.html");
			}
		}else {
			session.removeAttribute("account");
			resp.sendRedirect(req.getContextPath() + "/index");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
