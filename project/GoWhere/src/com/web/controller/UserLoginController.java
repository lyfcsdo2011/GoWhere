package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.domain.Users;
import com.web.execption.NameException;
import com.web.execption.PassException;
import com.web.service.UserLoginService;





@WebServlet("/userlogin.do")
public class UserLoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 接收用户请求，获取请求数据
		HttpSession session = request.getSession();
		String strCode= (String) session.getAttribute("random-captcha");
				String userName = request.getParameter("username");
				String userPassword = request.getParameter("password");
				String randomCode = request.getParameter("randomCode");
				//2 调用业务逻辑
				UserLoginService UserLoginService = new UserLoginService();
				try {
					if(strCode.equalsIgnoreCase(randomCode)) {
						Users users = UserLoginService.isLogin(userName, userPassword);
					//将用户保存到会话
					session.setAttribute("users", users);
					//3 页面导航，登录成功重定向到
					
					response.sendRedirect(request.getContextPath()+"/index.do");
					}else {
						request.getRequestDispatcher("/login.jsp").forward(request, response);
					}
				} catch (NameException | PassException e) {
					e.printStackTrace();
					//3 页面导航，登录失败转发到adminloing.jsp
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
