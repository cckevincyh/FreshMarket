package com.greengrocer.freshmarket.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.greengrocer.freshmarket.domain.User;
import com.greengrocer.freshmarket.exception.UserException;
import com.greengrocer.freshmarket.service.UserService;
import com.greengrocer.freshmarket.utils.WebUtils;
import com.greengrocer.freshmarket.web.formbean.RegisterForm;

public class UserServlet extends BaseServlet {

	/**
	 * 用户登陆
	 * @param request
	 * @param response
	 * @return 
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
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
			//response.sendRedirect(request.getContextPath() + "/index.jsp");
			return "r:/index.jsp";
			
		} catch (UserException e) {
			//如果抛出异常：获取异常信息，保存到request域，再保存form，转发到login.jsp
			request.setAttribute("errorMessage", e.getMessage());
			//存入数据，回显给login.jsp页面
			request.setAttribute("user", form);
			//跳转
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			return "/login.jsp";
		}
		
		
	}
	
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @return 
	 * @throws ServletException
	 * @throws IOException
	 */
	public String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
			//request.getRequestDispatcher("/register.jsp").forward(request, response);
			return "/register.jsp";
		}
		
		

		//如果校验成功，则调用service处理注册请求
		try {
			//没有异常：输出注册成功！
			service.register(form);
			//如果service处理成功，就跳转到网站的全局消息显示页面，为用户注册成功的消息，10秒后跳转到登陆页面
			//response.sendRedirect(request.getContextPath()+"/successRegister.jsp");
			return "r:/successRegister.jsp";
		} catch (UserException e) {
			//得到异常：获取异常信息，保存到request域，转发到regist.jsp中显示
			// 获取异常信息，保存到request域
			registerForm.getErrors().put("username", e.getMessage());
			request.setAttribute("errors", registerForm.getErrors());
			// 还要保存表单数据，到request域
			request.setAttribute("registerForm", registerForm);//用来在表单中回显！
			// 转发到regist.jsp
			//request.getRequestDispatcher("/register.jsp").forward(request, response);
			return "/register.jsp";
		}catch(Exception e){
			//如果service处理不成功，并且不成功的原因是其他问题的话，就跳到网站的全局消息显示页面，为用户显示友好错误消息
			//response.sendRedirect(request.getContextPath()+"/error/500.jsp");
			return "r:/error/500.jsp";
		}
		
		
	}
	
	
	/**
	 * 用户注销
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		//注销成功重定向到转到首页
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
		return "r:/index.jsp";
	}

	
	
	/**
	 * 完善个人信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String complementUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = WebUtils.request2Bean(request, User.class);
		//校验数据
		HashMap<String, String> errors = validate(user);
		if(errors.size()>0){
			//保存错误集合，回显
			request.setAttribute("errors", errors);
			//回显数据
			request.setAttribute("user", user);
			return "/users/message.jsp";
		}
		UserService service = new UserService();
		//完善信息
		service.complementUser(user);
		request.setAttribute("message", "修改成功!!");
		return "/index.jsp";
	}


	//校验数据
	private HashMap<String, String> validate(User user) {
		HashMap<String, String> errors = new HashMap<String, String>();
		if(user.getPhone()==null || user.getPhone().trim().equals("")){
			errors.put("phone", "手机号码不能为空!!");
		}else{
			//电话号码校验
			 Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");     
		     Matcher m = p.matcher(user.getPhone());   
		     if(!m.matches()){
		    	 errors.put("phone", "手机号码格式不正确!!");
		     }
		}
	     if(user.getEmail()==null || user.getEmail().trim().equals("")){
	    	 errors.put("email", "邮箱不能为空!!");
	     }else{
		     String str="^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		     Pattern p = Pattern.compile(str);     
		     Matcher m = p.matcher(user.getEmail()); 
		     if(!m.matches()){
		    	 errors.put("email", "邮箱格式不正确!!");
		     }
	     }
	     if(user.getAddress()==null || user.getAddress().trim().equals("")){
	    	 errors.put("address", "收货地址不能为空!!");
	     }
		return errors;
	}
	
	/**
	 * 查询用户详细信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		UserService service = new UserService();
		//查询用户详细信息
		User user = service.findUser(username);
		//存入request域中
		request.setAttribute("user", user);
		return "/users/message.jsp";
	}
	
	/**
	 * 修改收货地址
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String changeAddress(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = WebUtils.request2Bean(request, User.class);
		HashMap<String, String> errors = new HashMap<String, String>();
	     if(user.getAddress()==null || user.getAddress().trim().equals("")){
	    	 errors.put("address", "收货地址不能为空!!");
	     }
	     if(errors.size()>0){
			//保存错误集合，回显
			request.setAttribute("errors", errors);
			//回显数据
			request.setAttribute("user", user);
			return "/users/changeAddress.jsp";
		}
	     UserService service = new UserService();
	     //修改收货地址
	     service.changeAddress(user);
	     request.setAttribute("message", "修改成功!!");
		return "/users/cart_orderform.jsp";
	}

}
