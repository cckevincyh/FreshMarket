package com.greengrocer.freshmarket.web.formbean;

/**
 * 提交的商品信息表单类
 */
public class CommodityForm {
	private int commodityID;			//商品编号
	private int commodityTypeID;	//商品种类编号
	private String commodityName;			//商品名称
	private Double commodityPrice;			//商品价格
	private int commodityAmount;		//商品总数量
	private int commodityLeaveNum;		//商品剩余数量
	private String url;						//商品图片url
	

	public int getCommodityTypeID() {
		return commodityTypeID;
	}

	public void setCommodityTypeID(int commodityTypeID) {
		this.commodityTypeID = commodityTypeID;
	}

	public int getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}
	
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public Double getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	public int getCommodityAmount() {
		return commodityAmount;
	}
	public void setCommodityAmount(int commodityAmount) {
		this.commodityAmount = commodityAmount;
	}
	public int getCommodityLeaveNum() {
		return commodityLeaveNum;
	}
	public void setCommodityLeaveNum(int commodityLeaveNum) {
		this.commodityLeaveNum = commodityLeaveNum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Commodity [commodityID=" + commodityID + ", commodityTypeID="
				+ commodityTypeID + ", commodityName=" + commodityName
				+ ", commodityPrice=" + commodityPrice + ", commodityAmount="
				+ commodityAmount + ", commodityLeaveNum=" + commodityLeaveNum
				+ ", url=" + url + "]";
	}

}
