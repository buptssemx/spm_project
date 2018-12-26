/**
 * 
 */
package com.codeagles.shop.orders.dao;

import java.util.List;

import org.aspectj.weaver.ast.Or;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.codeagles.shop.orders.vo.Order;
import com.codeagles.shop.orders.vo.OrderItem;
import com.codeagles.util.PageHibernateCallback;

/**
 * <p>
 * Title: OrderDao
 * </p>
 * <p>
 * @function:
 * </p>
 * 
 * @author Codeagles ,
 * @date 下午7:42:08
 */
public class OrderDao extends HibernateDaoSupport {

	/**
	 * order订单操作保存
	 */
	public void save(Order order) {
		this.getHibernateTemplate().save(order);

	}

	/**
	 * @param uid
	 *            我的订单：通过UID查询总记录数
	 */
	public Integer findByCountUid(int uid) {
		String hql = "select count(*) from Order o where o.user.uid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	// 我的订单的查询
	public List<Order> findByPageUid(int uid, Integer begin, int limit) {
		String hql = "from Order o where o.user.uid=? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, new Object[] { uid },
						begin, limit));

		return list;
	}

	/**
	 * @param oid
	 * @return
	 */
	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	/**
	 * @param ourrOrder
	 */
	public void update(Order ourrOrder) {
		this.getHibernateTemplate().update(ourrOrder);

	}

	/**
	 * 查询订单总数
	 */
	public Integer findByCount() {
		String hql = "select count(*) from Order ";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 查询订单的集合
	 */
	public List<Order> findByPage(Integer begin, int limit) {
		String hql="from Order order by ordertime desc";
		List<Order>list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

	/**
	 * 根据订单id 查询订单项的方法
	 */
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql="from OrderItem oi where oi.order.oid =?";
		List<OrderItem> list=this.getHibernateTemplate().find(hql,oid);
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}

}
