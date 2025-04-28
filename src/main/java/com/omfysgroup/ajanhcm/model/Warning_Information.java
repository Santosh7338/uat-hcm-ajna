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

@Entity
@Table(name="WARNING_MANAGEMENT")
public class Warning_Information {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warning_management_seq")
@SequenceGenerator(name = "warning_management_seq", sequenceName = "WARNING_MANAGEMENT_SEQ", allocationSize = 1)

@Column(name = "WARNING_ID")
private int warningId;

@Column(name = "EMPLOYEE_ID")
private int employeeId;

@Column(name = "EMPLOYEE_NAME")
private String employeeName;

@Column(name = "WARNING_NO")
private int warningNo;

@Column(name = "CRITICALITY")
private String criticality;

@Column(name = "CATEGORY")
private String category;

@Column(name = "SUB_CATEGORY")
private String subCategory;

@Column(name = "SUB_SUB_CATEGORY")
private String sub_SubCategory;

@Column(name = "FILE_NAME")
private String fileName;

@Column(name = "FILE_TYPE")
private String fileType;

@Column(name = "GENERATED_BY")
private String generatedBy;

@Column(name = "TEMPLATE")
private byte[] template;

@Column(name = "MAIL_CONTENT")
private String mailContent;

@Column(name = "ISSUENCE_DATE")
public Date issuence_Date;

@Transient
public String repotersName;


public int getWarningId() {
	return warningId;
}

public void setWarningId(int warningId) {
	warningId = warningId;
}

public int getEmployeeId() {
	return employeeId;
}

public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}

public String getEmployeeName() {
	return employeeName;
}

public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}

public int getWarningNo() {
	return warningNo;
}

public void setWarningNo(int warningNo) {
	this.warningNo = warningNo;
}

public String getCriticality() {
	return criticality;
}

public void setCriticality(String criticality) {
	this.criticality = criticality;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getSubCategory() {
	return subCategory;
}

public void setSubCategory(String subCategory) {
	this.subCategory = subCategory;
}

public String getSub_SubCategory() {
	return sub_SubCategory;
}

public void setSub_SubCategory(String sub_SubCategory) {
	this.sub_SubCategory = sub_SubCategory;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getFileType() {
	return fileType;
}

public void setFileType(String fileType) {
	this.fileType = fileType;
}

public String getMailContent() {
	return mailContent;
}

public void setMailContent(String mailContent) {
	this.mailContent = mailContent;
}

public byte[] getTemplate() {
	return template;
}

public void setTemplate(byte[] template) {
	this.template = template;
}


public String getGeneratedBy() {
	return generatedBy;
}

public void setGeneratedBy(String generatedBy) {
	this.generatedBy = generatedBy;
}

public Date getIssuence_Date() {
	return issuence_Date;
}

public void setIssuence_Date(Date issuence_Date) {
	this.issuence_Date = issuence_Date;
}



public String getRepotersName() {
	return repotersName;
}

public void setRepotersName(String repotersName) {
	this.repotersName = repotersName;
}

@Override
public String toString() {
	return "Warning_Information [warningId=" + warningId + ", employeeId=" + employeeId + ", employeeName="
			+ employeeName + ", warningNo=" + warningNo + ", criticality=" + criticality + ", category=" + category
			+ ", subCategory=" + subCategory + ", sub_SubCategory=" + sub_SubCategory + ", fileName=" + fileName
			+ ", fileType=" + fileType + ", generatedBy=" + generatedBy + ", template=" + Arrays.toString(template)
			+ ", mailContent=" + mailContent + ", issuence_Date=" + issuence_Date + "]";
}





}
