package sts.logic.admin.login;

import java.io.IOException;
import java.sql.SQLException;

import sts.dao.AdminDAO;
import sts.tools.Tools;
import sts.vo.AdminVO;

public class LoginImp implements LoginIfs{

	public boolean login(AdminVO vo) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		AdminDAO dao = new AdminDAO();
		String password = dao.getPassword(vo.getAccount());
		if(!Tools.objectIsNull(password)){
			if(password.equals(vo.getPassword())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}

}
