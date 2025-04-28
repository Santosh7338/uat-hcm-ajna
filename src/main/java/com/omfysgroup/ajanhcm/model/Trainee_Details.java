package com.omfysgroup.ajanhcm.model;

import java.util.Date;

public class Trainee_Details {

	public int traineeId; 	
	public int assessmentNo;
	public String assessmentType;
	public String previousAssessmentDate;
	public String previousAssessmentResult;
	public String currentAssessmentResult;
	public Date scheduleForNextRound;
	public String remarks;
	public String nextAssessmentRequired;
	public Date scheduleForNextAssessment;
	public int empId;
	public int createdBy;
	public Date creationDate; 
    public int updatedBy;
	public Date updationDate;
	public int assoiciatNo;
	public String nameOfTheAssociate;
	private String email;
	private String emp_code;
	private String emp_first_name;
	private String emp_last_name;
	
	
	
	
	
	
	
	
	
	
	
	
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public int getAssessmentNo() {
		return assessmentNo;
	}
	public void setAssessmentNo(int assessmentNo) {
		this.assessmentNo = assessmentNo;
	}
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	public String getPreviousAssessmentDate() {
		return previousAssessmentDate;
	}
	public void setPreviousAssessmentDate(String previousAssessmentDate) {
		this.previousAssessmentDate = previousAssessmentDate;
	}
	public String getPreviousAssessmentResult() {
		return previousAssessmentResult;
	}
	public void setPreviousAssessmentResult(String previousAssessmentResult) {
		this.previousAssessmentResult = previousAssessmentResult;
	}
	public String getCurrentAssessmentResult() {
		return currentAssessmentResult;
	}
	public void setCurrentAssessmentResult(String currentAssessmentResult) {
		this.currentAssessmentResult = currentAssessmentResult;
	}
	public Date getScheduleForNextRound() {
		return scheduleForNextRound;
	}
	public void setScheduleForNextRound(Date scheduleForNextRound) {
		this.scheduleForNextRound = scheduleForNextRound;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getNextAssessmentRequired() {
		return nextAssessmentRequired;
	}
	public void setNextAssessmentRequired(String nextAssessmentRequired) {
		this.nextAssessmentRequired = nextAssessmentRequired;
	}
	public Date getScheduleForNextAssessment() {
		return scheduleForNextAssessment;
	}
	public void setScheduleForNextAssessment(Date scheduleForNextAssessment) {
		this.scheduleForNextAssessment = scheduleForNextAssessment;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdationDate() {
		return updationDate;
	}
	public void setUpdationDate(Date updationDate) {
		this.updationDate = updationDate;
	}
	public int getAssoiciatNo() {
		return assoiciatNo;
	}
	public void setAssoiciatNo(int assoiciatNo) {
		this.assoiciatNo = assoiciatNo;
	}
	public String getNameOfTheAssociate() {
		return nameOfTheAssociate;
	}
	public void setNameOfTheAssociate(String nameOfTheAssociate) {
		this.nameOfTheAssociate = nameOfTheAssociate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getEmp_first_name() {
		return emp_first_name;
	}
	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}
	public String getEmp_last_name() {
		return emp_last_name;
	}
	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}
	@Override
	public String toString() {
		return "Employee_Training_Evaluation_Details [traineeId=" + traineeId + ", assessmentNo=" + assessmentNo
				+ ", assessmentType=" + assessmentType + ", previousAssessmentDate=" + previousAssessmentDate
				+ ", previousAssessmentResult=" + previousAssessmentResult + ", currentAssessmentResult="
				+ currentAssessmentResult + ", scheduleForNextRound=" + scheduleForNextRound + ", remarks=" + remarks
				+ ", nextAssessmentRequired=" + nextAssessmentRequired + ", scheduleForNextAssessment="
				+ scheduleForNextAssessment + ", empId=" + empId + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", updatedBy=" + updatedBy + ", updationDate=" + updationDate + ", assoiciatNo="
				+ assoiciatNo + ", nameOfTheAssociate=" + nameOfTheAssociate + ", email=" + email + ", emp_code="
				+ emp_code + ", emp_first_name=" + emp_first_name + ", emp_last_name=" + emp_last_name + "]";
	}
	
	
	
	

	
}

	

