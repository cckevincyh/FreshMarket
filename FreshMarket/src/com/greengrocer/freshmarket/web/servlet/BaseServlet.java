package com.greengrocer.freshmarket.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 获取参数，用来识别用户想请求的方法
		 * 2. 然后判断是否哪一个方法，是哪一个我们就调用哪一个
		 */
		String methodName = req.getParameter("method");
		
		if(methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("您没有传递method参数！无法确定您想要调用的方法！");
		}
		
		/*
		 * 得到方法名称，是否可通过反射来调用方法？
		 * 1. 得到方法名，通过方法名再得到Method类的对象！
		 *   * 需要得到Class，然后调用它的方法进行查询！得到Method
		 *   * 我们要查询的是当前类的方法，所以我们需要得到当前类的Class
		 */
		Class c = this.getClass();//得到当前类的class对象
		Method method = null;
		try {
			method = c.getMethod(methodName, 
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您要调用的方法：" + methodName + "(HttpServletRequest,HttpServletResponse)，它不存在！");
		}
		
		/*
		 * 调用method表示的方法
		 */
		try {
			String result = (String)method.invoke(this, req, resp);
			/*
			 * 获取请求处理方法执行后返回的字符串，它表示转发或重定向的路径！
			 * 帮它完成转发或重定向！
			 */
			/*
			 * 如果用户返回的是字符串为null，或为""，那么我们什么也不做！
			 */
			if(result == null || result.trim().isEmpty()) {
				return;
			}
			/*
			 * 查看返回的字符串中是否包含冒号，如果没有，表示转发
			 * 如果有，使用冒号分割字符串，得到前缀和后缀！
			 * 其中前缀如果是f，表示转发，如果是r表示重定向，后缀就是要转发或重定向的路径了！
			 */
			if(result.contains(":")) {
				// 使用冒号分割字符串，得到前缀和后缀
				int index = result.indexOf(":");//获取冒号的位置
				String s = result.substring(0, index);//截取出前缀，表示操作
				String path = result.substring(index+1);//截取出后缀，表示路径
				if(s.equalsIgnoreCase("r")) {//如果前缀是r，那么重定向！
					resp.sendRedirect(req.getContextPath() + path);
				} else if(s.equalsIgnoreCase("f")) {
					req.getRequestDispatcher(path).forward(req, resp);
				} else {
					throw new RuntimeException("你指定的操作：" + s + "，当前版本还不支持！");
				}
			} else {//没有冒号，默认为转发！
				req.getRequestDispatcher(result).forward(req, resp);
			}
		} catch (Exception e) {
			System.out.println("您调用的方法：" + methodName + ",　它内部抛出了异常！");
			throw new RuntimeException(e);
		}
	}
}
