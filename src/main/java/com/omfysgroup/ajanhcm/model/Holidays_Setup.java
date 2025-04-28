package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "HOLIDAYS_SETUP")
public class Holidays_Setup {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "HOLIDAYS_SETUP_SEQ", allocationSize = 1)

	@Column(name = "H_ID")
	private int h_id;
	
	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;
	
	@Column(name = "HOLIDAY_DATE")
	private Date holiday_date;
	
	@Column(name = "HOLIDAY_NAME")
	private String holiday_name;
	
	@Column(name = "REMARKS")
	private String remarks;
	
	@Transient
	private String holiday_datestr;
	
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@Column(name = "LAST_UPDATED_BY", updatable = false)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE", updatable = false)
	private Date last_updated_date = new java.sql.Date(new java.util.Date().getTime());
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());


	public String getHoliday_datestr() {
		return holiday_datestr;
	}

	public void setHoliday_datestr(String holiday_datestr) {
		this.holiday_datestr = holiday_datestr;
	}

	public int getH_id() {
		return h_id;
	}

	public void setH_id(int h_id) {
		this.h_id = h_id;
	}

	

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public Date getHoliday_date() {
		return holiday_date;
	}

	public void setHoliday_date(Date holiday_date) {
		this.holiday_date = holiday_date;
	}

	public String getHoliday_name() {
		return holiday_name;
	}

	public void setHoliday_name(String holiday_name) {
		this.holiday_name = holiday_name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		return "Holidays_Setup [h_id=" + h_id + ", emp_id=" + emp_id + ", holiday_date=" + holiday_date
				+ ", holiday_name=" + holiday_name + ", remarks=" + remarks + ", holiday_datestr=" + holiday_datestr
				+ ", created_by=" + created_by + ", last_updated_by=" + last_updated_by + ", last_updated_date="
				+ last_updated_date + ", creation_date=" + creation_date + "]";
	}

	public Holidays_Setup(int h_id, Employee_Master emp_id, Date holiday_date, String holiday_name, String remarks,
			String holiday_datestr, int created_by, int last_updated_by, Date last_updated_date, Date creation_date) {
		super();
		this.h_id = h_id;
		this.emp_id = emp_id;
		this.holiday_date = holiday_date;
		this.holiday_name = holiday_name;
		this.remarks = remarks;
		this.holiday_datestr = holiday_datestr;
		this.created_by = created_by;
		this.last_updated_by = last_updated_by;
		this.last_updated_date = last_updated_date;
		this.creation_date = creation_date;
	}

	public Holidays_Setup() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	


	
	
	
	

	
	
}
