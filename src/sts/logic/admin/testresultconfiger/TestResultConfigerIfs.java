package sts.logic.admin.testresultconfiger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import sts.vo.TestResultCfgVO;

public interface TestResultConfigerIfs {
	public TestResultCfgVO  getTestResultCfgVO(String grader) throws SQLException, ClassNotFoundException, IOException;
	public void updateTestResultCfgVO(List<TestResultCfgVO> vo) throws SQLException, ClassNotFoundException, IOException;
	public List<TestResultCfgVO> getAllTestResultCfgVO() throws SQLException, ClassNotFoundException, IOException;
}
