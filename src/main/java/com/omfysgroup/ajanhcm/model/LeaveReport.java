package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
import java.util.Date;

public class LeaveReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lr_no;
	private int lr_id;
	private String subject;
	private String application_date;
	private String status;
	private String start_date;
	private String end_date;
	private String leave_type;
	private String emp_name;
	private String day_type;
	
	

	public String getDay_type() {
		return day_type;
	}

	public void setDay_type(String day_type) {
		this.day_type = day_type;
	}

	public int getLr_no() {
		return lr_no;
	}

	public void setLr_no(int lr_no) {
		this.lr_no = lr_no;
	}

	public int getLr_id() {
		return lr_id;
	}

	public void setLr_id(int lr_id) {
		this.lr_id = lr_id;
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

	public String getApplication_date() {
		return application_date;
	}

	public void setApplication_date(String application_date) {
		this.application_date = application_date;
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

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	@Override
	public String toString() {
		return "LeaveReport [lr_no=" + lr_no + ", lr_id=" + lr_id + ", subject=" + subject + ", application_date="
				+ application_date + ", status=" + status + ", Start_date=" + start_date + ", end_date=" + end_date
				+ ", leave_type=" + leave_type + "]";
	}

	public LeaveReport(int lr_no, int lr_id, String subject, String application_date, String status, String start_date,
			String end_date, String leave_type) {
		super();
		this.lr_no = lr_no;
		this.lr_id = lr_id;
		this.subject = subject;
		this.application_date = application_date;
		this.status = status;
		this.start_date = start_date;
		this.end_date = end_date;
		this.leave_type = leave_type;
	}

	public LeaveReport() {
		super();
		// TODO Auto-generated constructor stub
	}

}
