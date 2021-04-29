package com.web.domain;

import java.util.Date;

public class Order {
	private int oid;
	private String orderNumber;
	private int num;
	private int uid;
	private int rid;
	private double price;
	private double discount;
	
	private double amount;
	private int status;
	private Date createDate;
	private Date payDate;
	private Date updateDate;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", orderNumber=" + orderNumber + ", num=" + num + ", uid=" + uid + ", rid=" + rid
				+ ", price=" + price + ", discount=" + discount + ", amount=" + amount + ", status=" + status
				+ ", createDate=" + createDate + ", payDate=" + payDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
