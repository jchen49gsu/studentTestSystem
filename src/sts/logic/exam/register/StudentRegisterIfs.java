package sts.logic.exam.register;

import java.io.IOException;
import java.sql.SQLException;

import sts.vo.StudentVO;

public interface StudentRegisterIfs {
	public boolean validaterStudentExist(String email) throws SQLException, ClassNotFoundException, IOException;

}
