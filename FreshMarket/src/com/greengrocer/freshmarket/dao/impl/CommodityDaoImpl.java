package com.greengrocer.freshmarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.greengrocer.freshmarket.dao.CommodityDao;
import com.greengrocer.freshmarket.dao.JdbcUtils;
import com.greengrocer.freshmarket.dao.TxQueryRunner;
import com.greengrocer.freshmarket.domain.Commodity;
import com.greengrocer.freshmarket.domain.CommodityType;
import com.greengrocer.freshmarket.web.formbean.CommodityForm;

public class CommodityDaoImpl implements CommodityDao{

	private QueryRunner qr = new TxQueryRunner();
	/**
	 * 添加商品信息
	 */
	@Override
	public void addCommodity(CommodityForm commodityForm) {
		try {
			String sql = "INSERT INTO Commodity(`commodityName`,`commodityTypeID`,`commodityPrice`," +
					"`commodityAmount`,`commodityLeaveNum`,`url`) values(?,?,?,?,?,?)";
			Object[] params = {commodityForm.getCommodityName(),commodityForm.getCommodityTypeID(),
					commodityForm.getCommodityPrice(),commodityForm.getCommodityAmount(),
					commodityForm.getCommodityLeaveNum(),commodityForm.getUrl()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 查询所有的商品信息
	 */
	@Override
	public List<Commodity> findAllCommodity() {
		Connection  connection = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		List<Commodity> commodities = new ArrayList<Commodity>();
		try {
			connection = JdbcUtils.getConnection();
			 ps = connection.prepareStatement("SELECT commodity.`commodityTypeID`,`commodityTypeName`," +
					"`commodityName`,`commodityPrice`, `commodityAmount`," +
					"`commodityLeaveNum`,`url`,`commodityID` FROM commodityType ,commodity" +
					" where commodityType.commodityTypeID = commodity.commodityTypeID;");
			rs = ps.executeQuery();
			while(rs.next()){
				Commodity commodity = new Commodity();
				CommodityType type = new CommodityType();
				type.setCommodityTypeID(rs.getInt(1));
				type.setCommodityTypeName(rs.getString(2));
				commodity.setCommodityType(type);
				commodity.setCommodityName(rs.getString(3));
				commodity.setCommodityPrice(rs.getDouble(4));
				commodity.setCommodityAmount(rs.getInt(5));
				commodity.setCommodityLeaveNum(rs.getInt(6));
				commodity.setUrl(rs.getString(7));
				commodity.setCommodityID(rs.getInt(8));
				commodities.add(commodity);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			if(connection!=null ){
				try {
					JdbcUtils.releaseConnection(connection);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
		return commodities;
	}

	/**
	 * 删除商品信息
	 */
	@Override
	public void deleteCommodity(String commodityID) {
		try {
			String sql = "DELETE FROM commodity WHERE commodityID=?";
			qr.update(sql, commodityID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
	
	/**
	 * 根据id查询商品信息
	 * @param commodityID
	 */
	public Commodity findCommodity(String commodityID){
		Connection  connection = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		Commodity commodity = new Commodity();
		try {
			connection = JdbcUtils.getConnection();
			 ps = connection.prepareStatement("SELECT commodity.`commodityTypeID`,`commodityTypeName`," +
					"`commodityName`,`commodityPrice`, `commodityAmount`," +
					"`commodityLeaveNum`,`url`,`commodityID` FROM commodityType ,commodity" +
					" where commodityType.commodityTypeID = commodity.commodityTypeID and commodityID=?;");
			 ps.setInt(1, Integer.parseInt(commodityID));
			rs = ps.executeQuery();
			if(rs.next()){
				CommodityType type = new CommodityType();
				type.setCommodityTypeID(rs.getInt(1));
				type.setCommodityTypeName(rs.getString(2));
				commodity.setCommodityType(type);
				commodity.setCommodityName(rs.getString(3));
				commodity.setCommodityPrice(rs.getDouble(4));
				commodity.setCommodityAmount(rs.getInt(5));
				commodity.setCommodityLeaveNum(rs.getInt(6));
				commodity.setUrl(rs.getString(7));
				commodity.setCommodityID(rs.getInt(8));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			if(connection!=null ){
				try {
					JdbcUtils.releaseConnection(connection);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return commodity;
	}

	/**
	 * 修改商品信息
	 */
	@Override
	public void updateCommodity(CommodityForm commodityForm) {
		try {
			String sql = "UPDATE commodity SET " +
					"`commodityName`=?,`commodityTypeID`=?,`commodityPrice`=?, `commodityAmount`=?," +
					"`commodityLeaveNum`=?,`url`=? where `commodityID`=?;";
			Object[] params = {commodityForm.getCommodityName(),commodityForm.getCommodityTypeID(),
					commodityForm.getCommodityPrice(),commodityForm.getCommodityAmount(),
					commodityForm.getCommodityLeaveNum(),commodityForm.getUrl(),commodityForm.getCommodityID()};

			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
