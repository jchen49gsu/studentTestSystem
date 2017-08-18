package sts.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sts.vo.StudentScoreVO;
import sts.vo.StudentVO;

public class StudentScoreDAO extends BaseDAO{
	public List<StudentScoreVO> getStudentScoreList() throws SQLException, ClassNotFoundException, IOException{
		List<StudentScoreVO> list = new ArrayList<StudentScoreVO>();
		stm = this.getStatement();
		String sql = "select a.id, a.email, a.moblie_number, a.name, b.score, b.level from student a, student_score b where a.id=b.student_id";
		rs = stm.executeQuery(sql);
		while(rs.next()){
			StudentScoreVO vo = new StudentScoreVO();
			StudentVO svo = new StudentVO();
			svo.setId(rs.getInt("id"));
			svo.setEmail(rs.getString("email"));
			svo.setName(rs.getString("name"));
			svo.setMobile_number(rs.getString("moblie_number"));
			vo.setStudentVO(svo);
			vo.setScore(rs.getInt("score"));
			vo.setLevel(rs.getString("level"));
			list.add(vo);
		}
		this.closeConnection();
		return list;
	}
	
	public void insertScoreVO(StudentScoreVO vo) throws SQLException, ClassNotFoundException, IOException{
		String sql = "insert into student_score(score, level, student_id) values(?,?,?)";
		pstm = this.getPreparedStatement(sql);
		pstm.setInt(1, vo.getScore());
		pstm.setString(2, vo.getLevel());
		pstm.setInt(3, vo.getStudentVO().getId());
		pstm.execute();
		this.closeConnection();
	}
}
