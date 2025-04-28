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
@Table(name="IDENTITY_PROOFS")
public class Identity_proof {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity_seq")
	@SequenceGenerator(name = "identity_seq", sequenceName = "IDENTITY_PROOFS_SEQ", allocationSize = 1)
	
	@Column(name = "IDS")
    private int identity_id;
	
	@Column(name = "TYPES_OF_IDS")
    private String types_of_ids;
	
	@Column(name = "NAME_ON_DOCUMENT")
    private String name_on_document;
	
	@Column(name = "IDENTITY_NUMBER")
    private String identity_number;
	
	@Column(name = "PLACE_OF_ISSUE")
	private String place_of_issue;
	
	@Column(name = "COUNTRY_OF_ISSUE")
	private String country_of_issue;
	
	@Column(name = "PERSONAL_ID")
	private int personal_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_DATE", updatable = false)
	private Date last_update_date;

	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee_Master emp_id;
	
	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public int getIdentity_id() {
		return identity_id;
	}

	public void setIdentity_id(int identity_id) {
		this.identity_id = identity_id;
	}

	public String getTypes_of_ids() {
		return types_of_ids;
	}

	public void setTypes_of_ids(String types_of_ids) {
		this.types_of_ids = types_of_ids;
	}

	public String getName_on_document() {
		return name_on_document;
	}

	public void setName_on_document(String name_on_document) {
		this.name_on_document = name_on_document;
	}

	public String getIdentity_number() {
		return identity_number;
	}

	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}

	public String getPlace_of_issue() {
		return place_of_issue;
	}

	public void setPlace_of_issue(String place_of_issue) {
		this.place_of_issue = place_of_issue;
	}

	public String getCountry_of_issue() {
		return country_of_issue;
	}

	public void setCountry_of_issue(String country_of_issue) {
		this.country_of_issue = country_of_issue;
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
