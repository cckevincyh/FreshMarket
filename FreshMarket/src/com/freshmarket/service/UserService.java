package com.freshmarket.service;

import com.freshmarket.dao.UserDao;
import com.freshmarket.dao.factory.DaoFactory;
import com.freshmarket.domain.User;
import com.freshmarket.utils.ServiceUtils;
import com.freshmarket.utils.WebUtils;


public class UserService {
	// 把具体的实现类的创建，隐藏到工厂中了
	private UserDao userDao = DaoFactory.getUserDao();
	
	
	public void register(User form) throws UserException{
		//1.校验用户名
		User user = userDao.findByUsername(form.getUsername());
		//2.查看user对象是否为null，如果不为null说明用户已经注册过了，抛出异常（异常信息为：用户名已被注册！）
		if(user!=null){
			throw new UserException("用户名已被注册!!");
		}
		
		//若不为null说明可以注册
		//md5加密密码
		form.setUserpassword(ServiceUtils.md5(form.getUserpassword()));
		//给User对象添加uuid做userid
		form.setUserid(WebUtils.generateID());
		//添加User对象
		userDao.addUser(form);
		
	}
	
	
	
	public User login(User form) throws UserException{
		//1.使用form的username进行校验
		User user = userDao.findByUsername(form.getUsername());
		//2.判断user是否为null，若为null，说明用户名错误，所以抛出异常
		if(user==null){
			throw new UserException("用户不存在!!");
		}
		//md5加密后查找
		form.setUserpassword(ServiceUtils.md5(form.getUserpassword()));
		
		 //3.判断form和user密码是否相同,若不同，说明密码错误，所以抛出异常
		if(!user.getUserpassword().equals(form.getUserpassword())){
			throw new UserException("用户名或密码错误!!");
		}
		//4.若执行到这里，说明没有错误，登录成功了，返回当前user对象
		return user;
	}
}
