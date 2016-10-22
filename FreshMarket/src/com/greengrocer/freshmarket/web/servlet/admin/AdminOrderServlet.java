package com.greengrocer.freshmarket.web.servlet.admin;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greengrocer.freshmarket.domain.Order;
import com.greengrocer.freshmarket.exception.OrderException;
import com.greengrocer.freshmarket.service.OrderService;
import com.greengrocer.freshmarket.web.servlet.BaseServlet;

public class AdminOrderServlet extends BaseServlet {

	private OrderService orderService = new OrderService();
	
	/**
	 * 得到所有的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//查询所有的订单
		List<Order> orders = orderService.findAllOrder();
		//存入request域中，转发到订单列表界面
		request.setAttribute("orders", orders);
		return "/adminjsps/admin/order/list.jsp";
		
	}
	
	
	/**
	 * 查询指定状态的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByState(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//查询指定状态的订单
		//得到状态
		String state = request.getParameter("state");
		List<Order> orders = orderService.findByState(Integer.parseInt(state));
		//存入request域中，转发到订单列表界面
		request.setAttribute("orders", orders);
		return "/adminjsps/admin/order/list.jsp";
	}
	
	
	/**
	 * 发货
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delivery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//得到该订单的id
		String ordersID = request.getParameter("ordersID");
		try {
			orderService.delivery(ordersID);
			request.setAttribute("message", "恭喜，发货成功！");
		} catch (OrderException e) {
			request.setAttribute("message", e.getMessage());
		}
		return "/message.jsp";
	}
	
	
}
