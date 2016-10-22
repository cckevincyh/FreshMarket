package com.greengrocer.freshmarket.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.greengrocer.freshmarket.dao.OrderDao;
import com.greengrocer.freshmarket.dao.TxQueryRunner;
import com.greengrocer.freshmarket.domain.Commodity;
import com.greengrocer.freshmarket.domain.CommodityType;
import com.greengrocer.freshmarket.domain.Order;
import com.greengrocer.freshmarket.domain.OrderItem;
import com.greengrocer.freshmarket.utils.ServiceUtils;
import com.greengrocer.freshmarket.utils.WebUtils;

public class OrderDaoImpl implements OrderDao{

	private QueryRunner qr = new TxQueryRunner();
	
	/**
	 * 添加订单
	 */
	@Override
	public void addOrder(Order order) {
		try {
			String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?)";
			//处理util的Date转换成sql的Timestamp
			Timestamp timestamp = new Timestamp(order.getOrderTime().getTime());
			Object[] params = {order.getOrdersID(),order.getOrderTime(),order.getTotal(),
					order.getState(),order.getUser().getUserID(),order.getAddress()};
			qr.update(sql,params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 插入订单条目
	 */
	@Override
	public void addOrderItemList(List<OrderItem> orderItemList) {
		//一次性插入多个条目
		/**
		 * QueryRunner类的batch(String sql, Object[][] params)
		 * 其中params是多个一维数组！
		 * 每个一维数组都与sql在一起执行一次，多个一维数组就执行多次
		 */
		try {
			String sql = "INSERT INTO orderitem VALUES(?,?,?,?,?)";
			/*
			 * 把orderItemList转换成两维数组
			 *   把一个OrderItem对象转换成一个一维数组
			 */
			Object[][] params = new Object[orderItemList.size()][];
			// 循环遍历orderItemList，使用每个orderItem对象为params中每个一维数组赋值
			for(int i = 0; i<orderItemList.size(); i++){
				OrderItem item = orderItemList.get(i);
				params[i] = new Object[]{item.getOrderitemID(),item.getCount(),item.getSubtotal(),
						item.getOrder().getOrdersID(),item.getCommodity().getCommodityID()};
				
			}
			qr.batch(sql, params);//执行批处理，一次插入多条订单条目
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 按用户id查询订单
	 */
	@Override
	public List<Order> findByUid(String uid) {
		/*
		 * 1. 通过uid查询出当前用户的所有List<Order>
		 * 2. 循环遍历每个Order，为其加载他的所有OrderItem
		 */
		try {
			//查询用户下所有的订单
			String sql = "SELECT * FROM orders WHERE userID=?";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
			//循环遍历其中的每一个Order，为其加载它自己所有的订单项(订单条目)
			for (Order order : orderList) {
				//为order对象添加它的所有订单条目
				loadOrderItems(order);
			}
			//返回订单列表
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	
	
	/**
	 * 加载指定的订单的所有的订单项(订单条目)
	 * @param order
	 */
	private void loadOrderItems(Order order) {
		try {
			//需要查询三张表(orderitem 和 commodity,commodityType)
			String sql = "SELECT * FROM orderitem, commodity,commodityType WHERE orderitem.commodityID = commodity.commodityID " +
					"AND commodityType.commodityTypeID = commodity.commodityTypeID AND ordersID=?";
			//使用MapListHandler来映射成三个bean对象
			List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(),order.getOrdersID());
			//mapList是多个map，每个map对应一行结果集
			//使用一个Map生成三个个对象：OrderItem、Commodity，CommodityType，然后再建立三者的关系（把Commodity设置给OrderItem），(把CommodityType设置给Commodity)
			
			//循环遍历每个Map，使用map生成三个对象，然后建立关系（最终结果一个OrderItem），把OrderItem保存起来
			List<OrderItem> orderItems = toOrderItemList(mapList);
			//设置orderItems给order
			order.setOrderItemList(orderItems);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 把mapList中每个Map转换成三个个对象，并建立关系
	 * @param mapList
	 * @return
	 */
	private List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> orderItems =  new ArrayList<OrderItem>();
		for (Map<String, Object> map : mapList) {
			OrderItem item = toOrderItem(map);
			orderItems.add(item);
		}
		return orderItems;
	}

	/**
	 * 把一个Map转换成一个OrderItem对象
	 * @param map
	 * @return
	 */
	private OrderItem toOrderItem(Map<String, Object> map) {
		//把map集合映射成三个bean对象
		OrderItem orderItem = ServiceUtils.toBean(map, OrderItem.class);
		Commodity commodity = ServiceUtils.toBean(map, Commodity.class);
		CommodityType commodityType = ServiceUtils.toBean(map, CommodityType.class);
		//把CommodityType设置给Commodity
		commodity.setCommodityType(commodityType);
		//把Commodity设置给OrderItem
		orderItem.setCommodity(commodity);
		return orderItem;
	}

	/**
	 * 根据订单id加载订单
	 */
	@Override
	public Order load(String oid) {
		try {
			//得到当前用户的所有订单
			String sql = "SELECT * FROM orders WHERE ordersID=?";
			Order order =  qr.query(sql, new BeanHandler<Order>(Order.class),oid);
			//为order加载它所有的订单条目
			loadOrderItems(order);
			//返回订单列表
			return order;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 根据订单id查询订单状态
	 */
	@Override
	public int getStateByOid(String oid) {
		try {
			String sql = "SELECT state FROM orders WHERE ordersID=?";
			return (Integer) qr.query(sql, new ScalarHandler(),oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	
	
	/**
	 * 修改订单状态
	 */
	@Override
	public void updateState(String oid, int state) {
		try {
			String sql = "UPDATE orders SET state=? WHERE ordersID=?";
			qr.update(sql,state,oid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 返回所有的订单
	 */
	@Override
	public List<Order> findAllOrder() {
		try {
			//查询所有的订单
			String sql = "SELECT * FROM orders";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class));
			//循环遍历其中的每一个Order，为其加载它自己所有的订单项(订单条目)
			for (Order order : orderList) {
				//为order对象添加它的所有订单条目
				loadOrderItems(order);
			}
			//返回订单列表
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 返回指定状态下的订单
	 */
	@Override
	public List<Order> findByState(int state) {
		try {
			//查询指定状态下所有的订单
			String sql = "SELECT * FROM orders WHERE state=?";
			List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class),state);
			//循环遍历其中的每一个Order，为其加载它自己所有的订单项(订单条目)
			for (Order order : orderList) {
				//为order对象添加它的所有订单条目
				loadOrderItems(order);
			}
			//返回订单列表
			return orderList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	} 
	
	
	

}
