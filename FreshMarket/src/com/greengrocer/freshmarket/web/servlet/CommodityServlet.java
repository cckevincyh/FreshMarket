package com.greengrocer.freshmarket.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.greengrocer.freshmarket.domain.Commodity;
import com.greengrocer.freshmarket.domain.CommodityType;
import com.greengrocer.freshmarket.service.CommodityService;
import com.greengrocer.freshmarket.utils.ServiceUtils;
import com.greengrocer.freshmarket.utils.WebUtils;
import com.greengrocer.freshmarket.web.formbean.CommodityForm;

public class CommodityServlet extends BaseServlet {

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
		CommodityForm commodityForm = WebUtils.uploadForm2Bean(request, CommodityForm.class,"commodity","url");
		//添加商品信息实体
		service.addCommodity(commodityForm);
		//重定向到展示的列表（先查询所有的商品信息再重定向）
		return "r:/CommodityServlet?method=findAllCommodity";
		
	}
	
	/**
	 * 查询所有商品信息实体
	 * @param request
	 * @param response
	 * @return 
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllCommodity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到商品信息实体集合
		List<Commodity> commodities = service.findAllCommodity();
		//存入request域中
		request.setAttribute("commodities", commodities);
		//跳转到显示商品信息页面
		return "/adminjsps/admin/commodity/list.jsp";
		
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
		return "r:/CommodityServlet?method=findAllCommodity";
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
		//重定向到展示的列表（先查询所有的商品信息再重定向）
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
		//重定向到修改的列表（先查询所有的商品信息再重定向）
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
		CommodityForm commodityForm = WebUtils.uploadForm2Bean(request, CommodityForm.class,"commodity","url");
		//修改商品信息实体
		service.updateCommodity(commodityForm);
		//重定向到展示的列表（先查询所有的商品信息再重定向）
		return "r:/CommodityServlet?method=findAllCommodity";
	}
	
	
	

}
