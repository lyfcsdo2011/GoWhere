package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.UserService;



@WebServlet("/exist.do")
public class UserExistsController extends HttpServlet {
	private UserService userService=new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		try {
			boolean exists = userService.isExistsUsers(username);
			PrintWriter out = response.getWriter();

			//Gson g = new Gson();	
			if (exists) {
				out.print(1);	
			} else {
				out.print(0);
			}

		} catch (Exception ex) {
			// Ìø×ª´íÎóÒ³Ãæ
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
