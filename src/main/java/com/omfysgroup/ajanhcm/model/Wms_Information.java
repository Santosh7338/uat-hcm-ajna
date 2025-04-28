package com.omfysgroup.ajanhcm.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;

public class Wms_Information {

	
	private int employeeId;
	private String employeeName;
	private int warningNo;
	private String criticality;
	private String category;
	private String subCategory;
	private String sub_SubCategory;
	private int reportorsId;
	private String reportorsName;
	private String fileName;
	private String fileType;
	private String mailContent;
	private byte[] upTemplate;
	private Date issuence_Date;
	private String issue_Date;
	private int attendanceCount;
	private int productivityCount;
	private int behaviourCount;
	private int communicationCount;
	private int proactivenessCount;
    private int customCount ;
    private int generatedBy ;
    private String createdPersonName;
    public int warningId;
	
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

	public int getReportorsId() {
		return reportorsId;
	}

	public void setReportorsId(int reportorsId) {
		this.reportorsId = reportorsId;
	}

	public String getReportorsName() {
		return reportorsName;
	}

	public void setReportorsName(String reportorsName) {
		this.reportorsName = reportorsName;
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

	public byte[] getUpTemplate() {
		return upTemplate;
	}

	public void setUpTemplate(byte[] upTemplate) {
		this.upTemplate = upTemplate;
	}

	public Date getIssuence_Date() {
		return issuence_Date;
	}

	public void setIssuence_Date(Date issuence_Date) {
		this.issuence_Date = issuence_Date;
	}

	public String getIssue_Date() {
		return issue_Date;
	}

	public void setIssue_Date(String issue_Date) {
		this.issue_Date = issue_Date;
	}
	
	

	public int getAttendanceCount() {
		return attendanceCount;
	}

	public void setAttendanceCount(int attendanceCount) {
		this.attendanceCount = attendanceCount;
	}

	public int getProductivityCount() {
		return productivityCount;
	}

	public void setProductivityCount(int productivityCount) {
		this.productivityCount = productivityCount;
	}

	public int getBehaviourCount() {
		return behaviourCount;
	}

	public void setBehaviourCount(int behaviourCount) {
		this.behaviourCount = behaviourCount;
	}

	public int getCommunicationCount() {
		return communicationCount;
	}

	public void setCommunicationCount(int communicationCount) {
		this.communicationCount = communicationCount;
	}

	public int getProactivenessCount() {
		return proactivenessCount;
	}

	public void setProactivenessCount(int proactivenessCount) {
		this.proactivenessCount = proactivenessCount;
	}
	
	

	public int getCustomCount() {
		return customCount;
	}

	public void setCustomCount(int customCount) {
		this.customCount = customCount;
	}
	
	

	public int getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(int generatedBy) {
		this.generatedBy = generatedBy;
	}
	
	

	public String getCreatedPersonName() {
		return createdPersonName;
	}

	public void setCreatedPersonName(String createdPersonName) {
		this.createdPersonName = createdPersonName;
	}
	
	

	public int getWarningId() {
		return warningId;
	}

	public void setWarningId(int warningId) {
		this.warningId = warningId;
	}

	@Override
	public String toString() {
		return "Wms_Information [employeeId=" + employeeId + ", employeeName=" + employeeName + ", warningNo="
				+ warningNo + ", criticality=" + criticality + ", category=" + category + ", subCategory=" + subCategory
				+ ", sub_SubCategory=" + sub_SubCategory + ", reportorsId=" + reportorsId + ", reportorsName="
				+ reportorsName + ", fileName=" + fileName + ", fileType=" + fileType + ", mailContent=" + mailContent
				+ ", upTemplate=" + Arrays.toString(upTemplate) + ", issuence_Date=" + issuence_Date + ", issue_Date="
				+ issue_Date + ", attendanceCount=" + attendanceCount + ", productivityCount=" + productivityCount
				+ ", behaviourCount=" + behaviourCount + ", communicationCount=" + communicationCount
				+ ", proactivenessCount=" + proactivenessCount + ", customCount=" + customCount + ", generatedBy="
				+ generatedBy + ", createdPersonName=" + createdPersonName + ", warningId=" + warningId + "]";
	}

	
	

	
	
	

	
	
	

	

}
