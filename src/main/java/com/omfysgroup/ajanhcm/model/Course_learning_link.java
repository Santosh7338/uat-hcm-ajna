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
@Table(name="COURSE_LEARNING_LINK")
public class Course_learning_link {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "learning_link_seq")
	@SequenceGenerator(name = "learning_link_seq", sequenceName = "COURSE_LEARNING_LINK_SEQ", allocationSize = 1)
	
	@Column(name = "COURSE_LINK_ID")
	private int course_link_id;
	
	@Column(name="COURSE_TOPIC")
	private String course_topic;
	
	@Column(name="COURSE_MASTER_ID")
    private int course_master_id;
	
	@Column(name = "COURSE_LINK")
	private String course_link;
	
	@Column(name = "COURSE_COMMENT")
	private String course_comment;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = true)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = true)
	private Date last_updated_date;
	
	@Column(name="IS_ACTIVATED")
	private String is_activated;

	public int getCourse_link_id() {
		return course_link_id;
	}

	public void setCourse_link_id(int course_link_id) {
		this.course_link_id = course_link_id;
	}

	public String getCourse_topic() {
		return course_topic;
	}

	public void setCourse_topic(String course_topic) {
		this.course_topic = course_topic;
	}

	public int getCourse_master_id() {
		return course_master_id;
	}

	public void setCourse_master_id(int course_master_id) {
		this.course_master_id = course_master_id;
	}

	public String getCourse_link() {
		return course_link;
	}

	public void setCourse_link(String course_link) {
		this.course_link = course_link;
	}

	public String getCourse_comment() {
		return course_comment;
	}

	public void setCourse_comment(String course_comment) {
		this.course_comment = course_comment;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	public String getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
	}
	
	
}
