package com.omfysgroup.ajanhcm.model;

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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="KT_DOCUMENT")
public class Kt_document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kt_document_seq")
	@SequenceGenerator(name = "kt_document_seq", sequenceName = "KT_DOCUMENT_SEQ", allocationSize = 1)
    
	@Column(name="DOCUMENTS_ID")
	private int documents_id;
	
	@Column(name="DOCUMENT_NAME")
	private String document_name;
	
	@Column(name = "DOCUMENT_UPLOAD")
	private byte[] document_uploads;
	
	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@ManyToOne
	@JoinColumn(name="EXIT_ID")
	private MarkExitScreen exit_id;
	
	@Column(name = "FILE_NAME")
	private String file_name;
	
	@Column(name = "FILE_SIZE")
	private int file_size;
	
	@Column(name = "FILE_TYPE")
	private String file_type;
	
	@ManyToOne
	@JoinColumn(name="KT_TAKER_ID")
	private Employee_Master  kt_takrsName;

	public int getDocuments_id() {
		return documents_id;
	}

	public void setDocuments_id(int documents_id) {
		this.documents_id = documents_id;
	}

	public String getDocument_name() {
		return document_name;
	}

	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}

	public byte[] getDocument_uploads() {
		return document_uploads;
	}

	public void setDocument_uploads(byte[] document_uploads) {
		this.document_uploads = document_uploads;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
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

	public MarkExitScreen getExit_id() {
		return exit_id;
	}

	public void setExit_id(MarkExitScreen exit_id) {
		this.exit_id = exit_id;
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

	public Employee_Master getKt_takrsName() {
		return kt_takrsName;
	}

	public void setKt_takrsName(Employee_Master kt_takrsName) {
		this.kt_takrsName = kt_takrsName;
	}
	
	
	
}
