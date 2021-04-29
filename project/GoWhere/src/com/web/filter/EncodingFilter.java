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

@WebFilter("*.do")
public class EncodingFilter implements Filter {

    public EncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest=(HttpServletRequest) request;
		//统一处理中文
		//getMethod方法用来获取请求的提交方式
		if(httprequest.getMethod().equalsIgnoreCase("POST")) {
			
			request.setCharacterEncoding("UTF-8");//指定请求中的中文编码，针对Post请求
		}
		//放行
		
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
