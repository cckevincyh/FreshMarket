package com.greengrocer.freshmarket.domain;

import java.io.Serializable;
/**
 * 管理员类
 *
 */
public class Admin implements Serializable{ //实现序列化是因为设置了session钝化
	
	private int adminID;	//管理员编号
	private String username;//管理员用户名
	private String password;	//管理员密码
	
	
	




	public int getAdminID() {
		return adminID;
	}


	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}




	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	
	
	
}
