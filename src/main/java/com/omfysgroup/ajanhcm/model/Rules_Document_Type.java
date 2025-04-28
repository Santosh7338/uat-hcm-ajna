package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "RULES_DOCUMENT_TYPE")
public class Rules_Document_Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "Rules_Document_Type_SEQ", allocationSize = 1)

	@Column(name = "DOCS_TYPE_ID")
	private int docs_type_id;

	@Column(name = "DOCUMENT_NAME")
	private String document_name;

	public int getDocs_type_id() {
		return docs_type_id;
	}

	public void setDocs_type_id(int docs_type_id) {
		this.docs_type_id = docs_type_id;
	}

	public String getDocument_name() {
		return document_name;
	}

	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Rules_Document_Type [docs_type_id=" + docs_type_id + ", document_name=" + document_name + "]";
	}

	public Rules_Document_Type(int docs_type_id, String document_name) {
		super();
		this.docs_type_id = docs_type_id;
		this.document_name = document_name;
	}

	public Rules_Document_Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
