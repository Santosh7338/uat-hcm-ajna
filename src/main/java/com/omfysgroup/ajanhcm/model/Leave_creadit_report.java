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

@Entity
@Table(name ="LEAVE_CREADIT_REPORT")
public class Leave_creadit_report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Leave_creadit_report_seq")
	@SequenceGenerator(name = "Leave_creadit_report_seq", sequenceName ="LEAVE_CREADIT_REPORT_SEQ", allocationSize = 1)
	@Column(name = "LC_ID")
	private int lc_id;
	
	@Column(name="EMP_ID")
	private int empid;
	
	@Column(name="LEAVE_CREDITED")
	private float leave_creadited;
	
	@Column(name="LEAVE_TYPE")
	private String leavetype;
	
	@Column(name="UPDATED_DATE")
	private String updated_date;
	
	@Column(name="CREATED_DATE")
	private Date created_date;
	
	@Transient
	private String emp_name;
	
	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getLc_id() {
		return lc_id;
	}

	public void setLc_id(int lc_id) {
		this.lc_id = lc_id;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public float getLeave_creadited() {
		return leave_creadited;
	}

	public void setLeave_creadited(float leave_creadited) {
		this.leave_creadited = leave_creadited;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "Leave_creadit_report [lc_id=" + lc_id + ", empid=" + empid + ", leave_creadited=" + leave_creadited
				+ ", leavetype=" + leavetype + ", updated_date=" + updated_date + ", created_date=" + created_date
				+ "]";
	}
	


}
