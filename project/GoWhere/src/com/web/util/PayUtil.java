package com.web.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;

public class PayUtil {

	private static final String URL = "https://openapi.alipaydev.com/gateway.do";
	private static final String APP_ID = "2021000116668453";
	private static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC2XAu9YYR/a29IXvL+q8XzrDI8sPPQ1Th4/pkvt9gfDxZsN6mcRnEVmgdHAlwnRd8YkFgHvByxPtC4s8LoYe10xZOPzoVWjbUuHdiHGrkIO5vzFIdLzOJI/tgDSNEsjXk76LJ3u07GFU19CT82t7y5pO92Xh3UuMpFzQts3kIcCPAK0v8v1zO6L5PqJR8VYY2aWFLaQJlF8YeeED6N0Z2IhWSCVdT+hzC3ENAVuiDj5B0HNmf+KrkvjmoACBrpvh+IVXqQZac7r5UubRlLo/WCaeyLZosILBbk8Zc+CjhyDN5srvOvF0ywQ443FFPJmMyoFGUgz5ALY7iTEmGCCNwbAgMBAAECggEBAKbwToL48c2fsUkEOtjusRFn8rlimGD1wHPrRprLZxrPugwpTKjWR5Gp5r2XqHr/WMNo6F10VKPhyDs9vND1TObYNESyn5fjtBfalKzhxr+Fqjb19QFsNz7xpRgkofByNqikVjSLkQp+1+f9/hN+UlN0bQ7kC9T/sZQCqFHqiYSVEjatoIcWk6LskzCqAdu54EQ3KzCGqxuAVh2CfkD+/BdFM76q+ReVX+SU3+R6lfrzqLCS308yaZelAlrewZMJqTWilEQFNkKnkpg1+8k4+oGhd3sJqs9yU+1ign/KEI17EIB9EIUMesTAoXQI/tOxrQZHqzM8J61sbHkmP+iG3PkCgYEA3xC0LKtJRzfqyNcIFdMJAweivHfgXVhWsJWls4lRbbe4uhYQ/NLG8DezgvQjR1Ta0ZmlCQ/8/Qg0vAb+zzZgp+lpqS7n2MBNx2jfTCjvrTyzbX8yPfEyhUSlWyUFHNkFjeyFJX2sve2azwNH5tkBm+GLuKg+YirO+eNkLyqh0ZcCgYEA0UjFVV4DopbPLBwonnCN+RWU0KJ7+KdO2r7vepZjosFcMgrQy5SwGE+WbRklpM65IJppb66zCIvEkYiapDH/HAuCXg2vYS/gt36XQuVd5clug/GuC1AoGniF5ClixqkNiS1YtWE7hM8HDkR1l5yBu523g9ltT504rP87Uuq0kh0CgYBGh8+QeDBZVnLkQimKTQoCbT2lffnxSedPOmIEXJzkpjzAig2hAzxn5BTciTlGaqwtrfki3m1NzHRwJ34WIsl5DjKcjfo87MErFhvUxvTRv+mz644FS+h/fu8R3Ki7MFuzPl/zNMOT4jca0ZzAf0kk8rHtFzVycLq1BJM+3qn/zQKBgENYWG/FBgRu5RG7qfJ6I6VwpWeRsbTtGbnYUTWwaTV5ZVKRGmk4WoYoLi7DNdLX1sjAB4exvtjUKRfvzlth30bGCVh8rN/oSTai3MfhCRsle5On1Kq9S3phKCyoiKmGwt1Oo0oSlNWCzTFxJCn6aeDWurQJ5lwFKrS4mP1wm1SdAoGAeuhZRg/Qnz6RS1jWlfJvHkiGzGucL+2PUS3Rk7BaHdFw38sne269DnbuY7nIOZLqHxsVYtqRigj67TVP16wIyNo+HxREkK1V4aDfmQGJeKvXgD/7wvrv6PicUhXcY8RnM5JkM9J3rAjURXegnfXIOsmYG0/4AjIt5BW6pYqmNRE=";
	private static final String CHARSET = "utf-8";
	private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlJQlZCpkMrcelVRUlcaDC3JMOgE3D8iOSJL5H0XNgE7wioHvfxRrMyrGEk6ZFe13fJtjrOgVOV6NECtTbz/BZHMjirnre+FpXcdOo2/ioarAcmzTaiKdSBsadypK/bl/B3ahyyCmI8Pyx5kbfS6GegPdyH2fqeP7VjIak5TFITuonOXEUgXzHXFvpfXSPtyob+tOlpICEdC3DfatPDJaCULupqD7ygq4RJ3aFnKGWaB0fgSvWa5VvkJwlDNFeQhjBs0YgAVthu/pCHC4AaahFY740dZxdZzZrVnxAkJ5QlTDZ8nDvK3iHCveu7AULWAuUaLKre5yK2HqdCzKLNTgKQIDAQAB";
	private static final String returnURL = "http://localhost:9527/training-web/result.do";
	private static final String notifyURL = "http://localhost:9527/training-web/result.do";
	// 获得初始化的AlipayClient
	public static AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, "json", CHARSET,
			ALIPAY_PUBLIC_KEY, "RSA2");

	/**
	 * 创建收款单
	 * 
	 * @param orderNo
	 *            商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 * @param orderSubject
	 *            订单标题 256个字符以内
	 * @param totalAmount
	 *            订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * @param orderDesp
	 *            对交易或商品的描述 128个字符以内
	 * @param TradeGoodsDetail
	 *            商品明细说明
	 * @param notifyURL
	 *            支付结果异步通知地址URL
	 */
	public static TradePreCreateResp tradePrecreateRequest(String orderNo, String orderSubject, Double totalAmount,
			String orderDesp, List<TradeGoodsDetail> goodsList, String notifyURL) {

		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

		AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
		model.setOutTradeNo(orderNo);
		model.setTotalAmount(new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		model.setSubject(orderSubject);
		model.setBody(orderDesp);
		model.setQrCodeTimeoutExpress("1m");
		model.setTimeoutExpress("1m");

		try {

			if (!Objects.isNull(goodsList)) {
				List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();

				for (TradeGoodsDetail detail : goodsList) {
					GoodsDetail goods = new GoodsDetail();

					PropertyUtils.copyProperties(goods, detail);

					goodsDetailList.add(goods);
				}

				model.setGoodsDetail(goodsDetailList);
			}

			request.setBizModel(model);
			request.setNotifyUrl(notifyURL);

			AlipayTradePrecreateResponse response = alipayClient.execute(request);

			if (response.isSuccess()) {
				TradePreCreateResp resp = new TradePreCreateResp();
				BeanUtils.copyProperties(resp,response);

				return resp;
			}

			throw new RuntimeException("error");

		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}

	}

	public static String genUUID(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-","");
	}

	public static String getUrl() {
		return URL;
	}

	public static String getAppId() {
		return APP_ID;
	}

	public static String getReturnURL() {
		return returnURL;
	}

	public static String getAppPrivateKey() {
		return APP_PRIVATE_KEY;
	}

	public static String getCharset() {
		return CHARSET;
	}

	public static String getAlipayPublicKey() {
		return ALIPAY_PUBLIC_KEY;
	}

	public static String getNotifyurl() {
		return notifyURL;
	}
	
	
	
}
