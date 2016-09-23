package com.greengrocer.freshmarket.service;

import java.util.List;

import com.greengrocer.freshmarket.dao.CommodityTypeDao;
import com.greengrocer.freshmarket.dao.factory.DaoFactory;
import com.greengrocer.freshmarket.domain.CommodityType;

public class CommodityTypeService {

	// 把具体的实现类的创建，隐藏到工厂中了
	private CommodityTypeDao commodityTypDao = DaoFactory.getCommodityTypeDao();
	
	/**
	 * 返回带逗号拼接的商品（种类编号:商品种类）名称字符串
	 * @return 商品种类字符串
	 */
	public String getAllCommodityType(){
		List<CommodityType> types = commodityTypDao.findAllCommodityType();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<types.size(); i++) {
			CommodityType type = types.get(i);
			sb.append(type.getCommodityTypeID()+":"+type.getCommodityTypeName());
			if(i<types.size()-1){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 返回所有的商品种类集合
	 * @return 商品种类集合
	 */
	public List<CommodityType> getAllCommodityTypes(){	
		return commodityTypDao.findAllCommodityType();	
	}


	/**
	 * 添加商品种类
	 * @param commodityType
	 */
	public void addCommodityType(CommodityType commodityType) {
		commodityTypDao.addCommodityType(commodityType);
		
	}


	/**
	 * 查询商品种类
	 * @param commodityTypeID
	 * @return 
	 */
	public CommodityType findCommodityType(String commodityTypeID) {
		return commodityTypDao.findCommodityType(commodityTypeID);
		
	}


	/**
	 * 修改商品种类
	 * @param commodityType
	 */
	public void updateCommodityType(CommodityType commodityType) {
		commodityTypDao.updateCommodityType(commodityType);
	}

	/**
	 * 删除商品种类
	 * @param commodityTypeID
	 */
	public void deleteCommodityType(String commodityTypeID) {
		commodityTypDao.deleteCommodityType(commodityTypeID);
	}


	
}
