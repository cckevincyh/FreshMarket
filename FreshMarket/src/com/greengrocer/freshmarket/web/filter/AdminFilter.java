package com.greengrocer.freshmarket.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greengrocer.freshmarket.domain.Admin;
import com.greengrocer.freshmarket.domain.User;

public class AdminFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//根据session中的用户对象的Type属性来判断是否为管理员
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpSession session = req.getSession();
		//从session中获取用户对象
		Object obj =  session.getAttribute("sessionUser");
		if(obj!=null && obj instanceof Admin){
			//用户为管理员,放行
			chain.doFilter(request, response);
			
		}else{
			//不是管理员,跳转到login.jsp页面
			req.setAttribute("message", "您不是管理员!!");
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
