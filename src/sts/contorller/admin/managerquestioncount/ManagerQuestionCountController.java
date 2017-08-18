package sts.contorller.admin.managerquestioncount;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sts.logic.admin.managerquestioncount.ManagerQuestionCountIfs;
import sts.logic.admin.managerquestioncount.ManagerQuestionCountImp;
import sts.tools.Tools;
import sts.vo.PaperCfgVO;


public class ManagerQuestionCountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(Tools.objectIsNull(method)){
			ManagerQuestionCountIfs manager = new ManagerQuestionCountImp();
			 try {
				PaperCfgVO vo = manager.getQuestionCounts();
				int counts = vo.getQuestion_counts();
				List<Integer> list = new ArrayList<Integer>();
			    int maxCounts = manager.getMaxQuestionCount();
			    for(int i = 0; i<=maxCounts; i++){
			    	list.add(i);
			    }
				request.setAttribute("counts", counts);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/admin/manager_paper_question_count.jsp").forward(request, response);
				return;
			}  catch (Exception e) {
				response.sendRedirect("/framework/error.jsp");
			}
		}
		if(method.equals("update"));
		int counts = Integer.parseInt(request.getParameter("questioncfgs"));
		ManagerQuestionCountIfs manager = new ManagerQuestionCountImp();
		PaperCfgVO vo = new PaperCfgVO();
		vo.setQuestion_counts(counts);
		try {
			manager.updateQuestionCounts(vo);
		}  catch (Exception e) {
			response.sendRedirect("/framework/error.jsp");
		}
		response.sendRedirect("/admin/ManagerQuestionCountController");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
