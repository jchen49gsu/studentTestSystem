package sts.dao;

import java.io.IOException;
import java.sql.SQLException;




public class AdminDAO extends BaseDAO{
	
	public String getPassword(String account) throws SQLException, ClassNotFoundException, IOException{
		String sql = "select password from admin where account = ?";
		String password = "";
		pstm = getPreparedStatement(sql);
		pstm.setString(1, account);
		rs = pstm.executeQuery();
		while(rs.next()){
			password = rs.getString("password");
		}
		closeConnection();
		return password;
	}
}
