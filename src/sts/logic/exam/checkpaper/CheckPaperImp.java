package sts.logic.exam.checkpaper;

import java.io.IOException;
import java.sql.SQLException;

import sts.dao.StduentDAO;
import sts.dao.StudentScoreDAO;
import sts.vo.StudentScoreVO;
import sts.vo.StudentVO;

public class CheckPaperImp implements ChcekPaperIfs {

	@Override
	public void inserScore(StudentScoreVO scoreVO, StudentVO studentVO) throws SQLException, ClassNotFoundException, IOException {
		StduentDAO studentDAO = new StduentDAO();
		StudentScoreDAO scoreDAO = new StudentScoreDAO();
		studentDAO.insertStudent(studentVO);
		studentVO = studentDAO.getStudentByEmail(studentVO.getEmail());
		scoreVO.setStudentVO(studentVO);
		scoreDAO.insertScoreVO(scoreVO);
	}

}
