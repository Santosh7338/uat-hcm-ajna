package com.omfysgroup.ajanhcm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PER_ASSIGNED_PARM")
public class PerAssignedParm {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PerAssignedParm_seq")
	@SequenceGenerator(name = "PerAssignedParm_seq", sequenceName = "PER_ASSIGNED_PARM_SEQ", allocationSize = 1)
    
    @Column(name = "PAP_NO")
    private Long papNo;

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

	public Long getPapNo() {
		return papNo;
	}

	public void setPapNo(Long papNo) {
		this.papNo = papNo;
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

	@Override
	public String toString() {
		return "PerAssignedParm [papNo=" + papNo + ", competenceName=" + competenceName + ", rating=" + rating
				+ ", remarks=" + remarks + ", assignedTo=" + assignedTo + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", sai=" + sai + "]";
	}

    
}
