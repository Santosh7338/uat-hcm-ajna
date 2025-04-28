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
@Table(name ="EVALUATION_MASTER")
public class Evaluation_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eva_ma_seq")
	@SequenceGenerator(name = "eva_ma_seq", sequenceName ="EVALUATION_MASTER_SEQ", allocationSize = 1)
	@Column(name = "EVAL_MASTER_ID")
	private int eval_mast_id;

	@Column(name = "EVAL_TYPE")
	private String eval_type;

	@Column(name = "EVAL_NAME")
	private String eval_name;
	
	@Column(name = "DATA_TYPE")
	private String data_type;

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

	public int getEval_mast_id() {
		return eval_mast_id;
	}

	public void setEval_mast_id(int eval_mast_id) {
		this.eval_mast_id = eval_mast_id;
	}

	public String getEval_type() {
		return eval_type;
	}

	public void setEval_type(String eval_type) {
		this.eval_type = eval_type;
	}

	public String getEval_name() {
		return eval_name;
	}

	public void setEval_name(String eval_name) {
		this.eval_name = eval_name;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
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
