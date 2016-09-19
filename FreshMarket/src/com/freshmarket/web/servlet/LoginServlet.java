package com.freshmarket.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.freshmarket.domain.User;
import com.freshmarket.exception.UserException;
import com.freshmarket.service.UserService;
import com.freshmarket.utils.WebUtils;

public class LoginServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserService service = new UserService();
	
		//封装表单数据到User form中
		User form = WebUtils.request2Bean(request, User.class);
		try {
			//调用service的login()方法，得到返回的User user对象。
			User user = service.login(form);
			//如果没有异常：保存返回值到session中，重定向到welcome.jsp
			request.getSession().setAttribute("sessionUser", user);
			//重定向到首页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			
		} catch (UserException e) {
			//如果抛出异常：获取异常信息，保存到request域，再保存form，转发到login.jsp
			request.setAttribute("errorMessage", e.getMessage());
			//存入数据，回显给login.jsp页面
			request.setAttribute("user", form);
			//跳转
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
	}

}
