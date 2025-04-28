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
@Table(name="ASSESSMENT")
public class Assessment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assementseq")
	@SequenceGenerator(name = "assementseq", sequenceName = "ASSESMENT_SEQ", allocationSize = 1)
	private int assId;
	
	@ManyToOne
	@JoinColumn(name="CREATEDBY")
	private Employee_Master createdBy;
	
	@ManyToOne
	@JoinColumn(name="TR_SH_ID")
	private Training_Master tr_sh_id;
	
	@Column(name="ASSESSMENTNAME")
	private String assName;
	
	@Column(name="STATUS")
	private String status;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="CREATION_DATE",updatable=false)
	private Date creation_date=new java.sql.Date(new java.util.Date().getTime());
	
	@ManyToOne
	@JoinColumn(name="LAST_UPDATED_BY")
	private Employee_Master last_updated_by;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="LAST_UPDATE_DATE",updatable=true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());

	public int getAssId() {
		return assId;
	}

	public void setAssId(int assId) {
		this.assId = assId;
	}

	

	public Employee_Master getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee_Master createdBy) {
		this.createdBy = createdBy;
	}

	public Training_Master getTr_sh_id() {
		return tr_sh_id;
	}

	public void setTr_sh_id(Training_Master tr_sh_id) {
		this.tr_sh_id = tr_sh_id;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Employee_Master getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(Employee_Master last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssName() {
		return assName;
	}

	public void setAssName(String assName) {
		this.assName = assName;
	}			
}
