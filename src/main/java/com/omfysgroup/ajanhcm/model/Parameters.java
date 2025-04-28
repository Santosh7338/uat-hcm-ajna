package com.omfysgroup.ajanhcm.model;

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
@Table(name="ASSESSMENT_PARAMETERS")
public class Parameters {

	
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "par_assign_seq")
@SequenceGenerator(name = "par_assign_seq", sequenceName = "ASSESSMENT_PARAMETERS_SEQ", allocationSize = 1)
@Column(name="PARAMETER_NO")
public int parameterNo;

@Column(name="ASSESSMENT_TYPE")
public String assessmentType;

@Column(name="PARAMETER_NAME")
public  String parameterName;

@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
@Column(name="CREATION_DATE", updatable = false)
public Date creationDate;

@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
@Column(name="LAST_UPDATED_DATE" ,updatable = true )
public Date lastUpdatedDate;

@Column(name="IS_ACTIVE")
public String isActive;

public int getParameterNo() {
	return parameterNo;
}

public void setParameterNo(int parameterNo) {
	this.parameterNo = parameterNo;
}

public String getAssessmentType() {
	return assessmentType;
}

public void setAssessmentType(String assessmentType) {
	this.assessmentType = assessmentType;
}

public String getParameterName() {
	return parameterName;
}

public void setParameterName(String parameterName) {
	this.parameterName = parameterName;
}

public Date getCreationDate() {
	return creationDate;
}

public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}

public Date getLastUpdatedDate() {
	return lastUpdatedDate;
}

public void setLastUpdatedDate(Date lastUpdatedDate) {
	this.lastUpdatedDate = lastUpdatedDate;
}

public String getIsActive() {
	return isActive;
}

public void setIsActive(String isActive) {
	this.isActive = isActive;
}

@Override
public String toString() {
	return "Parameters [parameterNo=" + parameterNo + ", assessmentType=" + assessmentType + ", parameterName="
			+ parameterName + ", creationDate=" + creationDate + ", lastUpdatedDate=" + lastUpdatedDate + ", isActive="
			+ isActive + "]";
}






}
