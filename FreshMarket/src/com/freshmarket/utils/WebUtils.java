package com.freshmarket.utils;

import java.io.File;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
	
	
	/**
	 * 产生全球唯一的id
	 * @return 全球唯一的id
	 */
	public static String generateID(){
		return UUID.randomUUID().toString();
	}
		
	
	
	/**
	 * 把上传的表单文件封装成一个bean对象,并保存上传文件
	 * 只支持一个文件上传
	 * 上传文件的bean的属性为url(需要设置bean的属性名称为url)
	 * url的路径为WEB-INF/files/uuid+上传文件名.
	 * @param request
	 * @param breanClass
	 * @return bean对象
	 */
	public static <T> T uploadForm2Bean(HttpServletRequest request,Class<T> breanClass){
			//得到工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//通过工厂创建解析器
			ServletFileUpload sfu = new ServletFileUpload(factory);
			try{
				//1.创建要封装数据的bean
				T bean = breanClass.newInstance();
				//解析request，得到FileItem集合
				List<FileItem> fileItemList = sfu.parseRequest(request);
				for (FileItem fileItem : fileItemList) {
					if(fileItem.getContentType()==null){
						//为普通表单
						BeanUtils.setProperty(bean, fileItem.getFieldName(), fileItem.getString("UTF-8"));
					}else{
						//为文件表单
						String root = request.getServletContext().getRealPath("/commodity/imags/");
						//截取字符串
				        String filename = fileItem.getName();
				    	int index = filename.lastIndexOf("\\");
				    	if(index != -1) {
				    	    filename = filename.substring(index+1);
				    	}
				    	
				    	//给文件名称添加uuid前缀，处理文件同名问题			
						String savename = generateID() + "_" + filename;
						
						//创建目录链
						File dirFile = new File(root);
						System.out.println(dirFile.mkdirs());
						
						//保存文件
						File destFile = new File(dirFile,savename);
						
						//调用其API完成文件的保存
						fileItem.write(destFile);
						BeanUtils.setProperty(bean,"url", request.getContextPath()+"/commodity/imags/"+savename);
					}
				}
				return bean;
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			
		}
		
		
	
}
