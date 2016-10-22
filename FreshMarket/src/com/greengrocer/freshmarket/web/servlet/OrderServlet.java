package com.greengrocer.freshmarket.web.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greengrocer.freshmarket.domain.Cart;
import com.greengrocer.freshmarket.domain.CartItem;
import com.greengrocer.freshmarket.domain.Order;
import com.greengrocer.freshmarket.domain.OrderItem;
import com.greengrocer.freshmarket.domain.User;
import com.greengrocer.freshmarket.exception.OrderException;
import com.greengrocer.freshmarket.service.OrderService;
import com.greengrocer.freshmarket.utils.WebUtils;

public class OrderServlet extends BaseServlet {
	OrderService orderService = new OrderService();
	
	
	/**
	 * 添加订单，把session中的车用来生成Order对象
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从session中得到车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//把购物车cart对象转换成Order对象
		//创建order对象，并设置其属性
		Order order = new Order();
		order.setOrdersID(WebUtils.generateID());//产生全球唯一的id,作为订单id
		order.setOrderTime(new Date());//设置当前时间
		order.setState(1);//// 设置订单状态为1，表示未付款
		User user = (User) request.getSession().getAttribute("sessionUser");
		order.setUser(user);// 设置订单所有者
		order.setTotal(cart.getTotal());// 设置订单的合计，从cart中获取合计
		order.setAddress(user.getAddress());//设置地址
		
		//创建订单项(订单条目)的集合
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		//循环遍历Cart中所有的CartItem，使用每一个CartItem对象创建OrderItem对象，并添加到集合中
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem item = new OrderItem();
			item.setOrderitemID(WebUtils.generateID());// 设置条目的id
			item.setCount(cartItem.getCount());// 设置条目的数量
			item.setCommodity(cartItem.getCommodity());// 设置条目的商品
			item.setSubtotal(cartItem.getSubtotal());// 设置条目的小计
			item.setOrder(order);// 设置所属订单
			orderItems.add(item);// 把订单条目添加到集合中
		}
		//把所有订单的条目添加到订单中
		order.setOrderItemList(orderItems);
		
		//清空购物车
		cart.clear();
		
		//调用orderService添加订单
		orderService.add(order);
		//保存order到request域中，转发到....
		request.setAttribute("order", order);
		return "/users/pay.jsp";
	}

	
	
	
	/**
	 * 查询我的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myOrders(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//从session中得到当前用户，获取其id值
		User user = (User) request.getSession().getAttribute("sessionUser");
		//根据用户id查找其所有订单
		if(user!=null){
			List<Order> orders = orderService.myOrders(user.getUserID()+"");
			request.setAttribute("orders", orders);
		}
		return "/users/orderlist.jsp";
	}
	
	
	/**
	 * 加载指定订单id的订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到订单id
		String ordersID = request.getParameter("ordersID");
		//得到订单
		Order order = orderService.load(ordersID);
		//保存到request域中并转发
		request.setAttribute("order", order);
		return "/users/pay.jsp";
	}
	
	/**
	 * 确认收货
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String confirm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//得到该订单的id
		String ordersID = request.getParameter("ordersID");
		try {
			orderService.comfirm(ordersID);
			request.setAttribute("msg", "恭喜，交易成功！");
		} catch (OrderException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "/OrderServlet?method=myOrders";
	}
	
	/**
	 * 支付
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String pay(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//得到该订单的id
		String ordersID = request.getParameter("ordersID");
	
		try {
			orderService.pay(ordersID);
			request.setAttribute("message", "恭喜，支付成功！");
		} catch (OrderException e) {
			request.setAttribute("message", e.getMessage());
		}
		return "/index.jsp";
	}
	
	
}
