package com.omfysgroup.ajanhcm.model;


public class AttendanceModule {

	private String employee_code;
	private String emp_first_name;
	private String emp_last_name;
	private String logdate;
	private String logdatetime;
	private String panch_in;
	private String panch_out;
	private String total_time;
	private String status;
	private String leave_type;
	private String remark;
	private String status_in;
	private String status_out;
	private String email;
	private String ledeductionstatus;
	//added-13-02-2023
	private int attid;
	private String direction;
	
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getAttid() {
		return attid;
	}
	public void setAttid(int attid) {
		this.attid = attid;
	}
	public String getLedeductionstatus() {
		return ledeductionstatus;
	}
	public void setLedeductionstatus(String ledeductionstatus) {
		this.ledeductionstatus = ledeductionstatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
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
	public String getLogdate() {
		return logdate;
	}
	public void setLogdate(String logdate) {
		this.logdate = logdate;
	}
	public String getLogdatetime() {
		return logdatetime;
	}
	public void setLogdatetime(String logdatetime) {
		this.logdatetime = logdatetime;
	}
	public String getPanch_in() {
		return panch_in;
	}
	public void setPanch_in(String panch_in) {
		this.panch_in = panch_in;
	}
	public String getPanch_out() {
		return panch_out;
	}
	public void setPanch_out(String panch_out) {
		this.panch_out = panch_out;
	}
	public String getTotal_time() {
		return total_time;
	}
	public void setTotal_time(String total_time) {
		this.total_time = total_time;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus_in() {
		return status_in;
	}
	public void setStatus_in(String status_in) {
		this.status_in = status_in;
	}
	public String getStatus_out() {
		return status_out;
	}
	public void setStatus_out(String status_out) {
		this.status_out = status_out;
	}
	@Override
	public String toString() {
		return "AttendanceModule [employee_code=" + employee_code + ", emp_first_name=" + emp_first_name
				+ ", emp_last_name=" + emp_last_name + ", logdate=" + logdate + ", logdatetime=" + logdatetime
				+ ", panch_in=" + panch_in + ", panch_out=" + panch_out + ", total_time=" + total_time + ", status="
				+ status + ", leave_type=" + leave_type + ", remark=" + remark + ", status_in=" + status_in
				+ ", status_out=" + status_out + ", email=" + email + ", ledeductionstatus=" + ledeductionstatus
				+ ", attid=" + attid + ", direction=" + direction + "]";
	}
	
	
}
