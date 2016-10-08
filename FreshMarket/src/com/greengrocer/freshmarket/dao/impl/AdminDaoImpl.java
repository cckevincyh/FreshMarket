package com.greengrocer.freshmarket.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.greengrocer.freshmarket.dao.AdminDao;
import com.greengrocer.freshmarket.dao.TxQueryRunner;
import com.greengrocer.freshmarket.domain.Admin;
import com.greengrocer.freshmarket.web.formbean.AdminForm;

public class AdminDaoImpl implements AdminDao{

	private QueryRunner qr = new TxQueryRunner();
	
	/**
	 * 根据提交的用户表单添加管理员
	 */
	@Override
	public void addAdmin(Admin form) {
		try {
			String sql = "INSERT INTO ADMINS(`adminname`,`password`) VALUES(?,?)";
			Object[] params = {form.getUsername(),form.getPassword()};
			qr.update(sql,params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 根据管理员用户名找到管理员对象
	 * return 管理员对象
	 */
	@Override
	public Admin findByAdminname(String adminname) {
		String sql = "SELECT * FROM ADMINS WHERE USERNAME=?";
		try {
			return qr.query(sql, new BeanHandler<Admin>(Admin.class),adminname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 修改密码
	 */
	@Override
	public void changePassword(AdminForm form) {
		String sql = "UPDATE ADMINS SET `password` = ? WHERE username=?";
		Object []params = {form.getNewpassword1(),form.getUsername()}; 
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
