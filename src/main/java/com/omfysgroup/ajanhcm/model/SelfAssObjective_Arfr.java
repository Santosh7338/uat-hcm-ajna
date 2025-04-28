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


@Entity
@Table(name = "SELF_ASS_OBJECTIVE_ARFR")
public class SelfAssObjective_Arfr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SelfAssObjective_Arfr_seq")
	@SequenceGenerator(name = "SelfAssObjective_Arfr_seq", sequenceName = "SELF_ASS_OBJECTIVE_ARFR_SEQ", allocationSize = 1)

    @Column(name = "SAOA_NO")
    private Long saoaNo;

    @Column(name = "OBJECTIVE_TARGET")
    private String objectiveTarget;

    @Column(name = "ACTION_STEPS")
    private String actionSteps;

    @Column(name = "PROPOSE_COMPLETION")
    private Date proposeCompletion;

    @Column(name = "REMARKS")
    private String remarks;

    @ManyToOne
	@JoinColumn(name = "SAI")
    private SelfAssessmentInfo sai;
    
    @Column(name = "STATUS", length = 2000)
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "SAF")
    private SelfAssessmentFR saf;
    
    @ManyToOne
    @JoinColumn(name = "SAA")
    private SelfAssessmentAR saa;
    
    @ManyToOne
	@JoinColumn(name = "UPDATED_BY")
    private Employee_Master updatedBy;

	public Long getSaoaNo() {
		return saoaNo;
	}

	public void setSaoaNo(Long saoaNo) {
		this.saoaNo = saoaNo;
	}

	public String getObjectiveTarget() {
		return objectiveTarget;
	}

	public void setObjectiveTarget(String objectiveTarget) {
		this.objectiveTarget = objectiveTarget;
	}

	public String getActionSteps() {
		return actionSteps;
	}

	public void setActionSteps(String actionSteps) {
		this.actionSteps = actionSteps;
	}

	public Date getProposeCompletion() {
		return proposeCompletion;
	}

	public void setProposeCompletion(Date proposeCompletion) {
		this.proposeCompletion = proposeCompletion;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Employee_Master getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Employee_Master updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "SelfAssObjective_Arfr [saoaNo=" + saoaNo + ", objectiveTarget=" + objectiveTarget + ", actionSteps="
				+ actionSteps + ", proposeCompletion=" + proposeCompletion + ", remarks=" + remarks + ", sai=" + sai
				+ ", status=" + status + ", saf=" + saf + ", saa=" + saa + ", updatedBy=" + updatedBy + "]";
	}
    

}
