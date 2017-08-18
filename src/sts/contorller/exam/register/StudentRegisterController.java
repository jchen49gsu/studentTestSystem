package sts.contorller.exam.register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sts.logic.exam.register.StudentRegisterIfs;
import sts.logic.exam.register.StudentRegisterImp;
import sts.vo.StudentVO;

/**
 * Servlet implementation class StduentRegisterController
 */
public class StudentRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		StudentRegisterIfs manager = new StudentRegisterImp();
		String email = request.getParameter("email");
		try {
			if(manager.validaterStudentExist(email)){
				request.setAttribute("student_exist", "true");
				request.getRequestDispatcher("/exam/register.jsp").forward(request, response);
			}else{
				StudentVO vo = new StudentVO();
				vo.setEmail(email);
				vo.setMobile_number(request.getParameter("phonenumber"));
				vo.setName(request.getParameter("name"));
				request.getSession().setAttribute("StudentVO", vo);
				response.sendRedirect("/exam/PaperController");
			}

		} catch (Exception e) {
			response.sendRedirect("/framework/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
