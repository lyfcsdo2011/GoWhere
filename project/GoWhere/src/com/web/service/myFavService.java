package com.web.service;

import java.sql.SQLException;
import java.util.List;

import com.web.dao.myFavDao;
import com.web.domain.Route;
import com.web.util.ConnUtil;
import com.web.vo.PageVO;



public class myFavService {
	public PageVO<Route> select(int uid,int page,int recordOfPage){
		try {
			PageVO<Route> pageVO =new PageVO<>();
			int recordCount=myFavDao.getRecordCount(uid);
			int pageCount =((recordCount-1)/recordOfPage)+1;
			page=page<1?1:page;
			page=page>pageCount?pageCount:page;
			
			 List<Route>routeList=myFavDao.select(uid,page,recordOfPage);
			 
			pageVO.setPage(page);
			pageVO.setPageCount(pageCount);
			pageVO.setRecordCount(recordCount);
			pageVO.setRecordOfPage(recordOfPage);
			pageVO.setList(routeList);
			 return pageVO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			ConnUtil.closeConn();
		}
	}

}
