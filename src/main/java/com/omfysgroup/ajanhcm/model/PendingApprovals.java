package com.omfysgroup.ajanhcm.model;

import java.util.Date;

public class PendingApprovals {
	
	private int lr_id;
	
	private int lr_no;
	
	private String emp_name;
	
	private String subject;
	
	private String status;
	
	private String start_date;
	
	private String end_date;
	
	private String application_date;
	
	private Date startdate;
	
	private Date enddate;
	
	private Date applicationdate;
	
	private String leave_type;
	
	private float leave_count;
	
	private String Emp_code;
	
	private String reason_for_leave;
	
	private String day_type;
	
	private String  approver_type;
	
	private String  functional_decision;
	
	

	public String getEmp_code() {
		return Emp_code;
	}

	public void setEmp_code(String emp_code) {
		Emp_code = emp_code;
	}

	public float getLeave_count() {
		return leave_count;
	}

	public void setLeave_count(float f) {
		this.leave_count = f;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
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

	public int getLr_no() {
		return lr_no;
	}

	public void setLr_no(int lr_no) {
		this.lr_no = lr_no;
	}

	public String getReason_for_leave() {
		return reason_for_leave;
	}

	public void setReason_for_leave(String reason_for_leave) {
		this.reason_for_leave = reason_for_leave;
	}

	public String getDay_type() {
		return day_type;
	}

	public void setDay_type(String day_type) {
		this.day_type = day_type;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getApplicationdate() {
		return applicationdate;
	}

	public void setApplicationdate(Date applicationdate) {
		this.applicationdate = applicationdate;
	}

	public String getApplication_date() {
		return application_date;
	}

	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}

	public String getApprover_type() {
		return approver_type;
	}

	public void setApprover_type(String approver_type) {
		this.approver_type = approver_type;
	}

	public String getFunctional_decision() {
		return functional_decision;
	}

	public void setFunctional_decision(String functional_decision) {
		this.functional_decision = functional_decision;
	}
	
	
}
