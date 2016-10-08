package com.greengrocer.freshmarket.web.formbean;

import java.util.HashMap;
import java.util.Map;

/**
 * 提交的注册表单类
 */
public class RegisterForm {
	private String username;
	private String password;
	private String password2;
	private String verifyCode;//验证码
	private Map<String,String> errors = new HashMap<String, String>() ;	//存放错误集合
	
	public String getVerifyCode() {
		return verifyCode;
	}


	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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


	public String getPassword2() {
		return password2;
	}




	public void setPassword2(String password2) {
		this.password2 = password2;
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
		
		if(this.password==null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "密码不能为空!!");
		}else{
			if(password.length() < 3 || password.length() > 15){
				isOK = false;
				errors.put("password", "密码长度必须在3~15之间!!");
			}
		}
		
		if(this.password2==null || this.password2.trim().equals("")){
			isOK = false;
			errors.put("password", "确认密码不能为空!!");
		}else{
			if(!this.password2.equals(this.password)){
				isOK = false;
				errors.put("password2", "两次密码要一致!!");
			}
		}
	
		return isOK;
	}
	
}
