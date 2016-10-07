package com.greengrocer.freshmarket.domain;

import java.io.Serializable;

/**
 * 商品种类信息类
 */
public class CommodityType implements Serializable{ //实现序列化是因为设置了session钝化
	
	private int commodityTypeID;		//商品种类编号
	private String commodityTypeName;		//商品种类名称
	
	

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
