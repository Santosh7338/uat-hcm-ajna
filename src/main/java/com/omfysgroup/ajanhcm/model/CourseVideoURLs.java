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
@Table(name="COURSE_VIDEO_URLS")
public class CourseVideoURLs {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_video_seq")
	@SequenceGenerator(name = "course_video_seq", sequenceName = "COURSE_VIDEO_URLS_SEQ", allocationSize = 1)
	
	@Column(name = "COURSE_VIDEO_ID")
	private int course_video_id;
	
	@Column(name="VIDEO_TOPIC_NAME")
	private String video_topic_name;
	
	@Column(name = "COURSES_URLS")
	private String courses_urls;
	
	@Column(name = "COURSE_VIDEOS_NAME")
	private String video_name;
	
	@Column(name = "REMARKS")
	private String remarks;
	
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

	public int getCourse_video_id() {
		return course_video_id;
	}

	public void setCourse_video_id(int course_video_id) {
		this.course_video_id = course_video_id;
	}

	public String getVideo_topic_name() {
		return video_topic_name;
	}

	public void setVideo_topic_name(String video_topic_name) {
		this.video_topic_name = video_topic_name;
	}

	public String getCourses_urls() {
		return courses_urls;
	}

	public void setCourses_urls(String courses_urls) {
		this.courses_urls = courses_urls;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	
	
}
