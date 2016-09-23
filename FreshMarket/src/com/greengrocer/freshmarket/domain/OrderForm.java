package com.greengrocer.freshmarket.domain;

/**
 * 订单信息类
 */
public class OrderForm {
	private int orderFormID;	//订单编号
	private User user;				//用户信息
	private String orderFormNo;		//订单序号
	private Double totalPrice;		//总金额
	private int isPayoff;		//买家是否付款
	private int isConsignment;	//是否发货
	
	public int getOrderFormID() {
		return orderFormID;
	}
	public void setOrderFormID(int orderFormID) {
		this.orderFormID = orderFormID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOrderFormNo() {
		return orderFormNo;
	}
	public void setOrderFormNo(String orderFormNo) {
		this.orderFormNo = orderFormNo;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsPayoff() {
		return isPayoff;
	}
	public void setIsPayoff(int isPayoff) {
		this.isPayoff = isPayoff;
	}
	public int getIsConsignment() {
		return isConsignment;
	}
	public void setIsConsignment(int isConsignment) {
		this.isConsignment = isConsignment;
	}
	
	
}
