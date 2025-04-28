package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CRITICAL_RESULT")
public class Report_Critical {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "critical_seq")
	@SequenceGenerator(name = "critical_seq", sequenceName = "CRITICAL_RESULT_SEQ", allocationSize = 1)
	
	
	@Column(name = "REPORT_CRITI_ID")
	private int report_criti_id;
	
	@Column(name = "EMPLOYEE_ID")
	private int employee_id;
	
	@Column(name = "EMPLOYEE_NAME")
	private String employee_name;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "START_DATE" , updatable = true)
	private Date critical_start_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "END_DATE" , updatable = true)
	private Date critical_end_date;
	
	
	
	@Transient
	private String critical_startdatetrans;
	
	
	@Transient
	private String critical_enddatetrans;


	


	


	public int getReport_criti_id() {
		return report_criti_id;
	}


	public void setReport_criti_id(int report_criti_id) {
		this.report_criti_id = report_criti_id;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}


	public Date getCritical_start_date() {
		return critical_start_date;
	}


	public void setCritical_start_date(Date critical_start_date) {
		this.critical_start_date = critical_start_date;
	}


	public Date getCritical_end_date() {
		return critical_end_date;
	}


	public void setCritical_end_date(Date critical_end_date) {
		this.critical_end_date = critical_end_date;
	}


	public String getCritical_startdatetrans() {
		return critical_startdatetrans;
	}


	public void setCritical_startdatetrans(String critical_startdatetrans) {
		this.critical_startdatetrans = critical_startdatetrans;
	}


	public String getCritical_enddatetrans() {
		return critical_enddatetrans;
	}


	public void setCritical_enddatetrans(String critical_enddatetrans) {
		this.critical_enddatetrans = critical_enddatetrans;
	}


	
	
	
}
