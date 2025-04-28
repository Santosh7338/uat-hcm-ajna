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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="EVALUATION_PARAMETERS")
public class Evaluation_Parameters {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Evaluation_Parameters_seq")
	@SequenceGenerator(name = "Evaluation_Parameters_seq", sequenceName = "EVALUATION_PARAMETERS_SEQ", allocationSize = 1)
	@Column(name="EVAL_ID")
	public int evalId;
	
	@Column(name="ASSESSMENT_NO")
	public int assessmentNo;
	
	@Column(name="PARAMETERS")
	public String parameters;
	
	@Column(name="STATUS")
	public String status; 
	
	@Column(name="IMPPROVEMENT_POINTS")
	public String improvementPoints;
	
	@Column(name="UPDATED_BY")
	public int updatedBy;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name="UPDATION_DATE",updatable = true)
	public Date updationDate;
	
	@Column(name="CREATED_BY")
	public int createdBy;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name="CREATION_DATE" ,updatable = false)
	public Date creationDate;
	
	@Column(name="TRAINEE_ID")
	public int traineeId;

	@Column(name="EMP_ID")
	public int empId;

	public int getEvalId() {
		return evalId;
	}

	public void setEvalId(int evalId) {
		this.evalId = evalId;
	}

	public int getAssessmentNo() {
		return assessmentNo;
	}

	public void setAssessmentNo(int assessmentNo) {
		this.assessmentNo = assessmentNo;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImprovementPoints() {
		return improvementPoints;
	}

	public void setImprovementPoints(String improvementPoints) {
		this.improvementPoints = improvementPoints;
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

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Evaluation_Parameters [evalId=" + evalId + ", assessmentNo=" + assessmentNo + ", parameters="
				+ parameters + ", status=" + status + ", improvementPoints=" + improvementPoints + ", updatedBy="
				+ updatedBy + ", updationDate=" + updationDate + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", traineeId=" + traineeId + ", empId=" + empId + "]";
	}

		
}