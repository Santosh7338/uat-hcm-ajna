package com.omfysgroup.ajanhcm.model;

import java.util.Date;

public class Od_Report_data {

	private int emp_id;

	private String emp_code;

	private int leave_type;

	private Date start_date;

	private Date end_date;

	private String emp_first_name;

	private String emp_last_name;

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public int getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(int leave_type) {
		this.leave_type = leave_type;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "Od_Report_data [emp_code=" + emp_code + ", leave_type=" + leave_type + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", emp_first_name=" + emp_first_name + ", emp_last_name=" + emp_last_name
				+ "]";
	}

}
