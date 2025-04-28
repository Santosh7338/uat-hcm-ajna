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
@Table(name ="ATT_REASON_NAME")
public class Att_Reason_Name {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "att_reason_seq")
	@SequenceGenerator(name = "att_reason_seq", sequenceName ="ATT_REASON_NAME_SEQ", allocationSize = 1)
	@Column(name = "ATT_REASON_ID")
	private int att_reason_id;

	
    @Column(name = "ATT_RESON_NAME")
	private String att_reson_name;
    
    
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

	public int getAtt_reason_id() {
		return att_reason_id;
	}

	public void setAtt_reason_id(int att_reason_id) {
		this.att_reason_id = att_reason_id;
	}

	public String getAtt_reson_name() {
		return att_reson_name;
	}

	public void setAtt_reson_name(String att_reson_name) {
		this.att_reson_name = att_reson_name;
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
