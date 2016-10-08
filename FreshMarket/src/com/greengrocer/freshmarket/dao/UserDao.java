package com.greengrocer.freshmarket.dao;

import com.greengrocer.freshmarket.domain.User;

public interface UserDao {

	/**
	 * 添加用户
	 * @param form 提交的用户表单对象
	 */
	public void addUser(User form);
	/**
	 * 根据用户名查询用户
	 * @param username 用户名
	 * @return 用户对象
	 */
	public User findByUsername(String username);
	
	
	
	/**
	 * 完善用户信息
	 * @param user
	 */
	public void complementUser(User user);
	
	/**
	 * 修改收货地址
	 * @param address
	 */
	public void changeAddress(User user);
}
