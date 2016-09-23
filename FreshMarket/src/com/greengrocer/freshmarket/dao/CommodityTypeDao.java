package com.greengrocer.freshmarket.dao;


import java.util.List;

import com.greengrocer.freshmarket.domain.CommodityType;

public interface CommodityTypeDao {

	/**
	 * 查询所有的商品种类信息
	 * @return 商品种类信息实体集合
	 */
	public List<CommodityType> findAllCommodityType();
	
	/**
	 * 添加商品种类信息
	 * @param commodityType
	 */
	public void addCommodityType(CommodityType commodityType);

	
}
