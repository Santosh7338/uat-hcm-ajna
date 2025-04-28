package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "LEARNING_EMPR_APR")
public class LearningEmprApr {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LearningEmprApr_seq")
	@SequenceGenerator(name = "LearningEmprApr_seq", sequenceName = "LEARNING_EMPR_APR_SEQ", allocationSize = 1)
	
	
    @Column(name = "LEA_NO")
    private Long leaNo;

    @Column(name = "AREAS_OF_IMPROVEMENT", length = 2000)
    private String areasOfImprovement;

    @Column(name = "PROPOSED_ACTION", length = 20)
    private String proposedAction;

    @Column(name = "COMPLITED")
    private Date completed;

    @ManyToOne
	@JoinColumn(name = "SAI")
    private SelfAssessmentInfo sai;

	public Long getLeaNo() {
		return leaNo;
	}

	public void setLeaNo(Long leaNo) {
		this.leaNo = leaNo;
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

	@Override
	public String toString() {
		return "LearningEmprApr [leaNo=" + leaNo + ", areasOfImprovement=" + areasOfImprovement + ", proposedAction="
				+ proposedAction + ", completed=" + completed + ", sai=" + sai + "]";
	}

	    

}
