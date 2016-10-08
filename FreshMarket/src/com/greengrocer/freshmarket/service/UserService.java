package com.greengrocer.freshmarket.service;

import com.greengrocer.freshmarket.dao.UserDao;
import com.greengrocer.freshmarket.dao.factory.DaoFactory;
import com.greengrocer.freshmarket.domain.User;
import com.greengrocer.freshmarket.exception.UserException;
import com.greengrocer.freshmarket.utils.ServiceUtils;
import com.greengrocer.freshmarket.utils.WebUtils;


public class UserService {
	// 把具体的实现类的创建，隐藏到工厂中了
	private UserDao userDao = DaoFactory.getUserDao();
	
	
	public void register(User form) throws UserException{
		//1.校验用户名
		User user = userDao.findByUsername(form.getUsername());
		String password = form.getPassword();//保存未加密的密码
		//2.查看user对象是否为null，如果不为null说明用户已经注册过了，抛出异常（异常信息为：用户名已被注册！）
		if(user!=null){
			throw new UserException("用户名已被注册!!");
		}
		
		//若不为null说明可以注册
		//md5加密密码
		form.setPassword(ServiceUtils.md5(form.getPassword()));
		//添加User对象
		userDao.addUser(form);
		
	}
	
	
	
	public User login(User form) throws UserException{
		//1.使用form的username进行校验
		User user = userDao.findByUsername(form.getUsername());
		String password = form.getPassword();//保存未加密的密码
		//2.判断user是否为null，若为null，说明用户名错误，所以抛出异常
		if(user==null){
			throw new UserException("用户不存在!!");
		}
		//md5加密后查找
		form.setPassword(ServiceUtils.md5(form.getPassword()));
		
		 //3.判断form和user密码是否相同,若不同，说明密码错误，所以抛出异常
		if(!user.getPassword().equals(form.getPassword())){
			form.setPassword(password);//设置为原来未加密的密码
			throw new UserException("用户名或密码错误!!");
		}
		//4.若执行到这里，说明没有错误，登录成功了，返回当前user对象
		return user;
	}
	
	/**
	 * 完善个人信息
	 * @param user
	 */
	public void complementUser(User user){
		//完善个人信息
		userDao.complementUser(user);
	}
	
	/**
	 * 查询用户详细信息
	 * @param username
	 * @return
	 */
	public User findUser(String username){
		return userDao.findByUsername(username);
	}
	
	/**
	 * 修改收货地址
	 * @param user
	 */
	public void changeAddress(User user){
		userDao.changeAddress(user);
	}
}
