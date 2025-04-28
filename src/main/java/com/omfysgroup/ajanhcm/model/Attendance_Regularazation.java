package com.omfysgroup.ajanhcm.model;

public class Attendance_Regularazation {
	
	private String totaltime;
	private String catogary;
	public String getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(String totaltime) {
		this.totaltime = totaltime;
	}
	public String getCatogary() {
		return catogary;
	}
	public void setCatogary(String catogary) {
		this.catogary = catogary;
	}
	@Override
	public String toString() {
		return "Attendance_Regularazation [totaltime=" + totaltime + ", catogary=" + catogary + "]";
	}
	
	

}
