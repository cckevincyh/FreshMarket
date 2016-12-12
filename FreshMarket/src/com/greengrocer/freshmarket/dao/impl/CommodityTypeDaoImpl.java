package com.greengrocer.freshmarket.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.greengrocer.freshmarket.dao.CommodityTypeDao;
import com.greengrocer.freshmarket.dao.TxQueryRunner;
import com.greengrocer.freshmarket.domain.CommodityType;

public class CommodityTypeDaoImpl implements CommodityTypeDao{

	private QueryRunner qr = new TxQueryRunner();
	
	/**
	 * 查找所有的商品种类
	 */
	@Override
	public List<CommodityType> findAllCommodityType() {
		try {
			String sql = "SELECT * FROM CommodityType order by CommodityTypeID";
			return qr.query(sql, new BeanListHandler<CommodityType>(CommodityType.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	/**
	 * 添加商品种类信息
	 */
	@Override
	public void addCommodityType(CommodityType commodityType) {
		try {
			String sql = "INSERT INTO CommodityType VALUES(?,?)";
			Object[] params = {commodityType.getCommodityTypeID(),commodityType.getCommodityTypeName()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 查询商品种类信息
	 */
	@Override
	public CommodityType findCommodityType(String commodityTypeID) {
		try {
			String sql ="SELECT * FROM CommodityType WHERE CommodityTypeID = ? ;";
			return qr.query(sql, commodityTypeID, new BeanHandler<CommodityType>(CommodityType.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
	/**
	 * 修改商品种类信息
	 */
	@Override
	public void updateCommodityType(CommodityType commodityType) {
		try {
			String sql = "UPDATE CommodityType SET commodityTypeName=? WHERE commodityTypeID = ?;";
			Object[] params = {commodityType.getCommodityTypeName(),commodityType.getCommodityTypeID()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除商品种类信息
	 */
	@Override
	public void deleteCommodityType(String commodityTypeID) {
		try {
			String sql = "DELETE FROM CommodityType WHERE commodityTypeID = ?;";
			qr.update(sql, commodityTypeID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public CommodityType findCommodityTypeByName(String commodityTypeName) {
		try {
			String sql ="SELECT * FROM CommodityType WHERE CommodityTypeName = ? ;";
			CommodityType commodityType = qr.query(sql, commodityTypeName, new BeanHandler<CommodityType>(CommodityType.class));
			return commodityType;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
}
