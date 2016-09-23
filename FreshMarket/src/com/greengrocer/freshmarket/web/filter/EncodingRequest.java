package com.greengrocer.freshmarket.web.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingRequest extends HttpServletRequestWrapper{

	private HttpServletRequest  req;
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.req = request;
	}
	
	@Override
	public String getParameter(String name) {
		String value = req.getParameter(name);
		// 处理编码问题
		try {
			value = new String (value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return value;
	}

}
