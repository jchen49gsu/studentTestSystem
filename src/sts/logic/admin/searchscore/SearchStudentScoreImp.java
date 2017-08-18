package sts.logic.admin.searchscore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sts.dao.StudentScoreDAO;
import sts.vo.StudentScoreVO;

public class SearchStudentScoreImp implements SeacrhStudentScoreIfs{

	@Override
	public List<StudentScoreVO> getStudentScoreVO() throws SQLException, ClassNotFoundException, IOException {
		StudentScoreDAO dao = new StudentScoreDAO();
		return dao.getStudentScoreList();
	}

}
