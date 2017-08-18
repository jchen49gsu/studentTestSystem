package sts.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sts.vo.ExamVO;

public class ExamDAO extends BaseDAO{
	
	public void addExam(ExamVO vo) throws SQLException, ClassNotFoundException, IOException{
		String sql = "insert into exam (contans,answerA,answerB,answerC,answerD,answer) values(?,?,?,?,?,?)";
		pstm = getPreparedStatement(sql);
		pstm.setString(1, vo.getContans());
		pstm.setString(2, vo.getAnswerA());
		pstm.setString(3, vo.getAnswerB());
		pstm.setString(4, vo.getAnswerC());
		pstm.setString(5, vo.getAnswerD());
		pstm.setString(6, vo.getAnswer());
		pstm.execute();
		this.closeConnection();
	}
	
	public List<ExamVO> getExamList() throws ClassNotFoundException, SQLException, IOException{
		List<ExamVO> list = new ArrayList<ExamVO>();
		String sql = "select id, contans,answerA,answerB,answerC,answerD,answer from exam order by id";
		stm = this.getStatement();
		rs = stm.executeQuery(sql);
		while(rs.next()){
			ExamVO vo = new ExamVO();
			vo.setId(rs.getInt("id"));
			vo.setContans(rs.getString("contans"));
			vo.setAnswerA(rs.getString("answerA"));
			vo.setAnswerB(rs.getString("answerB"));
			vo.setAnswerC(rs.getString("answerC"));
			vo.setAnswerD(rs.getString("answerD"));
			vo.setAnswer(rs.getString("answer"));
			list.add(vo);
		}
		this.closeConnection();
		return list;
	}
	
	public void deleteExamById(int id) throws ClassNotFoundException, SQLException, IOException{
		String sql = "delete  from exam where id = ?";
		pstm = this.getPreparedStatement(sql);
		pstm.setInt(1, id);
		pstm.execute();
		this.closeConnection();
	}
	
	public ExamVO getExamById(int id) throws ClassNotFoundException, SQLException, IOException{
		List<ExamVO> list = getExamList();
	for(ExamVO vo: list){
		if(vo.getId()==id){
			return vo;
		}
	}
	return null;
	}
	
	public void updateExam(ExamVO vo) throws ClassNotFoundException, SQLException, IOException{
		String sql = "update exam set contans=?,answerA=?,answerB=?,answerC=?,answerD=?,answer=? where id= ?";
		pstm = getPreparedStatement(sql);
		pstm.setString(1, vo.getContans());
		pstm.setString(2, vo.getAnswerA());
		pstm.setString(3, vo.getAnswerB());
		pstm.setString(4, vo.getAnswerC());
		pstm.setString(5, vo.getAnswerD());
		pstm.setString(6, vo.getAnswer());
		pstm.setInt(7, vo.getId());
		pstm.executeUpdate();
		this.closeConnection();
	}
	
	public int getCountQuestion() throws ClassNotFoundException, SQLException, IOException{
		String sql ="select count(*) as counts from exam";
		stm = this.getStatement();
		rs = stm.executeQuery(sql);
		while(rs.next()){
			int result = rs.getInt("counts");
			this.closeConnection();
			return result;
		}
		this.closeConnection();
		return 0;
	}

}
