package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "POLICYCHILD")
public class Policy_Child {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pol_form_seq")
	@SequenceGenerator(name = "pol_form_seq", sequenceName = "POLICYCHILD_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int heading_id;

	@Column(name = "PARENT_ID")
	private int parent_id;

	@Column(name = "MHEADING_ID")
	private int mheading_id;

	@Column(name = "SUBHEADING_ID")
	private int subheading_id;

	@Column(name = "SUBSUBHEADING_ID")
	private int subsubheading_id;

	@Column(name = "SSSHEADING_ID")
	private int sssheading_id;

	@Column(name = "HEADINGTYPE")
	private String categories;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "UPDATED_STATUS")
	private String updated_status;

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

	public int getHeading_id() {
		return heading_id;
	}

	public void setHeading_id(int heading_id) {
		this.heading_id = heading_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getMheading_id() {
		return mheading_id;
	}

	public void setMheading_id(int mheading_id) {
		this.mheading_id = mheading_id;
	}

	public int getSubheading_id() {
		return subheading_id;
	}

	public void setSubheading_id(int subheading_id) {
		this.subheading_id = subheading_id;
	}

	public int getSubsubheading_id() {
		return subsubheading_id;
	}

	public void setSubsubheading_id(int subsubheading_id) {
		this.subsubheading_id = subsubheading_id;
	}

	public int getSssheading_id() {
		return sssheading_id;
	}

	public void setSssheading_id(int sssheading_id) {
		this.sssheading_id = sssheading_id;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpdated_status() {
		return updated_status;
	}

	public void setUpdated_status(String updated_status) {
		this.updated_status = updated_status;
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

	@Override
	public String toString() {
		return "Policy_Child [heading_id=" + heading_id + ", parent_id=" + parent_id + ", mheading_id=" + mheading_id
				+ ", subheading_id=" + subheading_id + ", subsubheading_id=" + subsubheading_id + ", sssheading_id="
				+ sssheading_id + ", categories=" + categories + ", name=" + name + ", content=" + content
				+ ", created_by=" + created_by + ", creation_date=" + creation_date + ", last_updated_by="
				+ last_updated_by + ", last_update_date=" + last_update_date + "]";
	}

}
