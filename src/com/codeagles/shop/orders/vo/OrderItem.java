/**
 * 
 */
package com.codeagles.shop.orders.vo;

import com.codeagles.shop.product.vo.Product;

/**
 * <p>
 * Title: OrderItem
 * </p>
 * <p>
 * @function:
 * </p>
 * 
 * @author Codeagles ,
 * @date 下午3:51:50
 */
public class OrderItem {
	private Integer itemid;
	private Integer count;
	private Double subtotal;

		/*
		 * 订单项表中的 产品id，订单id
		 */
		// 产品 pid
		// 订单 oid
	private Product product;
	private Order order;
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

}
