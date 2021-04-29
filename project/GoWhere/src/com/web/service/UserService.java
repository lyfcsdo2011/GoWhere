package com.web.service;

import java.sql.SQLException;

import com.web.dao.UsersDao;
import com.web.domain.Users;
import com.web.util.ConnUtil;



public class UserService {
    private UsersDao userDao=new UsersDao();
    /**
     * 判断用户是否存在业务方法
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
    		ConnUtil.getConn().setAutoCommit(false);//关闭自动提交，改为手动
			Boolean i= userDao.register(users);
			ConnUtil.getConn().commit();//事务提交
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ConnUtil.getConn().rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}// 事务回滚
			
			return false;
		}finally {
			ConnUtil.closeConn();
		}
    	
    }
	

}
