package com.omfysgroup.ajanhcm.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LEARNING_RSHEET")
public class LearningReportSheet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LearningReportSheet_seq")
	@SequenceGenerator(name = "LearningReportSheet_seq", sequenceName = "LEARNING_RSHEET_SEQ", allocationSize = 1)
	
    @Column(name = "LRS_NO")
    private int lrsNo;

    @Column(name = "COMPETENCIES")
    private String competencies;

	@ManyToOne
	@JoinColumn(name="ASSIGN_TO")
    private Employee_Master assignTo;
	
	@ManyToOne
	@JoinColumn(name="LRSM")
    private LearningReportSheetMaster lrsm;

	
    @Column(name = "PLANNED_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date plannedStartDate;
    

    @Column(name = "PLANNED_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date plannedEndDate;

    @Column(name = "ACTUAL_START_DATE")
    @Temporal(TemporalType.DATE)
    private Date actualStartDate;

    @Column(name = "ACTUAL_END_DATE")
    @Temporal(TemporalType.DATE)
    private Date actualEndDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "ACTIVITY_FILED_DATE")
    @Temporal(TemporalType.DATE)
    private Date activityFiledDate;

	@ManyToOne
	@JoinColumn(name="ASSIGNED_BY")
    private Employee_Master assignedBy;
	
	@ManyToOne
	@JoinColumn(name="TECHNOLOGY")
	private Technology technologyid;

	public int getLrsNo() {
		return lrsNo;
	}

	public void setLrsNo(int lrsNo) {
		this.lrsNo = lrsNo;
	}

	public String getCompetencies() {
		return competencies;
	}

	public void setCompetencies(String competencies) {
		this.competencies = competencies;
	}

	public Employee_Master getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(Employee_Master assignTo) {
		this.assignTo = assignTo;
	}

	public LearningReportSheetMaster getLrsm() {
		return lrsm;
	}

	public void setLrsm(LearningReportSheetMaster lrsm) {
		this.lrsm = lrsm;
	}

	public Date getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(Date plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public Date getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(Date plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getActivityFiledDate() {
		return activityFiledDate;
	}

	public void setActivityFiledDate(Date activityFiledDate) {
		this.activityFiledDate = activityFiledDate;
	}

	public Employee_Master getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Employee_Master assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Technology getTechnologyid() {
		return technologyid;
	}

	public void setTechnologyid(Technology technologyid) {
		this.technologyid = technologyid;
	}

	@Override
	public String toString() {
		return "LearningReportSheet [lrsNo=" + lrsNo + ", competencies=" + competencies + ", assignTo=" + assignTo
				+ ", lrsm=" + lrsm + ", plannedStartDate=" + plannedStartDate + ", plannedEndDate=" + plannedEndDate
				+ ", actualStartDate=" + actualStartDate + ", actualEndDate=" + actualEndDate + ", status=" + status
				+ ", remark=" + remark + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", updatedDate="
				+ updatedDate + ", updatedBy=" + updatedBy + ", activityFiledDate=" + activityFiledDate
				+ ", assignedBy=" + assignedBy + ", technologyid=" + technologyid + "]";
	}

	

	

    }
