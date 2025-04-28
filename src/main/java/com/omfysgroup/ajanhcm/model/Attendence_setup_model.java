package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ATTENDENCE_SETUP")
public class Attendence_setup_model {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "ATTENDENCE_SETUP_SEQ", allocationSize = 1)
	
	@Column(name = "ATTENDENCE_SETUP_ID")
	private int attendence_setup_id;
	
	@Column(name = "OFFICE_RESUME_TIME")
	private String office_resume_time;
	
	@Column(name = "OFFICE_DEPARTURE_TIME")
	private String office_departure_time;
	
	@Column(name = "GRACE_PERIOD_ALLOWED")
	private String grace_period_allowed;
	
	@Column(name = "MIN_CONTRIBUTION_FOR_FULL_DAY")
	private String min_contribution_for_full_day;
	
	@Column(name = "MIN_CONTRIBUTION_FOR_HALF_DAY")
	private String min_contribution_for_half_day;
	
	@Column(name = "RULES_APPLICABLE_TO")
	private String rules_applicable_to;
	
	@Column(name = "RULES_APPLICATION_FROM_DATE")
	private Date rules_application_from_date;
	
	@Column(name = "RULES_APPLICATION_TO_DATE")
	private Date rules_application_to_date;

	@Column(name = "GRACE_PERIOD_ALLOWED_IN_TIME")
	private String grace_period_allowed_in_time;
	
	
	
	@Column(name = "DEPT")
	private String dept;
	
	
	@Column(name = "DESIGNATION")
	private String designation;
	
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "EMP_NAMES")
	private String emp_names;
	
	@Column(name = "EMP_CODE")
	private String emp_code;
	
	@Column(name = "EMP_ID")
	private int emp_id;

	public int getAttendence_setup_id() {
		return attendence_setup_id;
	}

	public void setAttendence_setup_id(int attendence_setup_id) {
		this.attendence_setup_id = attendence_setup_id;
	}

	public String getOffice_resume_time() {
		return office_resume_time;
	}

	public void setOffice_resume_time(String office_resume_time) {
		this.office_resume_time = office_resume_time;
	}

	public String getOffice_departure_time() {
		return office_departure_time;
	}

	public void setOffice_departure_time(String office_departure_time) {
		this.office_departure_time = office_departure_time;
	}

	public String getGrace_period_allowed() {
		return grace_period_allowed;
	}

	public void setGrace_period_allowed(String grace_period_allowed) {
		this.grace_period_allowed = grace_period_allowed;
	}

	

	

	public String getMin_contribution_for_full_day() {
		return min_contribution_for_full_day;
	}

	public void setMin_contribution_for_full_day(String min_contribution_for_full_day) {
		this.min_contribution_for_full_day = min_contribution_for_full_day;
	}

	public String getMin_contribution_for_half_day() {
		return min_contribution_for_half_day;
	}

	public void setMin_contribution_for_half_day(String min_contribution_for_half_day) {
		this.min_contribution_for_half_day = min_contribution_for_half_day;
	}

	public String getRules_applicable_to() {
		return rules_applicable_to;
	}

	public void setRules_applicable_to(String rules_applicable_to) {
		this.rules_applicable_to = rules_applicable_to;
	}

	public Date getRules_application_from_date() {
		return rules_application_from_date;
	}

	public void setRules_application_from_date(Date rules_application_from_date) {
		this.rules_application_from_date = rules_application_from_date;
	}

	public Date getRules_application_to_date() {
		return rules_application_to_date;
	}

	public void setRules_application_to_date(Date rules_application_to_date) {
		this.rules_application_to_date = rules_application_to_date;
	}

	public String getGrace_period_allowed_in_time() {
		return grace_period_allowed_in_time;
	}

	public void setGrace_period_allowed_in_time(String grace_period_allowed_in_time) {
		this.grace_period_allowed_in_time = grace_period_allowed_in_time;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmp_names() {
		return emp_names;
	}

	public void setEmp_names(String emp_names) {
		this.emp_names = emp_names;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	
	
	
	
	
	
	
	
}
