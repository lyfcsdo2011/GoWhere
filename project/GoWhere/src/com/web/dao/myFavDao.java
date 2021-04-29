package com.web.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.domain.Route;
import com.web.util.ConnUtil;
import com.web.util.myFavSQLUtil;



public class myFavDao {
	
	/**
	 * 查询收藏功能
	 * @param searchVO 多条件
	 * @param page 当前页码
	 * @param recordOfPage 每页记录数量
	 * @return 收藏线程集合
	 * @throws SQLException
	 */
	public static List<Route> select(int Suid, int page,int recordOfPage) throws SQLException {
		List<Route> routeList = new ArrayList<Route>();
		String sql = "select tab_route.rid,rname,rimage,price,count(*) favorite "
				+ " from tab_favorite  left join tab_route on tab_route.rid = tab_favorite.rid"
				+ " where tab_favorite.uid=?"
				+ " group by tab_route.rid  "
				+ " order by count(*) desc , price asc"
				+ myFavSQLUtil.getLimit(page, recordOfPage);
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, Suid);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			Route route = new Route();
			route.setRid(rs.getInt("rid"));
			route.setRname(rs.getString("rname"));
			route.setPrice(rs.getDouble("price"));
			route.setRimage(rs.getString("rimage"));
			route.setFavorite(rs.getInt("favorite"));
			routeList.add(route);
		}
		return routeList;
	}
	
	public static int getRecordCount(int uid) throws SQLException {
		String sql ="SELECT	count(uid) FROM tab_favorite WHERE uid = ?";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, uid);
		ResultSet rs = pstat.executeQuery();
		//当我们使用聚合函数时，在没有分组的情况下，一定只有一条记录并且select后面只有一列
		rs.next();
		return rs.getInt(1);
	
	}

	/**
	 * 判断用户是否收藏了线程
	 * @param rid 线路编号
	 * @param uid 用户编号
	 * @return 当收藏时返回true，没收藏时返回false
	 * @throws SQLException
	 */
	public boolean isFavorite(int rid,int uid) throws SQLException{
		String sql ="SELECT 1 FROM tab_favorite WHERE rid = ? AND uid = ?";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, rid);
		pstat.setInt(2, uid);
		ResultSet rs = pstat.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}

}
