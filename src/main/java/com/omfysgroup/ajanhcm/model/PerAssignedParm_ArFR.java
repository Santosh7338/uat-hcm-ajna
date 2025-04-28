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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "PER_ASSIGNED_PARM_FRAR")
public class PerAssignedParm_ArFR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PerAssignedParm_ArFR_seq")
	@SequenceGenerator(name = "PerAssignedParm_ArFR_seq", sequenceName = "PER_ASSIGNED_PARM_FRAR_SEQ", allocationSize = 1)
    
    @Column(name = "PAPF_NO")
    private Long papfNo;

    @Column(name = "COMPETANCEY_NAME")
    private String competenceName;

    @Column(name = "RATING")
    private Integer rating;

    @Column(name = "REMARKS")
    private String remarks;

	@ManyToOne
	@JoinColumn(name = "ASSIGNED_TO")
    private Employee_Master assignedTo;

	@ManyToOne
	@JoinColumn(name = "UPDATED_BY")
    private Employee_Master updatedBy;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

	@ManyToOne
	@JoinColumn(name = "CREATED_BY")
    private Employee_Master createdBy;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

	@ManyToOne
	@JoinColumn(name = "SAI_NO")
    private SelfAssessmentInfo sai;
	
    @Column(name = "STATUS", length = 2000)
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "SAF")
    private SelfAssessmentFR saf;
    
    @ManyToOne
    @JoinColumn(name = "SAA")
    private SelfAssessmentAR saa;

	public Long getPapfNo() {
		return papfNo;
	}

	public void setPapfNo(Long papfNo) {
		this.papfNo = papfNo;
	}

	public String getCompetenceName() {
		return competenceName;
	}

	public void setCompetenceName(String competenceName) {
		this.competenceName = competenceName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Employee_Master getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Employee_Master assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Employee_Master getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Employee_Master updatedBy) {
		this.updatedBy = updatedBy;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public SelfAssessmentInfo getSai() {
		return sai;
	}

	public void setSai(SelfAssessmentInfo sai) {
		this.sai = sai;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SelfAssessmentFR getSaf() {
		return saf;
	}

	public void setSaf(SelfAssessmentFR saf) {
		this.saf = saf;
	}

	public SelfAssessmentAR getSaa() {
		return saa;
	}

	public void setSaa(SelfAssessmentAR saa) {
		this.saa = saa;
	}

	@Override
	public String toString() {
		return "PerAssignedParm_ArFR [papfNo=" + papfNo + ", competenceName=" + competenceName + ", rating=" + rating
				+ ", remarks=" + remarks + ", assignedTo=" + assignedTo + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", sai=" + sai
				+ ", status=" + status + ", saf=" + saf + ", saa=" + saa + "]";
	}
    

}
