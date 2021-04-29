package com.web.service;

import java.sql.SQLException;
import java.util.List;

import com.web.dao.FavoriteDAO;
import com.web.dao.RouteDAO;
import com.web.dao.RouteImgDAO;
import com.web.domain.Route;
import com.web.domain.RouteImg;
import com.web.util.ConnUtil;

import com.web.vo.PageVO;
import com.web.vo.PageVO1;
import com.web.vo.SearchVO;
import com.web.vo.SearchVO1;

public class RouteService {
	private RouteDAO routeDAO = new RouteDAO();
	private static FavoriteDAO favoritedao = new FavoriteDAO();
	private RouteImgDAO routeImgDAO = new RouteImgDAO();
	/**
	 * ��ѯ��·����
	 * @param id
	 * @return
	 */
	public Route findById(int id){
		try {
			Route route = this.routeDAO.selectById(id);
		
			List<RouteImg> routeImgList = this.routeImgDAO.selectByRoute(id);
			route.setRouteImgList(routeImgList);
			return route;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally{
			ConnUtil.closeConn();
		}
	}
	

	public List<Route> findguowai() {
		try {
			List<Route> routeList = routeDAO.selectguowai();
			return routeList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			
	}
	}//�����̲߳�ѯ

public List<Route> findguonei() {
	try {
		List<Route> routeList = routeDAO.selectguonei();
		return routeList;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	} finally {
		
}
}//�����̲߳�ѯ

public List<Route> findPopularity() {
	try {
		List<Route> routeList = routeDAO.selectPopularity();
		return routeList;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	} finally {
		
}
}//�����̲߳�ѯ


public List<Route> findzuixin() {
	try {
		List<Route> routeList = routeDAO.selectzuixin();
		return routeList;
	} catch (SQLException e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	} finally {
		
}
}

public static PageVO1<Route> search(SearchVO1 searchVO, int page, int recordOfPage) {
	   try {
	    PageVO1<Route> pageVO = new PageVO1<>();
	    // ����ܼ�¼����
	    int recordCount = RouteDAO.getRecordCount1(searchVO);
	    // �����ҳ��
	    int pageCount = ((recordCount - 1) / recordOfPage) + 1;
	    // ����һ��ҳ��
	    page = page < 1 ? 1 : page;
	    page = page > pageCount ? pageCount : page;
	    // ��õ�ǰ��Ʒ����
	    List<Route> RouteList = favoritedao.selected(searchVO, page, recordOfPage);

	    //�����ݷ�װ��PageVO
	    pageVO.setPage(page);
	    pageVO.setPageCount(pageCount);
	    pageVO.setRecordCount(recordCount);
	    pageVO.setRecordOfPage(recordOfPage);
	    pageVO.setList(RouteList);
	    return pageVO;
	   } catch (SQLException e) {
	    e.printStackTrace();
	    throw new RuntimeException(e);
	   } finally {
	    ConnUtil.closeConn();
	   }
	  }
	
public PageVO<Route> search(SearchVO searchVO, int page, int recordOfPage) {
	   try {
	    PageVO<Route> pageVO = new PageVO<>();
	    // ����ܼ�¼����
	    int recordCount = RouteDAO.getRecordCount(searchVO);
	    
	    // �����ҳ��
	    int pageCount = ((recordCount - 1) / recordOfPage) + 1;
	    // ����һ��ҳ��
	    page = page < 1 ? 1 : page;
	    page = page > pageCount ? pageCount : page;
	    // ��õ�ǰ��Ʒ����
	    List<Route> RouteList = favoritedao.select(searchVO, page, recordOfPage);

	    //�����ݷ�װ��PageVO
	    pageVO.setPage(page);
	    pageVO.setPageCount(pageCount);
	    pageVO.setRecordCount(recordCount);
	    pageVO.setRecordOfPage(recordOfPage);
	    pageVO.setList(RouteList);
	    return pageVO;
	   } catch (SQLException e) {
	    e.printStackTrace();
	    throw new RuntimeException(e);
	   } finally {
	    ConnUtil.closeConn();
	   }
	  }
	
}
