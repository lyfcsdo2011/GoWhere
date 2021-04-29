package com.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilToPay {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/**
	 * Date ---> String
	 * @param date 日期对象
	 * @return 日期对象的字符串形式
	 */
	public static String getString(Date date) {
		return sdf.format(date);
	}
	/**
	 * String ---> Date
	 * @param str 日期对象字符串形式
	 * @return 日期对象
	 * @throws ParseException 解析出现错误时抛出的异常
	 */
	public static Date getDate(String str) throws ParseException {
		return sdf.parse(str);
	}
}
