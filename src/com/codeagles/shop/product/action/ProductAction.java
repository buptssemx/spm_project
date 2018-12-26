/**
 * 
 */
package com.codeagles.shop.product.action;

import com.codeagles.shop.product.service.ProductService;
import com.codeagles.shop.product.vo.Product;
import com.codeagles.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * <p>Title: ProductAction</p>
 * <p>@function:</p>
 * @author Codeagles   ,
 * @date 上午8:47:40
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product> {
	private Product product = new Product();
	private Integer cid;
	private int page=1;//接收当前页数
	private Integer csid;
	
	
	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public Product getModel() {
		return product;
	}
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//根据商品ID查询商品
	public String findByPid(){
		product=productService.findByPid(product.getPid());
		return "findByPid";
	}
	//根据分类的id查询商品
	public String findByCid(){
		PageBean<Product> pageBean=productService.findByPageCid(cid,page);
		//将pageBean存入值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}
	//根据csid查询商品
	public String findByCsid(){
		PageBean<Product> pageBean=productService.findByPageCsid(csid,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
}
