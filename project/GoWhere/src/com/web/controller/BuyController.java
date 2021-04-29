package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.domain.Route;
import com.web.domain.Users;
import com.web.service.FavoriteService;
import com.web.service.RouteService;

@WebServlet("/buy.do")
public class BuyController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("users")!=null) {
			
			int rid = Integer.parseInt(request.getParameter("rid"));
			
			RouteService routeservice = new RouteService();
			Route route = routeservice.findById(rid);
			
			// 3 Ò³Ãæµ¼º½
			request.setAttribute("order_route", route);
			
			request.getRequestDispatcher("/route_buy_confirm.jsp").forward(request, response);		
			
		}else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);		
	}
}

