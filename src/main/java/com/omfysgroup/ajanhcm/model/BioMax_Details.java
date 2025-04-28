package com.omfysgroup.ajanhcm.model;

import java.sql.Timestamp;

public class BioMax_Details {
	
	private long attid;
	private String employee_code;
	private String logdate;
	private String logdatetime;
	private String direction;
	public long getAttid() {
		return attid;
	}
	public void setAttid(long attid) {
		this.attid = attid;
	}
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	public String getLogdate() {
		return logdate;
	}
	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}
	public String getLogdatetime() {
		return logdatetime;
	}
	public void setLogdatetime(String logdatetime) {
		this.logdatetime = logdatetime;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	@Override
	public String toString() {
		return "BioMax_Details [attid=" + attid + ", employee_code=" + employee_code + ", logdate=" + logdate
				+ ", logdatetime=" + logdatetime + ", direction=" + direction + "]";
	}
	
	

}
