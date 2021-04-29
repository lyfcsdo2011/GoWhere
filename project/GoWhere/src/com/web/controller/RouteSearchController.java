package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.domain.Route;
import com.web.service.RouteService;
import com.web.vo.PageVO;
import com.web.vo.SearchVO;

@WebServlet("/routesearch.do")
public class RouteSearchController extends HttpServlet{
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 接收请求获取请求参数
		// 多条件查询
		SearchVO searchVO = new SearchVO();
		if (request.getParameter("routeName") != null) {
			searchVO.setRouteName(request.getParameter("routeName"));
		}
		if (request.getParameter("minRoutePrice") != null && !"".equals(request.getParameter("minRoutePrice"))) {
			Float minRoutePrice = Float.parseFloat(request.getParameter("minRoutePrice"));
			searchVO.setMinRoutePrice(minRoutePrice);
		}
		if (request.getParameter("maxRoutePrice") != null && !"".equals(request.getParameter("maxRoutePrice"))) {
			Float maxRoutePrice = Float.parseFloat(request.getParameter("maxRoutePrice"));
			searchVO.setMaxRoutePrice(maxRoutePrice);
		}

		// 分页查询
		int recordOfPage = 20;
		int page = 1;//默认值为1 
		if (request.getParameter("page") != null && !"".equals(request.getParameter("page"))) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		// 2 调用业务逻辑
		RouteService routeService = new RouteService();
		PageVO<Route> pageVO = routeService.search(searchVO, page, recordOfPage);
		int beginPage = pageVO.getPage() - 4;
		int endPage = pageVO.getPage() + 5;
		beginPage = beginPage < 1 ? 1 : beginPage;
		endPage = endPage > pageVO.getPageCount() ? pageVO.getPageCount() : endPage;
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		// 3 页面导航
		request.setAttribute("pageVO", pageVO);
		request.setAttribute("routeList", pageVO.getList());// 将商品集合放到请求容器
		// 只要请求容器中有数据。就只能使用下面的跳转方式：转发。
		//??
		request.getRequestDispatcher("/favoriterank.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

