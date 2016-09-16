package com.freshmarket.web.formbean;

import java.util.HashMap;
import java.util.Map;


public class RegisterForm {
	private String username;
	private String userpassword;
	private String userpassword2;
	private String verifyCode;//验证码
	
	public String getVerifyCode() {
		return verifyCode;
	}


	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}


	private Map<String,String> errors = new HashMap<String, String>() ;	//存放错误集合
	
	
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


	public String getUserpassword2() {
		return userpassword2;
	}


	public void setUserpassword2(String userpassword2) {
		this.userpassword2 = userpassword2;
	}


	public Map<String,String>  getErrors() {
		return errors;
	}


	public void setErrors(Map<String,String>  errors) {
		this.errors = errors;
	}


	//用户名不能为空，并且要是3-8位字母
	//密码不能为空，并且是3-8位数字
	//确认密码不能为空，并且和一次一致

	public boolean validate(){
		boolean isOK = true;
		
		if(this.username==null || this.username.trim().equals("")){
			isOK = false;
			errors.put("username", "用户名不能为空!!");
		}else{
			if(this.username.length()<2 || this.username.length()>15){
				isOK = false;
				errors.put("username", "用户名长度必须在2~15之间!!");
			}
		}
		
		if(this.userpassword==null || this.userpassword.trim().equals("")){
			isOK = false;
			errors.put("userpassword", "密码不能为空!!");
		}else{
			if(userpassword.length() < 3 || userpassword.length() > 15){
				isOK = false;
				errors.put("userpassword", "密码长度必须在3~15之间!!");
			}
		}
		
		if(this.userpassword2==null || this.userpassword2.trim().equals("")){
			isOK = false;
			errors.put("userpassword", "确认密码不能为空!!");
		}else{
			if(!this.userpassword2.equals(this.userpassword)){
				isOK = false;
				errors.put("userpassword2", "两次密码要一致!!");
			}
		}
	
		return isOK;
	}
	
}
