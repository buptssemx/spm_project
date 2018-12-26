/**
 * 
 */
package com.codeagles.shop.product.service;

import java.util.List;

import com.codeagles.shop.product.dao.ProductDao;
import com.codeagles.shop.product.vo.Product;
import com.codeagles.util.PageBean;

/**
 * <p>
 * Title: ProductService
 * </p>
 * <p>
 * @function:
 * </p>
 * 
 * @author Codeagles ,
 * @date 上午8:48:01
 */
public class ProductService {
	// 注入Dao
	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	/**
	 * 首页的热门商品查询
	 */
	public List<Product> findHot() {
		return productDao.findHot();
	}

	/**
	 * 查询最新商品
	 */
	public List<Product> findNewProduct() {
		return productDao.findNewProduct();
	}

	/**
	 * @param pid
	 *            根据商品的Id查询商品
	 */
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	/**
	 * @param cid
	 * @param page
	 *            查询一级分类的cid带有分页查询的商品
	 */
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页的记录数
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		// Math.ceil(totalCount/limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * @param csid
	 * @param page
	 *            查询二级分类商品
	 */
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页的记录数
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		// Math.ceil(totalCount/limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * @param page
	 * @return
	 */
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = 0;
		totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		// Math.ceil(totalCount/limit);
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 保存商品
	 */
	public void save(Product product) {
		productDao.save(product);
		
	}

	/**
	 * 删除商品
	 */
	public void delete(Product product) {
		productDao.delete(product);
		
	}

	/**
	 * 修改
	 */
	public void update(Product product) {
		productDao.update(product);
		
	}

}
