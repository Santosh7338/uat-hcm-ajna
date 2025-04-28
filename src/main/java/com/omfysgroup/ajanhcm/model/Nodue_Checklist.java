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
@Table(name="NO_DUE_CHECKLIST")
public class Nodue_Checklist {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nodue_checklist_seq")
	@SequenceGenerator(name = "nodue_checklist_seq", sequenceName = "NODUE_CHECKLIST_SEQ", allocationSize = 1)
	
	@Column(name="CHECK_ID")
	private int check_id;
	
	@Column(name="PARTICULARS_NAME")
	private String particularname;
	
	@Column(name="CLEARANCE")
	private String clearance;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CLEARANCE_DATE", updatable = false)
	private Date dateofclearance;
	
	@ManyToOne
	@JoinColumn(name="CLEARED_BY")
	 private Employee_Master  clearedby;
	
	@Column(name="REMARKS")
	private String remarksduecheck;
	
	@ManyToOne
	@JoinColumn(name="EXIT_ID")
	private MarkExitScreen exit_id;
	
	@ManyToOne
	@JoinColumn(name="EMPID")
	private Employee_Master empid ;
	
	@Transient
	private String emp_name;
	
	@Transient
	private String dateofclear;

	public int getCheck_id() {
		return check_id;
	}

	public void setCheck_id(int check_id) {
		this.check_id = check_id;
	}

	public String getParticularname() {
		return particularname;
	}

	public void setParticularname(String particularname) {
		this.particularname = particularname;
	}

	public String getClearance() {
		return clearance;
	}

	public void setClearance(String clearance) {
		this.clearance = clearance;
	}

	public Date getDateofclearance() {
		return dateofclearance;
	}

	public void setDateofclearance(Date dateofclearance) {
		this.dateofclearance = dateofclearance;
	}

	public Employee_Master getClearedby() {
		return clearedby;
	}

	public void setClearedby(Employee_Master clearedby) {
		this.clearedby = clearedby;
	}

	public String getRemarksduecheck() {
		return remarksduecheck;
	}

	public void setRemarksduecheck(String remarksduecheck) {
		this.remarksduecheck = remarksduecheck;
	}

	public MarkExitScreen getExit_id() {
		return exit_id;
	}

	public void setExit_id(MarkExitScreen exit_id) {
		this.exit_id = exit_id;
	}

	public Employee_Master getEmpid() {
		return empid;
	}

	public void setEmpid(Employee_Master empid) {
		this.empid = empid;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDateofclear() {
		return dateofclear;
	}

	public void setDateofclear(String date) {
		this.dateofclear = date;
	}
	
	
}
