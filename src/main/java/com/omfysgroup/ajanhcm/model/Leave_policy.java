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
@Table(name = "LEAVE_POLICY")
public class Leave_policy {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_policy_seq")
	@SequenceGenerator(name = "leave_policy_seq", sequenceName = "LEAVE_POLICY_SEQ", allocationSize = 1)

	@Column(name = "LP_NO")
	private int lp_no;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee_Master emp_id;

	@Column(name = "LEAVE_COUNT")
	private int leave_count;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());

	@Transient
	private String date1;
	
	
	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public int getLp_no() {
		return lp_no;
	}

	public void setLp_no(int lp_no) {
		this.lp_no = lp_no;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public int getLeave_count() {
		return leave_count;
	}

	public void setLeave_count(int leave_count) {
		this.leave_count = leave_count;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	@Override
	public String toString() {
		return "Leave_policy [lp_no=" + lp_no + ", emp_id=" + emp_id + ", leave_count=" + leave_count
				+ ", last_update_date=" + last_update_date + ", date1=" + date1 + "]";
	}


	
	
}
