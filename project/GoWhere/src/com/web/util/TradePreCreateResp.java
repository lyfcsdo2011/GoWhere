package com.web.util;

import java.io.Serializable;

public class TradePreCreateResp implements Serializable {

	private static final long serialVersionUID = 1L;

	// 商户的订单号
	private String outTradeNo;

	// 预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码	
	private String qrCode;

	public TradePreCreateResp() {

	}

	public TradePreCreateResp(String tradeNo, String qrCode) {
		this.outTradeNo = tradeNo;
		this.qrCode = qrCode;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

}
