package sts.logic.admin.managerquestioncount;

import java.io.IOException;
import java.sql.SQLException;

import sts.dao.ExamDAO;
import sts.dao.PaperCfgDAO;
import sts.vo.PaperCfgVO;

public class ManagerQuestionCountImp implements ManagerQuestionCountIfs{

	@Override
	public PaperCfgVO getQuestionCounts() throws ClassNotFoundException, SQLException, IOException {
		PaperCfgVO vo = new PaperCfgVO();
		PaperCfgDAO dao = new PaperCfgDAO();
		ExamDAO examDao = new ExamDAO();
		int maxCounts = examDao.getCountQuestion();
		int paperCounts = dao.getPaperCfgCount();
		if(maxCounts<paperCounts){
			vo.setQuestion_counts(maxCounts);
		}else{
			vo.setQuestion_counts(paperCounts);
		}
		return vo;
	}

	@Override
	public void updateQuestionCounts(PaperCfgVO vo) throws SQLException, ClassNotFoundException, IOException {
		PaperCfgDAO dao = new PaperCfgDAO();
		dao.setPaperCfgCount(vo);
		
	}

	public int getMaxQuestionCount() throws ClassNotFoundException, SQLException, IOException{
		ExamDAO examDao = new ExamDAO();
		return examDao.getCountQuestion();
	}
}
