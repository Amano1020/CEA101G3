package com.shop_order.model;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.shop_order_detail.model.ShopOrderDetailVO;

public class ShopOrderVO implements java.io.Serializable {
	private String shop_order_id;
	private String mem_id;
	private String payment;
	private Date time;
	private Float shop_total_amount;
	private Integer status;
	
	private Set<ShopOrderDetailVO> shopOrderDetails = new HashSet<ShopOrderDetailVO>();

	public String getShop_order_id() {
		return shop_order_id;
	}

	public void setShop_order_id(String shop_order_id) {
		this.shop_order_id = shop_order_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Float getShop_total_amount() {
		return shop_total_amount;
	}

	public void setShop_total_amount(Float i) {
		this.shop_total_amount = i;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<ShopOrderDetailVO> getShopOrderDetails() {
		return shopOrderDetails;
	}

	public void setShopOrderDetails(Set<ShopOrderDetailVO> shopOrderDetails) {
		this.shopOrderDetails = shopOrderDetails;
	}	
	
	
}
