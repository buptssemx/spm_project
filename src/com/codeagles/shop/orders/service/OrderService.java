/**
 * 
 */
package com.codeagles.shop.orders.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.codeagles.shop.orders.dao.OrderDao;
import com.codeagles.shop.orders.vo.Order;
import com.codeagles.shop.orders.vo.OrderItem;
import com.codeagles.util.PageBean;

/**
 * <p>
 * Title: OrderService
 * </p>
 * <p>
 * @function:
 * </p>
 * 
 * @author Codeagles ,
 * @date 下午7:42:15
 */
@Transactional
public class OrderService {
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 * 生成订单的方法
	 */
	public void save(Order order) {
		orderDao.save(order);
	}

	/**
	 * @param uid
	 * @param page
	 *            我的订单的业务成代码
	 */
	public PageBean<Order> findByPageUid(int uid, Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);

		int limit = 4;
		pageBean.setLimit(limit);
		Integer totalCount = null;

		totalCount = orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);

		Integer totalPage = null;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		Integer begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPageUid(uid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * @param oid
	 *            根据订单id 查询订单
	 */
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	/**
	 * @param ourrOrder
	 */
	public void update(Order ourrOrder) {
		orderDao.update(ourrOrder);

	}

	/**
	 * 分页查询订单的方法
	 */
	public PageBean<Order> findByPage(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);

		int limit = 10;
		pageBean.setLimit(limit);
		Integer totalCount = null;

		totalCount = orderDao.findByCount();
		pageBean.setTotalCount(totalCount);

		Integer totalPage = null;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		Integer begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPage( begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 根据订单ID查询订单项的方法
	 */
	public List<OrderItem> findOrderItem(Integer oid) {
		
		return orderDao.findOrderItem(oid);
	}

}
