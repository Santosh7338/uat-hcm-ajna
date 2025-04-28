package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="PREV_COMPENSATION_DETAILS")
public class Compensation_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_seq")
	@SequenceGenerator(name = "comp_seq", sequenceName = "PREV_COMPENSATION_DETAILS_SEQ", allocationSize = 1)
	
	@Column(name = "COMP_ID")
    private int compensate_id;
	
	@Column(name = "ORGANISATION_NAME")
    private String prev_Organisation;
	
	@Column(name = "COMPENSATION_HEAD")
	private String compensation_head;
	
	@Column(name = "PERIOD")
	private String period;
	
	@Column(name = "MONTHLY")
	private int monthly;
	
	@Column(name = "ANUALLY")
	private int anually;
	
	@Column(name = "MONTHLY_TOTAL")
	private int total_monthly;
	
	@Column(name = "ANNUAL_TOTAL")
	private int total_annually;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee_Master emp_id;
	
	public int getTotal_monthly() {
		return total_monthly;
	}

	public void setTotal_monthly(int total_monthly) {
		this.total_monthly = total_monthly;
	}

	public int getTotal_annually() {
		return total_annually;
	}

	public void setTotal_annually(int total_annually) {
		this.total_annually = total_annually;
	}

	@Column(name = "PERSONAL_ID")
	private int personal_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_DATED", updatable = false)
	private Date last_date;

	public int getCompensate_id() {
		return compensate_id;
	}

	public void setCompensate_id(int compensate_id) {
		this.compensate_id = compensate_id;
	}

	public String getPrev_Organisation() {
		return prev_Organisation;
	}

	public void setPrev_Organisation(String prev_Organisation) {
		this.prev_Organisation = prev_Organisation;
	}

	public String getCompensation_head() {
		return compensation_head;
	}

	public void setCompensation_head(String compensation_head) {
		this.compensation_head = compensation_head;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getMonthly() {
		return monthly;
	}

	public void setMonthly(int monthly) {
		this.monthly = monthly;
	}

	public int getAnually() {
		return anually;
	}

	public void setAnually(int anually) {
		this.anually = anually;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	
	
	
}
