package com.freshmarket.web.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freshmarket.domain.User;
import com.freshmarket.service.UserException;
import com.freshmarket.service.UserService;
import com.freshmarket.utils.WebUtils;
import com.freshmarket.web.formbean.RegisterForm;

public class RegisterServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserService service = new UserService();
		//封装表单数据（封装到User对象中）
		User form = WebUtils.request2Bean(request, User.class);
		//封装表单数据（封装到RegisterForm对象中）
		RegisterForm registerForm = WebUtils.request2Bean(request, RegisterForm.class);
		
		
		
	
		// 对验证码进行校验
		String sessionVerifyCode = (String) request.getSession().getAttribute("session_vcode");
		String verifyCode = request.getParameter("verifyCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()) {
			registerForm.getErrors().put("verifyCode", "验证码不能为空!!");
		} else if(verifyCode.length() != 4) {
			registerForm.getErrors().put("verifyCode", "验证码长度必须为4!!");
		} else if(!verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
			registerForm.getErrors().put("verifyCode", "验证码错误!!");
		}
		
		//校验表单
		boolean b = registerForm.validate();	
		//如果校验失败，跳回到表单页面，回显校验失败信息
		if(!b){
			/*
			 * 1. 保存errors到request域
			 * 2. 保存form到request域，为了回显
			 * 3. 转发到regist.jsp
			 */
			request.setAttribute("errors", registerForm.getErrors());
			request.setAttribute("user", form);
			// 还要保存表单数据，到request域
			request.setAttribute("registerForm", registerForm);//用来在表单中回显！
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		
		

		//如果校验成功，则调用service处理注册请求
		try {
			//没有异常：输出注册成功！
			service.register(form);
			//如果service处理成功，就跳转到网站的全局消息显示页面，为用户注册成功的消息，3秒后跳转到登陆页面
			request.setAttribute("message", "恭喜你，注册成功!!浏览器将在3秒后跳转到首页，如果没有跳转请点击：<a href='"+request.getContextPath()+"/login.jsp'>登陆</a> <meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/login.jsp'>");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (UserException e) {
			//得到异常：获取异常信息，保存到request域，转发到regist.jsp中显示
			// 获取异常信息，保存到request域
			registerForm.getErrors().put("username", e.getMessage());
			request.setAttribute("errors", registerForm.getErrors());
			// 还要保存表单数据，到request域
			request.setAttribute("registerForm", registerForm);//用来在表单中回显！
			// 转发到regist.jsp
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}catch(Exception e){
			//如果service处理不成功，并且不成功的原因是其他问题的话，就跳到网站的全局消息显示页面，为用户显示友好错误消息
			request.setAttribute("message", "服务器出现未知错误!!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return ;
		}
		
		
	}

}
