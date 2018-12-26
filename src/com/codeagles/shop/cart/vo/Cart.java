/**
 * 
 */
package com.codeagles.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Title: Cart</p>
 * <p>@function:封装购物车，属性</p>
 * @author Codeagles   ,
 * @date 上午8:39:52
 */
public class Cart  implements Serializable{
	//购物项集合 key:商品id value:购物项
	private Map<Integer,CartItem>map = new LinkedHashMap<Integer,CartItem>();
	
	//Cart对象中 有CartItems属性
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	//总计
	private double total;
	
	//要实现的功能
	//1.购物项添加到购物车
	public void addCart(CartItem cartItem){
		//判断购物车中是否已经存在购物项：
		//业务逻辑：
		/*	
		 * 	*如果存在：
		 * 			数量增加
		 * 			总计=总计+购物项小计
		 * *如果不存在：
		 * 			向map中添加购物项
		 * 			总计=总计+购物项小计
		 */
		Integer pid=cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			CartItem _cartItem=map.get(pid);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			map.put(pid, cartItem);
		}
		//设置总计金额
		total+=cartItem.getSubtotal();
	}
	//2.从购物车移除购物项
	public void removeCart(Integer pid){
		//移除单条商品
		CartItem cartItem=map.remove(pid);
		//总计随之变化
		total=total-cartItem.getSubtotal();
	}
	//3.清空购物车
	public void clearCart(){
		//将所有的购物项清空 且 总计金额设为0
		map.clear();
		total=0;
		
	}
	
	public Map<Integer, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
