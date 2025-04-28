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
@Table(name="LATE_EARLY_DEBITED_LEAVES")
public class Late_Early_Debited_Leaves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LATE_EARLY_DEBITED_LEAVES_SEQ", allocationSize = 1)
	
	@Column(name="SLNO")
	private long slno;
	
	@Column(name="EMP_ID")
	private String emp_id;
	
	private String firstName;
	
	private String lastName;
	
	@Column(name="PL")
	private String pl;
	
	@Column(name="CL")
	private String cl;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name="EMP_CODE")
	private String emp_code;
	
	@Column(name="LWP")
	private String lwp;
	
	@Column(name="STATUS")
	private String status;
	
	@Transient
	private String total_event;
	

	public String getTotal_event() {
		return total_event;
	}

	public void setTotal_event(String total_event) {
		this.total_event = total_event;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getSlno() {
		return slno;
	}

	public void setSlno(long slno) {
		this.slno = slno;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getLwp() {
		return lwp;
	}

	public void setLwp(String lwp) {
		this.lwp = lwp;
	}

	@Override
	public String toString() {
		return "Late_Early_Debited_Leaves [slno=" + slno + ", emp_id=" + emp_id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", pl=" + pl + ", cl=" + cl + ", creation_date=" + creation_date
				+ ", last_update_date=" + last_update_date + ", emp_code=" + emp_code + ", lwp=" + lwp + ", status="
				+ status + ", total_event=" + total_event + "]";
	}

}