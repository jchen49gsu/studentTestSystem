package sts.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sts.vo.TestResultCfgVO;

public class TestResultCfgDAO extends BaseDAO{
	public TestResultCfgVO  getTestResultCfgVO(String grader) throws SQLException, ClassNotFoundException, IOException{
		TestResultCfgVO vo = new TestResultCfgVO();
		String sql ="select * from test_result_cfg where grader=?";
		pstm = this.getPreparedStatement(sql);
		pstm.setString(1, grader);
		rs =pstm.executeQuery();
		while(rs.next()){
			vo.setId(rs.getInt("id"));
			vo.setGrader(rs.getString("grader"));
			vo.setGrader_percent_start(rs.getInt("grader_percent_start"));
			vo.setGrader_percent_end(rs.getInt("grader_percent_end"));
			vo.setGrader_descripton(rs.getString("grader_description"));
		}
		this.closeConnection();
		return vo;
	}
	
	
		public List<TestResultCfgVO>  getAllTestResultCfgVO() throws SQLException, ClassNotFoundException, IOException{
			TestResultCfgVO vo = new TestResultCfgVO();
			String sql ="select * from test_result_cfg";
			pstm = this.getPreparedStatement(sql);
			rs =pstm.executeQuery();
			List<TestResultCfgVO> list = new ArrayList<TestResultCfgVO>();
			while(rs.next()){
				vo.setId(rs.getInt("id"));
				vo.setGrader(rs.getString("grader"));
				vo.setGrader_percent_start(rs.getInt("grader_percent_start"));
				vo.setGrader_percent_end(rs.getInt("grader_percent_end"));
				vo.setGrader_descripton(rs.getString("grader_description"));
				list.add(vo);
			}
			this.closeConnection();
			return list;
		}
	
	public void updateTestResultCfgVO(List<TestResultCfgVO> list) throws SQLException, ClassNotFoundException, IOException{
		for(TestResultCfgVO vo : list){
			String grader = vo.getGrader();
			String sql = "select * from test_result_cfg where grader=?";
			pstm = this.getPreparedStatement(sql);
			pstm.setString(1, grader);
			rs = pstm.executeQuery();
			if(rs.next()){
				String sql1 = "update test_result_cfg set grader_percent_start=?,grader_percent_end=?, grader_description=? where grader=?";
				pstm =this.getPreparedStatement(sql1);
				pstm.setInt(1, vo.getGrader_percent_start());
				pstm.setInt(2, vo.getGrader_percent_end());
				pstm.setString(3, vo.getGrader_descripton());
				pstm.setString(4, vo.getGrader());
				pstm.executeUpdate();
			}else{
				String sql2 = "insert into test_result_cfg(grader_percent_start,grader_percent_end,grader_description, grader)values(?,?,?,?)";
				pstm =this.getPreparedStatement(sql2);
				pstm.setInt(1, vo.getGrader_percent_start());
				pstm.setInt(2, vo.getGrader_percent_end());
				pstm.setString(3, vo.getGrader_descripton());
				pstm.setString(4, vo.getGrader());
				pstm.execute();
			}
		}
		this.closeConnection();
	}
}
