package com.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.domain.Order;
import com.web.domain.Route;
import com.web.domain.Users;
import com.web.service.OrderService;
import com.web.service.RouteService;
import com.web.util.DateUtil;
import com.web.util.DateUtilToPay;
import com.web.util.PayUtil;
@WebServlet("/users/CreateOrder.do")
public class CreateOrder extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RouteService routeService = new RouteService();
		Route route = routeService.findById(Integer.parseInt(request.getParameter("rid")));
		
		HttpSession session = request.getSession();
		OrderService orderService = new OrderService();
		Order order = new Order();
		order.setOrderNumber(PayUtil.genUUID());
		order.setAmount(Double.parseDouble(request.getParameter("amount")));
		order.setPrice(Double.parseDouble(request.getParameter("price")));
		order.setNum(Integer.parseInt(request.getParameter("num")));
		order.setDiscount(Double.parseDouble(request.getParameter("discount")));
		order.setUid(((Users)session.getAttribute("users")).getUid());
		order.setRid(route.getRid());
		order.setStatus(10);
		try {
			Date date = DateUtilToPay.getDate(DateUtilToPay.getString(new Date()));
			order.setCreateDate(date);
			order.setUpdateDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orderService.createOrder(order);
		
		session.setAttribute("order", order);
		session.setAttribute("buyRoute", route);
		
		
		request.getRequestDispatcher("/route_buy_choose.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
