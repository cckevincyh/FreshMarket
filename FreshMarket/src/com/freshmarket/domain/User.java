package com.freshmarket.domain;

import java.io.Serializable;


public class User implements Serializable{	
	
	private int userID;			//用户编号
	private String username;		//用户名
	private String password;		//密码
	private String sex;				//性别
	private String address;			//住址
	private String phone;			//联系电话
	private String email;			//Email地址
	
	
	
	public User() {

	}

	public User(int userID, String username, String password, String sex,
			String address, String phone, String email) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

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

	
