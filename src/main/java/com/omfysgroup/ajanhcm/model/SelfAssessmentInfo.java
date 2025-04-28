package com.omfysgroup.ajanhcm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SELF_ASS_INFO")
public class SelfAssessmentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SelfAssessmentInfo_seq")
	@SequenceGenerator(name = "SelfAssessmentInfo_seq", sequenceName = "SELF_ASS_INFO_SEQ", allocationSize = 1)
	
    @Column(name = "SAI_NO")
    private int saiNo;

	@ManyToOne
	@JoinColumn(name = "EMP_ID")
    private Employee_Master empId;

    @Column(name = "SELF_ASS_OTP")
    private Long selfAssOtp;

    @Column(name = "OTP_EXPPRIED")
    @Temporal(TemporalType.DATE)
    private Date otpExpired;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "ASSIGNED_BY")
    private Employee_Master assignedBy;

    @Column(name = "SUBMITTED_FLAG")
    private String submittedFlag;
    
    @Column(name = "LAST_SUB_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastsubdate;
    
    @Column(name = "QUETER")
    private int queter;
    
    @Column(name = "YEAR")
    private int year;

	public int getSaiNo() {
		return saiNo;
	}

	public void setSaiNo(int saiNo) {
		this.saiNo = saiNo;
	}

	public Employee_Master getEmpId() {
		return empId;
	}

	public void setEmpId(Employee_Master empId) {
		this.empId = empId;
	}

	public Long getSelfAssOtp() {
		return selfAssOtp;
	}

	public void setSelfAssOtp(Long selfAssOtp) {
		this.selfAssOtp = selfAssOtp;
	}

	public Date getOtpExpired() {
		return otpExpired;
	}

	public void setOtpExpired(Date otpExpired) {
		this.otpExpired = otpExpired;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Employee_Master getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Employee_Master assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getSubmittedFlag() {
		return submittedFlag;
	}

	public void setSubmittedFlag(String submittedFlag) {
		this.submittedFlag = submittedFlag;
	}

	public Date getLastsubdate() {
		return lastsubdate;
	}

	public void setLastsubdate(Date lastsubdate) {
		this.lastsubdate = lastsubdate;
	}

	public int getQueter() {
		return queter;
	}

	public void setQueter(int queter) {
		this.queter = queter;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "SelfAssessmentInfo [saiNo=" + saiNo + ", empId=" + empId + ", selfAssOtp=" + selfAssOtp
				+ ", otpExpired=" + otpExpired + ", creationDate=" + creationDate + ", updatedDate=" + updatedDate
				+ ", assignedBy=" + assignedBy + ", submittedFlag=" + submittedFlag + ", lastsubdate=" + lastsubdate
				+ ", queter=" + queter + ", year=" + year + "]";
	}
    
    
    
    
    // Constructors, getters, and setters
}
