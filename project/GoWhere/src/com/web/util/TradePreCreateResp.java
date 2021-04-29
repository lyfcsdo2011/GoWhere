package com.web.util;

import java.io.Serializable;

public class TradePreCreateResp implements Serializable {

	private static final long serialVersionUID = 1L;

	// �̻��Ķ�����
	private String outTradeNo;

	// Ԥ�µ��������ɵĶ�ά���봮�������ö�ά�����ɹ��߸��ݸ��봮ֵ���ɶ�Ӧ�Ķ�ά��	
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
