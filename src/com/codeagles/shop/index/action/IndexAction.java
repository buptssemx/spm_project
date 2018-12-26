/**
 * 
 */
package com.codeagles.shop.index.action;

import java.util.List;

import com.codeagles.shop.category.service.CategoryService;
import com.codeagles.shop.category.vo.Category;
import com.codeagles.shop.product.dao.ProductDao;
import com.codeagles.shop.product.service.ProductService;
import com.codeagles.shop.product.vo.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: IndexAction</p>
 * <p>@function:首页访问的action</p>
 * @author Codeagles   ,
 * @date 上午10:39:44
 */
public class IndexAction extends ActionSupport{
	private CategoryService categoryService;
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public String execute() throws Exception {
		List<Category>clist=categoryService.findAll();
		//存放到session的范围
		ActionContext.getContext().getSession().put("clist", clist);
		//查询热门商品
		List<Product> hlist=productService.findHot();
		ActionContext.getContext().getValueStack().set("hlist", hlist);
		List<Product> nlist=productService.findNewProduct();
		ActionContext.getContext().getValueStack().set("nlist", nlist);
		return "index";
	}
}
