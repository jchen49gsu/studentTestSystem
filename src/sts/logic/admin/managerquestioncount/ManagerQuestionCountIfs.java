package sts.logic.admin.managerquestioncount;

import java.io.IOException;
import java.sql.SQLException;

import sts.vo.PaperCfgVO;

public interface ManagerQuestionCountIfs {
	public PaperCfgVO getQuestionCounts() throws ClassNotFoundException, SQLException, IOException;
	public  void updateQuestionCounts(PaperCfgVO vo) throws SQLException, ClassNotFoundException, IOException;
	public int getMaxQuestionCount() throws ClassNotFoundException, SQLException, IOException;
	}
