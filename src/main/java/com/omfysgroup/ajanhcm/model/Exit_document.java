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
@Table(name="EXIT_DOCUMENT")
public class Exit_document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exit_docs_seq")
	@SequenceGenerator(name = "exit_docs_seq", sequenceName = "EXIT_DOCS_SEQ", allocationSize = 1)

	@Column(name="DOCUMENT_ID")
     private int documentid;
	
	@Column(name="DOCUMENT_NAME")
	private String documentname;
	
	@Column(name = "DOCUMENT_UPLOAD")
	private byte[] document_upload;
	
	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPADATE_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	
	@ManyToOne
	@JoinColumn(name="EXIT_ID")
	private MarkExitScreen exit_id;
	
	@Column(name = "FILE_NAME")
	private String filename;
	
	@Column(name = "FILE_SIZE")
	private int filesize;
	
	@Column(name = "FILE_TYPE")
	private String file_type;

	public int getDocumentid() {
		return documentid;
	}

	public void setDocumentid(int documentid) {
		this.documentid = documentid;
	}

	public String getDocumentname() {
		return documentname;
	}

	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}

	public byte[] getDocument_upload() {
		return document_upload;
	}

	public void setDocument_upload(byte[] document_upload) {
		this.document_upload = document_upload;
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}	
	
	
	
}
