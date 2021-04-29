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
	 * ��ѯ�ղع���
	 * @param searchVO ������
	 * @param page ��ǰҳ��
	 * @param recordOfPage ÿҳ��¼����
	 * @return �ղ��̼߳���
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
		//������ʹ�þۺϺ���ʱ����û�з��������£�һ��ֻ��һ����¼����select����ֻ��һ��
		rs.next();
		return rs.getInt(1);
	
	}

	/**
	 * �ж��û��Ƿ��ղ����߳�
	 * @param rid ��·���
	 * @param uid �û����
	 * @return ���ղ�ʱ����true��û�ղ�ʱ����false
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
