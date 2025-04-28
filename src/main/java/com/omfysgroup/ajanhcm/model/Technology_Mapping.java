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
@Table(name = "TECHNOLOGY_MAPPING")
public class Technology_Mapping {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technology_mapping_seq")
	@SequenceGenerator(name = "technology_mapping_seq", sequenceName = "TECHNOLOGY_MAPPING_SEQ", allocationSize = 1)
	@Column(name="TECHOLOGY_ID")
	private int techology_id;
	
	@Column(name="DEPARTMENT_NAME")
	private String department_name;
	
	@Column(name="TECHNOLOGY_NAME")
	private String technology_name;
	
	@Column(name="PANEL_NAME")
	private int panel_name;

	@Column(name="IS_ACTIVATED")
	private String is_activated;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;

	@Transient
	private String full_name;
	
	@Transient
	private String str_date;
	
	public int getTechology_id() {
		return techology_id;
	}

	public void setTechology_id(int techology_id) {
		this.techology_id = techology_id;
	}

	public String getTechnology_name() {
		return technology_name;
	}

	public void setTechnology_name(String technology_name) {
		this.technology_name = technology_name;
	}

	
	public int getPanel_name() {
		return panel_name;
	}

	public void setPanel_name(int panel_name) {
		this.panel_name = panel_name;
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

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getStr_date() {
		return str_date;
	}

	public void setStr_date(String str_date) {
		this.str_date = str_date;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	@Override
	public String toString() {
		return "Technology_Mapping [techology_id=" + techology_id + ", department_name=" + department_name
				+ ", technology_name=" + technology_name + ", panel_name=" + panel_name + ", is_activated="
				+ is_activated + ", creation_date=" + creation_date + ", full_name=" + full_name + ", str_date="
				+ str_date + "]";
	}
	
	
}
