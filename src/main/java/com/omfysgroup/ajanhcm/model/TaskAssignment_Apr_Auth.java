package com.omfysgroup.ajanhcm.model;


import javax.persistence.*;

@Entity
@Table(name = "TASK_ASSIGNMENTS_APR_AUTH")
public class TaskAssignment_Apr_Auth {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TaskAssignment_Apr_Auth_seq")
	@SequenceGenerator(name = "TaskAssignment_Apr_Auth_seq", sequenceName = "TASK_ASSIGNMENTS_APR_AUTH_SEQ", allocationSize = 1)
	
	
    @Column(name = "TAAA_NO")
    private Long taaaNo;

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

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private Employee_Master emp_id;

    @Column(name = "STATUS", length = 2000)
    private String status;
    
    
    @ManyToOne
    @JoinColumn(name = "SAF")
    private SelfAssessmentFR saf;
    
    @ManyToOne
    @JoinColumn(name = "SAA")
    private SelfAssessmentAR saa;

	public Long getTaaaNo() {
		return taaaNo;
	}

	public void setTaaaNo(Long taaaNo) {
		this.taaaNo = taaaNo;
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

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
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
		return "TaskAssignment_Apr_Auth [taaaNo=" + taaaNo + ", taskAssignment=" + taskAssignment
				+ ", specialContribution=" + specialContribution + ", appreciationReceived=" + appreciationReceived
				+ ", timeTaken=" + timeTaken + ", supportingDocuments=" + supportingDocuments + ", performanceRating="
				+ performanceRating + ", sai=" + sai + ", emp_id=" + emp_id + ", status=" + status + ", saf=" + saf
				+ ", saa=" + saa + "]";
	}
    
    
    
    

}
