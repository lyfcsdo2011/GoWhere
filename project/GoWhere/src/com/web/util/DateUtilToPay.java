package com.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilToPay {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/**
	 * Date ---> String
	 * @param date ���ڶ���
	 * @return ���ڶ�����ַ�����ʽ
	 */
	public static String getString(Date date) {
		return sdf.format(date);
	}
	/**
	 * String ---> Date
	 * @param str ���ڶ����ַ�����ʽ
	 * @return ���ڶ���
	 * @throws ParseException �������ִ���ʱ�׳����쳣
	 */
	public static Date getDate(String str) throws ParseException {
		return sdf.parse(str);
	}
}
