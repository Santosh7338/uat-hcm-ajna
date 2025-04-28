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
@Table(name="DAILY_ATTENDANCE_REPORT")
public class Daily_Attendance_Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DAILY_ATTENDANCE_REPORT_SEQ")
	@SequenceGenerator(name = "DAILY_ATTENDANCE_REPORT_SEQ", sequenceName = "DAILY_ATTENDANCE_REPORT_SEQ", allocationSize = 1)
	
	@Column(name = "ID")
	private int id;
	
	@Column(name = "EMP_CODE")
	private String Emp_Code;
	
	@Column(name = "EMP_NAME")
	private String Employee_Name;
	
	@Column(name = "SHIFT")
	private String Shift;
	
	@Column(name = "S_IN_TIME")
	private String Shift_In_time; 
	
	@Column(name = "S_OUT_TIME")
	private String Shift_Out_time; 
	
	@Column(name = "A_IN_TIME")
	private String A_In_time; 
	
	@Column(name = "A_OUT_TIME")
	private String A_Out_time; 
	
	@Column(name = "WORK_DURATION")
	private String Work_Duration; 
	
	@Column(name = "OVER_TIME")
	private String OT; 
	
	@Column(name = "TOTAL_DURATION")
	private String Total_Duration;
	
	@Column(name = "LATE_BY")
	private String Late_by;
	
	@Column(name = "EARLY_GOING_BY")
	private String Early_Going_by;
	
	@Column(name = "ATTENDANCE_STATUS")
	private String Status;
	
	@Column(name = "PUNCH_RECORDS")
	private String Punch_Records;
	

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ATTENDANCE_DATE", updatable = false)
	private Date attendance_date;
	

	@Column(name = "DEPARTMENT")
	private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getEmp_Code() {
		return Emp_Code;
	}

	public void setEmp_Code(String emp_Code) {
		Emp_Code = emp_Code;
	}

	public String getEmployee_Name() {
		return Employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		Employee_Name = employee_Name;
	}

	public String getShift() {
		return Shift;
	}

	public void setShift(String shift) {
		Shift = shift;
	}

	public String getShift_In_time() {
		return Shift_In_time;
	}

	public void setShift_In_time(String shift_In_time) {
		Shift_In_time = shift_In_time;
	}

	public String getShift_Out_time() {
		return Shift_Out_time;
	}

	public void setShift_Out_time(String shift_Out_time) {
		Shift_Out_time = shift_Out_time;
	}

	public String getA_In_time() {
		return A_In_time;
	}

	public void setA_In_time(String a_In_time) {
		A_In_time = a_In_time;
	}

	public String getA_Out_time() {
		return A_Out_time;
	}

	public void setA_Out_time(String a_Out_time) {
		A_Out_time = a_Out_time;
	}

	public String getWork_Duration() {
		return Work_Duration;
	}

	public void setWork_Duration(String work_Duration) {
		Work_Duration = work_Duration;
	}

	public String getOT() {
		return OT;
	}

	public void setOT(String oT) {
		OT = oT;
	}

	public String getTotal_Duration() {
		return Total_Duration;
	}

	public void setTotal_Duration(String total_Duration) {
		Total_Duration = total_Duration;
	}

	public String getLate_by() {
		return Late_by;
	}

	public void setLate_by(String late_by) {
		Late_by = late_by;
	}

	public String getEarly_Going_by() {
		return Early_Going_by;
	}

	public void setEarly_Going_by(String early_Going_by) {
		Early_Going_by = early_Going_by;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPunch_Records() {
		return Punch_Records;
	}

	public void setPunch_Records(String punch_Records) {
		Punch_Records = punch_Records;
	}

	public Date getAttendance_date() {
		return attendance_date;
	}

	public void setAttendance_date(Date attendance_date) {
		this.attendance_date = attendance_date;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
    
}
