package sts.logic.admin.question;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sts.vo.ExamVO;

public interface QuestionIfs {
	public void addQuestion(ExamVO vo) throws SQLException, ClassNotFoundException, IOException;
	public List<ExamVO> getQuestionList() throws ClassNotFoundException, SQLException, IOException;
	public void deletQuestionById(int id) throws ClassNotFoundException, SQLException, IOException;
	public ExamVO getQuestionById(int id) throws ClassNotFoundException, SQLException, IOException;
	public void updateQuestionById(ExamVO vo) throws ClassNotFoundException, SQLException, IOException;
}
