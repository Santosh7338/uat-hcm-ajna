package com.omfysgroup.ajanhcm.model;

import java.util.Date;

public class Od_result {
	
	
	@Override
	public String toString() {
		return "Od_result [emp_code=" + emp_code + ", emp_name=" + emp_name + ", Start_date=" + Start_date
				+ ", end_date=" + end_date + ", report_submit=" + report_submit + "]";
	}

	public Od_result() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String emp_code;
	
	
	private String emp_name;
	

	private Date Start_date;
	

	private Date end_date;

	private String report_submit;

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Date getStart_date() {
		return Start_date;
	}

	public void setStart_date(Date start_date) {
		Start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getReport_submit() {
		return report_submit;
	}

	public void setReport_submit(String report_submit) {
		this.report_submit = report_submit;
	}
}
