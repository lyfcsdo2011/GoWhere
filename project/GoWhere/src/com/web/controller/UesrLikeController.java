package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.domain.Users;
import com.web.service.myFavService;
import com.web.vo.PageVO;


@WebServlet("/users/myfavorite.do")

public class UesrLikeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		myFavService myfavService = new myFavService();
		HttpSession session = request.getSession();
		Integer sesUid = ((Users) session.getAttribute("users")).getUid();

		// ��ҳ��ѯ
		int recordOfPage = 8;
		int page = 1;// Ĭ��ֵΪ1
		if (request.getParameter("page") != null && !"".equals(request.getParameter("page"))) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		// 2 ����ҵ���߼�
		PageVO myFavPageVO = myfavService.select(sesUid, page, recordOfPage);
		int beginPage = myFavPageVO.getPage() - 4;
		int endPage = myFavPageVO.getPage() + 5;
		beginPage = beginPage < 1 ? 1 : beginPage;
		endPage = endPage > myFavPageVO.getPageCount() ? myFavPageVO.getPageCount() : endPage;
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		// 3 ҳ�浼��
		request.setAttribute("myFavPageVO", myFavPageVO);
		request.setAttribute("routeList", myFavPageVO.getList());
		// ֻҪ���������������ݡ���ֻ��ʹ���������ת��ʽ��ת����
		request.getRequestDispatcher("/myfavorite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
