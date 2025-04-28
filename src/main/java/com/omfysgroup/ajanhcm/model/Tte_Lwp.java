package com.omfysgroup.ajanhcm.model;

import java.util.Date;

public class Tte_Lwp {
	
	private String leave_type;
	private String leave_status;
	private String day_type;
	private Date tte_date;
	private String emp_id;
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	public String getLeave_status() {
		return leave_status;
	}
	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}
	public String getDay_type() {
		return day_type;
	}
	public void setDay_type(String day_type) {
		this.day_type = day_type;
	}
	public Date getTte_date() {
		return tte_date;
	}
	public void setTte_date(Date tte_date) {
		this.tte_date = tte_date;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	@Override
	public String toString() {
		return "Tte_Lwp [leave_type=" + leave_type + ", leave_status=" + leave_status + ", day_type=" + day_type
				+ ", tte_date=" + tte_date + ", emp_id=" + emp_id + "]";
	}
	
	
}
