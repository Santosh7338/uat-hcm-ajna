package com.omfysgroup.ajanhcm.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OD_REPORT_HISTORY")
public class Od_Report_History {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "od_report_seq")
	@SequenceGenerator(name = "od_report_seq", sequenceName = "OD_REPORT_HISTORY_SEQ", allocationSize = 1)
	@Column(name = "SR_NO")
	private int sr_no;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "od_report_seq")
	@SequenceGenerator(name = "od_report_seq", sequenceName = "OD_REPORT_HISTORY_SEQ", allocationSize = 1)
	@Column(name = "REPORT_ID")
	private int report_id;
	
	@Column(name = "EMP_CODE")
	private String emp_code;
	
	@Column(name = "START_TIME")
	private String start_time;
	
	@Column(name = "END_TIME")
	private String end_time;
	


	@Column(name = "ACTIVITY")
	private String activity;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "REMARK")
	private String remark;
	

	@Column(name = "REPORT_DATE")
	private Date report_date;
	
	

	public Od_Report_History() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSr_no() {
		return sr_no;
	}

	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}

	
	
	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
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

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	@Override
	public String toString() {
		return "Od_Report_History [sr_no=" + sr_no + ", report_id=" + report_id + ", emp_code=" + emp_code
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", activity=" + activity + ", status="
				+ status + ", remark=" + remark + ", report_date=" + report_date + "]";
	}
	
	
}
