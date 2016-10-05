package com.jc.ssm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

import com.jc.ssm.dao.UserDao;
import com.jc.ssm.model.User;
import com.jc.ssm.util.Helper;
/**
* @ClassName: UserService  
* @Description: 用户模块
* @author guofu 81378536_qq_com  
* @date 2016年5月14日 下午7:44:22  
*
 */
@Component
public class UserService {
	public UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserById(int id){
		return userDao.getById(id);
	}
	
	/**
	 * 
	* @Title: login  
	* @Description: TODO
	* @param @param userName
	* @param @param password
	* @param @return
	* @return User
	* @throws
	 */
	public User checkPassword(String userName, String password){
		if (userName == null){
			return null;
		}
		User user = userDao.getByUserName(userName);
		if (user == null){
			return null;
		}
		if (Helper.MD5(password).toUpperCase().equals(user.getPassword().toUpperCase())){
			return user;
		} else{
			return null;
		}
	}

	public boolean changePassword(int id, String newPassword) {
		newPassword = Helper.MD5(newPassword);
		userDao.updatePassword(id, newPassword);
		return true;
	}
}
