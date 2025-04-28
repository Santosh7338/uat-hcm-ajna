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
@Table(name ="EVAL_INCIDENT_NAME")
public class Eval_Incident_Name {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eva_incident_seq")
	@SequenceGenerator(name = "eva_incident_seq", sequenceName ="EVAL_INCIDENT_NAME_SEQ", allocationSize = 1)
	@Column(name = "EVAL_INCIDENT_ID")
	private int eval_incident_id;

	
    @Column(name = "INCIDENT_NAME")
	private String incident_name;
    
    
    @Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date;
	
	@Transient
	private String creationdatetrans;
	

	public int getEval_incident_id() {
		return eval_incident_id;
	}

	public void setEval_incident_id(int eval_incident_id) {
		this.eval_incident_id = eval_incident_id;
	}

	public String getIncident_name() {
		return incident_name;
	}

	public void setIncident_name(String incident_name) {
		this.incident_name = incident_name;
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

	public String getCreationdatetrans() {
		return creationdatetrans;
	}

	public void setCreationdatetrans(String creationdatetrans) {
		this.creationdatetrans = creationdatetrans;
	}


	
    
	
}
