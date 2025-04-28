package com.omfysgroup.ajanhcm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SELF_ASS_AR")
public class SelfAssessmentAR {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SelfAssessmentAR_seq")
	@SequenceGenerator(name = "SelfAssessmentAR_seq", sequenceName = "SELF_ASS_AR_SEQ", allocationSize = 1)
    
	@Column(name = "SAA_NO")
    private int saaNo;

	@ManyToOne
	@JoinColumn(name = "ASSIGNED_ID")
    private Employee_Master assigned_id;

    @Column(name = "SAA_OTP")
    private Long saaOtp;

    @Column(name = "SAA_OTP_EXP")
    @Temporal(TemporalType.DATE)
    private Date saaOtpExp;

    @ManyToOne
	@JoinColumn(name = "AR_ID")
    private Employee_Master arId;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    @ManyToOne
	@JoinColumn(name = "CREATED_BY")
    private Employee_Master createdBy;

    @Column(name = "SAA_SUBMITED_FLAG")
    private String saaSubmittedFlag;

    @ManyToOne
	@JoinColumn(name = "SAI_ID")
    private SelfAssessmentInfo saiId;
    
    @Column(name = "LAST_SUB_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastsubdate;

	public int getSaaNo() {
		return saaNo;
	}

	public void setSaaNo(int saaNo) {
		this.saaNo = saaNo;
	}

	public Employee_Master getAssigned_id() {
		return assigned_id;
	}

	public void setAssigned_id(Employee_Master assigned_id) {
		this.assigned_id = assigned_id;
	}

	public Long getSaaOtp() {
		return saaOtp;
	}

	public void setSaaOtp(Long saaOtp) {
		this.saaOtp = saaOtp;
	}

	public Date getSaaOtpExp() {
		return saaOtpExp;
	}

	public void setSaaOtpExp(Date saaOtpExp) {
		this.saaOtpExp = saaOtpExp;
	}

	public Employee_Master getArId() {
		return arId;
	}

	public void setArId(Employee_Master arId) {
		this.arId = arId;
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

	public String getSaaSubmittedFlag() {
		return saaSubmittedFlag;
	}

	public void setSaaSubmittedFlag(String saaSubmittedFlag) {
		this.saaSubmittedFlag = saaSubmittedFlag;
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
		return "SelfAssessmentAR [saaNo=" + saaNo + ", assigned_id=" + assigned_id + ", saaOtp=" + saaOtp
				+ ", saaOtpExp=" + saaOtpExp + ", arId=" + arId + ", creationDate=" + creationDate + ", updatedDate="
				+ updatedDate + ", createdBy=" + createdBy + ", saaSubmittedFlag=" + saaSubmittedFlag + ", saiId="
				+ saiId + ", lastsubdate=" + lastsubdate + "]";
	}
    
    

}
