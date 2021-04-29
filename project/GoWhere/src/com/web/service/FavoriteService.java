package com.web.service;

import java.sql.SQLException;

import com.web.dao.FavoriteDAO;
import com.web.util.ConnUtil;

public class FavoriteService {
	private FavoriteDAO favoriteDAO = new FavoriteDAO();
	/**
	 * �����ղ�
	 * @param rid ��·���
	 * @param uid �û����
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
	 * ȡ���ղ�
	 * @param rid ��·���
	 * @param uid �û����
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
	 * �ж��Ƿ����ղ� 
	 * @param rid
	 * @param uid
	 * @return �ղط���true,û�ղط���false;
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
