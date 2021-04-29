package com.web.util;


public class myFavSQLUtil {
	/**
	 * 动态生成分页语句
	 * @param page 当前页码
	 * @param recordOfPage 每页记录数量
 	 * @return 分页limit子句
	 */
	public static String getLimit(int page, int recordOfPage) {
		return "  limit  " + ((page - 1) * recordOfPage) + ", " + recordOfPage;
	}

	/**
	 * 按查询条件动态生成where子句的方法
	 * @param searchVO
	 *            查询条件
	 * @return where子句
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
