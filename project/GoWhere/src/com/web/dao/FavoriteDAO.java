package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.domain.Route;
import com.web.util.ConnUtil;
import com.web.util.DateUtil;
import com.web.util.SQLUtil;
import com.web.vo.SearchVO;
import com.web.vo.SearchVO1;

public class FavoriteDAO {
	
	/**
	 * 查询收藏功能
	 * @param searchVO 多条件
	 * @param page 当前页码
	 * @param recordOfPage 每页记录数量
	 * @return 收藏线程集合
	 * @throws SQLException
	 */
	public List<Route> select(SearchVO searchVO,int page,int recordOfPage) throws SQLException{
		List<Route> routeList = new ArrayList<Route>();
		String sql = "select tab_route.rid,rname,rimage,price,count(*) favorite "
				+ " from tab_favorite  left join tab_route on tab_route.rid = tab_favorite.rid"
				+ SQLUtil.getWhere(searchVO)
				+ " group by tab_route.rid  "
				+ " order by count(*) desc , price asc"
				+ SQLUtil.getLimit(page, recordOfPage);
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
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
	
	public List<Route> selected(SearchVO1 searchVO,int page,int recordOfPage) throws SQLException{
		  List<Route> routeList = new ArrayList<Route>();
		  String sql =  "SELECT * FROM tab_route "
		       + SQLUtil.getWhered(searchVO) + " ORDER BY price asc " + SQLUtil.getLimit(page, recordOfPage);
		  Connection conn = ConnUtil.getConn();
		  PreparedStatement pstat = conn.prepareStatement(sql);
		  ResultSet rs = pstat.executeQuery();
		  while(rs.next()){
		   Route route = new Route();
		   route.setRid(rs.getInt("rid"));
		   route.setRname(rs.getString("rname"));
		   route.setPrice(rs.getDouble("price"));
		   route.setRimage(rs.getString("rimage"));
		   route.setRouteIntroduce(rs.getString("routeIntroduce"));
		   routeList.add(route);
		  }
		  return routeList;
		}
	
	/**
	 * 增加收藏
	 * @param rid 线程编号
	 * @param uid 用户编号
	 * @throws SQLException
	 */
	public void insert(int rid,int uid) throws SQLException{
		String sql = "insert into tab_favorite(rid,date,uid) values(?,?,?)";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, rid);
		pstat.setString(2, DateUtil.getString(new Date()));//系统当前时间
		pstat.setInt(3, uid);
		pstat.executeUpdate();
	}
	
	/**
	 * 取消收藏
	 * @param rid 线程编号
	 * @param uid 用户编号
	 * @throws SQLException
	 */
	public void delete(int rid,int uid) throws SQLException{
		String sql = "delete from tab_favorite where rid = ? and uid = ? ";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, rid);
		pstat.setInt(2, uid);
		pstat.executeUpdate();
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





