package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;

public class LateEarlyDetails {
	
	private int srno;
	
	private int emp_id;
	
	private String late_coming;
	
	private String early_going;
	
	private Date update_date;
	
	private long mm;
	
	private String status;
	
	private int lecount;

	public int getSrno() {
		return srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getLate_coming() {
		return late_coming;
	}

	public void setLate_coming(String late_coming) {
		this.late_coming = late_coming;
	}

	public String getEarly_going() {
		return early_going;
	}

	public void setEarly_going(String early_going) {
		this.early_going = early_going;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public long getMm() {
		return mm;
	}

	public void setMm(long mm) {
		this.mm = mm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLecount() {
		return lecount;
	}

	public void setLecount(int lecount) {
		this.lecount = lecount;
	}

	@Override
	public String toString() {
		return "LateEarlyDetails [srno=" + srno + ", emp_id=" + emp_id + ", late_coming=" + late_coming
				+ ", early_going=" + early_going + ", update_date=" + update_date + ", mm=" + mm + ", status=" + status
				+ ", lecount=" + lecount + "]";
	}
	
	

}
