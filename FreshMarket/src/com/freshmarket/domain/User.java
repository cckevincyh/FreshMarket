package com.freshmarket.domain;


public class User {
	
	private String userid;//用户id
	private String username;//用户名
	private String userpassword;//密码
	private int usertype;//用户类型(管理员or注册用户)

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
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



	public User(String userid, String username, String userpassword,
			int usertype) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.usertype = usertype;
	}

	public User() {
		
	}
	
	
	
	

}

	
