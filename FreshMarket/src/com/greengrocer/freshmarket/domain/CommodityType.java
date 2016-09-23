package com.greengrocer.freshmarket.domain;

/**
 * 商品种类信息类
 */
public class CommodityType {
	
	@Override
	public String toString() {
		return "CommodityType [commodityTypeID=" + commodityTypeID
				+ ", commodityTypeName=" + commodityTypeName + ", typeUrl="
				+ typeUrl + "]";
	}
	private int commodityTypeID;		//商品种类编号
	private String commodityTypeName;		//商品种类名称
	private String typeUrl;	//商品种类图片
	
	

	public String getTypeUrl() {
		return typeUrl;
	}
	public void setTypeUrl(String typeUrl) {
		this.typeUrl = typeUrl;
	}
	public int getCommodityTypeID() {
		return commodityTypeID;
	}
	public void setCommodityTypeID(int commodityTypeID) {
		this.commodityTypeID = commodityTypeID;
	}
	public String getCommodityTypeName() {
		return commodityTypeName;
	}
	public void setCommodityTypeName(String commodityTypeName) {
		this.commodityTypeName = commodityTypeName;
	}
	
	

}
