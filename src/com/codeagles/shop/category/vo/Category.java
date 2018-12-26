/**
 * 
 */
package com.codeagles.shop.category.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.codeagles.shop.categorysecond.vo.CategorySecond;

/**
 * <p>Title: Category</p>
 * <p>@function:一级分类的实体类</p>
 * @author Codeagles   ,
 * @date 下午8:04:38
 */
public class Category  implements Serializable {
	private Integer cid;
	private String cname;
	//一级分类中存放 二级集合
	private Set<CategorySecond> categorySeconds =new HashSet<CategorySecond>();
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
