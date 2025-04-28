package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
import java.util.Arrays;
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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "RULES_DOCUMENTS")
public class Rules_Documents implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "RULES_DOCUMENTS_SEQ", allocationSize = 1)

	@Column(name = "DOC_ID")
	private int doc_id;

	@Column(name = "DOCUMENT_TYPE_ID")
	private int document_type_id;

	@Column(name = "DOCUMENT_NAME")
	private String document_name;

	@Column(name = "DOC_TITLE")
	private String doc_title;

	@Column(name = "DOCUMENT")
	private byte[] document;

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_TIME", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_TIME", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Transient
	private String creationDateStr;

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public int getDocument_type_id() {
		return document_type_id;
	}

	public void setDocument_type_id(int document_type_id) {
		this.document_type_id = document_type_id;
	}

	public String getDocument_name() {
		return document_name;
	}

	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}

	public String getDoc_title() {
		return doc_title;
	}

	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getCreationDateStr() {
		return creationDateStr;
	}

	public void setCreationDateStr(String creationDateStr) {
		this.creationDateStr = creationDateStr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Rules_Documents [doc_id=" + doc_id + ", document_type_id=" + document_type_id + ", document_name="
				+ document_name + ", doc_title=" + doc_title + ", document=" + Arrays.toString(document)
				+ ", created_by=" + created_by + ", creation_date=" + creation_date + ", last_updated_by="
				+ last_updated_by + ", last_update_date=" + last_update_date + ", creationDateStr=" + creationDateStr
				+ "]";
	}

	public Rules_Documents(int doc_id, int document_type_id, String document_name, String doc_title, byte[] document,
			int created_by, Date creation_date, int last_updated_by, Date last_update_date, String creationDateStr) {
		super();
		this.doc_id = doc_id;
		this.document_type_id = document_type_id;
		this.document_name = document_name;
		this.doc_title = doc_title;
		this.document = document;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
		this.creationDateStr = creationDateStr;
	}

	public Rules_Documents() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

	
	

	
}
