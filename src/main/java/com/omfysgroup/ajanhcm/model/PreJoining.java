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
@Table(name="PRE_JOINING")
public class PreJoining {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_joining_seq")
	@SequenceGenerator(name = "pre_joining_seq", sequenceName = "PRE_JOINING_SEQ", allocationSize = 1)
	
	@Column(name = "PREJOIN_ID")
    private int pre_id;
	
	@Column(name = "PREJOINING_REGISTRATION")
	private String pre_joining;
	
	@Column(name = "CANDIDATE_FIRSTNAME")
	private String candfirst_name;
	
	@Column(name = "CANDIDATE_LASTNAME")
	private String candlast_name;
	
	@Column(name = "CANDIDATE_EMAIL")
	private String candidate_email;
	
	@Column(name = "CANDIDATE_MOBILE")
	private String candidate_mobile;
	
	@Column(name = "EMPLOYMENT")
	private String employment;
	
	@ManyToOne
	@JoinColumn(name = "DESIGNATION")
	private Designation_Master designation;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT")
	private Department_Master departments;
	
	@ManyToOne
	@JoinColumn(name = "GRADE")
	private Grade_Level_Master grade;
	
	@ManyToOne
	@JoinColumn(name = "ROLE")
	private Role_Master role;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "DATEOF_JOINING", updatable = false)
	private Date joiningdate;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_DATEOF_JOINING", updatable = false)
	private Date last_joiningdate;
	
	@Column(name = "JOINING_STATUS")
	private String joining_status;
	
	@Column(name = "EMPLOYEE_STATUS")
	private String employee_status;
    
	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	@Transient
	private String joining_dateT;
	
	@Transient
	private String Lastdate_joiningT;
	
	public int getPre_id() {
		return pre_id;
	}

	public void setPre_id(int pre_id) {
		this.pre_id = pre_id;
	}

	public String getPre_joining() {
		return pre_joining;
	}

	public void setPre_joining(String pre_joining) {
		this.pre_joining = pre_joining;
	}

	public String getCandfirst_name() {
		return candfirst_name;
	}

	public void setCandfirst_name(String candfirst_name) {
		this.candfirst_name = candfirst_name;
	}

	public String getCandlast_name() {
		return candlast_name;
	}

	public void setCandlast_name(String candlast_name) {
		this.candlast_name = candlast_name;
	}

	public String getCandidate_email() {
		return candidate_email;
	}

	public void setCandidate_email(String candidate_email) {
		this.candidate_email = candidate_email;
	}

	public String getCandidate_mobile() {
		return candidate_mobile;
	}

	public void setCandidate_mobile(String candidate_mobile) {
		this.candidate_mobile = candidate_mobile;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public Designation_Master getDesignation() {
		return designation;
	}

	public void setDesignation(Designation_Master designation) {
		this.designation = designation;
	}

	public Department_Master getDepartments() {
		return departments;
	}

	public void setDepartments(Department_Master departments) {
		this.departments = departments;
	}

	public Grade_Level_Master getGrade() {
		return grade;
	}

	public void setGrade(Grade_Level_Master grade) {
		this.grade = grade;
	}

	public Role_Master getRole() {
		return role;
	}

	public void setRole(Role_Master role) {
		this.role = role;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public Date getLast_joiningdate() {
		return last_joiningdate;
	}

	public void setLast_joiningdate(Date last_joiningdate) {
		this.last_joiningdate = last_joiningdate;
	}

	public String getJoining_status() {
		return joining_status;
	}

	public void setJoining_status(String joining_status) {
		this.joining_status = joining_status;
	}

	public String getLastdate_joiningT() {
		return Lastdate_joiningT;
	}

	public void setLastdate_joiningT(String lastdate_joiningT) {
		Lastdate_joiningT = lastdate_joiningT;
	}

	public String getJoining_dateT() {
		return joining_dateT;
	}

	public void setJoining_dateT(String joining_dateT) {
		this.joining_dateT = joining_dateT;
	}

	
	
}
