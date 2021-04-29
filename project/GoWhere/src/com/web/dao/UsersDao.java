package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.web.domain.Users;
import com.web.util.ConnUtil;
import com.web.util.DateUtil;
import com.web.util.SHAUtil;




public class UsersDao {
	public Users SelectByName(String username) throws SQLException{
		String sql=" SELECT * FROM tab_user where username=?";
		Connection conn=ConnUtil.getConn();
		PreparedStatement pstat=conn.prepareStatement(sql);
		pstat.setString(1,username);
		ResultSet rs=pstat.executeQuery();
		if(rs.next()) {
			Users users=new Users();
			users.setUid(rs.getInt("uid"));
			users.setUsername(rs.getString("username"));
			users.setPassword(rs.getString("password"));
			users.setSalt(rs.getString("salt"));
			
			return users;
		}else {
			return null;
		}
		
	}
	public Boolean existsUser(String username) throws SQLException {
		String sql=" SELECT * FROM tab_user where username=?";
		Connection conn=ConnUtil.getConn();
		PreparedStatement pstat=conn.prepareStatement(sql);
		pstat.setString(1,username);
		ResultSet rs=pstat.executeQuery();
		
		if(rs.next()) {
			return true;
		}else{
			return false;
		}
	}



 public Boolean register(Users users) throws SQLException {
	 String userSalt=UUID.randomUUID().toString();
	 String sql="insert into"+" tab_user(username,password,telephone,email,name,sex,birthday,salt)"
	 +" values(?,?,?,?,?,?,?,?)";
	 Connection conn=ConnUtil.getConn();
	 PreparedStatement pstat=conn.prepareStatement(sql);
	 pstat.setString(1, users.getUsername());
	 pstat.setString(2, getSHA256(users.getPassword(), userSalt));
	 pstat.setString(3, users.getTelephone());
	 pstat.setString(4, users.getEmail());
	 pstat.setString(5, users.getName());
	 pstat.setString(6, users.getSex());
	 pstat.setString(7, DateUtil.getString(users.getBirthday()));
	 pstat.setString(8, userSalt);
	 pstat.executeUpdate();
	 return true;
	 
 }
 /**
	 * √‹¬ÎSHA256¥¶¿Ì
	 * 
	 * @param pass
	 * @param salt
	 * @return
	 */
	private String getSHA256(String pass, String salt) {
		return SHAUtil.getSHA256(pass + salt);
	
	 
 }
 }
 
