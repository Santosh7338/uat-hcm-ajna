package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ADMINISTRATIVE_REPORTING")
public class Administrative_Reporting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "ADMINISTRATIVE_REPORTING_SEQ", allocationSize = 1)
	
	@Column(name = "AR_NO")
	private int ar_no;
	
	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;

	@ManyToOne
	@JoinColumn(name = "ADMINISTRATIVE_REPORTING_ID")
	private Employee_Master administrative_reporting_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATED_DATE" , updatable = false)
	private Date created_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;
	
	@Column(name = "LAST_UPDATED_BY", updatable = false)
	private int last_updated_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = false)
	private Date last_updated_date= new java.sql.Date(new java.util.Date().getTime());
	
	public int getAr_no() {
		return ar_no;
	}

	public void setAr_no(int ar_no) {
		this.ar_no = ar_no;
	}

	

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public Employee_Master getAdministrative_reporting_id() {
		return administrative_reporting_id;
	}

	public void setAdministrative_reporting_id(Employee_Master administrative_reporting_id) {
		this.administrative_reporting_id = administrative_reporting_id;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	@Override
	public String toString() {
		return "Administrative_Reporting [ar_no=" + ar_no + ", emp_id=" + emp_id + ", administrative_reporting_id="
				+ administrative_reporting_id + ", created_date=" + created_date + ", created_by=" + created_by
				+ ", last_updated_by=" + last_updated_by + ", last_updated_date=" + last_updated_date + "]";
	}

	public Administrative_Reporting(int ar_no, Employee_Master emp_id, Employee_Master administrative_reporting_id, Date created_date,
			int created_by, int last_updated_by, Date last_updated_date) {
		super();
		this.ar_no = ar_no;
		this.emp_id = emp_id;
		this.administrative_reporting_id = administrative_reporting_id;
		this.created_date = created_date;
		this.created_by = created_by;
		this.last_updated_by = last_updated_by;
		this.last_updated_date = last_updated_date;
	}

	public Administrative_Reporting() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
