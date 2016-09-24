package com.greengrocer.freshmarket.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import sun.misc.BASE64Encoder;

public class ServiceUtils {

	/**
	 * md5加密
	 * @param message 输入的数据
	 * @return 加密后的数据
	 */
	public static String md5(String message){
		try{
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());
			
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}
	
	

	/**
	 * 把map转换成对象
	 * @param map
	 * @param clazz
	 * @return
	 * 
	 * 把Map转换成指定类型
	 */
	public static <T> T toBean(Map map, Class<T> clazz) {
		try {
			/*
			 * 1. 通过参数clazz创建实例
			 * 2. 使用BeanUtils.populate把map的数据封闭到bean中
			 */
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtils.populate(bean, map);
			return bean;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
