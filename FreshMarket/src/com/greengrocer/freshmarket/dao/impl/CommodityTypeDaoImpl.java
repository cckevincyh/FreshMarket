package com.greengrocer.freshmarket.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
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
			String sql = "SELECT * FROM CommodityType";
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
			String sql = "INSERT INTO CommodityType VALUES(?,?,?)";
			Object[] params = {commodityType.getCommodityTypeID(),commodityType.getCommodityTypeName(),commodityType.getTypeUrl()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
}
