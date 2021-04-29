package com.web.domain;

import java.util.List;

import com.web.domain.Route;

public class myFavorite {
	private Integer rid;
	private Integer uid;
	private String rname;
	private String rimage;
	private double price;
	private List<Route> route;
	public myFavorite() {
		
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRimage() {
		return rimage;
	}
	public void setRimage(String rimage) {
		this.rimage = rimage;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<Route> getRoute() {
		return route;
	}
	public void setRoute(List<Route> route) {
		this.route = route;
	}
	
	

}
