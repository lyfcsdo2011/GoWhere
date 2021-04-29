package com.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 
	 * @param date���ڶ���
	 * @return ���ڶ�����ַ�����ʽ
	 */
	public static String getString(Date date) {
		return sdf.format(date);
	}
	/**
	 * 
	 * @param str �����ַ�����ʽ
	 * @return ���ڶ���
	 * @throws ParseException�������ִ����׳��쳣
	 */
	public static Date getDate(String str) throws ParseException {
		return sdf.parse(str);
	}

}
