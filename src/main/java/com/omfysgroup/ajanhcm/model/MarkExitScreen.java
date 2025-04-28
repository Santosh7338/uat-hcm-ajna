package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
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
@Table(name="MARK_EXIT_SCREEN")
public class MarkExitScreen implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mark_exit_seq")
	@SequenceGenerator(name = "mark_exit_seq", sequenceName = "MARK_EXIT_SCREEN_SEQ", allocationSize = 1)
	
	@Column(name = "EXIT_ID")
    private int exitid;
	
	@Column(name = "EMPLOYEE_NAME")
	private String employee;
	
	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;
	
	
	@Column(name = "EMP_CODE")
	private String emp_code;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "JOINING_DATE", updatable = false)
	private Date joiningdate;
	
	@Column(name = "DESIGNATION")
	private String designation;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "RESIGNATION_DATE", updatable = true)
	private Date resignationdate;
	
	@Column(name = "NOTICE_DAYS_SERVED")
	private int daysServed; 
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "FINAL_EXIT_DATE", updatable = true)
	private Date finalexitdate;
	
	@Column(name = "EXIT_TYPE")
	private String exittype;
	
	@Column(name="PL_LEAVE_ALLOWANCE")
	private String leaveallowPl;
	
	@Column(name="CL_LEAVE_ALLOWANCE")
	private String leaveallowCl;
	
	@Column(name="LoP_LEAVE_ALLOWANCE")
	private String leaveallowLop;
	
	@Column(name="OD_LEAVE_ALLOWANCE")
	private String leaveallowOD;
	
	//santosh add code
	@Column(name="SOD_LEAVE_ALLOWANCE")
	private String leaveallowSOD;
	
	@Column(name="IS_APPLICABLE")
	private String is_applicable;
	
	@Transient
	private String email_id;
	
	public int getExitid() {
		return exitid;
	}

	public String getExittype() {
		return exittype;
	}

	public void setExittype(String exittype) {
		this.exittype = exittype;
	}

	public void setExitid(int exitid) {
		this.exitid = exitid;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getResignationdate() {
		return resignationdate;
	}

	public void setResignationdate(Date resignationdate) {
		this.resignationdate = resignationdate;
	}

	public int getDaysServed() {
		return daysServed;
	}

	public void setDaysServed(int daysServed) {
		this.daysServed = daysServed;
	}

	public Date getFinalexitdate() {
		return finalexitdate;
	}

	public void setFinalexitdate(Date finalexitdate) {
		this.finalexitdate = finalexitdate;
	}

	public String getLeaveallowPl() {
		return leaveallowPl;
	}

	public void setLeaveallowPl(String leaveallowPl) {
		this.leaveallowPl = leaveallowPl;
	}

	public String getLeaveallowCl() {
		return leaveallowCl;
	}

	public void setLeaveallowCl(String leaveallowCl) {
		this.leaveallowCl = leaveallowCl;
	}

	public String getLeaveallowLop() {
		return leaveallowLop;
	}

	public void setLeaveallowLop(String leaveallowLop) {
		this.leaveallowLop = leaveallowLop;
	}

	public String getLeaveallowOD() {
		return leaveallowOD;
	} 

	public void setLeaveallowOD(String leaveallowOD) {
		this.leaveallowOD = leaveallowOD;
	}
	
	public String getLeaveallowSOD() {
		return leaveallowSOD;
	}

	public void setLeaveallowSOD(String leaveallowSOD) {
		this.leaveallowSOD = leaveallowSOD;
	}

	public String getIs_applicable() {
		return is_applicable;
	}

	public void setIs_applicable(String is_applicable) {
		this.is_applicable = is_applicable;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	
	
	

	

	

	
}
	