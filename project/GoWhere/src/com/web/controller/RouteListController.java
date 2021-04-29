package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.domain.Route;
import com.web.service.RouteService;
import com.web.vo.PageVO1;
import com.web.vo.SearchVO1;


@WebServlet("/routelist.do")
public class RouteListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//�����������
		SearchVO1 searchVO1=new SearchVO1();
		
		if (request.getParameter("rname") != null) {
			   searchVO1.setRname(request.getParameter("rname"));
			  }
		 //��ҳ��ѯ
		  int page = 1;//Ĭ��Ϊ1
		  if(request.getParameter("page")!=null && !"".contentEquals(request.getParameter("page"))) {
			  page=Integer.parseInt(request.getParameter("page"));
		  }
		  int recordOfPage=7;
		  // 2 ����ҵ���߼�
		  RouteService routeService = new RouteService();
		  
		  PageVO1<Route> pageVO = routeService.search(searchVO1, page, recordOfPage);
		  // 3 ҳ�浼��
	
		  request.setAttribute("RouteList", pageVO.getList());//����Ʒ���Ϸŵ���������
		 
	
		  
		  //������ҳʹ�õı���
		  int beginPage=pageVO.getPage()-4;
		  int engPage=pageVO.getPage()+5;
		  beginPage=beginPage<1?1:beginPage;
		  engPage=engPage>pageVO.getPageCount()?pageVO.getPageCount():engPage;
		  
		  request.setAttribute("beginPage",beginPage);
		  request.setAttribute("engPage",engPage);
		  request.setAttribute("pageVO", pageVO);
		  //ֻҪ���������������ݡ���ֻ��ʹ���������ת��ʽ��ת����
		  request.getRequestDispatcher("/route_list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
