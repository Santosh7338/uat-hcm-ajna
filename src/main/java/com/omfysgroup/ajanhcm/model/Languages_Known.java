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
@Table(name="LANGUAGES_KNOWN")
public class Languages_Known {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_known_seq")
	@SequenceGenerator(name = "language_known_seq", sequenceName = "LANGUAGES_KNOWN_SEQ", allocationSize = 1)
	
	@Column(name = "LANGUAGE_ID")
    private int language_id;
	
	@Column(name = "LANGUAGE")
	private String language_name;
	
	@Column(name = "SPEAK")
	private String speak;
	
	@Column(name = "READ")
	private String read;
	
	@Column(name = "WRITE")
	private String write;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = false)
	private Date last_update_date;
	
	@Column(name = "PERSONAL_EMP_ID")
	private int personal_emp_id;

	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee_Master emp_id;
	
	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getLanguage_name() {
		return language_name;
	}

	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}

	public String getSpeak() {
		return speak;
	}

	public void setSpeak(String speak) {
		this.speak = speak;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public int getPersonal_emp_id() {
		return personal_emp_id;
	}

	public void setPersonal_emp_id(int personal_emp_id) {
		this.personal_emp_id = personal_emp_id;
	}
		
	
}
