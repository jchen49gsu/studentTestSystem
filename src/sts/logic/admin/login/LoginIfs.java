package sts.logic.admin.login;

import java.io.IOException;
import java.sql.SQLException;

import sts.vo.AdminVO;

public interface LoginIfs {
	public boolean login(AdminVO vo) throws SQLException, ClassNotFoundException, IOException;
}
