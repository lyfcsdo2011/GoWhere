package com.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.domain.Route;
import com.web.service.RouteService;

@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RouteService routeService = new RouteService();
		
        List<Route> PopuList = routeService.findPopularity();
		
        request.setAttribute("PopuList", PopuList);//人气线程查询
        
        List<Route> zuixin = routeService.findzuixin();
		
        request.setAttribute("zuixin", zuixin);//最新线程查询
        
		List<Route> guowai = routeService.findguowai();
		
        request.setAttribute("guowai", guowai);//国外线程查询
		
        List<Route> guonei = routeService.findguonei();
		
        request.setAttribute("guonei", guonei);//国内线程查询
        
		request.getRequestDispatcher("/index.jsp").forward(request, response);//转发到index.jsp页面
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
