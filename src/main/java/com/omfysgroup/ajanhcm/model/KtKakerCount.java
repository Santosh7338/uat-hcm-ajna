package com.omfysgroup.ajanhcm.model;

import java.util.Date;

public class KtKakerCount {
	
	private int kttakers;
	
	private Date MinDates;
	
	private Date Maxdates;
	
	private String MinTrans;
	
	private String MaxTrans;

	public int getKttakers() {
		return kttakers;
	}

	public void setKttakers(int kttakers) {
		this.kttakers = kttakers;
	}	

	public Date getMinDates() {
		return MinDates;
	}

	public void setMinDates(Date minDates) {
		MinDates = minDates;
	}

	public Date getMaxdates() {
		return Maxdates;
	}

	public void setMaxdates(Date maxdates) {
		Maxdates = maxdates;
	}

	public String getMinTrans() {
		return MinTrans;
	}

	public void setMinTrans(String minTrans) {
		MinTrans = minTrans;
	}

	public String getMaxTrans() {
		return MaxTrans;
	}

	public void setMaxTrans(String maxTrans) {
		MaxTrans = maxTrans;
	}
	

}
