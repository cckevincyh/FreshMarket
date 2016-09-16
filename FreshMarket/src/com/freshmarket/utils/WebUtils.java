package com.freshmarket.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	
	/**
	 * 把request域里的数据封装到bean对象中
	 * @param request 
	 * @param breanClass
	 * @return bean对象
	 */
	public static <T> T request2Bean(HttpServletRequest request,Class<T> breanClass){
		
		try{
			//1.创建要封装数据的bean
			T bean = breanClass.newInstance();
			//2.把request的数据整到bean中
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements()){
				String name = (String)e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
		
			return bean;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
}
