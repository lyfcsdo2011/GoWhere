  package com.web.service;

import java.sql.SQLException;

import com.web.dao.UsersDao;
import com.web.domain.Users;
import com.web.execption.NameException;
import com.web.execption.PassException;
import com.web.util.ConnUtil;
import com.web.util.SHAUtil;



public class UserLoginService {
	private UsersDao userDao =new UsersDao();
	public  Users isLogin(String username,String password) throws NameException, PassException {
		try {
		Users users=this.userDao.SelectByName(username);
		if(users==null) {
			
			throw new NameException("�û��������ڣ�");
		}
		if (SHAUtil.getSHA256(password+users.getSalt()).equals(users.getPassword())) {
		//	if (password.equals(users.getPassword())) {
			// ��¼�ɹ�
			return users;
		} else {
			throw new PassException("�������");
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	} finally {
		ConnUtil.closeConn();// һ��ҵ�񷽷�����ɣ���Ҫ�ر����ݿ�����
	}
	}

}
