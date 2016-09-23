package com.greengrocer.freshmarket.web.formbean;

/**
 * 提交的订单信息表单类
 */
public class OrderFormForm {
	private int orderFormID;	//订单编号
	private int userID;				//用户编号
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

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
