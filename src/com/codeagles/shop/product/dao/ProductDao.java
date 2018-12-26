/**
 * 
 */
package com.codeagles.shop.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.codeagles.shop.product.vo.Product;
import com.codeagles.util.PageHibernateCallback;

/**
 * <p>
 * Title: ProductDao
 * </p>
 * <p>
 * @function:
 * </p>
 * 
 * @author Codeagles ,
 * @date 上午8:47:51
 */
@Transactional
public class ProductDao extends HibernateDaoSupport {

	/**
	 * 首页上的热门商品查询
	 */
	public List<Product> findHot() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 查询热门商品 0不热，1为热门
		criteria.add(Restrictions.eq("is_hot", 1));
		// 倒序排序显示
		criteria.addOrder(Order.desc("pdate"));
		// 查询
		List<Product> hlist = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return hlist;
	}

	/**
	 * 查询最新商品
	 */
	public List<Product> findNewProduct() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		// 倒序排序显示 按日期显示
		criteria.addOrder(Order.desc("pdate"));
		// 查询
		List<Product> nlist = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return nlist;
	}

	/**
	 * @param pid
	 * @return
	 */
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);

	}

	/**
	 * @param cid
	 *            根据分类id查询商品个数 根据二级分类查询商品个数
	 */
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, cid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * @param cid
	 * @param begin
	 * @param limit
	 *            根据分类id查询商品个数 根据二级分类查询商品信息
	 */
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		// String sql="select * from category c,categorysecond cs,product p "
		// + "where c.cid=cs.cid and p.csid=cs.csid and c.cid=1";
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		// String hql =
		// "select p from Product p join p.categorySecond cs where cs.csid = ?";
		// 分页非离线条件查询：
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, new Object[] { cid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * @param csid
	 *            根据二级分类查询商品个数
	 */
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * @param csid
	 * @param begin
	 * @param limit
	 *            根据二级分类查询商品信息
	 */
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid=?";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, new Object[] { csid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return list;
	}

	/**
	 * 统计所有商品个数
	 */
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 带分页的查询
	 */
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql,null,
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return list;
	}

	/**
	 * 保存商品
	 */
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	/**
	 * 删除删除商品
	 */
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	/**
	 * 修改
	 */
	public void update(Product product) {
		this.getHibernateTemplate().update(product);
	}

}
