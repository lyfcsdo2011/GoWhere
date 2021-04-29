package com.web.service;

import java.sql.SQLException;

import com.web.dao.OrderDAO;
import com.web.domain.Order;
import com.web.util.ConnUtil;

public class OrderService {
	private OrderDAO orderDAO = new OrderDAO();
	
	public void createOrder(Order order) {
		try {
			orderDAO.createOrder(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtil.closeConn();
		}
	}
	public void updateOrder(Order order, int status) {
		try {
			orderDAO.updateOrder(order,status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtil.closeConn();
		}
	}
	public void updateTime(Order order) {
		try {
			orderDAO.updateTime(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtil.closeConn();
		}
	}
	public void updatePayTime(Order order) {
		try {
			orderDAO.updatePayTime(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnUtil.closeConn();
		}
	}
}
