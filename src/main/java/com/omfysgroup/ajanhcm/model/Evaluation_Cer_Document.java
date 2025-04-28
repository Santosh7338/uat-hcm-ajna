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
@Table(name="EVALUATION_CER_DOCUMENT")
public class Evaluation_Cer_Document {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_cer_docs_seq")
	@SequenceGenerator(name = "evaluation_cer_docs_seq", sequenceName = "EVALUATION_CER_DOCUMENT_SEQ", allocationSize = 1)
	
	@Column(name = "CER_DOC_ID")
	private int cert_doc_id;
	
	@Column(name="EVAL_CHILD_ID")
    private int eval_child_id;
	
	
	@Column(name ="REPORT_CRITI_ID")
	private int report_criti_id;
	
	
	@Column(name = "EMPLOYEE_ID")
	private int employee_id;
	
	@Column(name="DOCUMENT_NAME")
	private String document_name;
	
	@Column(name = "DOCUMENT_UPLOAD")
	private byte[] document_upload;
	
	@Column(name="REMARKS")
	private String remarks;
	
	
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
	private Date last_update_date;
	
	@Column(name="IS_ACTIVATED")
	private String is_active;
	
	
	

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getReport_criti_id() {
		return report_criti_id;
	}

	public void setReport_criti_id(int report_criti_id) {
		this.report_criti_id = report_criti_id;
	}

	public int getCert_doc_id() {
		return cert_doc_id;
	}

	public void setCert_doc_id(int cert_doc_id) {
		this.cert_doc_id = cert_doc_id;
	}

	public int getEval_child_id() {
		return eval_child_id;
	}

	public void setEval_child_id(int eval_child_id) {
		this.eval_child_id = eval_child_id;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	
	
	
}

