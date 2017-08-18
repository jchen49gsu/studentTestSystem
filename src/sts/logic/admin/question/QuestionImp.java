package sts.logic.admin.question;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sts.dao.ExamDAO;
import sts.vo.ExamVO;

public class QuestionImp implements QuestionIfs {

	@Override
	public void addQuestion(ExamVO vo) throws SQLException, ClassNotFoundException, IOException {
		ExamDAO dao = new ExamDAO();
		dao.addExam(vo);
		
	}

	@Override
	public List<ExamVO> getQuestionList() throws ClassNotFoundException, SQLException, IOException {
		ExamDAO dao = new ExamDAO();
		return dao.getExamList();
	}

	@Override
	public void deletQuestionById(int id)
			throws ClassNotFoundException, SQLException, IOException {
		ExamDAO dao = new ExamDAO();
		dao.deleteExamById(id);
	}

	@Override
	public ExamVO getQuestionById(int id) throws ClassNotFoundException,
			SQLException, IOException {
		ExamDAO dao = new ExamDAO();
		return dao.getExamById(id);
	}

	@Override
	public void updateQuestionById(ExamVO vo) throws ClassNotFoundException,
			SQLException, IOException {
		ExamDAO dao = new ExamDAO();
		dao.updateExam(vo);
	}

}
