package com.freshmarket.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.freshmarket.dao.TxQueryRunner;
import com.freshmarket.dao.UserDao;
import com.freshmarket.domain.User;

public class UserDaoImpl implements UserDao{

private QueryRunner qr = new TxQueryRunner();
	

	/**
	 * 根据提交的用户表单添加用户
	 */
	@Override
	public void addUser(User form) {
		
		try {
			String sql = "INSERT INTO USERS(`username`,`password`) VALUES(?,?)";
			Object[] params = {form.getUsername(),form.getPassword()};
			qr.update(sql,params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	/**
	 * 根据用户名找到用户对象
	 * return 用户对象
	 */
	@Override
	public User findByUsername(String username) {
		String sql = "SELECT * FROM USERS WHERE USERNAME=?";
		try {
			return qr.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


}
