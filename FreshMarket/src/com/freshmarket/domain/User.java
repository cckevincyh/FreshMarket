package com.freshmarket.domain;

import java.io.Serializable;

/**
 * 用户类
 */
public class User implements Serializable{	//实现序列化是因为设置了session钝化
	
	private int userID;			//用户编号
	private String username;		//用户名
	private String password;		//密码
	private String sex;				//性别
	private String address;			//住址
	private String phone;			//联系电话
	private String email;			//Email地址
	

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}

	
