/**
 * 
 */
package com.codeagles.shop.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.codeagles.shop.category.vo.Category;

/**
 * <p>Title: CategoryDao</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date 下午8:08:54
 */
@Transactional
public class CategoryDao extends HibernateDaoSupport {

	/**
	 * @return
	 */
	public List<Category> findAll() {
		// 查询所有一级分类的方法
		String hql="from Category";
		List<Category>list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 *添加一级分类
	 */
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	public Category findByCid(Integer cid) {
		
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	/**
	 * @param category
	 */
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	/**
	 * @param category
	 */
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
		
	}

	
}
