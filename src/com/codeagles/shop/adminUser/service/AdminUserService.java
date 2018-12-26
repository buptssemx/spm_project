/**
 * 
 */
package com.codeagles.shop.adminUser.service;

import org.springframework.transaction.annotation.Transactional;

import com.codeagles.shop.adminUser.dao.AdminUserDao;
import com.codeagles.shop.adminUser.vo.AdminUser;

/**
 * <p>Title: AdminUserService</p>
 * <p>@function:</p>
 * @author Codeagles ,
 * @date обнГ7:49:01
 */
@Transactional
public class AdminUserService {
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	/**
	 * @param adminUser
	 * 
	 */
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
