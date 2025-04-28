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
@Table(name="ASSOCIATE_LEARNING_LINK")
public class Associate_Learning_link {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asso_learning_seq")
	@SequenceGenerator(name = "asso_learning_seq", sequenceName = "ASSOCIATE_LEARNING_LINK_SEQ", allocationSize = 1)
	
	@Column(name = "ASSO_LERN_LINK_ID")
	private int asso_lern_link_id;
	
	@Column(name="LEARNING_TOPIC")
	private String learning_topic;
	
	@Column(name="COURSE_MASTER_ID")
    private int course_master_id;
	
	@Column(name = "LEARNING_LINK")
	private String learning_link;
	
	@Column(name = "LEARNING_COMMENTS")
	private String learning_comments;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = true)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = true)
	private Date last_update_date;
	
	@Column(name="IS_ACTIVATED")
	private String is_activated;
	
	@Column(name="ASSIGNED_MASTER_ID")
    private int assigned_master_id;
	
	@Column(name="EMP_ID")
    private int emp_id;
	
	@Column(name="LINK_STATUS")
	private String link_status;

	public int getAsso_lern_link_id() {
		return asso_lern_link_id;
	}

	public void setAsso_lern_link_id(int asso_lern_link_id) {
		this.asso_lern_link_id = asso_lern_link_id;
	}

	public String getLearning_topic() {
		return learning_topic;
	}

	public void setLearning_topic(String learning_topic) {
		this.learning_topic = learning_topic;
	}

	public int getCourse_master_id() {
		return course_master_id;
	}

	public void setCourse_master_id(int course_master_id) {
		this.course_master_id = course_master_id;
	}

	public String getLearning_link() {
		return learning_link;
	}

	public void setLearning_link(String learning_link) {
		this.learning_link = learning_link;
	}

	public String getLearning_comments() {
		return learning_comments;
	}

	public void setLearning_comments(String learning_comments) {
		this.learning_comments = learning_comments;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
	}

	public int getAssigned_master_id() {
		return assigned_master_id;
	}

	public void setAssigned_master_id(int assigned_master_id) {
		this.assigned_master_id = assigned_master_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getLink_status() {
		return link_status;
	}

	public void setLink_status(String link_status) {
		this.link_status = link_status;
	}
	
	
	
}
