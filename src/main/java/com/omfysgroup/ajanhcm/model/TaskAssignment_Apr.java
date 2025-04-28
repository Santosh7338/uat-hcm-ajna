package com.omfysgroup.ajanhcm.model;

import javax.persistence.*;

@Entity
@Table(name = "TASK_ASSIGNMENTS_APR")
public class TaskAssignment_Apr {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TaskAssignment_Apr_seq")
	@SequenceGenerator(name = "TaskAssignment_Apr_seq", sequenceName = "TASK_ASSIGNMENTS_APR_SEQ", allocationSize = 1)
    
    @Column(name = "TAA_NO")
    private Long taaNo;

    @Column(name = "TASK_ASSIGNMENT", length = 2000)
    private String taskAssignment;

    @Column(name = "SPECIAL_CONTRIBUTION", length = 2000)
    private String specialContribution;

    @Column(name = "APPRECIATION_RECEIVED", length = 2000)
    private String appreciationReceived;

    @Column(name = "TIME_TAKEN", length = 2000)
    private String timeTaken;

    @Column(name = "SUPPORTING_DOCUMENTS", length = 2000)
    private String supportingDocuments;

    @Column(name = "PERFORMANCE_RATING", length = 2000)
    private String performanceRating;

    @ManyToOne
    @JoinColumn(name = "SAI")
    private SelfAssessmentInfo sai;

	public Long getTaaNo() {
		return taaNo;
	}

	public void setTaaNo(Long taaNo) {
		this.taaNo = taaNo;
	}

	public String getTaskAssignment() {
		return taskAssignment;
	}

	public void setTaskAssignment(String taskAssignment) {
		this.taskAssignment = taskAssignment;
	}

	public String getSpecialContribution() {
		return specialContribution;
	}

	public void setSpecialContribution(String specialContribution) {
		this.specialContribution = specialContribution;
	}

	public String getAppreciationReceived() {
		return appreciationReceived;
	}

	public void setAppreciationReceived(String appreciationReceived) {
		this.appreciationReceived = appreciationReceived;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

	public String getSupportingDocuments() {
		return supportingDocuments;
	}

	public void setSupportingDocuments(String supportingDocuments) {
		this.supportingDocuments = supportingDocuments;
	}

	public String getPerformanceRating() {
		return performanceRating;
	}

	public void setPerformanceRating(String performanceRating) {
		this.performanceRating = performanceRating;
	}

	public SelfAssessmentInfo getSai() {
		return sai;
	}

	public void setSai(SelfAssessmentInfo sai) {
		this.sai = sai;
	}

	@Override
	public String toString() {
		return "TaskAssignment_Apr [taaNo=" + taaNo + ", taskAssignment=" + taskAssignment + ", specialContribution="
				+ specialContribution + ", appreciationReceived=" + appreciationReceived + ", timeTaken=" + timeTaken
				+ ", supportingDocuments=" + supportingDocuments + ", performanceRating=" + performanceRating + ", sai="
				+ sai + "]";
	}
    
    

}
