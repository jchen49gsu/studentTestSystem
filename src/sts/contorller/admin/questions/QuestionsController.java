package sts.contorller.admin.questions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sts.logic.admin.question.QuestionIfs;
import sts.logic.admin.question.QuestionImp;
import sts.tools.Tools;
import sts.vo.ExamVO;


public class QuestionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String method = request.getParameter("method");
		if(Tools.objectIsNull(method)){
			QuestionIfs questionBean = new QuestionImp();
			try {
				List<ExamVO> questList = questionBean.getQuestionList();
				ExamVO vo = new ExamVO();
				request.setAttribute("exam_vo", vo);
				request.setAttribute("questList", questList);
				request.getRequestDispatcher("/admin/question.jsp").forward(request, response);
				return;
			}  catch (Exception e) {
				response.sendRedirect("/framework/error.jsp");
			}
		}
		if(method.equals("add")){
			QuestionIfs questionBean = new QuestionImp();
			ExamVO vo = new ExamVO();
			vo.setContans(request.getParameter("question_content"));
			vo.setAnswerA(request.getParameter("answer_a"));
			vo.setAnswerB(request.getParameter("answer_b"));
			vo.setAnswerC(request.getParameter("answer_c"));
			vo.setAnswerD(request.getParameter("answer_d"));
			vo.setAnswer(request.getParameter("answer"));
			
			try {
				questionBean.addQuestion(vo);
				response.sendRedirect("/admin/QuestionsController");
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(method.equals("delete")){
			System.out.println("del");
			QuestionIfs questionBean = new QuestionImp();
			Integer id = Integer.parseInt(request.getParameter("id"));
			try {
				questionBean.deletQuestionById(id.intValue());
				response.sendRedirect("/admin/QuestionsController");
				return;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(method.equals("modify")){
			QuestionIfs questionBean = new QuestionImp();
			Integer id = Integer.parseInt(request.getParameter("id"));
			try {
				ExamVO vo = questionBean.getQuestionById(id.intValue());
				List<ExamVO> questList = questionBean.getQuestionList();
				request.setAttribute("exam_vo", vo);
				request.setAttribute("modify", "Y");
				request.setAttribute("questList", questList);
				request.getRequestDispatcher("/admin/question.jsp").forward(request, response);
				return;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		if(method.equals("update")){
			QuestionIfs questionBean = new QuestionImp();
			try {
				ExamVO vo = new ExamVO();
				vo.setContans(request.getParameter("question_content"));
				vo.setAnswerA(request.getParameter("answer_a"));
				vo.setAnswerB(request.getParameter("answer_b"));
				vo.setAnswerC(request.getParameter("answer_c"));
				vo.setAnswerD(request.getParameter("answer_d"));
				vo.setAnswer(request.getParameter("answer"));
				vo.setId(Integer.parseInt(request.getParameter("questionid")));
				questionBean.updateQuestionById(vo);
				response.sendRedirect("/admin/QuestionsController");
				return;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
