/**
 * 
 */
package com.codeagles.shop.cart.vo;

import com.codeagles.shop.product.vo.Product;

/**
 * <p>Title: CartItem</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date 上午8:39:46
 */
public class CartItem {
	private Product product;
	private int count;//数量
	private double subtotal; //小计 金额
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return count*product.getShop_price();
	}
//	public void setSubtotal(double subtotal) {
//		this.subtotal = subtotal;
//	}

}
