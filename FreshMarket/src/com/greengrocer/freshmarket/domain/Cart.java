package com.greengrocer.freshmarket.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车类
 *
 */
public class Cart implements Serializable{ //实现序列化是因为设置了session钝化

	//购物项集合
	//用商品的id做键，用购物项做值
	private Map<String,CartItem> map = new HashMap<String, CartItem>();

	
	/**
	 * 获得所有的购物车条目 
	 * @return 返回购物车条目的集合
	 */
	public Collection<CartItem> getCartItems(){
		return map.values();
	}

	/**
	 * 计算合计
	 *	合计=所有条目的小计之和
	 * @return 
	 */
	public double getTotal(){
		//解决二进制运算问题
		BigDecimal total = new BigDecimal("0");
		for (CartItem cartItem : map.values()) {
			//获取每个购物项的小计进行加和，计算出购物车的总价格
			BigDecimal subtotal = new BigDecimal(cartItem.getSubtotal()+"");
			total = total.add(subtotal);
		}
		return total.doubleValue();
	}
	
	
	
	/**
	 * 计算购物车所有条目总数量
	 * @return
	 */
	public int getTotalCount(){
		int count = 0;
		for (CartItem cartItem : map.values()) {
			count += cartItem.getCount();
		}
		return count;
	}
	
	
	/**
	 * 添加购物项条目到购物车中
	 * @param cartItem 新的购物条目
	 * 
	 */
	public void add(CartItem cartItem){
		//判断购物车的购物项是否有该商品，如果有进行购物项里数目累加，没有就新创建购物项
		//如果包含了购物项，则直接累加
		if(map.containsKey(cartItem.getCommodity().getCommodityID()+"")){
			//获得原来的已有的购物条目
			CartItem _cartItem = map.get(cartItem.getCommodity().getCommodityID()+"");
			//数量累加上新的购物项的条目
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
			map.put(cartItem.getCommodity().getCommodityID()+"", _cartItem);
		}else{
			//否则直接添加新的购物项
			map.put(cartItem.getCommodity().getCommodityID()+"", cartItem);
		}
		
	}
	
	
	/**
	 * 清空所有的条目
	 */
	public void clear(){
		map.clear();
	}
	
	
	
	/**
	 * 删除指定条目
	 * @param bid
	 */
	public void delete(String bid){
		map.remove(bid);
	}

	
	/**
	 * 修改购物项条目的数量
	 * @param id
	 * @param parseInt2
	 */
	public void changeQuantity(String id, int count) {
		//得到购物项
		CartItem cartItem = map.get(id);
		if(cartItem!=null){
			cartItem.setCount(count);			
		}

	}
	
	
}
