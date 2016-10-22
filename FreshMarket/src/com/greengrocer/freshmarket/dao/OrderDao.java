package com.greengrocer.freshmarket.dao;

import java.util.List;

import com.greengrocer.freshmarket.domain.Order;
import com.greengrocer.freshmarket.domain.OrderItem;

public interface OrderDao {

	/**
	 * 添加订单
	 * @param order
	 */
	public void addOrder(Order order);
	
	/**
	 * 插入订单条目
	 * @param orderItemList
	 */
	public void addOrderItemList(List<OrderItem> orderItemList);
	
	
	/**
	 * 按用户id查询订单
	 * @param uid
	 * @return
	 */
	public List<Order> findByUid(String uid);
	
	
	/**
	 * 加载订单
	 * @param oid
	 * @return
	 */
	public Order load(String oid);
	
	
	/**
	 * 通过订单的id查询订单的状态
	 * @param oid
	 * @return
	 */
	public int getStateByOid(String oid);
	
	
	/**
	 * 修改订单的状态
	 * @param oid
	 * @param state
	 */
	public void updateState(String oid, int state);
	
	
	
	/**
	 * 查询所有的订单
	 * @return
	 */
	public List<Order> findAllOrder();
	
	
	/**
	 * 查询指定状态的订单
	 * @return
	 */
	public List<Order> findByState(int state);
	
	
	
	
}
