/**
 * 
 */
package com.codeagles.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import com.codeagles.shop.user.dao.UserDao;
import com.codeagles.shop.user.vo.User;
import com.codeagles.util.MailUitls;
import com.codeagles.util.UUIDUtils;

/**
 * <p>Title: UserService</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date 下午3:13:25
 */
@Transactional
public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//检查用户是否存在
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

	/**
	 * 业务层，完成注册
	 */
	public void save(User user) {
		user.setState(0);//0:未激活 1：已激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();//32+32=64
		user.setCode(code);
		userDao.save(user);
		//发送激活邮件
		MailUitls.sendMail(user.getEmail(), code);
	}

	/**
	 * @param code
	 * 激活码查询用户
	 */
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}

	/**
	 * @param exsitUser
	 * 修改用户状态
	 */
	public void update(User exsitUser) {
		userDao.update(exsitUser);
	}

	/**
	 * @param user
	 * 用户登录
	 */
	public User login(User user) {
		
		return userDao.login(user);
	}
	
}
