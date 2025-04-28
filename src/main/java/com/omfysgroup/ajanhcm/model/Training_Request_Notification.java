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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TRAINING_REQUEST_NOTIFICATION")
public class Training_Request_Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_req_not_seq")
	@SequenceGenerator(name = "training_req_not_seq", sequenceName = "TRAINING_REQ_NOTIFICATION", allocationSize = 1)
	
	@Column(name = "TRN_ID")
	private int trn_id;
	
	@ManyToOne
	@JoinColumn(name = "FREMP_ID")
	private Employee_Master fremp_id;
	
	@ManyToOne
	@JoinColumn(name = "TR_ID")
	private Training_Master tr_id;
	
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

	public int getTrn_id() {
		return trn_id;
	}

	public void setTrn_id(int trn_id) {
		this.trn_id = trn_id;
	}

	public Employee_Master getFremp_id() {
		return fremp_id;
	}

	public void setFremp_id(Employee_Master fremp_id) {
		this.fremp_id = fremp_id;
	}

	public Training_Master getTr_id() {
		return tr_id;
	}

	public void setTr_id(Training_Master tr_id) {
		this.tr_id = tr_id;
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
	
}
