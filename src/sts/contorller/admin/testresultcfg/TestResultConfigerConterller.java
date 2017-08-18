package sts.contorller.admin.testresultcfg;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sts.logic.admin.testresultconfiger.TestResultConfigerIfs;
import sts.logic.admin.testresultconfiger.TestResultConfigerImp;
import sts.tools.Tools;
import sts.vo.TestResultCfgVO;


public class TestResultConfigerConterller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(Tools.objectIsNull(method)){
			TestResultConfigerIfs manager = new TestResultConfigerImp();
			try {
				TestResultCfgVO voa = manager.getTestResultCfgVO("A");
				TestResultCfgVO vob = manager.getTestResultCfgVO("B");
				TestResultCfgVO voc = manager.getTestResultCfgVO("C");
				TestResultCfgVO vod = manager.getTestResultCfgVO("D");
				if(voa.getGrader_percent_start()==0){
					voa.setGrader_percent_end(10);
					voa.setGrader_descripton("");
				}
				if(vob.getGrader_percent_start()==0){
					vob.setGrader_percent_end(10);
					vob.setGrader_percent_start(10);
					vob.setGrader_descripton("");
				}
				if(voc.getGrader_percent_start()==0){
					voc.setGrader_percent_end(10);
					voc.setGrader_percent_start(10);
					voc.setGrader_descripton("");
				}
				if(vod.getGrader_percent_end()==0){
					vod.setGrader_percent_start(10);
					vod.setGrader_descripton("");
				}
				request.setAttribute("voa", voa);
				request.setAttribute("vob", vob);
				request.setAttribute("voc", voc);
				request.setAttribute("vod", vod);
				request.getRequestDispatcher("/admin/test_result_configer.jsp").forward(request, response);
				return;
			} 
			 catch (Exception e) {
				 response.sendRedirect("/framework/error.jsp");
			}
			
		}
		if(method.equals("update")){
			TestResultCfgVO voa = new TestResultCfgVO();
			TestResultCfgVO vob = new TestResultCfgVO();
			TestResultCfgVO voc = new TestResultCfgVO();
			TestResultCfgVO vod = new TestResultCfgVO();
			voa.setGrader("A");
			voa.setGrader_descripton(request.getParameter("desca"));
			voa.setGrader_percent_start(Integer.parseInt(request.getParameter("a_start")));
			voa.setGrader_percent_end(Integer.parseInt(request.getParameter("a_end")));
			vob.setGrader("B");
			vob.setGrader_descripton(request.getParameter("descb"));
			vob.setGrader_percent_start(Integer.parseInt(request.getParameter("b_start")));
			vob.setGrader_percent_end(Integer.parseInt(request.getParameter("b_end")));
			voc.setGrader("C");
			voc.setGrader_descripton(request.getParameter("descc"));
			voc.setGrader_percent_start(Integer.parseInt(request.getParameter("c_start")));
			voc.setGrader_percent_end(Integer.parseInt(request.getParameter("c_end")));
			vod.setGrader("D");
			vod.setGrader_descripton(request.getParameter("descd"));
			vod.setGrader_percent_start(Integer.parseInt(request.getParameter("d_start")));
			vod.setGrader_percent_end(Integer.parseInt(request.getParameter("d_end")));
			List<TestResultCfgVO> list = new ArrayList<TestResultCfgVO>();
			list.add(voa);
			list.add(vob);
			list.add(voc);
			list.add(vod);
			TestResultConfigerIfs manager = new TestResultConfigerImp();
			try {
				manager.updateTestResultCfgVO(list);
				response.sendRedirect("/admin/TestResultConfigerConterller");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
