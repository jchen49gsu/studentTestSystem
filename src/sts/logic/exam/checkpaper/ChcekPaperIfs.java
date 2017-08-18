package sts.logic.exam.checkpaper;

import java.io.IOException;
import java.sql.SQLException;

import sts.vo.StudentScoreVO;
import sts.vo.StudentVO;

public interface ChcekPaperIfs {
	public void inserScore(StudentScoreVO scoreVO, StudentVO studentVO) throws SQLException, ClassNotFoundException, IOException;

}
