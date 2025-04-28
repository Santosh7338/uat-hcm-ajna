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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="PREVIOUS_EMPLOYMENT")
public class Previous_Employment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "PREVIOUS_EMPLOYMENT_SEQ", allocationSize = 1)
	
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TOTAL_YEAR")
	private float total_year;
	
	@Column(name = "FROM_DATE", updatable = false)
	private String from_date;
	
	@Column(name = "TO_DATE",  updatable = false)
	private String to_date;
	
	@Column(name = "ORGANISATION")
	private String organisation_name;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "DESIGNATION")
	private String position_held;
	
	@Column(name = "CTC")
	private Long ctc;
	
//	@Column(name = "GROSS_SALARY_START")
//	private String gross_salary_start;
	
	@Column(name = "GROSS_SALARY_END")
	private String gross_salary_end;
	
	@Column(name = "GROSS_SALARY_START")
	private String gross_salary_start;
	
	@Column(name = "REASON_FOR_LEAVING")
	private String reason_leaving;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee_Master emp_id;
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY" , updatable=true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "IS_DELETED")
	private String is_deleted;
	
	@Transient
	private String startTrans;
	
	@Transient
	private String endTrans;

	public String getStartTrans() {
		return startTrans;
	}

	public void setStartTrans(String startTrans) {
		this.startTrans = startTrans;
	}

	public String getEndTrans() {
		return endTrans;
	}

	public void setEndTrans(String endTrans) {
		this.endTrans = endTrans;
	}

	public String getOrganisation_name() {
		return organisation_name;
	}

	public void setOrganisation_name(String organisation_name) {
		this.organisation_name = organisation_name;
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

	public String getGross_salary_start() {
		return gross_salary_start;
	}

	public void setGross_salary_start(String gross_salary_start) {
		this.gross_salary_start = gross_salary_start;
	}

	public String getGross_salary_end() {
		return gross_salary_end;
	}

	public void setGross_salary_end(String gross_salary_end) {
		this.gross_salary_end = gross_salary_end;
	}

	public String getReason_leaving() {
		return reason_leaving;
	}

	public void setReason_leaving(String reason_leaving) {
		this.reason_leaving = reason_leaving;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public float getTotal_year() {
		return total_year;
	}

	public void setTotal_year(float total_year) {
		this.total_year = total_year;
	}


	public Long getCtc() {
		return ctc;
	}

	public void setCtc(Long ctc) {
		this.ctc = ctc;
	}

	

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	
	}

	
//	public String getGross_salary() {
//		return gross_salary;
//	}
//
//	public void setGross_salary(String gross_salary) {
//		this.gross_salary = gross_salary;
//	}
//	
	
	
	

