package com.web.vo;

public class SearchVO {
	    // 1 路线名称的模糊查询 routeName
		private String routeName;
		// 2 路线的最小值 minRoutePrice
		private Float minRoutePrice;
		// 3 路线的最大值 maxRoutePrice
		private Float maxRoutePrice;
		
		public String getRouteName() {
			return routeName;
		}
		public void setRouteName(String routeName) {
			this.routeName = routeName;
		}
		public Float getMinRoutePrice() {
			return minRoutePrice;
		}
		public void setMinRoutePrice(Float minRoutePrice) {
			this.minRoutePrice = minRoutePrice;
		}
		public Float getMaxRoutePrice() {
			return maxRoutePrice;
		}
		public void setMaxRoutePrice(Float maxRoutePrice) {
			this.maxRoutePrice = maxRoutePrice;
		}
		

}
