package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.domain.Users;
import com.web.service.UserService;
import com.web.util.DateUtil;





@WebServlet("/register.do")
public class RegisterController extends HttpServlet {
	private UserService userService=new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String telephone=request.getParameter("telephone");
			String email=request.getParameter("email");
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			String birthday=request.getParameter("birthday");
			String check = request.getParameter("check");
			HttpSession session = request.getSession();
			String strCode= (String) session.getAttribute("random-captcha");
			
			if(username!=null&&!userService.isExistsUsers(username).equals(username)) {
				
				if(strCode.equalsIgnoreCase(check)) {
					Users users=new Users();
					users.setUsername(username);
					users.setPassword(password);
					users.setTelephone(telephone);
					users.setEmail(email);
					users.setName(name);
					users.setSex(sex);
					users.setBirthday(DateUtil.getDate(birthday));						
					
					userService.register(users);
					response.sendRedirect(request.getContextPath()+"/login.jsp");
					
					
				}else {
					System.out.println("验证码错误");
					request.getRequestDispatcher("/register.jsp").forward(request, response);
				}
				
			}else {
				System.out.println("用户名已存在");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}

		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
