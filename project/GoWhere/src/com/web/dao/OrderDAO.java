package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import com.web.domain.Order;
import com.web.util.ConnUtil;
import com.web.util.DateUtil;
import com.web.util.DateUtilToPay;

public class OrderDAO {

	public boolean createOrder(Order order) throws SQLException {
		String orderNumber = order.getOrderNumber();
		int num = order.getNum();
		int uid = order.getUid();
		int rid = order.getRid();
		double price = order.getPrice();
		double discount = order.getDiscount();
		double amount = order.getAmount();
		int status = order.getStatus();
		
		String sql = "insert into orders(order_number,num,uid,rid,price,discount,amount,"
				+ "status,create_date,update_date)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn =ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, orderNumber);
		pstat.setInt(2, num);
		pstat.setInt(3, uid);
		pstat.setInt(4, rid);
		pstat.setDouble(5, price);
		pstat.setDouble(6, discount);
		pstat.setDouble(7, amount);
		pstat.setInt(8, status);
		pstat.setString(9, DateUtilToPay.getString(order.getCreateDate()));
		pstat.setString(10, DateUtilToPay.getString(order.getUpdateDate()));
		
		pstat.executeUpdate();
		
		return true;
		
	}
	
	public boolean updateOrder(Order order,int status) throws SQLException {
		String orderNumber = order.getOrderNumber();
		
		String sql = "update orders set status=? where order_number='"+orderNumber+"'";
		Connection conn =ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, status);
		
		pstat.executeUpdate();
		
		return true;
		
	}
	
	public boolean updateTime(Order order) throws SQLException {
		String orderNumber = order.getOrderNumber();
		String date = DateUtilToPay.getString(new Date());
		
		String sql = "update orders set update_date='"+date+"' where order_number='"+orderNumber+"'";
		Connection conn =ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		
		pstat.executeUpdate();
		
		return true;
		
	}
	public boolean updatePayTime(Order order) throws SQLException {
		String orderNumber = order.getOrderNumber();
		String date = DateUtilToPay.getString(new Date());
		String sql = "update orders set pay_date='"+date+"' where order_number='"+orderNumber+"'";
		Connection conn =ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		
		pstat.executeUpdate();
		
		return true;
		
	}
}

