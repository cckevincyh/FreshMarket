package com.freshmarket.test;

import org.junit.Test;

import com.freshmarket.domain.User;
import com.freshmarket.service.UserException;
import com.freshmarket.service.UserService;

public class LoginTest {

	@Test
	public void login(){
		UserService service = new UserService();
		User form = new User("aaa", "1253", 0, 0);
		try {
			service.login(form);
		} catch (UserException e) {
			
			e.printStackTrace();
		}

	}
	
}
