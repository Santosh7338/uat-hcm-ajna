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
@Table(name="COURSE_REFERENCE_DOCUMENT")
public class Course_Reference_Document {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_document_seq")
	@SequenceGenerator(name = "course_document_seq", sequenceName = "COURSE_REFERENCE_DOCUMENT_SEQ", allocationSize = 1)
	
	@Column(name = "COURSE_DOCS_ID")
	private int course_docs_id;
	
	@Column(name="COURSE_DOCUMENT_NAME")
	private String course_document_name;
	
	@Column(name = "COURSE_DOCUMENT_UPLOAD")
	private byte[] course_document_upload;
	
	@Column(name="REMARKS_COURSES")
	private String remarks_courses;
	
	@Column(name="COURSE_MASTER_ID")
    private int course_master_id;
	
	@Column(name = "FILE_NAME")
	private String file_name;
	
	@Column(name = "FILE_SIZE")
	private int file_size;
	
	@Column(name = "FILE_TYPE")
	private String file_type;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = true)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = true)
	private Date last_updated_date;
	
	@Column(name="IS_ACTIVATED")
	private String is_activated;
	
	@Column(name="DOCUMENT_STATUS")
	private String document_status;

	public int getCourse_docs_id() {
		return course_docs_id;
	}

	public void setCourse_docs_id(int course_docs_id) {
		this.course_docs_id = course_docs_id;
	}

	public String getCourse_document_name() {
		return course_document_name;
	}

	public void setCourse_document_name(String course_document_name) {
		this.course_document_name = course_document_name;
	}

	public byte[] getCourse_document_upload() {
		return course_document_upload;
	}

	public void setCourse_document_upload(byte[] course_document_upload) {
		this.course_document_upload = course_document_upload;
	}

	public String getRemarks_courses() {
		return remarks_courses;
	}

	public void setRemarks_courses(String remarks_courses) {
		this.remarks_courses = remarks_courses;
	}

	public int getCourse_master_id() {
		return course_master_id;
	}

	public void setCourse_master_id(int course_master_id) {
		this.course_master_id = course_master_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
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

	public String getDocument_status() {
		return document_status;
	}

	public void setDocument_status(String document_status) {
		this.document_status = document_status;
	}
	
	
}
