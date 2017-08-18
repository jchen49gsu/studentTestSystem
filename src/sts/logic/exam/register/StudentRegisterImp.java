package sts.logic.exam.register;

import java.io.IOException;
import java.sql.SQLException;

import sts.dao.StduentDAO;
import sts.vo.StudentVO;

public class StudentRegisterImp implements StudentRegisterIfs{

	@Override
	public boolean validaterStudentExist(String email) throws SQLException, ClassNotFoundException, IOException {
		StduentDAO dao = new StduentDAO();
		return dao.validaterStudentExist(email);
	}


}
