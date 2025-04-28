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
@Table(name="POLICYPARENT")
public class policyform 
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pol_form_seq")
	@SequenceGenerator(name = "pol_form_seq", sequenceName = "POLICYPARENT_SEQ1", allocationSize = 1)
	
	
	@Column(name = "PARENT_ID")
	private int parent_id;
	
	
	@Column(name = "TYPE")
	private String type;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "EFFECTIVE_DATE" , updatable = true)
	private Date effective_date;
	

	@Column(name = "TITLE")
	private String title;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PUBLISHED_DATE", updatable = true)
	private Date published_date;
	
	
	
	@Column(name = "PUBLISHED_STATUS")
	private String published_status;
	
	
	@Column(name = "IS_ACTIVATED")
	private String is_activated;
	
	
	
	@Column(name = "UPDATED_STATUS")
	private String updated_status;
	
	@Transient
	private String effectivedatetrans;
	
	@Transient
	private String creationdatetrans;
	
	@Transient
	private String publisheddatetrans;
	
	
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

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(Date effective_date) {
		this.effective_date = effective_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublished_date() {
		return published_date;
	}

	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}

	public String getPublished_status() {
		return published_status;
	}

	public void setPublished_status(String published_status) {
		this.published_status = published_status;
	}

	public String getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
	}

	public String getUpdated_status() {
		return updated_status;
	}

	public void setUpdated_status(String updated_status) {
		this.updated_status = updated_status;
	}

	public String getEffectivedatetrans() {
		return effectivedatetrans;
	}

	public void setEffectivedatetrans(String effectivedatetrans) {
		this.effectivedatetrans = effectivedatetrans;
	}

	public String getCreationdatetrans() {
		return creationdatetrans;
	}

	public void setCreationdatetrans(String creationdatetrans) {
		this.creationdatetrans = creationdatetrans;
	}

	public String getPublisheddatetrans() {
		return publisheddatetrans;
	}

	public void setPublisheddatetrans(String publisheddatetrans) {
		this.publisheddatetrans = publisheddatetrans;
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

}
