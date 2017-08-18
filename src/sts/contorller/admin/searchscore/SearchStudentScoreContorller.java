package sts.contorller.admin.searchscore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sts.logic.admin.searchscore.SeacrhStudentScoreIfs;
import sts.logic.admin.searchscore.SearchStudentScoreImp;
import sts.vo.StudentScoreVO;


public class SearchStudentScoreContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SeacrhStudentScoreIfs manager= new SearchStudentScoreImp();
		try {
			List<StudentScoreVO> scoreList = manager.getStudentScoreVO();
			request.setAttribute("scoreList", scoreList);
		}  catch (Exception e) {
			response.sendRedirect("/framework/error.jsp");
		}
		request.getRequestDispatcher("/admin/student_score.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
