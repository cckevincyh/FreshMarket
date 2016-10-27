package com.greengrocer.freshmarket.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.greengrocer.freshmarket.dao.CommodityDao;
import com.greengrocer.freshmarket.dao.JdbcUtils;
import com.greengrocer.freshmarket.dao.TxQueryRunner;
import com.greengrocer.freshmarket.domain.Commodity;
import com.greengrocer.freshmarket.domain.CommodityType;
import com.greengrocer.freshmarket.domain.PageBean;
import com.greengrocer.freshmarket.utils.ServiceUtils;
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
					"`url`) values(?,?,?,?)";
			Object[] params = {commodityForm.getCommodityName(),commodityForm.getCommodityTypeID(),
					commodityForm.getCommodityPrice(),commodityForm.getUrl()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 查询所有的商品信息 (返回的是分页后的商品信息集合)
	 */
	@Override
	public PageBean<Commodity> findAllCommodity(int pageCode,int pageSize) {	
		PageBean<Commodity> pb = new PageBean<Commodity>();	//pageBean对象，用于分页
		//根据传入的pageCode当前页码和pageSize页面记录数来设置pb对象
		pb.setPageCode(pageCode);//设置当前页码
		pb.setPageSize(pageSize);//设置页面记录数
		
		try {
			String sql = "SELECT count(*) FROM Commodity";
			Number num;	//记录查询的总记录结果
			num = (Number)qr.query(sql, new ScalarHandler());
			int totalRecord = num.intValue(); //得到总记录数
			pb.setTotalRecord(totalRecord);	//设置总记录数
			
			sql = "SELECT * FROM Commodity order by commodityID limit ?,? ;";
			Object[] params = {(pageCode-1)*pageSize,pageSize};
			//得到分页后的商品信息集合
			List<Commodity> commodities = qr.query(sql, params, new BeanListHandler<Commodity>(Commodity.class));		
			//设置分页后的商品信息集合
			pb.setBeanList(commodities);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return pb;
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
		try {
			String sql = "SELECT * FROM  commodityType ,commodity WHERE " +
					"commodityType.commodityTypeID = commodity.commodityTypeID AND CommodityID = ? order by commodityID";
			//查询出List的map集合
			Map<String, Object> map = qr.query(sql, commodityID,new MapHandler());
			//得到Commodity对象
			Commodity commodity = toCommodity(map);
			
			return commodity;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	

	/**
	 * 把一个Map转换成一个Commodity对象和CommdityType对象，并建立关系
	 * @param map
	 * @return
	 */
	private Commodity toCommodity(Map<String, Object> map) {
		//通过工具类把map集合转换为
		Commodity commodity = ServiceUtils.toBean(map, Commodity.class);
		CommodityType commodityType = ServiceUtils.toBean(map, CommodityType.class);
		//给商品设置商品种类
		commodity.setCommodityType(commodityType);
		return commodity;
	}
	
	
	
	

	/**
	 * 修改商品信息
	 */
	@Override
	public void updateCommodity(CommodityForm commodityForm) {
		try {
			String sql = "UPDATE commodity SET " +
					"`commodityName`=?,`commodityTypeID`=?,`commodityPrice`=?, "+
					"`url`=? where `commodityID`=?;";
			Object[] params = {commodityForm.getCommodityName(),commodityForm.getCommodityTypeID(),
					commodityForm.getCommodityPrice(),commodityForm.getUrl(),commodityForm.getCommodityID()};

			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 多条件查询商品信息(分页查询)
	 */
	@Override
	public PageBean<Commodity> queryCommodity(int pageCode, int pageSize,
			CommodityForm commodityForm) {
		PageBean<Commodity> pb = new PageBean<Commodity>();	//pageBean对象，用于分页
		//根据传入的pageCode当前页码和pageSize页面记录数来设置pb对象
		pb.setPageCode(pageCode);//设置当前页码
		pb.setPageSize(pageSize);//设置页面记录数
		
		try {
			
			StringBuilder sql = new StringBuilder("SELECT count(*) FROM Commodity WHERE 1=1 ");
			
			
			//进行多条件查询
			//得到分页后的商品信息集合
			List<Commodity> commodities = null;
			
			StringBuilder _sql = new StringBuilder("SELECT * FROM Commodity WHERE 1=1 ");
			//Object[] params = {(pageCode-1)*pageSize,pageSize};
			ArrayList<Object> params = new ArrayList<Object>();
			
			if(commodityForm.getCommodityName()!=null && !commodityForm.getCommodityName().trim().equals("")){
				_sql.append("AND CommodityName like '%"+commodityForm.getCommodityName()+"%' ");
				sql.append("AND CommodityName like '%"+commodityForm.getCommodityName()+"%' ");
			}
			if(commodityForm.getCommodityTypeID()!=-1 ){
				_sql.append("AND commodity.`commodityTypeID`=? ");
				sql.append("AND commodity.`commodityTypeID`=? ");
				params.add(commodityForm.getCommodityTypeID());
			
			}
			_sql.append(" order by commodityID limit ?,? ");
			
			Number num;	//记录查询的总记录结果
			num = (Number)qr.query(sql.toString(),params.toArray(), new ScalarHandler());
			int totalRecord = num.intValue(); //得到总记录数
			pb.setTotalRecord(totalRecord);	//设置总记录数
			
			params.add((pageCode-1)*pageSize);
			params.add(pageSize);
			commodities = qr.query(_sql.toString(), params.toArray(), new BeanListHandler<Commodity>(Commodity.class));	
			
			
			
			//设置分页后的商品信息集合
			pb.setBeanList(commodities);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pb;
	}

	


	
	
	
	
	
}
