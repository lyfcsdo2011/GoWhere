package com.web.domain;

public class RouteImg {
	// rgid int
	private int rgid;
	// rid int
	private int rid;
	// bigPic varchar
	private String bigPic;
	// smallPic varchar
	private String smallPic;
	public int getRgid() {
		return rgid;
	}
	public void setRgid(int rgid) {
		this.rgid = rgid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getBigPic() {
		return bigPic;
	}
	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
	}
	@Override
	public String toString() {
		return "RouteImg [rgid=" + rgid + ", rid=" + rid + ", bigPic=" + bigPic + ", smallPic=" + smallPic + "]";
	}
}

