package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "LEAVE_BALANCE")
public class LeaveBalance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LEAVE_BALANCE_SEQ", allocationSize = 1)

	@Column(name = "LB_NO")
	private int lb_no;

	@Column(name = "EMP_ID")
	private int emp_id;
	
	@Column(name="EMP_CODE")
	private String emp_code;

	@Column(name = "PL")
	private float pl;

	@Column(name = "CL")
	private float cl;

	@Column(name = "ML")
	private float ml;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());

	public int getLb_no() {
		return lb_no;
	}

	public void setLb_no(int lb_no) {
		this.lb_no = lb_no;
	}

	public float getPl() {
		return pl;
	}

	public void setPl(float pl) {
		this.pl = pl;
	}

	public float getCl() {
		return cl;
	}

	public void setCl(float cl) {
		this.cl = cl;
	}
	

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public float getMl() {
		return ml;
	}

	public void setMl(float ml) {
		this.ml = ml;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "LeaveBalance [lb_no=" + lb_no + ", pl=" + pl + ", cl=" + cl + ", ml=" + ml + ", creation_date="
				+ creation_date + ", last_update_date=" + last_update_date + "]";
	}

	public LeaveBalance(int lb_no, int emp_id, float pl, float cl, float ml, Date creation_date, Date last_update_date) {
		super();
		this.lb_no = lb_no;
		this.emp_id = emp_id;
		this.pl = pl;
		this.cl = cl;
		this.ml = ml;
		this.creation_date = creation_date;
		this.last_update_date = last_update_date;
	}

	public LeaveBalance() {
		super();
		// TODO Auto-generated constructor stub
	}

}
