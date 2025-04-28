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
@Table(name="THREE_RELATIVES")
public class Particular_Relatives {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relative_seq")
	@SequenceGenerator(name = "relative_seq", sequenceName = "THREE_RELATIVES_SEQ", allocationSize = 1)
	
	@Column(name = "RELATIVE_ID")
    private int relative_id;
	
	@Column(name = "RELATIVE_NAME")
    private String relative_name;
	
	@Column(name = "RELATION")
    private String relation;
	
	@Column(name = "RELATIVE_ADDRESS")
	private String relative_address;
	
	@Column(name = "RELATIVE_OCCUPATION")
	private String relative_occupation;
	
	@Column(name = "RELATIVE_EMAIL")
	private String relative_email;
	
	@Column(name = "RELATIVE_CONTACT")
	private String relative_mobile;
	
	@Column(name = "PERSONAL_ID")
	private int personal_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "UPDATED_DATE", updatable = false)
	private Date last_date;

	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;
	
	
	public int getRelative_id() {
		return relative_id;
	}

	public void setRelative_id(int relative_id) {
		this.relative_id = relative_id;
	}

	public String getRelative_name() {
		return relative_name;
	}

	public void setRelative_name(String relative_name) {
		this.relative_name = relative_name;
	}

	public String getRelative_address() {
		return relative_address;
	}

	public void setRelative_address(String relative_address) {
		this.relative_address = relative_address;
	}

	public String getRelative_occupation() {
		return relative_occupation;
	}

	public void setRelative_occupation(String relative_occupation) {
		this.relative_occupation = relative_occupation;
	}

	public String getRelative_email() {
		return relative_email;
	}

	public void setRelative_email(String relative_email) {
		this.relative_email = relative_email;
	}

	public String getRelative_mobile() {
		return relative_mobile;
	}

	public void setRelative_mobile(String relative_mobile) {
		this.relative_mobile = relative_mobile;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
}
