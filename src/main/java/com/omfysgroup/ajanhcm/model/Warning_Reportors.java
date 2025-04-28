package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="WARNING_MANAGEMENT_REPORTORS")
public class Warning_Reportors {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "warning_management_seq")
	@SequenceGenerator(name = "warning_management_seq", sequenceName = "WARNING_MANAGEMENT_REPORTORS_", allocationSize = 1)

	@Column(name = "WARNING_MANAGEMENT_REPORTORS")
	private int warningReportorsId;
	
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	@Column(name = "REPORTORS_ID")
	private int reportorsId;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "SUB_CATEGORY")
	private String sub_category;
	
	
	@Column(name = "SUB_SUB_CATEGORY")
	private String sub_sub_category;
	
	@Column(name = "WARNING_NO")
	private String  warningNo;
	
	

	public int getWarningReportorsId() {
		return warningReportorsId;
	}

	public void setWarningReportorsId(int warningReportorsId) {
		this.warningReportorsId = warningReportorsId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getReportorsId() {
		return reportorsId;
	}

	public void setReportorsId(int reportorsId) {
		this.reportorsId = reportorsId;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSub_category() {
		return sub_category;
	}

	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}

	public String getSub_sub_category() {
		return sub_sub_category;
	}

	public void setSub_sub_category(String sub_sub_category) {
		this.sub_sub_category = sub_sub_category;
	}
	
	
	public String getWarningNo() {
		return warningNo;
	}

	public void setWarningNo(String warningNo) {
		this.warningNo = warningNo;
	}

	@Override
	public String toString() {
		return "Warning_Reportors [warningReportorsId=" + warningReportorsId + ", employeeId=" + employeeId
				+ ", reportorsId=" + reportorsId + ", category=" + category + ", sub_category=" + sub_category
				+ ", sub_sub_category=" + sub_sub_category + ", warningNo=" + warningNo + "]";
	}
	
	

	
	

	
	
	
}
