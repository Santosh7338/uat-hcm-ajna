package com.omfysgroup.ajanhcm.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SELF_ASS_OBJECTIVE")
public class SelfAssObjective {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SelfAssObjective_seq")
	@SequenceGenerator(name = "SelfAssObjective_seq", sequenceName = "SELF_ASS_OBJECTIVE_SEQ", allocationSize = 1)

    @Column(name = "SAO_NO")
    private Long saoNo;

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

	public Long getSaoNo() {
		return saoNo;
	}

	public void setSaoNo(Long saoNo) {
		this.saoNo = saoNo;
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

	@Override
	public String toString() {
		return "SelfAssObjective [saoNo=" + saoNo + ", objectiveTarget=" + objectiveTarget + ", actionSteps="
				+ actionSteps + ", proposeCompletion=" + proposeCompletion + ", remarks=" + remarks + ", sai=" + sai
				+ "]";
	}
    

}
