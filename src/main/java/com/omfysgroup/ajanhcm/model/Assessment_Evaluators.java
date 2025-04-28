package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ASSESSMENT_EVALUATORS")
public class Assessment_Evaluators {

	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Assessment_Evaluators_seq")
@SequenceGenerator(name = "Assessment_Evaluators_seq", sequenceName = "ASSESSMENT_EVALUATORS_SEQ", allocationSize = 1)
	
	
@Column(name="ASSESS_EVAL_ID")
public int asses_eval_id;

@Column(name="TRAINEE_ID")
public int trainee_id;

@Column(name="ASSESSMENT_NO")
public int assessment_no;

@Column(name="EVALUATOR_EMP_ID")
	public int eval_emp_id;

@Column(name="CREATED_BY")
public int createdBy;


@Column(name="CREATION_DATE", updatable=false)
public Date creationDate;


@Column(name="UPDATED_BY")
public int updatedBy;


@Column(name="UPDATION_DATE",updatable=true)
public Date  updationDate;

@Column(name="EMP_ID")
public int empId;

public int getAsses_eval_id() {
	return asses_eval_id;
}

public void setAsses_eval_id(int asses_eval_id) {
	this.asses_eval_id = asses_eval_id;
}

public int getTrainee_id() {
	return trainee_id;
}

public void setTrainee_id(int trainee_id) {
	this.trainee_id = trainee_id;
}

public int getAssessment_no() {
	return assessment_no;
}

public void setAssessment_no(int assessment_no) {
	this.assessment_no = assessment_no;
}

public int getEval_emp_id() {
	return eval_emp_id;
}

public void setEval_emp_id(int eval_emp_id) {
	this.eval_emp_id = eval_emp_id;
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

public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

@Override
public String toString() {
	return "Assessment_Evaluators [asses_eval_id=" + asses_eval_id + ", trainee_id=" + trainee_id + ", assessment_no="
			+ assessment_no + ", eval_emp_id=" + eval_emp_id + ", createdBy=" + createdBy + ", creationDate="
			+ creationDate + ", updatedBy=" + updatedBy + ", updationDate=" + updationDate + ", empId=" + empId + "]";
}







}
