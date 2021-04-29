package com.web.domain;

import java.util.List;
import java.util.Locale.Category;

public class Route {
	// rid int
	private int rid;
	// rname varchar
	private String rname;
	// price double
	private double price;
	// rimage varchar
	private String rimage;
	// cid int
	private CateGory category;
	// 这个是自定义的线路的图片集合
	private List<RouteImg> routeImgList;
	//收藏数量，通过SQL计算获得
	private int favorite;
	
	private String routeIntroduce;
	
	 
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRimage() {
		return rimage;
	}
	public void setRimage(String rimage) {
		this.rimage = rimage;
	}
	public CateGory getCategory() {
		return category;
	}
	public void setCategory(CateGory category) {
		this.category = category;
	}
	public List<RouteImg> getRouteImgList() {
		return routeImgList;
	}
	public void setRouteImgList(List<RouteImg> routeImgList) {
		this.routeImgList = routeImgList;
	}
	public int getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
	
	public String getRouteIntroduce() {
		return routeIntroduce;
	}
	public void setRouteIntroduce(String routeIntroduce) {
		this.routeIntroduce = routeIntroduce;
	}
	@Override
	public String toString() {
		return "Route [rid=" + rid + ", rname=" + rname + ", price=" + price + ", rimage=" + rimage + ", category="
				+ category + ", routeImgList=" + routeImgList + ", favorite=" + favorite + "]";
	}
	
}

