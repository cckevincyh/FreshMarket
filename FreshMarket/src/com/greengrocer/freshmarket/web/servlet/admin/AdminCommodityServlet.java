package com.greengrocer.freshmarket.web.servlet.admin;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greengrocer.freshmarket.domain.Commodity;
import com.greengrocer.freshmarket.domain.PageBean;
import com.greengrocer.freshmarket.service.CommodityService;
import com.greengrocer.freshmarket.utils.WebUtils;
import com.greengrocer.freshmarket.web.formbean.CommodityForm;
import com.greengrocer.freshmarket.web.servlet.BaseServlet;

public class AdminCommodityServlet extends BaseServlet {

	private CommodityService service = new CommodityService();
	
	/**
	 * 添加商品信息实体
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addCommodity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用工具类，把上传的表单封装成一个bean对象
		CommodityForm commodityForm = WebUtils.uploadForm2Bean(request, CommodityForm.class);
		Commodity commodity = service.findCommodityByName(commodityForm.getCommodityName());
		
		if(commodity!=null && commodity.getCommodityName()==null){
			//添加商品信息实体
			service.addCommodity(commodityForm);
			//重定向到展示的列表（先查询所有的商品信息再重定向）
			return "r:/AdminCommodityServlet?method=findAllCommodity";
		}else{
		
			request.setAttribute("message", "该商品名称存在，添加失败!");
			return "/message.jsp";
		}
	}
	
	/**
	 * 查询所有商品信息实体（分页查询）
	 * @param request
	 * @param response
	 * @return 
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllCommodity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得url
		String url = getUrl(request);
		//获取页面传递过来的当前页码数
		int pageCode = getPageCode(request);
		//给pageSize,每页的记录数赋值
		int pageSize = 10;
		//得到商品信息实体集合
		PageBean<Commodity> pb = service.findAllCommodity(pageCode,pageSize);
		//设置url
		pb.setUrl(url);
		//存入request域中
		request.setAttribute("pb", pb);
		//跳转到显示商品信息页面
		return "/adminjsps/admin/commodity/list.jsp";
		
	}
	
	/**
	 * 获取url信息
	 * @param request
	 * @return
	 */
	private String getUrl(HttpServletRequest request) {
		String url = request.getQueryString();
		 //url中有可能导游pageCode，需要把它截取掉
		int index = url.lastIndexOf("&pageCode=");
		if(index == -1) {
			return url;
		}
		return url.substring(0, index);
	}

	/**
	 * 获取当前页码数
	 * @param request
	 * @return
	 */
	private int getPageCode(HttpServletRequest request) {
		/*
		 * 1. 得到PageCode
		 *   如果PageCode参数不存在，说明PageCode=1
		 *   如果PageCode参数存在，需要转换成int类型即可
		 */
		String value = request.getParameter("pageCode");
		if(value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}

	/**
	 * 根据商品编号删除该商品信息实体
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String deleteCommodity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到删除的商品编号
		String commodityID = request.getParameter("commodityID");
		//进行删除操作
		service.deleteCommodity(commodityID);
		//重定向到展示的列表（先查询所有的商品信息再重定向）
		return "r:/AdminCommodityServlet?method=findAllCommodity";
	}
	
	
	
	/**
	 * 根据商品id查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findCommodity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到修改的商品编号
		String commodityID = request.getParameter("commodityID");
		//查询该商品信息
		Commodity commodity = service.findCommodity(commodityID);
		request.setAttribute("commodity", commodity);
		//转发到展示的列表
		return "/adminjsps/admin/commodity/showCommodity.jsp";
	}
	
	
	
	
	
	/**
	 * 根据商品编号查询该商品信息返回给修改页面
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到修改的商品编号
		String commodityID = request.getParameter("commodityID");
		//查询该商品信息
		Commodity commodity = service.findCommodity(commodityID);
		request.setAttribute("commodity", commodity);
		//转发向到修改的列表
		return "/adminjsps/admin/commodity/update.jsp";
	}
	
	
	
	/**
	 * 修改商品信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updateCommodity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//调用工具类，把上传的表单封装成一个bean对象
		CommodityForm commodityForm = WebUtils.uploadForm2Bean(request, CommodityForm.class);
		//修改商品信息实体
		service.updateCommodity(commodityForm);
		//重定向到展示的列表（先查询所有的商品信息再重定向）
		return "r:/AdminCommodityServlet?method=findAllCommodity";
	}
	
	
	
	/**
	 * 多条件查询商品信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String queryCommodity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得url
		String url = getUrl(request);
		//获取页面传递过来的当前页码数
		int pageCode = getPageCode(request);
		//给pageSize,每页的记录数赋值
		int pageSize = 10;
		//把提交的表单封装成一个bean对象
		CommodityForm commodityForm = WebUtils.request2Bean(request, CommodityForm.class);
		//得到商品信息实体集合
		PageBean<Commodity> pb = service.queryCommodity(pageCode,pageSize,commodityForm);
		//设置url
		pb.setUrl(url);
		//存入request域中
		request.setAttribute("pb", pb);
		//转发到修改的列表
		return "/adminjsps/admin/commodity/list.jsp";
	}
	
	

}