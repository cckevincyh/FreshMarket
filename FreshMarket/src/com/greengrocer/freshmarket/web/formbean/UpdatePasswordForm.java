package com.greengrocer.freshmarket.web.formbean;

import java.util.HashMap;
import java.util.Map;

public class UpdatePasswordForm {
	private String username;
	private String oldpassword;
	private String newpassword1;
	private String newpassword2;
	private Map<String,String> errors = new HashMap<String, String>() ;	//存放错误集合


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword1() {
		return newpassword1;
	}
	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	
	//密码不能为空，并且是3-8位数字
	//确认密码不能为空，并且和一次一致

	public boolean validate(){
		boolean isOK = true;
		if(newpassword1==null || newpassword1.trim().equals("")){
			isOK = false;
			errors.put("newpassword1", "新密码密码不能为空!!");
		}else{
			if(newpassword1.length() < 3 || newpassword1.length() > 15){
				errors.put("newpassword1", "新密码密码长度必须在3~15之间!!");
				isOK = false;
			}
		}
		
		if(newpassword2==null || newpassword2.trim().equals("")){
			errors.put("newpassword2", "确认密码不能为空!!");
			isOK = false;
		}else{
			if(!newpassword1.equals(newpassword2)){
				errors.put("newpassword2", "两次密码要一致!!");
				isOK = false;
			}
		}
		return isOK;
	}

}
