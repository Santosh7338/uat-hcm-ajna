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
@Table(name="WORK_EXPERIENCE")
public class Work_Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_experience_seq")
	@SequenceGenerator(name = "work_experience_seq", sequenceName = "WORK_EXPERIENCE_SEQ", allocationSize = 1)

	@Column(name = "WORK_ID")
	private int work_id;
	
	@Column(name = "ORGANISATION_ADDRESS")
	private String organisation_address;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "POSITION_HELD")
	private String position_held;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "FROM_MONTH", updatable = false)
	private Date from_month;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "TO_MONTH", updatable = false)
	private Date to_month;
	
	
	@Column(name = "GROSS_START_MONTHLY")
	private String gross_start_monthly;
	
	@Column(name = "GROSS_LAST_MONTHLY")
	private String gross_last_monthly;
	
	@Column(name = "REASON_FOR_LEAVING")
	private String reason_for_leaving;
	
	
	
	@Column(name = "PERSONAL_ID")
	private int personal_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_DATE_UPDATE", updatable = false)
	private Date last_date;
	
	@Transient
	private String startdateT;
	
	@Transient
	private String enddateT;

	public int getWork_id() {
		return work_id;
	}

	public void setWork_id(int work_id) {
		this.work_id = work_id;
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

	public String getOrganisation_address() {
		return organisation_address;
	}

	public void setOrganisation_address(String organisation_address) {
		this.organisation_address = organisation_address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPosition_held() {
		return position_held;
	}

	public void setPosition_held(String position_held) {
		this.position_held = position_held;
	}

	public Date getFrom_month() {
		return from_month;
	}

	public void setFrom_month(Date from_month) {
		this.from_month = from_month;
	}

	public Date getTo_month() {
		return to_month;
	}

	public void setTo_month(Date to_month) {
		this.to_month = to_month;
	}

	public String getGross_start_monthly() {
		return gross_start_monthly;
	}

	public void setGross_start_monthly(String gross_start_monthly) {
		this.gross_start_monthly = gross_start_monthly;
	}

	public String getGross_last_monthly() {
		return gross_last_monthly;
	}

	public void setGross_last_monthly(String gross_last_monthly) {
		this.gross_last_monthly = gross_last_monthly;
	}

	public String getReason_for_leaving() {
		return reason_for_leaving;
	}

	public void setReason_for_leaving(String reason_for_leaving) {
		this.reason_for_leaving = reason_for_leaving;
	}

	public String getStartdateT() {
		return startdateT;
	}

	public void setStartdateT(String startdateT) {
		this.startdateT = startdateT;
	}

	public String getEnddateT() {
		return enddateT;
	}

	public void setEnddateT(String enddateT) {
		this.enddateT = enddateT;
	}

	


}
