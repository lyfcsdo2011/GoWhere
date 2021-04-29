package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.domain.RouteImg;
import com.web.util.ConnUtil;

public class RouteImgDAO {
	/**
	 * 按线路查询图片
	 * @param rid 线路ID
	 * @return 当前线路的所有图片
	 * @throws SQLException 
	 */
	public List<RouteImg> selectByRoute(int rid) throws SQLException{
		List<RouteImg> routeImgList = new ArrayList<RouteImg>();
		String sql = "SELECT * FROM tab_route_img WHERE rid = ?";
		Connection conn = ConnUtil.getConn();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, rid);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			RouteImg img = new RouteImg();
			img.setRgid(rs.getInt("rgid"));
			img.setRid(rs.getInt("rid"));
			img.setBigPic(rs.getString("bigPic"));
			img.setSmallPic(rs.getString("smallPic"));
			routeImgList.add(img);
		}
		return routeImgList;
	}
}
