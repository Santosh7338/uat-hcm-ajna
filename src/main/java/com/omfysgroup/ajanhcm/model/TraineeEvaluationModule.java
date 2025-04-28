package com.omfysgroup.ajanhcm.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TRAINING_EVALUATION_MODULE")
public class TraineeEvaluationModule {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TraineeEvaluationModule_seq")
	@SequenceGenerator(name = "TraineeEvaluationModule_seq", sequenceName = "TRAINING_EVALUATION_MODULE_SEQ", allocationSize = 1)
	
@Column(name="TRAINEE_ID")	
public int traineeId; 	
	
	/*
	 * @Column(name="ASSOCIATES_NAME") public int nameOfTheAssociats;
	 */

@Column(name="ASSESSMENT_NO")	
public int assessmentNo;

@Column(name="ASSESSMENT_TYPE")	
public String assessmentType;

@Column(name="PREVIOUS_ASSESSMENT_DATE")	
public String previousAssessmentDate;

@Column(name="PREVIOUS_ASSESSMENT_RESULT")	
public String previousAssessmentResult;

@Column(name="CURRENT_ASSESSMENT_RESULT")	
public String currentAssessmentResult;

@Column(name="SCHEDULE_FOR_NEXT_ROUND")
public Date scheduleForNextRound;

@Column(name="REMARKS")	
public String remarks;

@Column(name="NEXT_ASSESSMENT_REQUIRED")	
public String nextAssessmentRequired;




@Column(name="SCHEDULE_FOR_NEXT_ASSESSMENT")	
public Date scheduleForNextAssessment;

@Column(name="EMP_ID")
public int empId;



@Column(name="CREATED_BY")
public int createdBy;

@Column(name="CREATION_DATE",updatable=false)
public Date creationDate; 

@Column(name="UPDATED_BY")
public int updatedBy;

@Column(name="UPDATION_DATE",updatable=true)
public Date updationDate;

@Column(name="ASSOCIATE_NO")
public int assoiciatNo;

@Column(name="NAME_OF_THE_ASSOCIATE")
public String nameOfTheAssociate;

@Transient
public String dueDate;

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

public String getDueDate() {
	return dueDate;
}

public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
}

@Override
public String toString() {
	return "TraineeEvaluationModule [traineeId=" + traineeId + ", assessmentNo=" + assessmentNo + ", assessmentType="
			+ assessmentType + ", previousAssessmentDate=" + previousAssessmentDate + ", previousAssessmentResult="
			+ previousAssessmentResult + ", currentAssessmentResult=" + currentAssessmentResult
			+ ", scheduleForNextRound=" + scheduleForNextRound + ", remarks=" + remarks + ", nextAssessmentRequired="
			+ nextAssessmentRequired + ", scheduleForNextAssessment=" + scheduleForNextAssessment + ", empId=" + empId
			+ ", createdBy=" + createdBy + ", creationDate=" + creationDate + ", updatedBy=" + updatedBy
			+ ", updationDate=" + updationDate + ", assoiciatNo=" + assoiciatNo + ", nameOfTheAssociate="
			+ nameOfTheAssociate + "]";
}



}