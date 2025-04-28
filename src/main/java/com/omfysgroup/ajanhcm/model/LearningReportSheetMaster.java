package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEARNING_RS_MASTER")
public class LearningReportSheetMaster {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LearningReportSheetMaster_seq")
	@SequenceGenerator(name = "LearningReportSheetMaster_seq", sequenceName = "LEARNING_RS_MASTER_SEQ", allocationSize = 1)

	
    @Column(name = "LRSM")
    private int lrsm;

	@ManyToOne
	@JoinColumn(name="ASSIGNTO")
    private Employee_Master assignTo;

	@ManyToOne
	@JoinColumn(name="ASSIGNEDBY")
    private Employee_Master assignedBy;

	@ManyToOne
	@JoinColumn(name="TECHNOLOGYID")
    private Technology technologyId;
	
	@ManyToOne
	@JoinColumn(name="CLE_NO")
	private CompetencyLearningExcelSheet cle_no;

    @Column(name = "STATUS", length = 200)
    private String status;

    @Column(name = "TRAINING_TYPE")
    private String traningtype;

    @Column(name = "CREATEDDATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "CREATEDBY")
    private int createdBy;

    @Column(name = "UPDATEDDATE")
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    @Column(name = "UPDATEDBY")
    private int updatedBy;

	public int getLrsm() {
		return lrsm;
	}

	public void setLrsm(int lrsm) {
		this.lrsm = lrsm;
	}

	public Employee_Master getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(Employee_Master assignTo) {
		this.assignTo = assignTo;
	}

	public Employee_Master getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(Employee_Master assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Technology getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Technology technologyId) {
		this.technologyId = technologyId;
	}

	public CompetencyLearningExcelSheet getCle_no() {
		return cle_no;
	}

	public void setCle_no(CompetencyLearningExcelSheet cle_no) {
		this.cle_no = cle_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTraningtype() {
		return traningtype;
	}

	public void setTraningtype(String traningtype) {
		this.traningtype = traningtype;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "LearningReportSheetMaster [lrsm=" + lrsm + ", assignTo=" + assignTo + ", assignedBy=" + assignedBy
				+ ", technologyId=" + technologyId + ", cle_no=" + cle_no + ", status=" + status + ", traningtype="
				+ traningtype + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", updatedDate="
				+ updatedDate + ", updatedBy=" + updatedBy + "]";
	}

	    
    
    
}

