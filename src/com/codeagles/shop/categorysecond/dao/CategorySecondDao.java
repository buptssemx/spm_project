/**
 * 
 */
package com.codeagles.shop.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.codeagles.shop.categorysecond.vo.CategorySecond;
import com.codeagles.util.PageHibernateCallback;

/**
 * <p>Title: CategorySecondService</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date 下午9:16:41
 */
public class CategorySecondDao extends HibernateDaoSupport{
	//查询总数
	public int findCountCid() {
		String hql="select count(*) from CategorySecond";
		List<Long>list=this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//查询二级集合
	public List<CategorySecond> findByPageCid(int begin, int limit) {
		String hql="from CategorySecond order by csid desc";
		List<CategorySecond>list=this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, null, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
		
	}

	/**
	 * @param csid
	 * @return
	 */
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	/**
	 * @param categorySecond
	 */
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
		
	}

	/**
	 * @param categorySecond
	 */
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}

	/**
	 * 查询二级分类的方法
	 */
	public List<CategorySecond> findAll() {
		String hql="from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}

}
