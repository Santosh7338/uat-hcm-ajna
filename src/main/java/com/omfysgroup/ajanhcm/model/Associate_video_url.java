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
@Table(name="ASSOCIATE_VIDEO_URL")
public class Associate_video_url {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "associate_url_seq")
	@SequenceGenerator(name = "associate_url_seq", sequenceName = "ASSOCIATE_VIDEO_URL_SEQ", allocationSize = 1)
	
	@Column(name = "ASSOCIATE_VIDEO_ID")
	private int associate_video_id;
	
	@Column(name="VIDEO_TOPIC_NAME")
	private String video_topic_name;
	
	@Column(name = "COURSES_URL_PATH")
	private String courses_url_path;
	
	@Column(name = "COURSE_VIDEOS_NAME")
	private String course_videos_name;
	
	@Column(name = "ASSOCIATE_REMARKS")
	private String associate_remarks;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = true)
	private Date last_updated_date;
	
	@Column(name="IS_ACTIVATED")
	private String is_activated;
	
	@Column(name="COURSE_MASTER_ID")
    private int course_master_id;
	
	@Column(name="COURSE_VIDEO_STATUS")
    private String course_video_status;
	
	@Column(name="ASSIGNED_MASTER_ID")
    private int assigned_master_id;
	
	@Column(name="EMP_ID")
    private int emp_id;

	public int getAssociate_video_id() {
		return associate_video_id;
	}

	public void setAssociate_video_id(int associate_video_id) {
		this.associate_video_id = associate_video_id;
	}

	public String getVideo_topic_name() {
		return video_topic_name;
	}

	public void setVideo_topic_name(String video_topic_name) {
		this.video_topic_name = video_topic_name;
	}

	public String getCourses_url_path() {
		return courses_url_path;
	}

	public void setCourses_url_path(String courses_url_path) {
		this.courses_url_path = courses_url_path;
	}

	public String getCourse_videos_name() {
		return course_videos_name;
	}

	public void setCourse_videos_name(String course_videos_name) {
		this.course_videos_name = course_videos_name;
	}

	public String getAssociate_remarks() {
		return associate_remarks;
	}

	public void setAssociate_remarks(String associate_remarks) {
		this.associate_remarks = associate_remarks;
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

	public int getCourse_master_id() {
		return course_master_id;
	}

	public void setCourse_master_id(int course_master_id) {
		this.course_master_id = course_master_id;
	}

	public String getCourse_video_status() {
		return course_video_status;
	}

	public void setCourse_video_status(String course_video_status) {
		this.course_video_status = course_video_status;
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
	
	
}
