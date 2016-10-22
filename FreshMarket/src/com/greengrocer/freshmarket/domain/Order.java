package com.greengrocer.freshmarket.domain;

import java.util.Date;
import java.util.List;

/**
 * 	订单类
 *
 */
public class Order {

	private String ordersID;//订单id
	private Date orderTime;//下单时间
	private double total;	//合计
	private int state;	//订单的状态四种：1未付款 2已付款但未发货 3已发货但未确认收货 4已确认交易成功
	private User user;	//下单的用户
	private String address;	//收货地址
	private List<OrderItem> orderItemList;//当前订单下所有条目
	

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(String ordersID) {
		this.ordersID = ordersID;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTimel) {
		this.orderTime = orderTimel;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
