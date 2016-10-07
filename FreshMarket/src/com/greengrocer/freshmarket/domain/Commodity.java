package com.greengrocer.freshmarket.domain;

import java.io.Serializable;
/**
 * 商品信息类
 *
 */
public class Commodity implements Serializable{ //实现序列化是因为设置了session钝化
	private int commodityID;			//商品编号
	private CommodityType commodityType;	//商品种类
	private String commodityName;			//商品名称
	private Double commodityPrice;			//商品价格
	private String url;						//商品图片url
	

	public CommodityType getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(CommodityType commodityType) {
		this.commodityType = commodityType;
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

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	

	
	
}
