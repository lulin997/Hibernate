package com.wangqingbo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 订单
 * @author oracle
 *
 */
public class Torder {

	// id
	private String id;
	// 订单日期
	private Date orderTime;
	// 购买日期
	private Date shopperTime;
	// 总价
	private Double total;
	// 配置一对多的关系，和配置文件中set标签的name对应
	private Set<TorderLine> torderLines;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getShopperTime() {
		return shopperTime;
	}
	public void setShopperTime(Date shopperTime) {
		this.shopperTime = shopperTime;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Set<TorderLine> getTorderLines() {
		return torderLines;
	}
	public void setTorderLines(Set<TorderLine> torderLines) {
		this.torderLines = torderLines;
	}
	
	
	
	
}
