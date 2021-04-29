package com.web.util;

import java.io.Serializable;

public class TradeGoodsDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	// 商品的编号,必填
	private String goodsId;
	// 支付宝定义的统一商品编号,可选
	private String alipayGoodsId;
	// 商品名称 ,必填
	private String goodsName;
	// 商品数量 ,必填
	private Long quantity;
	// 商品单价，单位为元 ,必填
	private Double price;
	// 商品类目 ,可选
	private String goodsCategory;
	// 商品描述信息 ,可选
	private String body;
	// 商品的展示地址 ,可选
	private String showUrl;

	public TradeGoodsDetail() {

	}

	public TradeGoodsDetail(String goodsId, String goodsName, Long goodsQuantity, Double goodsPrice) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.quantity = goodsQuantity;
		this.price = goodsPrice;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getAlipayGoodsId() {
		return alipayGoodsId;
	}

	public void setAlipayGoodsId(String alipayGoodsId) {
		this.alipayGoodsId = alipayGoodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getShowUrl() {
		return showUrl;
	}

	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}

}
