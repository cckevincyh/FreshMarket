package com.greengrocer.freshmarket.web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greengrocer.freshmarket.domain.Cart;
import com.greengrocer.freshmarket.domain.CartItem;
import com.greengrocer.freshmarket.domain.Commodity;
import com.greengrocer.freshmarket.service.CommodityService;

public class CartServlet extends BaseServlet {
	
	
	/**
	 * 添加购物条目
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1.得到购物车，如果购物车不存在则创建购物车
		//如果有购物车则得到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
	
		if(cart==null){
			//否则直接创建购物车,并且存入session域中
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		/*
		 * 2.购物时,提交的数据只有商品的id，
		 * 	然后根据提交的数据构造一个购物项
		 */
		String commodityID = request.getParameter("commodityID");	//获得商品id
		//构造商品
		Commodity commodity = new CommodityService().findCommodity(commodityID);	//根据商品id获得商品对象
		//构造出购物项
		CartItem cartItem = new CartItem();
		cartItem.setCommodity(commodity);
		cartItem.setCount(1);
		//3.把购物条目添加到购物车中
		cart.add(cartItem);
		//重定向到购物车页面,用转发出现刷新购买多次的情况
		return "r:/users/shoppingCart.jsp";
	}
	
	
	/**
	 * 清空购物条目
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//通过购物车调用清空购物车的方法
		if(cart!=null){
			cart.clear();
		}
		//重定向回到购物车页面
		return "r:/users/shoppingCart.jsp";
	}
	
	
	
	/**
	 * 删除购物条目
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		String id = request.getParameter("commodityID");//得到商品id
		if(cart!=null){
			//通过购物车的删除条目的方法删除指定id的购物项
			cart.delete(id);
		}
		//重定向到购物车页面
		return "r:/users/shoppingCart.jsp";
	}
	
	
	
	/**
	 * 修改购物车的数量
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String changeQuantity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到商品的id
		String id = request.getParameter("commodityID");
		//得到修改的数量
		String quantity = request.getParameter("quantity");
		
		//得到购物车
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart!=null){
			//修改购物车的数量
			cart.changeQuantity(id,Integer.parseInt(quantity));
		}
		//重定向到购物车页面
		return "r:/users/shoppingCart.jsp";
	}
	
	
	
	
	
	
}
