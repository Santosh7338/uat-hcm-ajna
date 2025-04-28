package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
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
@Table(name = "LEAVE_NOTIFICATIONS")
public class LeaveNotifications implements Serializable, Comparable<LeaveNotifications> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LEAVE_NOTIFICATIONS_SEQ", allocationSize = 1)

	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;

	@ManyToOne
	@JoinColumn(name = "LR_ID")
	private LeaveRequest lr_id;

	@ManyToOne
	@JoinColumn(name = "APPROVER_ID")
	private Employee_Master approver_id;

	@Column(name = "APPROVER_TYPE")
	private String approver_type;

	@Column(name = "STATUS")
	private String status;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATED_DATE", updatable = false)
	private Date created_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@Column(name = "LAST_UPDATED_BY", updatable = false)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE", updatable = false)
	private Date last_updated_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Transient
	private String start_Date;
	
	@Transient
	private String end_Date;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public Employee_Master getApprover_id() {
		return approver_id;
	}

	public void setApprover_id(Employee_Master approver_id) {
		this.approver_id = approver_id;
	}

	public String getApprover_type() {
		return approver_type;
	}

	public void setApprover_type(String approver_type) {
		this.approver_type = approver_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LeaveRequest getLr_id() {
		return lr_id;
	}

	public void setLr_id(LeaveRequest lr_id) {
		this.lr_id = lr_id;
	}
	
	

	public String getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}

	public String getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(String end_Date) {
		this.end_Date = end_Date;
	}

	@Override
	public String toString() {
		return "LeaveNotifications [id=" + id + ", emp_id=" + emp_id + ", lr_id=" + lr_id + ", approver_id="
				+ approver_id + ", approver_type=" + approver_type + ", status=" + status + ", created_date="
				+ created_date + ", created_by=" + created_by + ", last_updated_by=" + last_updated_by
				+ ", last_updated_date=" + last_updated_date + "]";
	}

	public LeaveNotifications(int id, Employee_Master emp_id, LeaveRequest lr_id, Employee_Master approver_id,
			String approver_type, String status, Date created_date, int created_by, int last_updated_by,
			Date last_updated_date) {
		super();
		this.id = id;
		this.emp_id = emp_id;
		this.lr_id = lr_id;
		this.approver_id = approver_id;
		this.approver_type = approver_type;
		this.status = status;
		this.created_date = created_date;
		this.created_by = created_by;
		this.last_updated_by = last_updated_by;
		this.last_updated_date = last_updated_date;
	}

	public LeaveNotifications() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compareTo(LeaveNotifications o) {
		return this.getStatus().compareTo(o.getStatus());
		//return this.getStatus() - o.getStatus();
	}


}
