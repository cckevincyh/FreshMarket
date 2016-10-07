package com.greengrocer.freshmarket.dao;

import com.greengrocer.freshmarket.domain.Admin;



public interface AdminDao {
	/**
	 * 添加管理员
	 * @param form 提交的管理员表单对象
	 */
	public void addAdmin(Admin form);
	/**
	 * 根据管理员用户名查询出管理员
	 * @param adminname 管理员用户名
	 * @return 管理员对象
	 */
	public Admin findByAdminname(String adminname);
	
	/**
	 * 修改密码
	 * @param admin
	 * @param newPass
	 */
	public void changePassword(Admin admin,String newPass);
}
