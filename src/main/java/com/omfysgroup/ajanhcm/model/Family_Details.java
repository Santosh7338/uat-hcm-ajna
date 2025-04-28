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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="FAMILY_DETAILS")
public class Family_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "family_details_seq")
	@SequenceGenerator(name = "family_details_seq", sequenceName = "FAMILY_DETAILS_SEQ", allocationSize = 1)

	@Column(name = "FAMILY_ID")
	private int family_id;
	
	@Column(name = "MEMBER")
	private String members;
	
	@Column(name = "SALUTATION")
	private String salutation;
	
	@Column(name = "FIRST_NAME")
	private String first_name;
	
	@Column(name = "MIDDLE_NAME")
	private String middle_name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "BIRTH_DATE", updatable = false)
	private Date dateofbirth;
	
	@Column(name = "PLACE_OF_BIRTH")
	private String placeofbirth;
	
	@Column(name = "NATIONALITY")
	private String nationality;
	
	@Column(name = "OCCUPATION")
	private String occupation;
    
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = false)
	private Date last_updated_date;
	
	@Column(name = "PERSONAL_ID")
	private int personal_emp_id;
	

	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee_Master emp_id;
	
	@Transient
	private String dob;
	
	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getFamily_id() {
		return family_id;
	}

	public void setFamily_id(int family_id) {
		this.family_id = family_id;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPlaceofbirth() {
		return placeofbirth;
	}

	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	public int getPersonal_emp_id() {
		return personal_emp_id;
	}

	public void setPersonal_emp_id(int personal_emp_id) {
		this.personal_emp_id = personal_emp_id;
	}
	
	
}
