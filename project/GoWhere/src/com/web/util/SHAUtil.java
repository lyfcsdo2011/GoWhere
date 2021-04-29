package com.web.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA256��֤��
 * 
 * @author 41619
 *
 */
public class SHAUtil {
	/**
	 * ����javaԭ������ʵ��SHA256����
	 *
	 * @param str
	 *            ����ƴ�ӵ��ַ���
	 * @return
	 */
	public static String getSHA256(String str) {
		MessageDigest messageDigest;
		String encodeStr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodeStr = bytesToHexString(messageDigest.digest());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

	/**
	 * ���ֽ�����ת����16�����ַ���
	 * 
	 * @param bytes
	 *            ����ת��������
	 * @return 16�����ַ���
	 */
	private static String bytesToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer(bytes.length);
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(0xFF & bytes[i]);
			if (temp.length() < 2) {
				sb.append(0);
			}
			sb.append(temp);
		}
		return sb.toString();
	}
}
