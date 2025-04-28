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
@Table(name="PRE_DOCUMENT_UPLOAD")
public class Pre_Document {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docs_seq")
	@SequenceGenerator(name = "docs_seq", sequenceName = "PRE_DOCUMENT_UPLOAD_SEQ", allocationSize = 1)

	@Column(name="PRE_DOC_ID")
     private int pre_doc_id;
	
	@Column(name="DOCUMENT_NAME")
	private String document_name;
	
	@Column(name = "DOCUMENT_UPLOAD")
	private byte[] document_upload;
	
	@Column(name = "FILE_NAME")
	private String file_name;
	
	@Column(name = "FILE_SIZE")
	private int file_size;
	
	@Column(name = "FILE_TYPE")
	private String file_type;

	@Column(name="PRE_EMP_ID")
    private int personal_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = true)
	private Date last_update_date;

	public int getPre_doc_id() {
		return pre_doc_id;
	}

	public void setPre_doc_id(int pre_doc_id) {
		this.pre_doc_id = pre_doc_id;
	}

	
	public String getDocument_name() {
		return document_name;
	}

	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}

	public byte[] getDocument_upload() {
		return document_upload;
	}

	public void setDocument_upload(byte[] document_upload) {
		this.document_upload = document_upload;
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

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}
	
	
	
}
