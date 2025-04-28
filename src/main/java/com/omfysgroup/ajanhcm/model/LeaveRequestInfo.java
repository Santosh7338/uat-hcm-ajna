package com.omfysgroup.ajanhcm.model;

public class LeaveRequestInfo {
	
	private int lr_no;
	private int lr_id;
	private int emp_id;
	private String subject;
	private String status;
	private String created_by;
	private String creation_date;
	private String last_updated_by;
	private String last_update_date;
	private String start_date;
	private String end_date;
	private String application_date;
	private String functional_comment;
	private String adminstrative_comment;
	private String management_comment;
	private String leave_type;
	
	
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
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
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getLast_updated_by() {
		return last_updated_by;
	}
	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}
	public String getLast_update_date() {
		return last_update_date;
	}
	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
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
	public String getApplication_date() {
		return application_date;
	}
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	public String getFunctional_comment() {
		return functional_comment;
	}
	public void setFunctional_comment(String functional_comment) {
		this.functional_comment = functional_comment;
	}
	public String getAdminstrative_comment() {
		return adminstrative_comment;
	}
	public void setAdminstrative_comment(String adminstrative_comment) {
		this.adminstrative_comment = adminstrative_comment;
	}
	public String getManagement_comment() {
		return management_comment;
	}
	public void setManagement_comment(String management_comment) {
		this.management_comment = management_comment;
	}
	@Override
	public String toString() {
		return "LeaveRequestInfo [lr_no=" + lr_no + ", lr_id=" + lr_id + ", emp_id=" + emp_id + ", subject=" + subject
				+ ", status=" + status + ", created_by=" + created_by + ", creation_date=" + creation_date
				+ ", last_updated_by=" + last_updated_by + ", last_update_date=" + last_update_date + ", start_date="
				+ start_date + ", end_date=" + end_date + ", application_date=" + application_date
				+ ", functional_comment=" + functional_comment + ", adminstrative_comment=" + adminstrative_comment
				+ ", management_comment=" + management_comment + "]";
	}
	
	
	

}

