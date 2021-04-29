package com.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.domain.Order;
import com.web.service.OrderService;
import com.web.util.DateUtil;
import com.web.util.PayUtil;
import com.web.util.TradeGoodsDetail;
import com.web.util.TradePreCreateResp;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/users/Pay.do")
public class PayController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderService orderService = new OrderService();
		
		Order order = ((Order)request.getSession().getAttribute("order"));
		order.setStatus(20);
		orderService.updateOrder(order, 20);
		orderService.updateTime(order);
		String orderNo = PayUtil.genUUID();
		String orderSubject = request.getParameter("orderSubject");
		 Double totalAmount = 0.01;
		 String orderDesp = request.getParameter("orderSubject");;
		 String notifyURL = "http://localhost:9527/training-web/result.do";
		 
		 
		 List goodsList = new ArrayList<TradeGoodsDetail>();
		 TradeGoodsDetail goods = new TradeGoodsDetail();
		 goods.setAlipayGoodsId("200001");
		 goods.setGoodsName(request.getParameter("orderSubject"));
		 goods.setQuantity(1L);
		 goods.setPrice(2699.00);
		 
		 TradePreCreateResp resp = PayUtil.tradePrecreateRequest(orderNo, orderSubject, totalAmount, orderDesp, goodsList, notifyURL);
		 
		request.setAttribute("resp", resp);
		
		request.getRequestDispatcher("/route_buy_pay.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
