package com.greengrocer.freshmarket.domain;

/**
 *  订单列表类
 *
 */
public class OrderList {
	
	private int orderListId;	//订单列表编号
	private Commodity commodity;	//商品信息
	private OrderForm orderForm;	//订单信息
	private int amount;			//商品数量
	
	public int getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(int orderListId) {
		this.orderListId = orderListId;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public OrderForm getOrderForm() {
		return orderForm;
	}
	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
