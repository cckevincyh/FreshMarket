package com.greengrocer.freshmarket.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 购物车条目类 
 *
 */
public class CartItem implements Serializable{ //实现序列化是因为设置了session钝化

	private Commodity commodity;	//商品
	private int count;	//数目
	
	/**
	 * 计算一个购物项的条目价格之和
	 * 小计分法
	 * 处理二进制运算的误差问题
	 * @return
	 */
	public double getSubtotal() {
		//获得商品的价格
		BigDecimal bd1 = new BigDecimal(commodity.getCommodityPrice()+"");	
		//获得购买的数量
		BigDecimal bd2 = new BigDecimal(count+"");
		//进行乘积运算获得小计
		return bd1.multiply(bd2).doubleValue();
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	} 
	
	
	

}
