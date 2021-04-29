package com.web.vo;

import java.util.List;

public class PageVO <T>{
	    // 1 ��ǰҳ�� page int �û�ָ��������û�û��ָ��Ĭ�ϵ�1ҳ0
		private int page;
		// 2 ÿҳ��¼���� recordOfPage int �û�ָ���ͳ���Աָ����
		private int pageCount;
		// 3�ܼ�¼�� recordCount int ��ѯ��select count(*) from goods where ������
		private int recordOfPage;
		// 4 ��ҳ�� pageCount int ���㣬pageCount =����recordCount-1��/ recordOfPage��+ 1
		private int recordCount;
		// 5 ��ǰҳ���ݼ��� list List<T> ��ѯ��limit ��page-1��* recordOfPage,recordOfPage
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
