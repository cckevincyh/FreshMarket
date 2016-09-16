package com.freshmarket.dao.factory;

import java.io.InputStream;
import java.util.Properties;

import com.freshmarket.dao.UserDao;

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
		String daoClassName = props.getProperty("com.freshmarket.dao.UserDao");
		
		//通过反射来创建实现类的对象
		try{
			Class clazz = Class.forName(daoClassName);
			return (UserDao) clazz.newInstance();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
