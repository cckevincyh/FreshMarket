package com.greengrocer.freshmarket.web.servlet.admin;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greengrocer.freshmarket.domain.CommodityType;
import com.greengrocer.freshmarket.service.CommodityTypeService;
import com.greengrocer.freshmarket.utils.WebUtils;
import com.greengrocer.freshmarket.web.servlet.BaseServlet;

public class AdminCommodityTypeServlet extends BaseServlet {

	private CommodityTypeService service = new CommodityTypeService();
	
	/**
	 * 得到所有的商品种类信息并以字符串返回
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAllCommodityType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String types = service.getAllCommodityType();
		response.getWriter().print(types);
	}
	
	/**
	 * 得到所有的商品种类信息
	 * @param request
	 * @param response
	 */
	public String getAllCommodityTypes(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("commodityTypes", service.getAllCommodityTypes());
		return "/adminjsps/admin/commodityType/list.jsp";
	}
	
	/**
	 * 添加商品种类信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String addCommodityType(HttpServletRequest request, HttpServletResponse response){
		//调用工具类，把上传的表单封装成一个bean对象
		CommodityType commodityType = WebUtils.request2Bean(request, CommodityType.class);
		CommodityType type = service.findCommodityTypeByName(commodityType.getCommodityTypeName());
		if(type==null){
			//添加商品信息实体
			service.addCommodityType(commodityType);
			//重定向到展示的列表（先查询所有的商品信息再重定向）
			return "r:/AdminCommodityTypeServlet?method=getAllCommodityTypes";	
		}else{
			request.setAttribute("message", "已存在该商品种类名称，添加失败!");
			return "/message.jsp";
		}
		
	}
	
	
	/**
	 * 获得商品种类信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String findCommodityType(HttpServletRequest request, HttpServletResponse response){
		String commodityTypeID = request.getParameter("commodityTypeID");
		//根据id查询
		CommodityType commodityType = service.findCommodityType(commodityTypeID);
		request.setAttribute("commodityType", commodityType);
		return "/adminjsps/admin/commodityType/mod.jsp";
	}

	/**
	 * 修改商品种类信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateCommodityType(HttpServletRequest request, HttpServletResponse response){
		//调用工具类，把上传的表单封装成一个bean对象
		CommodityType commodityType = WebUtils.request2Bean(request, CommodityType.class);
		//修改商品信息实体
		service.updateCommodityType(commodityType);
		return "r:/AdminCommodityTypeServlet?method=getAllCommodityTypes";
	}
	
	/**
	 * 删除商品种类信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteCommodityType(HttpServletRequest request, HttpServletResponse response){
		String commodityTypeID = request.getParameter("commodityTypeID");
		//删除商品信息实体
		service.deleteCommodityType(commodityTypeID);
		return "r:/AdminCommodityTypeServlet?method=getAllCommodityTypes";
	}
	
}
