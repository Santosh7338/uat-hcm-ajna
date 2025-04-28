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
@Table(name="ASSESSMENT_RESULT_MASTER")
public class Assessment_Result {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assessment_reg_seq")
	@SequenceGenerator(name = "assessment_reg_seq", sequenceName = "ASSESSMENT_RESULT_MASTER_SEQ", allocationSize = 1)
	
	
	@Column(name = "ASSESS_ID")
	private int assess_id_master;
	
	@Column(name = "EMPLOYEE_ID")
	private int employee_id;
	
	@Column(name = "EMPLOYEE_NAME")
	private String employee_name;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ASSESS_START_DATE" , updatable = false)
	private Date assessment_start_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ASSESS_END_DATE" , updatable = false)
	private Date assessment_end_date;
	
	@Column(name = "RATING_OUT_OF")
	private int rating_outof;
	
	@Column(name = "ACTUAL_RATING")
	private int actual_rating;
	
	@Column(name = "GAP")
	private int gap;
	
	
	@Transient
	private String assstartdatetrans;
	
	
	@Transient
	private String assesenddatetrans;


	public int getAssess_id_master() {
		return assess_id_master;
	}


	public void setAssess_id_master(int assess_id_master) {
		this.assess_id_master = assess_id_master;
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


	public Date getAssessment_start_date() {
		return assessment_start_date;
	}


	public void setAssessment_start_date(Date assessment_start_date) {
		this.assessment_start_date = assessment_start_date;
	}


	public Date getAssessment_end_date() {
		return assessment_end_date;
	}


	public void setAssessment_end_date(Date assessment_end_date) {
		this.assessment_end_date = assessment_end_date;
	}


	public int getRating_outof() {
		return rating_outof;
	}


	public void setRating_outof(int rating_outof) {
		this.rating_outof = rating_outof;
	}


	public int getActual_rating() {
		return actual_rating;
	}


	public void setActual_rating(int actual_rating) {
		this.actual_rating = actual_rating;
	}


	public int getGap() {
		return gap;
	}


	public void setGap(int gap) {
		this.gap = gap;
	}


	public String getAssstartdatetrans() {
		return assstartdatetrans;
	}


	public void setAssstartdatetrans(String assstartdatetrans) {
		this.assstartdatetrans = assstartdatetrans;
	}


	public String getAssesenddatetrans() {
		return assesenddatetrans;
	}


	public void setAssesenddatetrans(String assesenddatetrans) {
		this.assesenddatetrans = assesenddatetrans;
	}
	
	
	
}
