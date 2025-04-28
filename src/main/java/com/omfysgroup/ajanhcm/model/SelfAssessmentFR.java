package com.omfysgroup.ajanhcm.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SELF_ASS_FR")
public class SelfAssessmentFR {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SelfAssessmentFR_seq")
	@SequenceGenerator(name = "SelfAssessmentFR_seq", sequenceName = "SELF_ASS_FR_SEQ", allocationSize = 1)
	
    @Column(name = "SAF_NO")
    private int safNo;

	@ManyToOne
	@JoinColumn(name = "ASSIGNED_ID")
    private Employee_Master assigned_to;

    @Column(name = "ASF_OTP")
    private Long asfOtp;

    @Column(name = "ASF_OTP_EXP")
    @Temporal(TemporalType.DATE)
    private Date asfOtpExp;

    @ManyToOne
    @JoinColumn(name = "FR_ID")
    private Employee_Master frId;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "CREATED_BY")
    private Employee_Master createdBy;

    @Column(name = "ASF_SUBMITED_FLAG")
    private String asfSubmittedFlag;

    @ManyToOne
    @JoinColumn(name = "SAI_ID")
    private SelfAssessmentInfo saiId;
    
    @Column(name = "LAST_SUB_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastsubdate;

	public int getSafNo() {
		return safNo;
	}

	public void setSafNo(int safNo) {
		this.safNo = safNo;
	}

	public Employee_Master getAssigned_to() {
		return assigned_to;
	}

	public void setAssigned_to(Employee_Master assigned_to) {
		this.assigned_to = assigned_to;
	}

	public Long getAsfOtp() {
		return asfOtp;
	}

	public void setAsfOtp(Long asfOtp) {
		this.asfOtp = asfOtp;
	}

	public Date getAsfOtpExp() {
		return asfOtpExp;
	}

	public void setAsfOtpExp(Date asfOtpExp) {
		this.asfOtpExp = asfOtpExp;
	}

	public Employee_Master getFrId() {
		return frId;
	}

	public void setFrId(Employee_Master frId) {
		this.frId = frId;
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

	public Employee_Master getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee_Master createdBy) {
		this.createdBy = createdBy;
	}

	public String getAsfSubmittedFlag() {
		return asfSubmittedFlag;
	}

	public void setAsfSubmittedFlag(String asfSubmittedFlag) {
		this.asfSubmittedFlag = asfSubmittedFlag;
	}

	public SelfAssessmentInfo getSaiId() {
		return saiId;
	}

	public void setSaiId(SelfAssessmentInfo saiId) {
		this.saiId = saiId;
	}

	public Date getLastsubdate() {
		return lastsubdate;
	}

	public void setLastsubdate(Date lastsubdate) {
		this.lastsubdate = lastsubdate;
	}

	@Override
	public String toString() {
		return "SelfAssessmentFR [safNo=" + safNo + ", assigned_to=" + assigned_to + ", asfOtp=" + asfOtp
				+ ", asfOtpExp=" + asfOtpExp + ", frId=" + frId + ", creationDate=" + creationDate + ", updatedDate="
				+ updatedDate + ", createdBy=" + createdBy + ", asfSubmittedFlag=" + asfSubmittedFlag + ", saiId="
				+ saiId + ", lastsubdate=" + lastsubdate + "]";
	}
    
    
}
