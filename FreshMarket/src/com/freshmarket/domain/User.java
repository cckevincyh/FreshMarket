package com.freshmarket.domain;


public class User {
	
	private String username;//用户名
	private String userpassword;//密码
	private int usertype;//用户类型(管理员or注册用户)
	private int userstatus;//登陆状态(已登陆or未登陆)

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public int getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}

	public User(String username, String userpassword, int usertype,
			int userstatus) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.usertype = usertype;
		this.userstatus = userstatus;
	}

	public User() {
		
	}
	
	
	
	

}

	
