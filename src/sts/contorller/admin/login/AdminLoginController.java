package sts.contorller.admin.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sts.logic.admin.login.LoginIfs;
import sts.logic.admin.login.LoginImp;
import sts.vo.AdminVO;


public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminLoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String password = request.getParameter("password").trim();
		AdminVO vo = new AdminVO();
		LoginIfs loginBean = new LoginImp();
		vo.setAccount(name);
		vo.setPassword(password);
		try {
			if(loginBean.login(vo)){
				request.getSession().setAttribute("adminlogin","adminlogin");
				response.sendRedirect("/admin/main.jsp");
			}else{
				request.setAttribute("login_fail", "Y");
				request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/framework/error.jsp");
		}
	}

}
