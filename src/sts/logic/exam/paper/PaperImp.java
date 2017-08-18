package sts.logic.exam.paper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sts.logic.admin.managerquestioncount.ManagerQuestionCountIfs;
import sts.logic.admin.managerquestioncount.ManagerQuestionCountImp;
import sts.logic.admin.question.QuestionIfs;
import sts.logic.admin.question.QuestionImp;
import sts.vo.ExamVO;
import sts.vo.PaperCfgVO;

public class PaperImp implements PaperIfs{
	
	public int getRandom(int max){
		int min=0;
		max = max-1;
	     Random random = new Random();
	     return random.nextInt(max)%(max-min+1) + min;
	}

	@Override
	public List<ExamVO> getExamList() throws ClassNotFoundException, SQLException, IOException {
		List<ExamVO> papaerList = new ArrayList<ExamVO>();
		ManagerQuestionCountIfs questionCountManager = new ManagerQuestionCountImp();
		QuestionIfs questionManager = new QuestionImp();
		int maxCount = questionCountManager.getMaxQuestionCount();
		PaperCfgVO paperCfgVO = questionCountManager.getQuestionCounts();
		int  configerNumber = paperCfgVO.getQuestion_counts();
		List<ExamVO> list = questionManager.getQuestionList();
		for(int i=1; i<=configerNumber; i++){
			int temp = getRandom(maxCount);
			ExamVO vo = list.get(temp);
			papaerList.add(vo);
		}
		return papaerList;
	}
	 
}
