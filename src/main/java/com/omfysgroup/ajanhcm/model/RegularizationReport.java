package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;

public class RegularizationReport   implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private int attendanceRegId; 
	private String employee_code;
	private String employee_name;
	private String start_date;
	private String end_date;
	private String start_time;
	private String end_time;
	private String  category;
	private String leave_Status;
	
	public RegularizationReport(int attendanceRegId, String employee_code, String employee_name, String start_date,
			String end_date, String start_time, String end_time, String category, String leave_Status) 
	{
		super();
		this.attendanceRegId = attendanceRegId;
		this.employee_code = employee_code;
		this.employee_name = employee_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.category = category;
		this.leave_Status = leave_Status;
	}

	public RegularizationReport()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RegularizationReport [attendanceRegId=" + attendanceRegId + ", employee_code=" + employee_code
				+ ", employee_name=" + employee_name + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", category=" + category + ", leave_Status="
				+ leave_Status + "]";
	}

	public int getAttendanceRegId() {
		return attendanceRegId;
	}

	public void setAttendanceRegId(int attendanceRegId) {
		this.attendanceRegId = attendanceRegId;
	}

	public String getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(String string) {
		this.employee_code = string;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLeave_Status() {
		return leave_Status;
	}

	public void setLeave_Status(String leave_Status) {
		this.leave_Status = leave_Status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
