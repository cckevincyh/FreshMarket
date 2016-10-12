package com.greengrocer.freshmarket.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.greengrocer.freshmarket.dao.TxQueryRunner;
import com.greengrocer.freshmarket.dao.UserDao;
import com.greengrocer.freshmarket.domain.User;
import com.greengrocer.freshmarket.web.formbean.UpdatePasswordForm;

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
		try {
			String sql = "SELECT * FROM USERS WHERE USERNAME=?";
			return qr.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	/**
	 * 完善用户信息
	 */
	@Override
	public void complementUser(User user) {
		try {
			String sql = "UPDATE USERS SET sex=? ,address=? , phone=?, email=? WHERE USERNAME=?";
			Object []params = {user.getSex(),user.getAddress(),user.getPhone(),user.getEmail(),user.getUsername()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 修改收货地址
	 */
	@Override
	public void changeAddress(User user) {
		try {
			String sql = "UPDATE USERS SET address=?  WHERE USERNAME=?";
			Object []params = {user.getAddress(),user.getUsername()};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * 修改密码
	 */
	@Override
	public void changePassword(UpdatePasswordForm form) {
		try {
			String sql = "UPDATE USERS SET `password` = ? WHERE username=?";
			Object []params = {form.getNewpassword1(),form.getUsername()}; 
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}





}
