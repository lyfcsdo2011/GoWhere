package com.web.util;


public class myFavSQLUtil {
	/**
	 * ��̬���ɷ�ҳ���
	 * @param page ��ǰҳ��
	 * @param recordOfPage ÿҳ��¼����
 	 * @return ��ҳlimit�Ӿ�
	 */
	public static String getLimit(int page, int recordOfPage) {
		return "  limit  " + ((page - 1) * recordOfPage) + ", " + recordOfPage;
	}

	/**
	 * ����ѯ������̬����where�Ӿ�ķ���
	 * @param searchVO
	 *            ��ѯ����
	 * @return where�Ӿ�
	 */
//	public static  String getWhere(int Suid) {
//		String sql = " WHERE 1=1 ";
//		if (!"".equals(Suid)) {
//			sql += " AND tab_favorite.uid= Suid ";
//		}
//		
//		return sql;
//	}
}
