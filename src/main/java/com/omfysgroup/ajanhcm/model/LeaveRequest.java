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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "LEAVE_REQUEST")
public class LeaveRequest implements Comparable<LeaveRequest> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LEAVE_REQUEST_SEQ", allocationSize = 1)

	@Column(name = "LR_NO")
	private int lr_no;

	@Column(name = "LR_ID")
	private int lr_id;

	@Column(name = "EMP_ID")
	private int emp_id;
	
	@Transient
	private  String emp_name;
	
	@Transient
	private String application_date1;
	
	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "APPLICATION_DATE")
	private Date application_date;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "FUNCTIONAL_COMMENT")
	private String functional_comment;

	@Column(name = "ADMINISTRATIVE_COMMENT")
	private String administrative_comment;

	@Column(name = "MANAGEMENT_COMMENT")
	private String management_comment;

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Transient
	private String Functional_Decision;
	
	@Transient
	private String Administartive_Decision;
	
	@Transient
	private String Management_Decision;
	
	
	
	
	public String getApplication_date1() {
		return application_date1;
	}

	public void setApplication_date1(String application_date1) {
		this.application_date1 = application_date1;
	}

	public int getLr_no() {
		return lr_no;
	}

	public void setLr_no(int lr_no) {
		this.lr_no = lr_no;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getApplication_date() {
		return application_date;
	}

	public void setApplication_date(Date application_date) {
		this.application_date = application_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getLr_id() {
		return lr_id;
	}

	public void setLr_id(int lr_id) {
		this.lr_id = lr_id;
	}

	public String getFunctional_comment() {
		return functional_comment;
	}

	public void setFunctional_comment(String functional_comment) {
		this.functional_comment = functional_comment;
	}

	public String getAdministrative_comment() {
		return administrative_comment;
	}

	public void setAdministrative_comment(String administrative_comment) {
		this.administrative_comment = administrative_comment;
	}

	public String getManagement_comment() {
		return management_comment;
	}

	public void setManagement_comment(String management_comment) {
		this.management_comment = management_comment;
	}

	public LeaveRequest(int lr_no, int lr_id, int emp_id, String subject, Date application_date, String status,
			String functional_comment, String administrative_comment, String management_comment, int created_by,
			Date creation_date, int last_updated_by, Date last_update_date) {
		super();
		this.lr_no = lr_no;
		this.lr_id = lr_id;
		this.emp_id = emp_id;
		this.subject = subject;
		this.application_date = application_date;
		this.status = status;
		this.functional_comment = functional_comment;
		this.administrative_comment = administrative_comment;
		this.management_comment = management_comment;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
	}

	@Override
	public String toString() {
		return "LeaveRequest [lr_no=" + lr_no + ", lr_id=" + lr_id + ", emp_id=" + emp_id + ", subject=" + subject
				+ ", application_date=" + application_date + ", status=" + status + ", functional_comment="
				+ functional_comment + ", administrative_comment=" + administrative_comment + ", management_comment="
				+ management_comment + ", created_by=" + created_by + ", creation_date=" + creation_date
				+ ", last_updated_by=" + last_updated_by + ", last_update_date=" + last_update_date + "]";
	}

	public LeaveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(LeaveRequest o) {
		return this.getStatus().compareTo(o.getStatus());
		//return this.getStatus() - o.getStatus();
	}

	public String getFunctional_Decision() {
		return Functional_Decision;
	}

	public void setFunctional_Decision(String functional_Decision) {
		Functional_Decision = functional_Decision;
	}

	public String getAdministartive_Decision() {
		return Administartive_Decision;
	}

	public void setAdministartive_Decision(String administartive_Decision) {
		Administartive_Decision = administartive_Decision;
	}

	public String getManagement_Decision() {
		return Management_Decision;
	}

	public void setManagement_Decision(String management_Decision) {
		Management_Decision = management_Decision;
	}
	
	
	
	

}
