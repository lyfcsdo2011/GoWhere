package com.web.vo;

import java.util.List;

public class PageVO <T>{
	    // 1 当前页码 page int 用户指定，如果用户没有指定默认第1页0
		private int page;
		// 2 每页记录数量 recordOfPage int 用户指定和程序员指定。
		private int pageCount;
		// 3总记录数 recordCount int 查询，select count(*) from goods where 多条件
		private int recordOfPage;
		// 4 总页数 pageCount int 计算，pageCount =（（recordCount-1）/ recordOfPage）+ 1
		private int recordCount;
		// 5 当前页数据集合 list List<T> 查询，limit （page-1）* recordOfPage,recordOfPage
		private List<T> list;
		
		public PageVO() {
			// TODO Auto-generated constructor stub
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getRecordOfPage() {
			return recordOfPage;
		}
		public void setRecordOfPage(int recordOfPage) {
			this.recordOfPage = recordOfPage;
		}
		public int getPageCount() {
			return pageCount;
		}
		public void setPageCount(int pageCount) {
			this.pageCount = pageCount;
		}
		public int getRecordCount() {
			return recordCount;
		}
		public void setRecordCount(int recordCount) {
			this.recordCount = recordCount;
		}
		public List<T> getList() {
			return list;
		}
		public void setList(List<T> list) {
			this.list = list;
		}
		
		
		
}
