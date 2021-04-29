package com.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.domain.Order;
import com.web.service.OrderService;
import com.web.util.DateUtil;

/**
 * Servlet implementation class setStatus
 */
@WebServlet("/setStatus.do")
public class setStatus extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int status = Integer.parseInt(request.getParameter("status"));
		OrderService orderService = new OrderService();
		Order order = ((Order)request.getSession().getAttribute("order"));
		order.setStatus(status);
		orderService.updateOrder(order, status);
		if(status ==30) {
			orderService.updatePayTime(order);
			orderService.updateTime(order);
		}
		request.getRequestDispatcher("/route_buy_result.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
