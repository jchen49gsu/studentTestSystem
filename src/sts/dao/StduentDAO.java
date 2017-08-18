package sts.dao;

import java.io.IOException;
import java.sql.SQLException;

import sts.vo.StudentVO;

public class StduentDAO extends BaseDAO{
	
	public boolean validaterStudentExist(String email) throws SQLException, ClassNotFoundException, IOException{	
		String sql = "select email from student where email = ?";
		pstm = this.getPreparedStatement(sql);
		pstm.setString(1, email);
		rs = pstm.executeQuery();
		if(rs.next()){
			return true;
		}
		this.closeConnection();
		return false;
		
	}
	
	public void insertStudent(StudentVO vo) throws SQLException, ClassNotFoundException, IOException{
		String sql = "insert into student(name, email, moblie_number) values(?,?,?)";
		pstm = this.getPreparedStatement(sql);
		pstm.setString(1, vo.getName());
		pstm.setString(2, vo.getEmail());
		pstm.setString(3, vo.getMobile_number());
		pstm.execute();
	}
	
	public StudentVO getStudentByEmail(String email) throws SQLException, ClassNotFoundException, IOException{
		StudentVO vo = new StudentVO();
		String sql = "select id from student where email = ?";
		pstm = this.getPreparedStatement(sql);
		pstm.setString(1, email);
		rs = pstm.executeQuery();
		while(rs.next()){
			vo.setId(rs.getInt("id"));
		}
		this.closeConnection();
		return vo;
	}

}
