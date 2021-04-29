package com.web.service;

import java.sql.SQLException;

import com.web.dao.UsersDao;
import com.web.domain.Users;
import com.web.util.ConnUtil;



public class UserService {
    private UsersDao userDao=new UsersDao();
    /**
     * �ж��û��Ƿ����ҵ�񷽷�
     * @param usersname
     * @return
     */
    public Boolean isExistsUsers(String username) {
    	try {
			return userDao.existsUser(username);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			ConnUtil.closeConn();
		}
    }
    
    public Boolean register(Users users) {
    	try {
    		ConnUtil.getConn().setAutoCommit(false);//�ر��Զ��ύ����Ϊ�ֶ�
			Boolean i= userDao.register(users);
			ConnUtil.getConn().commit();//�����ύ
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ConnUtil.getConn().rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}// ����ع�
			
			return false;
		}finally {
			ConnUtil.closeConn();
		}
    	
    }
	

}
