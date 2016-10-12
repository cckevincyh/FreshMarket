package com.greengrocer.freshmarket.service;

import com.greengrocer.freshmarket.dao.AdminDao;
import com.greengrocer.freshmarket.dao.factory.DaoFactory;
import com.greengrocer.freshmarket.dao.impl.AdminDaoImpl;
import com.greengrocer.freshmarket.domain.Admin;
import com.greengrocer.freshmarket.exception.UserException;
import com.greengrocer.freshmarket.utils.ServiceUtils;
import com.greengrocer.freshmarket.web.formbean.UpdatePasswordForm;


public class AdminService {
	// 把具体的实现类的创建，隐藏到工厂中了
	private AdminDao adminDao = DaoFactory.getAdminDao();
	
	
	public Admin login(Admin form) throws UserException{
		//1.使用form的username进行校验
		Admin admin = adminDao.findByAdminname(form.getUsername());
		String password = form.getPassword();//保存未加密的密码
		//2.判断admin是否为null，若为null，说明用户名错误，所以抛出异常
		if(admin==null){
			throw new UserException("用户不存在!!");
		}
		//md5加密后查找
		form.setPassword(ServiceUtils.md5(form.getPassword()));
		
		 //3.判断form和user密码是否相同,若不同，说明密码错误，所以抛出异常
		if(!admin.getPassword().equals(form.getPassword())){
			form.setPassword(password);//设置为原来未加密的密码
			throw new UserException("用户名或密码错误!!");
		}
		//4.若执行到这里，说明没有错误，登录成功了，返回当前admin对象
		return admin;
	}
	
	
	
	/**
	 * 修改密码
	 * @param admim
	 * @param newPass
	 * @throws UserException 
	 */
	public void changePassword(UpdatePasswordForm form) throws UserException{
		Admin admin = adminDao.findByAdminname(form.getUsername());
		//md5加密输入的原密码
		String oldpass = ServiceUtils.md5(form.getOldpassword());
		//判断输入的原密码是否正确
		if(!oldpass.equals(admin.getPassword())){
			throw new UserException("原密码错误!!");
		}else{
			//md5加密新密码
			form.setNewpassword1(ServiceUtils.md5(form.getNewpassword1()));
			//修改密码
			adminDao.changePassword(form);
		}
	}
}
