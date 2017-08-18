package sts.dao;

import java.io.IOException;
import java.sql.SQLException;

import sts.vo.PaperCfgVO;

public class PaperCfgDAO extends BaseDAO{
	
	public int getPaperCfgCount() throws ClassNotFoundException, SQLException, IOException{
		String sql = "select question_counts from paper_cfg ";
		stm = this.getStatement();
		rs = stm.executeQuery(sql);
		while(rs.next()){
			int result = rs.getInt("question_counts");
			this.closeConnection();
			return result;
		}
		this.closeConnection();
		return 0;
	}
	public void setPaperCfgCount(PaperCfgVO vo) throws SQLException, ClassNotFoundException, IOException{
		String sql = "select question_counts from paper_cfg ";
		int result = 0;
		stm = this.getStatement();
		rs = stm.executeQuery(sql);
		while(rs.next()){
			result = rs.getInt("question_counts");
		}
		if(result==0){
			String sql1 = "insert into paper_cfg (question_counts) values(?)";
			pstm = this.getPreparedStatement(sql1);
			pstm.setInt(1, vo.getQuestion_counts());
			pstm.execute();
		}else{
			String sql2 = "update paper_cfg set question_counts=?";
			pstm = this.getPreparedStatement(sql2);
			pstm.setInt(1, vo.getQuestion_counts());
			pstm.executeUpdate();
		}
		this.closeConnection();
	}
	

}
