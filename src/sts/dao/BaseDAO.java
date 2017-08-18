package sts.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sts.tools.Tools;

public class BaseDAO {



	private Connection conn;
	public ResultSet rs;
	public Statement stm;
	public PreparedStatement pstm;

	public Statement getStatement() throws ClassNotFoundException, SQLException, IOException {
		if (stm == null) {
			if (conn == null) {
				creatConnection();
			}
			stm = conn.createStatement();
		}

		return stm;
	}

	public PreparedStatement getPreparedStatement(String sql)
			throws SQLException, ClassNotFoundException, IOException {
		if (pstm == null) {
			if (conn == null) {
				creatConnection();
			}
		}else{
			pstm.close();
		}
		pstm = conn.prepareStatement(sql);
		return pstm;

	}

	public void closeConnection() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stm != null) {
			stm.close();
		}
		if (pstm != null) {
			pstm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	private void creatConnection() throws ClassNotFoundException, SQLException, IOException {
		Class.forName(Tools.getDataBaseProperty("jdbcDriver"));
		conn = DriverManager.getConnection(Tools.getDataBaseProperty("url"), Tools.getDataBaseProperty("username"), Tools.getDataBaseProperty("password"));
	}

}
