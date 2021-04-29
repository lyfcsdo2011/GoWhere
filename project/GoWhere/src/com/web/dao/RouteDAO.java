package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.domain.Route;
import com.web.util.ConnUtil;
import com.web.util.SQLUtil;
import com.web.vo.SearchVO;
import com.web.vo.SearchVO1;

public class RouteDAO {
	
	public List<Route> select(String rname,int page,int recordOfPage) throws SQLException{
		List<Route> routeList = new ArrayList<Route>();
		String sql = "SELECT * FROM tab_route where rname like ? ";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, "%"+rname+"%");
		ResultSet rs = pstat.executeQuery();
		
		return routeList;
	}
	
	//人气线程查询
	public List<Route> selectPopularity() throws SQLException {
		List<Route> routeList = new ArrayList<Route>();
		String sql = "select tab_route.rid,rname,rimage,price "
				+ " from tab_route  left join tab_favorite on tab_route.rid = tab_favorite.rid"
				+ " group by tab_route.rid "
				+ " order by count(*) desc , price asc " 
				+ SQLUtil.getLimit(1, 4);
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Route route = new Route();
			route.setRid(rs.getInt("rid"));
			route.setRname(rs.getString("rname"));
			route.setPrice(rs.getDouble("price"));
			route.setRimage(rs.getString("rimage"));
			routeList.add(route);
		}
		return routeList;
	}
	
	//国外线程查询
	public List<Route> selectguowai() throws SQLException {
		List<Route> routeList = new ArrayList<Route>();
		String sql = "select *from tab_route where cid=5 ORDER BY price DESC"
				+ SQLUtil.getLimit(1, 6);
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Route route = new Route();
			route.setRid(rs.getInt("rid"));
			route.setRname(rs.getString("rname"));
			route.setPrice(rs.getDouble("price"));
			route.setRimage(rs.getString("rimage"));
			routeList.add(route);
		}
		return routeList;
	}
	
	//国内线程查询
	public List<Route> selectguonei() throws SQLException {
		List<Route> routeList = new ArrayList<Route>();
		String sql ="select *from tab_route where cid=4 ORDER BY price DESC " 
				+ SQLUtil.getLimit(1, 6);
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Route route = new Route();
			route.setRid(rs.getInt("rid"));
			route.setRname(rs.getString("rname"));
			route.setPrice(rs.getDouble("price"));
			route.setRimage(rs.getString("rimage"));
			routeList.add(route);
		}
		return routeList;
	}
	
	//最新线程查询
	public List<Route> selectzuixin() throws SQLException {
		List<Route> routeList = new ArrayList<Route>();
		String sql ="SELECT * from tab_route  ORDER BY rdate ASC " 
				+ SQLUtil.getLimit(1, 4);
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Route route = new Route();
			route.setRid(rs.getInt("rid"));
			route.setRname(rs.getString("rname"));
			route.setPrice(rs.getDouble("price"));
			route.setRimage(rs.getString("rimage"));
			routeList.add(route);
		}
		return routeList;
	}
	
	public Route selectById(int id) throws SQLException {
		String sql = "SELECT tab_route.rid , rname , price ,  rimage ,routeIntroduce,count(*) AS favorite "
				+ " FROM tab_route left join tab_favorite "
				+ " on tab_route.rid = tab_favorite.rid "
				+ " WHERE tab_route.rid = ? "
				+ " group by tab_route.rid ";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, id);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			Route route = new Route();
			route.setRid(rs.getInt("rid"));
			route.setRname(rs.getString("rname"));
			route.setPrice(rs.getDouble("price"));
			route.setRimage(rs.getString("rimage"));
			route.setFavorite(rs.getInt("favorite"));
			route.setRouteIntroduce(rs.getString("routeIntroduce"));
			return route;
		} else {
			return null;
		}
	}
	
	public static int getRecordCount1(SearchVO1 searchVO) throws SQLException {
	    String sql = "select count(*) from tab_route " + SQLUtil.getWhered(searchVO);
	    Connection conn = ConnUtil.getConn();
	    PreparedStatement pstat = conn.prepareStatement(sql);
	    System.out.println(pstat);
	    ResultSet rs = pstat.executeQuery();
	    //当我们使用聚合函数时，在没有分组的情况下，一定只有一条记录。
	    //并且。select 后面只有一列。
	    rs.next();
	    return rs.getInt(1);
	   }
	public static int getRecordCount(SearchVO searchVO) throws SQLException {
	    String sql = "select count(*) from tab_route " + SQLUtil.getWhere(searchVO);
	    Connection conn = ConnUtil.getConn();
	    PreparedStatement pstat = conn.prepareStatement(sql);
	    System.out.println(pstat);
	    ResultSet rs = pstat.executeQuery();
	    //当我们使用聚合函数时，在没有分组的情况下，一定只有一条记录。
	    //并且。select 后面只有一列。
	    rs.next();
	    return rs.getInt(1);
	   }
	
	
}

