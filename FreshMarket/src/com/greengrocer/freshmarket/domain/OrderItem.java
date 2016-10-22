package com.greengrocer.freshmarket.domain;



/**
 * 订单项(订单条目)类
 *
 */
public class OrderItem {

	private String orderitemID;	//订单项id
	 private int count;	//数量
	 private double subtotal;//小计
	 private Order order;//所属订单
	 private Commodity commodity;//所要购买的商品
	 
	public String getOrderitemID() {
		return orderitemID;
	}
	public void setOrderitemID(String orderitemID) {
		this.orderitemID = orderitemID;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	 
	 
	 
}
