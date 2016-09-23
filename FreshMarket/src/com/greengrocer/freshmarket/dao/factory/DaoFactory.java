package com.greengrocer.freshmarket.dao.factory;

import java.io.InputStream;
import java.util.Properties;

import com.greengrocer.freshmarket.dao.AdminDao;
import com.greengrocer.freshmarket.dao.CommodityDao;
import com.greengrocer.freshmarket.dao.CommodityTypeDao;
import com.greengrocer.freshmarket.dao.UserDao;

/**
 * 通过配置文件得到dao实现类的名称
 * 通过类名称，完成创建类对象（反射）
 *
 */
public class DaoFactory {

	private static Properties props = null;
	
	static{
		// 加载配置文件内容到props对象中
		try {
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			props = new Properties();
			props.load(in);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 给出一个配置文件，文件中给出UserDao接口的实现类名称
	 * 我们这个方法，获取实现类的类名，通过反射完成创建对象
	 * 
	 * 返回一个具体UserDao的实现类对象
	 * @return UserDao的实现类对象
	 */
	public static UserDao getUserDao(){
		//得到dao实现类的名称
		String daoClassName = props.getProperty("com.greengrocer.freshmarket.dao.UserDao");
		
		//通过反射来创建实现类的对象
		try{
			Class clazz = Class.forName(daoClassName);
			return (UserDao) clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 给出一个配置文件，文件中给出AdminDao接口的实现类名称
	 * 我们这个方法，获取实现类的类名，通过反射完成创建对象
	 * 
	 * 返回一个具体AdminDao的实现类对象
	 * @return AdminDao的实现类对象
	 */
	public static AdminDao getAdminDao(){
		//得到dao实现类的名称
		String daoClassName = props.getProperty("com.greengrocer.freshmarket.dao.AdminDao");
		
		//通过反射来创建实现类的对象
		try{
			Class clazz = Class.forName(daoClassName);
			return (AdminDao) clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 给出一个配置文件，文件中给出CommodityTypeDao接口的实现类名称
	 * 我们这个方法，获取实现类的类名，通过反射完成创建对象
	 * 
	 * 返回一个具体CommodityTypeDao的实现类对象
	 * @return CommodityTypeDao的实现类对象
	 */
	public static CommodityTypeDao getCommodityTypeDao(){
		//得到dao实现类的名称
		String daoClassName = props.getProperty("com.greengrocer.freshmarket.dao.CommodityTypeDao");
		
		//通过反射来创建实现类的对象
		try{
			Class clazz = Class.forName(daoClassName);
			return (CommodityTypeDao) clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 给出一个配置文件，文件中给出CommodityDao接口的实现类名称
	 * 我们这个方法，获取实现类的类名，通过反射完成创建对象
	 * 
	 * 返回一个具体CommodityDao的实现类对象
	 * @return CommodityDao的实现类对象
	 */
	public static CommodityDao getCommodityDao(){
		//得到dao实现类的名称
		String daoClassName = props.getProperty("com.greengrocer.freshmarket.dao.CommodityDao");
		
		//通过反射来创建实现类的对象
		try{
			Class clazz = Class.forName(daoClassName);
			return (CommodityDao) clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
