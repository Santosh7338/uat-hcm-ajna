
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
@Table(name="COUNSELLING_RESULT")
public class Report_Counselling {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "counselling_seq")
	@SequenceGenerator(name = "counselling_seq", sequenceName = "COUNSELLING_RESULT_SEQ", allocationSize = 1)
	
	
	@Column(name = "REPORT_COUN_ID")
	private int report_coun_id;
	
	@Column(name = "EMPLOYEE_ID")
	private int employee_id;
	
	@Column(name = "EMPLOYEE_NAME")
	private String employee_name;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "START_DATE" , updatable = true)
	private Date counseling_start_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "END_DATE" , updatable = true)
	private Date counseling_end_date;
	
	
	
	@Transient
	private String counseling_startdatetrans;
	
	
	@Transient
	private String  counseling_enddatetrans;


	

	public int getReport_coun_id() {
		return report_coun_id;
	}


	public void setReport_coun_id(int report_coun_id) {
		this.report_coun_id = report_coun_id;
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


	public Date getCounseling_start_date() {
		return counseling_start_date;
	}


	public void setCounseling_start_date(Date counseling_start_date) {
		this.counseling_start_date = counseling_start_date;
	}


	public Date getCounseling_end_date() {
		return counseling_end_date;
	}


	public void setCounseling_end_date(Date counseling_end_date) {
		this.counseling_end_date = counseling_end_date;
	}


	public String getCounseling_startdatetrans() {
		return counseling_startdatetrans;
	}


	public void setCounseling_startdatetrans(String counseling_startdatetrans) {
		this.counseling_startdatetrans = counseling_startdatetrans;
	}


	public String getCounseling_enddatetrans() {
		return counseling_enddatetrans;
	}


	public void setCounseling_enddatetrans(String counseling_enddatetrans) {
		this.counseling_enddatetrans = counseling_enddatetrans;
	}


	
	
	
}
