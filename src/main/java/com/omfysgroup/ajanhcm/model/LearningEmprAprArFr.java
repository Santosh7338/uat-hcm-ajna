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
@Table(name = "LEARNING_EMPR_APR_ARFR")
public class LearningEmprAprArFr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LearningEmprAprArFr_seq")
	@SequenceGenerator(name = "LearningEmprAprArFr_seq", sequenceName = "LEARNING_EMPR_APR_ARFR_SEQ", allocationSize = 1)
	
	
    @Column(name = "LEAA_NO")
    private Long leaaNo;

    @Column(name = "AREAS_OF_IMPROVEMENT", length = 2000)
    private String areasOfImprovement;

    @Column(name = "PROPOSED_ACTION", length = 20)
    private String proposedAction;

    @Column(name = "COMPLITED")
    private Date completed;

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

	public Long getLeaaNo() {
		return leaaNo;
	}

	public void setLeaaNo(Long leaaNo) {
		this.leaaNo = leaaNo;
	}

	public String getAreasOfImprovement() {
		return areasOfImprovement;
	}

	public void setAreasOfImprovement(String areasOfImprovement) {
		this.areasOfImprovement = areasOfImprovement;
	}

	public String getProposedAction() {
		return proposedAction;
	}

	public void setProposedAction(String proposedAction) {
		this.proposedAction = proposedAction;
	}

	public Date getCompleted() {
		return completed;
	}

	public void setCompleted(Date completed) {
		this.completed = completed;
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
		return "LearningEmprAprArFr [leaaNo=" + leaaNo + ", areasOfImprovement=" + areasOfImprovement
				+ ", proposedAction=" + proposedAction + ", completed=" + completed + ", sai=" + sai + ", status="
				+ status + ", saf=" + saf + ", saa=" + saa + ", updatedBy=" + updatedBy + "]";
	}
    
    

}
