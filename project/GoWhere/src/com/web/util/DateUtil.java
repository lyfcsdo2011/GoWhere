package com.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 
	 * @param date日期对象
	 * @return 日期对象的字符串形式
	 */
	public static String getString(Date date) {
		return sdf.format(date);
	}
	/**
	 * 
	 * @param str 日期字符串形式
	 * @return 日期对象
	 * @throws ParseException解析出现错误抛出异常
	 */
	public static Date getDate(String str) throws ParseException {
		return sdf.parse(str);
	}

}
