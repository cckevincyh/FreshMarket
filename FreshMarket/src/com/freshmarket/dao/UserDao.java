package com.freshmarket.dao;

import com.freshmarket.domain.User;

public interface UserDao {

	public void addUser(User form);
	public User findByUsername(String username);
	
}
