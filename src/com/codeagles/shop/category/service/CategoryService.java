/**
 * 
 */
package com.codeagles.shop.category.service;

import java.util.List;

import com.codeagles.shop.category.dao.CategoryDao;
import com.codeagles.shop.category.vo.Category;

/**
 * <p>Title: CategoryService</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date 下午8:08:11
 */
public class CategoryService {
	private CategoryDao categoryDao;

	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * 查询所有一级分类的方法实现
	 */
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}

	/**
	 * 添加一级分类的方法
	 */
	public void save(Category category) {
		categoryDao.save(category);
		
	}



	/**
	 * @param cid
	 * @return
	 */
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	/**
	 * @param category
	 */
	public void delete(Category category) {
		categoryDao.delete(category);
		
	}

	/**
	 * @param category
	 */
	public void update(Category category) {
		categoryDao.update(category);
	}


	
}
