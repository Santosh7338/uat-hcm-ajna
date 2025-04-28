package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;

public class MonthlyData {
	
	private String emp_code;
	private String emp_first_name;
	private String emp_last_name;
	private String end_date;
	private String start_date;
	private String status;
	private String leave_type;
	private String dayType;
	private Date holiday_date;
	private String holiday_name;
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getEmp_first_name() {
		return emp_first_name;
	}
	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}
	public String getEmp_last_name() {
		return emp_last_name;
	}
	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	public String getDayType() {
		return dayType;
	}
	public void setDayType(String dayType) {
		this.dayType = dayType;
	}
	public Date getHoliday_date() {
		return holiday_date;
	}
	public void setHoliday_date(Date holiday_date) {
		this.holiday_date = holiday_date;
	}
	public String getHoliday_name() {
		return holiday_name;
	}
	public void setHoliday_name(String holiday_name) {
		this.holiday_name = holiday_name;
	}
	@Override
	public String toString() {
		return "MonthlyData [emp_code=" + emp_code + ", emp_first_name=" + emp_first_name + ", emp_last_name="
				+ emp_last_name + ", end_date=" + end_date + ", start_date=" + start_date + ", status=" + status
				+ ", leave_type=" + leave_type + ", dayType=" + dayType + ", holiday_date=" + holiday_date
				+ ", holiday_name=" + holiday_name + "]";
	}
	
	

}
