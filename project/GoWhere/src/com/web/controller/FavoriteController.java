package com.web.controller;
/////////////////////��ӻ�ȡ���ղ�
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.domain.Users;
import com.web.service.FavoriteService;

@WebServlet("/favorite.do")
public class FavoriteController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 ���������ȡ�������
		int rid = Integer.parseInt(request.getParameter("rid"));
		boolean isFavorite;
		//�ӻỰ�л�ȡ��ǰ��¼�û��ı��///////////�����
		HttpSession session = request.getSession();
		request.setAttribute("rid", rid);
		if(session.getAttribute("users")!=null) {
			
			int uid = ((Users)session.getAttribute("users")).getUid();
			// 2 ����ҵ���߼�
			FavoriteService favoriteservice = new FavoriteService();
			isFavorite = favoriteservice.isFavorite(rid,uid);
			if(isFavorite){
				favoriteservice.delFavorite(rid,uid);
			}
			else{
				favoriteservice.addFavorite(rid,uid);
			}
			
			// 3 ҳ�浼��
			request.getRequestDispatcher("/routedetail.do?rid="+rid).forward(request, response);
			
			
		}else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}
}		