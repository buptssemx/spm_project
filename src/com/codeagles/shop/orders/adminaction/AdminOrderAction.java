/**
 * 
 */
package com.codeagles.shop.orders.adminaction;

import java.util.List;

import com.codeagles.shop.orders.service.OrderService;
import com.codeagles.shop.orders.vo.Order;
import com.codeagles.shop.orders.vo.OrderItem;
import com.codeagles.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * <p>Title: AdminOrderAction</p>
 * <p>@function:后台订单管理</p>
 * @author Codeagles   ,
 * @date 下午9:50:41
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	private Order order= new Order();
	private OrderService orderService;
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@Override
	public Order getModel() {
		return order;
	}
	//带分页的查询
	public String findAll(){
		PageBean<Order>pageBean=orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	//根据订单id查询订单项
	public String findOrderItem(){
		List<OrderItem>list=orderService.findOrderItem(order.getOid());
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}
	//修改订单状态的方法
	public String updateStates(){
		//根据订单id 查询订单
		Order currOrder=orderService.findByOid(order.getOid());
		//修改订单状态
		currOrder.setState(3);
		orderService.update(currOrder);
		return "updateStates";
	}
}
