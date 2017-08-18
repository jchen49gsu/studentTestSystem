package sts.logic.admin.searchscore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sts.vo.StudentScoreVO;

public interface SeacrhStudentScoreIfs {
	public List<StudentScoreVO> getStudentScoreVO() throws SQLException, ClassNotFoundException, IOException;
}
