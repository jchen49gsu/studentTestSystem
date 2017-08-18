package sts.logic.admin.testresultconfiger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sts.dao.TestResultCfgDAO;
import sts.vo.TestResultCfgVO;

public class TestResultConfigerImp implements TestResultConfigerIfs{

	@Override
	public TestResultCfgVO getTestResultCfgVO(String grader) throws SQLException, ClassNotFoundException, IOException {
		TestResultCfgDAO dao = new TestResultCfgDAO();
		return dao.getTestResultCfgVO(grader);
	}

	@Override
	public void updateTestResultCfgVO(List<TestResultCfgVO> list) throws SQLException, ClassNotFoundException, IOException {
		TestResultCfgDAO dao = new TestResultCfgDAO();
		dao.updateTestResultCfgVO(list);
		
	}
	
	public List<TestResultCfgVO> getAllTestResultCfgVO() throws SQLException, ClassNotFoundException, IOException {
		TestResultCfgDAO dao = new TestResultCfgDAO();
		return dao.getAllTestResultCfgVO();
		
	}
}
