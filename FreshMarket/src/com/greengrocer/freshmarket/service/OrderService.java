package com.greengrocer.freshmarket.service;

import java.sql.SQLException;
import java.util.List;

import com.greengrocer.freshmarket.dao.JdbcUtils;
import com.greengrocer.freshmarket.dao.OrderDao;
import com.greengrocer.freshmarket.dao.factory.DaoFactory;
import com.greengrocer.freshmarket.domain.Order;
import com.greengrocer.freshmarket.exception.OrderException;

public class OrderService {

	OrderDao orderDao = DaoFactory.getOrderDao();
	
	/**
	 * 添加订单
	 * 需要处理事务
	 * @param order
	 */
	public void add(Order order){
		try {
			//开启事务
			JdbcUtils.beginTransaction();
			orderDao.addOrder(order);//插入订单
			orderDao.addOrderItemList(order.getOrderItemList());//插入订单项(订单条目)
			//提交事务
			JdbcUtils.commitTransaction();
			
		} catch (Exception e) {
			//回滚事务
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
		}
	}
	
	
	/**
	 * 查询我的订单
	 * @param userid
	 * @return
	 */
	public List<Order> myOrders(String userid){
		return orderDao.findByUid(userid);
	}
	
	
	
	
	/**
	 * 加载订单
	 * @param orderid
	 * @return
	 */
	public Order load(String orderid){
		return orderDao.load(orderid);
	}
	
	
	/**
	 * 确认订单
	 * @param oid
	 * @throws OrderException
	 */
	public void comfirm(String oid) throws OrderException{
		//校验订单状态，如果不是3，抛出异常
		int state = orderDao.getStateByOid(oid);//获取订单状态
		if(state != 3) {
			throw new OrderException("订单确认失败！");
		}
		//订单的状态四种：1未付款 2已付款但未发货 3已发货但未确认收货 4已确认交易成功
		//修改订单状态为4，表示交易成功
		orderDao.updateState(oid, 4);
	}
	
	
	/**
	 * 支付
	 * @param oid
	 * @throws OrderException
	 */
	public void pay(String oid) throws OrderException{
		/*
		 * 1. 获取订单的状态
		 *   * 如果状态为1，那么执行下面代码
		 *   * 如果状态不为1，那么本方法什么都不做
		 */
		int state = orderDao.getStateByOid(oid);//获取订单状态
		if(state == 1) {
			// 修改订单状态为2
			orderDao.updateState(oid, 2);
		}
	}
	
	/**
	 * 发货
	 * @param oid
	 * @throws OrderException
	 */
	public void delivery(String oid) throws OrderException{
		/*
		 * 1. 获取订单的状态
		 *   * 如果状态为2，那么执行下面代码
		 *   * 如果状态不为2，那么本方法什么都不做
		 */
		int state = orderDao.getStateByOid(oid);//获取订单状态
		if(state == 2) {
			// 修改订单状态为2
			orderDao.updateState(oid, 3);
		}
	}
	
	
	
	/**
	 * 查询所有的订单
	 * @return
	 */
	public List<Order> findAllOrder(){
		return orderDao.findAllOrder();
	}
	
	
	/**
	 * 查询指定状态的订单
	 * @param state
	 * @return
	 */
	public List<Order> findByState(int state){
		return orderDao.findByState(state);
	}
	
	
	
}
