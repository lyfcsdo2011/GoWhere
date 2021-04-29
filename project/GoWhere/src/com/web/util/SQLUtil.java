package com.web.util;

import com.web.vo.SearchVO;
import com.web.vo.SearchVO1;

public class SQLUtil {
	
	public static String getLimit(int page, int recordOfPage) {
		  return "  limit  " + ((page - 1) * recordOfPage) + ", " + recordOfPage;
		 }
	
	public static String getWhere(SearchVO searchVO) {
		String sql = " WHERE 1=1 ";
		if (searchVO.getRouteName() != null && !"".equals(searchVO.getRouteName())) {
			sql += " AND rname like '%" + searchVO.getRouteName() + "%' ";
		}
		if (searchVO.getMinRoutePrice() != null) {
			sql += " AND price >= " + searchVO.getMinRoutePrice();
		}
		if (searchVO.getMaxRoutePrice() != null) {
			sql += " AND price <= " + searchVO.getMaxRoutePrice();
		}

		return sql;
	}
	
	public static String getWhered(SearchVO1 searchVO) {
		   String sql = " WHERE 1=1 ";
		   System.out.println(searchVO.getRname());
		   if (searchVO.getRname() != null && !"".equals(searchVO.getRname())) {
		    sql += " AND rname like '%" + searchVO.getRname() + "%' ";
		   }
		   
		   return sql;
		  }

}