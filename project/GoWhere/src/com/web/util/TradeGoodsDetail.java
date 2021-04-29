package com.web.util;

import java.io.Serializable;

public class TradeGoodsDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	// ��Ʒ�ı��,����
	private String goodsId;
	// ֧���������ͳһ��Ʒ���,��ѡ
	private String alipayGoodsId;
	// ��Ʒ���� ,����
	private String goodsName;
	// ��Ʒ���� ,����
	private Long quantity;
	// ��Ʒ���ۣ���λΪԪ ,����
	private Double price;
	// ��Ʒ��Ŀ ,��ѡ
	private String goodsCategory;
	// ��Ʒ������Ϣ ,��ѡ
	private String body;
	// ��Ʒ��չʾ��ַ ,��ѡ
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
