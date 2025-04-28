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
@Table(name = "TECHNOLOGY")
public class Technology implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tech_seq")
	@SequenceGenerator(name = "tech_seq", sequenceName = "TECHNOLOGY_SEQ", allocationSize = 1)

	@Column(name = "TECHNOLOGY_ID")
	private int technology_id;
	
	@Column(name="PRACTICE_ID")
	private int practice_id;
	
	@Column(name = "TECHNOLOGY_NAME")
	private String technology_name;
	
	@Column(name = "IS_ACTIVATED")
	private String is_activated;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE")
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "CREATED_BY")
	private int created_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	public int getTechnology_id() {
		return technology_id;
	}

	public void setTechnology_id(int technology_id) {
		this.technology_id = technology_id;
	}

	public int getPractice_id() {
		return practice_id;
	}

	public void setPractice_id(int practice_id) {
		this.practice_id = practice_id;
	}

	public String getTechnology_name() {
		return technology_name;
	}

	public void setTechnology_name(String technology_name) {
		this.technology_name = technology_name;
	}

	public String getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	@Override
	public String toString() {
		return "Technology [technology_id=" + technology_id + ", practice_id=" + practice_id + ", technology_name="
				+ technology_name + ", is_activated=" + is_activated + ", creation_date=" + creation_date
				+ ", created_by=" + created_by + ", last_update_date=" + last_update_date + ", last_updated_by="
				+ last_updated_by + "]";
	}
	
	

}
