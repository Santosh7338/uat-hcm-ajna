package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="RECOGNITION_REPORTORS")
public class Recognition_Reportors {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recognition_management_seq")
	@SequenceGenerator(name = "recognition_management_seq", sequenceName = "RECOGNITION_REPORTORS_SEQ", allocationSize = 1)

	@Column(name = "RECOGNITION__REPORTOR_ID")
	private int recognition_reportors_id;
	
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

	@Column(name = "REPORTORS_ID")
	private int reportorsId;
	
	@Column(name = "RECOGNITION_NO")
	private String  recognition_no;
	
	@Column(name = "RECOGNITION_ID")
	private String  recognition_id;

	public int getRecognition_reportors_id() {
		return recognition_reportors_id;
	}

	public void setRecognition_reportors_id(int recognition_reportors_id) {
		this.recognition_reportors_id = recognition_reportors_id;
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

	public String getRecognition_no() {
		return recognition_no;
	}

	public void setRecognition_no(String recognition_no) {
		this.recognition_no = recognition_no;
	}

	public String getRecognition_id() {
		return recognition_id;
	}

	public void setRecognition_id(String recognition_id) {
		this.recognition_id = recognition_id;
	}

	@Override
	public String toString() {
		return "Recognition_Reportors [recognition_reportors_id=" + recognition_reportors_id + ", employeeId="
				+ employeeId + ", reportorsId=" + reportorsId + ", recognition_no=" + recognition_no
				+ ", recognition_id=" + recognition_id + "]";
	}
	
	

}
