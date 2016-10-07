package com.greengrocer.freshmarket.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greengrocer.freshmarket.domain.CommodityType;
import com.greengrocer.freshmarket.service.CommodityTypeService;


public class CommodityTypeServlet extends BaseServlet {

	private CommodityTypeService service = new CommodityTypeService();
	

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
	
	
	
}
