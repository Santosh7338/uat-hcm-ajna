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
@Table(name="PARAMETERS_ASSESS")
public class Parameters_Assess {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameters_assess_seq")
	@SequenceGenerator(name = "parameters_assess_seq", sequenceName = "PARAMETERS_ASSESS_SEQ", allocationSize = 1)
	
	@Column(name = "PARA_ASS_ID")
	private int para_ass_id;
	
	
	// field is related to Topics of the training
	@Column(name="PARAM_TITLE")
	private String param_title;
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="CREATION_DATE",updatable=false)
	private Date creation_date=new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name="LAST_UPDATED_BY",updatable = true)
	private int last_updated_by;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="LAST_UPDATE_DATE",updatable=true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name="ACTIVE_FLAG")
	private String active_flag;

	public int getPara_ass_id() {
		return para_ass_id;
	}

	public void setPara_ass_id(int para_ass_id) {
		this.para_ass_id = para_ass_id;
	}

	public String getParam_title() {
		return param_title;
	}

	public void setParam_title(String param_title) {
		this.param_title = param_title;
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

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
	}


}
