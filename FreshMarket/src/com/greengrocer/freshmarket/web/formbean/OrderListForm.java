package com.greengrocer.freshmarket.web.formbean;

/**
 * 提交的订单列表表单类
 *
 */
public class OrderListForm {
	
	private int orderListId;	//订单列表编号
	private int commodityID;	//商品编号
	private int orderFormID;	//订单编号
	private int amount;			//商品数量
	
	public int getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(int orderListId) {
		this.orderListId = orderListId;
	}
	
	public int getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}
	public int getOrderFormID() {
		return orderFormID;
	}
	public void setOrderFormID(int orderFormID) {
		this.orderFormID = orderFormID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
