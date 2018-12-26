/**
 * 
 */
package com.codeagles.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.codeagles.shop.categorysecond.dao.CategorySecondDao;
import com.codeagles.shop.categorysecond.vo.CategorySecond;
import com.codeagles.shop.product.vo.Product;
import com.codeagles.util.PageBean;

/**
 * <p>Title: CategorySecondService</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date 下午9:16:50
 */
@Transactional
public class CategorySecondService {
	private CategorySecondDao categorySecondDao= new CategorySecondDao();

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	/**
	 * @param page
	 * @return
	 */
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean=new PageBean<CategorySecond>();
		//设置当前页数
			pageBean.setPage(page);
			//设置每页的记录数
			int limit =10;
			pageBean.setLimit(limit);
			//设置总记录数
			int totalCount=0;
			totalCount = categorySecondDao.findCountCid();
			pageBean.setTotalCount(totalCount);
			//设置总页数
			int totalPage=0;
//				Math.ceil(totalCount/limit);
			if(totalCount%limit==0){
				totalPage=totalCount/limit;
			}else{
				totalPage=totalCount/limit+1;
			}
			pageBean.setTotalPage(totalPage);
			//每页显示的数据集合
			int begin=(page-1)*limit;
			List<CategorySecond>list=categorySecondDao.findByPageCid(begin,limit);
			pageBean.setList(list);
			return pageBean;
	}

	/**
	 * @param categorySecond
	 */
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
		
	}

	/**
	 * @param csid
	 * @return
	 */
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	/**
	 * @param categorySecond
	 */
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	/**
	 * @param categorySecond
	 */
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
		
	}

	/**
	 * 查询二级分类的方法
	 */
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
	
}
