package com.omfysgroup.ajanhcm.model;

import javax.persistence.Transient;

public class Reporting_Structure_Show {
	
	@Transient
	private int ar_no;
	
	@Transient
	private int fr_no;
	
	@Transient
	private int emp_id;

	public int getAr_no() {
		return ar_no;
	}
	public void setAr_no(int ar_no) {
		this.ar_no = ar_no;
	}
	public int getFr_no() {
		return fr_no;
	}
	public void setFr_no(int fr_no) {
		this.fr_no = fr_no;
	}
	@Transient
	private String employee_first_name;
	
	@Transient
	private String employee_last_name;
	
	@Transient
	private String fr_first_name;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	@Transient
	private String ar_first_name;
	
	@Transient
	private String fr_last_name;
	
	@Transient
	private String ar_last_name;
	
	public String getEmployee_first_name() {
		return employee_first_name;
	}
	public void setEmployee_first_name(String employee_first_name) {
		this.employee_first_name = employee_first_name;
	}
	public String getEmployee_last_name() {
		return employee_last_name;
	}
	public void setEmployee_last_name(String employee_last_name) {
		this.employee_last_name = employee_last_name;
	}
	public String getFr_first_name() {
		return fr_first_name;
	}
	public void setFr_first_name(String fr_first_name) {
		this.fr_first_name = fr_first_name;
	}
	public String getAr_first_name() {
		return ar_first_name;
	}
	public void setAr_first_name(String ar_first_name) {
		this.ar_first_name = ar_first_name;
	}
	public String getFr_last_name() {
		return fr_last_name;
	}
	public void setFr_last_name(String fr_last_name) {
		this.fr_last_name = fr_last_name;
	}
	public String getAr_last_name() {
		return ar_last_name;
	}
	public void setAr_last_name(String ar_last_name) {
		this.ar_last_name = ar_last_name;
	}
	
}
