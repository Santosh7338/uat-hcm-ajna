package com.omfysgroup.ajanhcm.model;

import java.util.Arrays;
import java.util.Date;

public class RGS {
	
	private int employeeId;
	private String employeeName;
	private int recognitionNo;
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
	private int attendanceCountRecognition;
	private int productivityCountRecognition;
	private int behaviourCountRecognition;
	private int communicationCountRecognition;
	private int proactivenessCountRecognition;
    private int customCountRecognition ;
    private int generatedBy ;
    private String createdPersonName;
    public int recognitionId;
    public String rating;
    
    
    
    
    
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
	public int getRecognitionNo() {
		return recognitionNo;
	}
	public void setRecognitionNo(int recognitionNo) {
		this.recognitionNo = recognitionNo;
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
	public int getAttendanceCountRecognition() {
		return attendanceCountRecognition;
	}
	public void setAttendanceCountRecognition(int attendanceCountRecognition) {
		this.attendanceCountRecognition = attendanceCountRecognition;
	}
	public int getProductivityCountRecognition() {
		return productivityCountRecognition;
	}
	public void setProductivityCountRecognition(int productivityCountRecognition) {
		this.productivityCountRecognition = productivityCountRecognition;
	}
	public int getBehaviourCountRecognition() {
		return behaviourCountRecognition;
	}
	public void setBehaviourCountRecognition(int behaviourCountRecognition) {
		this.behaviourCountRecognition = behaviourCountRecognition;
	}
	public int getCommunicationCountRecognition() {
		return communicationCountRecognition;
	}
	public void setCommunicationCountRecognition(int communicationCountRecognition) {
		this.communicationCountRecognition = communicationCountRecognition;
	}
	public int getProactivenessCountRecognition() {
		return proactivenessCountRecognition;
	}
	public void setProactivenessCountRecognition(int proactivenessCountRecognition) {
		this.proactivenessCountRecognition = proactivenessCountRecognition;
	}
	public int getCustomCountRecognition() {
		return customCountRecognition;
	}
	public void setCustomCountRecognition(int customCountRecognition) {
		this.customCountRecognition = customCountRecognition;
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
	public int getRecognitionId() {
		return recognitionId;
	}
	public void setRecognitionId(int recognitionId) {
		this.recognitionId = recognitionId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "RGS [employeeId=" + employeeId + ", employeeName=" + employeeName + ", recognitionNo=" + recognitionNo
				+ ", criticality=" + criticality + ", category=" + category + ", subCategory=" + subCategory
				+ ", sub_SubCategory=" + sub_SubCategory + ", reportorsId=" + reportorsId + ", reportorsName="
				+ reportorsName + ", fileName=" + fileName + ", fileType=" + fileType + ", mailContent=" + mailContent
				+ ", upTemplate=" + Arrays.toString(upTemplate) + ", issuence_Date=" + issuence_Date + ", issue_Date="
				+ issue_Date + ", attendanceCountRecognition=" + attendanceCountRecognition
				+ ", productivityCountRecognition=" + productivityCountRecognition + ", behaviourCountRecognition="
				+ behaviourCountRecognition + ", communicationCountRecognition=" + communicationCountRecognition
				+ ", proactivenessCountRecognition=" + proactivenessCountRecognition + ", customCountRecognition="
				+ customCountRecognition + ", generatedBy=" + generatedBy + ", createdPersonName=" + createdPersonName
				+ ", recognitionId=" + recognitionId + ", rating=" + rating + "]";
	}
    
    
    
	    

}
