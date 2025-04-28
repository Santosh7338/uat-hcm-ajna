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
@Table(name="COURSE_VIDEO_MASTER")
public class Courses_Video_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_Vmstr_seq")
	@SequenceGenerator(name = "courses_Vmstr_seq", sequenceName = "COURSE_VIDEO_MASTER_SEQ", allocationSize = 1)
	
	@Column(name = "COURSE_MASTERID")
	private int course_masterid;
	
	@Column(name = "COURSES_ID")
	private String courses_id;
	
	@Column(name = "COURSES_NAME")
	private String courses_name;
	
	@Column(name = "COURSES_TYPE")
	private String courses_type;
	
	@Column(name = "COURSES_PRACTICE")
	private String courses_practice;
	
	@Column(name = "COURSES_TECHNOLOGY")
	private String courses_technology;
	
	@Column(name = "COURCES_CERFY_AUTHORITY")
	private String cources_cerfy_authority;
	
	@Column(name = "COURSES_MODE")
	private String courses_mode;
	
	@Column(name = "COURSES_COMPETENCIES")
	private String courses_competencies;
	
	@Column(name = "COURSES_MANDATORY_OPTIONAL")
	private String courses_mandatory_optional;
	
	@Column(name = "COURSES_REMARKS")
	private String courses_remarks;
	
	@Column(name = "COURSE_CATEGORY")
	private String course_category;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;
	
	@Column(name = "IS_ACTIVE")
	private String is_active;
	
	@Column(name = "COURSE_PAID_NONPAID")
	private String course_paid_nonpaid;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATION_DATE", updatable = true)
	private Date last_updation_date;

	public int getCourse_masterid() {
		return course_masterid;
	}

	public void setCourse_masterid(int course_masterid) {
		this.course_masterid = course_masterid;
	}

	public String getCourses_id() {
		return courses_id;
	}

	public void setCourses_id(String courses_id) {
		this.courses_id = courses_id;
	}

	public String getCourses_name() {
		return courses_name;
	}

	public void setCourses_name(String courses_name) {
		this.courses_name = courses_name;
	}

	public String getCourses_type() {
		return courses_type;
	}

	public void setCourses_type(String courses_type) {
		this.courses_type = courses_type;
	}

	public String getCourses_practice() {
		return courses_practice;
	}

	public void setCourses_practice(String courses_practice) {
		this.courses_practice = courses_practice;
	}

	public String getCourses_technology() {
		return courses_technology;
	}

	public void setCourses_technology(String courses_technology) {
		this.courses_technology = courses_technology;
	}

	public String getCources_cerfy_authority() {
		return cources_cerfy_authority;
	}

	public void setCources_cerfy_authority(String cources_cerfy_authority) {
		this.cources_cerfy_authority = cources_cerfy_authority;
	}

	public String getCourses_mode() {
		return courses_mode;
	}

	public void setCourses_mode(String courses_mode) {
		this.courses_mode = courses_mode;
	}

	public String getCourses_competencies() {
		return courses_competencies;
	}

	public void setCourses_competencies(String courses_competencies) {
		this.courses_competencies = courses_competencies;
	}

	public String getCourses_mandatory_optional() {
		return courses_mandatory_optional;
	}

	public void setCourses_mandatory_optional(String courses_mandatory_optional) {
		this.courses_mandatory_optional = courses_mandatory_optional;
	}

	public String getCourses_remarks() {
		return courses_remarks;
	}

	public void setCourses_remarks(String courses_remarks) {
		this.courses_remarks = courses_remarks;
	}

	public String getCourse_category() {
		return course_category;
	}

	public void setCourse_category(String course_category) {
		this.course_category = course_category;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public String getCourse_paid_nonpaid() {
		return course_paid_nonpaid;
	}

	public void setCourse_paid_nonpaid(String course_paid_nonpaid) {
		this.course_paid_nonpaid = course_paid_nonpaid;
	}

	public Date getLast_updation_date() {
		return last_updation_date;
	}

	public void setLast_updation_date(Date last_updation_date) {
		this.last_updation_date = last_updation_date;
	}
	
	
}
