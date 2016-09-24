package com.greengrocer.freshmarket.service;

import java.util.List;

import com.greengrocer.freshmarket.dao.CommodityDao;
import com.greengrocer.freshmarket.dao.factory.DaoFactory;
import com.greengrocer.freshmarket.domain.Commodity;
import com.greengrocer.freshmarket.domain.PageBean;
import com.greengrocer.freshmarket.web.formbean.CommodityForm;

public class CommodityService {

	private CommodityDao commodityDao= DaoFactory.getCommodityDao();
	
	/**
	 * 添加商品信息实体
	 * @param commodity 商品信息实体
	 */
	public void addCommodity(CommodityForm commodityForm){
		commodityDao.addCommodity(commodityForm);
	}
	
	/**
	 * 找到所有商品信息实体
	 * @return 所有商品信息实体集合
	 */
	public PageBean<Commodity> findAllCommodity(int pageCode,int pageSize){
		return commodityDao.findAllCommodity(pageCode,pageSize);
	}
	
	/**
	 * 删除商品信息
	 * @param commodityID
	 */
	public void deleteCommodity(String commodityID){
		commodityDao.deleteCommodity(commodityID);
	}
	
	/**
	 * 修改商品信息
	 * @param commodityID
	 */
	public void updateCommodity(CommodityForm commodityForm){
		commodityDao.updateCommodity(commodityForm);
	}
	
	/**
	 * 查询商品信息
	 * @param commodityID
	 */
	public Commodity findCommodity(String commodityID){
		return commodityDao.findCommodity(commodityID);
	}
	
}
