/**
 * 
 */
package com.codeagles.shop.adminUser.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.codeagles.shop.adminUser.vo.AdminUser;

/**
 * <p>Title: AdminUserDao</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date обнГ7:49:06
 */
public class AdminUserDao extends HibernateDaoSupport {

	public AdminUser login(AdminUser adminUser) {
		String hql="from AdminUser where username=? and password=?";
		List<AdminUser>list=this.getHibernateTemplate().find(hql,adminUser.getUsername(),adminUser.getPassword());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
