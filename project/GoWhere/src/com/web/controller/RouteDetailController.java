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

@WebServlet("/routedetail.do")
public class RouteDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		FavoriteService favoriteService = new FavoriteService();
		RouteService routeService = new RouteService();
		Route route = routeService.findById(rid);
		boolean isFavorite = false;
		//从会话中获取当前登录用户的编号///////////待完成
		HttpSession session = request.getSession();
		if(session.getAttribute("users")!=null) {
			
			int uid = ((Users)session.getAttribute("users")).getUid();
			isFavorite= favoriteService.isFavorite(rid, uid);
			
		}
		request.setAttribute("isFavorite", isFavorite);
		request.setAttribute("route", route);
		request.getRequestDispatcher("/route_detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

