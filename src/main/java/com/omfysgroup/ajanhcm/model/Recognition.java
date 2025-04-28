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
@Table(name="RECOGNITION_MGMT")
public class Recognition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recognition_seq")
	@SequenceGenerator(name = "recognition_seq", sequenceName = "RECOGNITION_MGMT_SEQ", allocationSize = 1)

	@Column(name = "RECOGNITION_ID")
	public int recognition_Id;
	
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Column(name = "RECOGNITION_NO")
	private int recognitionNo;

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

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ISSUENCE_DATE")
	public Date issuence_Date = new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "RATING")
	public String rating;

	public int getRecognition_Id() {
		return recognition_Id;
	}

	public void setRecognition_Id(int recognition_Id) {
		this.recognition_Id = recognition_Id;
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

	public String getGeneratedBy() {
		return generatedBy;
	}

	public void setGeneratedBy(String generatedBy) {
		this.generatedBy = generatedBy;
	}

	public byte[] getTemplate() {
		return template;
	}

	public void setTemplate(byte[] template) {
		this.template = template;
	}

	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public Date getIssuence_Date() {
		return issuence_Date;
	}

	public void setIssuence_Date(Date issuence_Date) {
		this.issuence_Date = issuence_Date;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Recognition [recognition_Id=" + recognition_Id + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", recognitionNo=" + recognitionNo + ", criticality=" + criticality + ", category="
				+ category + ", subCategory=" + subCategory + ", sub_SubCategory=" + sub_SubCategory + ", fileName="
				+ fileName + ", fileType=" + fileType + ", generatedBy=" + generatedBy + ", template="
				+ Arrays.toString(template) + ", mailContent=" + mailContent + ", issuence_Date=" + issuence_Date
				+ ", rating=" + rating + "]";
	}
	
	
	



}
