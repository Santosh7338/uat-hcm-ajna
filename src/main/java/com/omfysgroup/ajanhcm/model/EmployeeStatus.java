package com.omfysgroup.ajanhcm.model;

import java.util.Date;

public class EmployeeStatus {
	
	private String emp_code;
	private String emp_first_name;
	private String emp_last_name;
	private String end_date;
	private String start_date;
	private String status;
	private String leave_type;
	private String dayType;
	private String leaveUtilized;
	private Date  startDate;
	private Date endDate;
	private String empid;
	private float leavecount;
	private String application_date;
	private String leaveflag;
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
	public String getLeaveUtilized() {
		return leaveUtilized;
	}
	public void setLeaveUtilized(String leaveUtilized) {
		this.leaveUtilized = leaveUtilized;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public float getLeavecount() {
		return leavecount;
	}
	public void setLeavecount(float leavecount) {
		this.leavecount = leavecount;
	}
	public String getApplication_date() {
		return application_date;
	}
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	public String getLeaveflag() {
		return leaveflag;
	}
	public void setLeaveflag(String leaveflag) {
		this.leaveflag = leaveflag;
	}
	@Override
	public String toString() {
		return "EmployeeStatus [emp_code=" + emp_code + ", emp_first_name=" + emp_first_name + ", emp_last_name="
				+ emp_last_name + ", end_date=" + end_date + ", start_date=" + start_date + ", status=" + status
				+ ", leave_type=" + leave_type + ", dayType=" + dayType + ", leaveUtilized=" + leaveUtilized
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", empid=" + empid + ", leavecount="
				+ leavecount + ", application_date=" + application_date + ", leaveflag=" + leaveflag + "]";
	}
	
	
	
}