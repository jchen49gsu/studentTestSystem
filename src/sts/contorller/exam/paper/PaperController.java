package sts.contorller.exam.paper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sts.logic.exam.paper.PaperIfs;
import sts.logic.exam.paper.PaperImp;
import sts.vo.ExamVO;


public class PaperController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaperIfs manager = new PaperImp();
		try {
			List<ExamVO> list= manager.getExamList();
			request.getSession().setAttribute("examList", list);
		}  catch (Exception e) {
			response.sendRedirect("/framework/error.jsp");
		}
		request.getRequestDispatcher("/exam/paper.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
