package sts.contorller.exam.checkpaper;

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
import sts.logic.exam.checkpaper.ChcekPaperIfs;
import sts.logic.exam.checkpaper.CheckPaperImp;
import sts.vo.ExamVO;
import sts.vo.StudentScoreVO;
import sts.vo.StudentVO;
import sts.vo.TestResultCfgVO;

/**
 * Servlet implementation class CheckPaperContorller
 */
public class CheckPaperContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ExamVO> list= (List<ExamVO>)request.getSession().getAttribute("examList");
		List<ExamVO> right = new ArrayList<ExamVO>();
		List<ExamVO> wrong = new ArrayList<ExamVO>();
		for(ExamVO vo:list){
			String studentAnswer = request.getParameter(vo.getId()+"");
			studentAnswer = studentAnswer+"";
			if(studentAnswer.equals(vo.getAnswer())){
				right.add(vo);
			}else{
				wrong.add(vo);
			}
		}
		int persent = getPersent(list.size(), right.size());
		String garde ="";
		String desciption = "";
		TestResultConfigerIfs manager = new TestResultConfigerImp();
		try {
			List<TestResultCfgVO> cfgList = manager.getAllTestResultCfgVO();
			for(TestResultCfgVO vo: cfgList){
				if(vo.getGrader_percent_start()<=persent&&persent<=vo.getGrader_percent_end() ){
					garde=vo.getGrader();
				desciption = vo.getGrader_descripton();}
			}
			ChcekPaperIfs imsertManager = new CheckPaperImp();
			StudentScoreVO scoreVO = new StudentScoreVO();
			StudentVO studentVO = (StudentVO)request.getSession().getAttribute("StudentVO");
			scoreVO.setScore(persent);
			scoreVO.setLevel(garde);
			imsertManager.inserScore(scoreVO, studentVO);
			request.setAttribute("persent", persent);
			request.setAttribute("garde", garde);
			request.setAttribute("desciption", desciption);
			request.setAttribute("wrong", wrong);
			request.getRequestDispatcher("/exam/result.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/framework/error.jsp");
		}
	}
	
	private int getPersent(int questCount, int rightCount){
		float rf = Float.parseFloat(rightCount+"");
		float cf = Float.parseFloat(questCount+"");
		return (int) (rf/cf*100);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
