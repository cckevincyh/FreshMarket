package com.greengrocer.freshmarket.dao;

import java.util.List;

import com.greengrocer.freshmarket.domain.Commodity;
import com.greengrocer.freshmarket.domain.PageBean;
import com.greengrocer.freshmarket.web.formbean.CommodityForm;

public interface CommodityDao {

	/**
	 * 添加商品信息
	 * @param commodity 商品实体
	 */
	public void addCommodity(CommodityForm commodityForm);
	
	/**
	 * 查询所有的商品信息，用于分页查询
	 * @param pageCode 当前页码
	 * @param pageSize 页面的记录数
	 * @return
	 */
	public PageBean<Commodity> findAllCommodity(int pageCode,int pageSize);
	
	/**
	 * 根据商品编号删除商品信息
	 * @param commodityID
	 */
	public void deleteCommodity(String commodityID);
	

	/**
	 * 根据商品编号查询商品信息
	 * @param commodityID
	 * @return
	 */
	public Commodity findCommodity(String commodityID);
	
	/**
	 * 修改商品信息
	 * @param commodityID
	 */
	public void updateCommodity(CommodityForm commodityForm);
	
	
	/**
	 * 多条件查询商品信息（分页查询）
	 * @param pageCode
	 * @param pageSize
	 * @param commodityForm
	 * @return
	 */
	public PageBean<Commodity> queryCommodity(int pageCode, int pageSize,CommodityForm commodityForm);
	 


	 
}
