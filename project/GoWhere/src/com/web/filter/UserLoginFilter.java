package com.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter("/users/*")
public class UserLoginFilter implements Filter {

    public UserLoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest=(HttpServletRequest) request;
		HttpServletResponse httpresponse=(HttpServletResponse) response;
		//��¼״̬�ж������ǻỰ����û�й���Ա����
		HttpSession session=((HttpServletRequest)request).getSession();
		if(session.getAttribute("users")==null) {
			httpresponse.sendRedirect(httprequest.getContextPath()+"/login.jsp");
	
		}else {
		
		chain.doFilter(request, response);//����
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
