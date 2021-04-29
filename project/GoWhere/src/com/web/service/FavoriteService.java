package com.web.service;

import java.sql.SQLException;

import com.web.dao.FavoriteDAO;
import com.web.util.ConnUtil;

public class FavoriteService {
	private FavoriteDAO favoriteDAO = new FavoriteDAO();
	/**
	 * 增加收藏
	 * @param rid 线路编号
	 * @param uid 用户编号
	 */
	public void addFavorite(int rid,int uid){
		try {
			ConnUtil.getConn().setAutoCommit(false);
			this.favoriteDAO.insert(rid, uid);
			ConnUtil.getConn().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ConnUtil.getConn().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		} finally{
			ConnUtil.closeConn();
		}
	}
	
	/**
	 * 取消收藏
	 * @param rid 线路编号
	 * @param uid 用户编号
	 */
	public void delFavorite(int rid,int uid){
		try {
			ConnUtil.getConn().setAutoCommit(false);
			this.favoriteDAO.delete(rid, uid);
			ConnUtil.getConn().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ConnUtil.getConn().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		} finally{
			ConnUtil.closeConn();
		}
	}
	
	/**
	 * 判断是否有收藏 
	 * @param rid
	 * @param uid
	 * @return 收藏返回true,没收藏返回false;
	 */
	public boolean isFavorite(int rid,int uid){
		try {
			return this.favoriteDAO.isFavorite(rid, uid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnUtil.closeConn();
		}
		
	}
}
