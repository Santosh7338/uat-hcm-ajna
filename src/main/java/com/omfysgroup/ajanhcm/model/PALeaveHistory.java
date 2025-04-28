package com.omfysgroup.ajanhcm.model;

import java.util.Date;

public class PALeaveHistory {
	
	private int lr_id;
	
	private String emp_name;
	
	private String subject;
	
	private String status;
	
	private Date application_date;
	
	private String leave_type;
	
	private String application_date_Str;

	public int getLr_id() {
		return lr_id;
	}

	public void setLr_id(int lr_id) {
		this.lr_id = lr_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApplication_date() {
		return application_date;
	}

	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}

	public String getApplication_date_Str() {
		return application_date_Str;
	}

	public void setApplication_date_Str(String application_date_Str) {
		this.application_date_Str = application_date_Str;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	
}
