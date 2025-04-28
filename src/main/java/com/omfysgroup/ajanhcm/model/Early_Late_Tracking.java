package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ATTENDANCE_REGULARIZATION")
public class Early_Late_Tracking 
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "att_reg_seq")
	@SequenceGenerator(name = "att_reg_seq", sequenceName = "ATTENDANCE_REGULARIZATION_SEQ", allocationSize = 1)
	
	
	@Column(name = "ATTENDANCE_REG_ID")
	private int attendanceRegId;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee_Master emp_id;
	
	@Column(name = "EMPLOYEE_NAME")
	private String employee_name;
	
	@Column(name = "EMPLOYEE_CODE")
	private String employee_code;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "START_DATE" , updatable = false)
	private Date start_date;

	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "END_DATE" , updatable = false)
	private Date end_date;
	
	@Column(name = "START_TIME")
	private String start_time;
	
	
	@Column(name = "END_TIME")
	private String end_time;
	
	
	@Column(name = "REASON_LEAVE")
	private String reason_leave;
	
	
	@Column(name = "NUMBER_DAYS")
	private String number_days;
	

	@Column(name = "TOTAL_TIME")
	private String total_time;
	
	
	@Column(name = "FR_ID")
	private int fr_id;


	@Column(name = "AR_ID")
	private int ar_id;	

	@Column(name = "FR_COMMENT")
	private String fr_comment;
	

	@Column(name = "AR_COMMENT")
	private String  ar_comment;
	
	
	@Column(name = "CATEGORIES")
	private String  category;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date ;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date ;
	
	@Column(name = "LEAVE_STATUS")
	private String leave_Status;
	
	
	@Transient
	private String startdatetrans;
	
	@Transient
	private String enddatetrans;
	
	@Transient
	private String creationdatetrans;
	
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLANNED_START_DATE", updatable = false)
	private Date planned_start;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLANNED_END_DATE", updatable = false)
	private Date planned_completion;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ACTUAL_START_DATE", updatable = true)
	private Date actual_start_date;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ACTUAL_END_DATE", updatable = true)
	private Date actual_completion_date;
	
	
	
	@Transient
	private String plannedSdateTrans;

	@Transient
	private String plannedEdateTrans;

	@Transient
	private String actaulStartTrans;

	@Transient
	private String actualEndTrans;
	
	
	

	public int getAttendanceRegId() {
		return attendanceRegId;
	}

	public void setAttendanceRegId(int attendanceRegId) {
		this.attendanceRegId = attendanceRegId;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getReason_leave() {
		return reason_leave;
	}

	public void setReason_leave(String reason_leave) {
		this.reason_leave = reason_leave;
	}

	public String getNumber_days() {
		return number_days;
	}

	public void setNumber_days(String number_days) {
		this.number_days = number_days;
	}

	public String getTotal_time() {
		return total_time;
	}

	public void setTotal_time(String total_time) {
		this.total_time = total_time;
	}

	public int getFr_id() {
		return fr_id;
	}

	public void setFr_id(int fr_id) {
		this.fr_id = fr_id;
	}

	public int getAr_id() {
		return ar_id;
	}

	public void setAr_id(int ar_id) {
		this.ar_id = ar_id;
	}

	public String getFr_comment() {
		return fr_comment;
	}

	public void setFr_comment(String fr_comment) {
		this.fr_comment = fr_comment;
	}

	public String getAr_comment() {
		return ar_comment;
	}

	public void setAr_comment(String ar_comment) {
		this.ar_comment = ar_comment;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getLeave_Status() {
		return leave_Status;
	}

	public void setLeave_Status(String leave_Status) {
		this.leave_Status = leave_Status;
	}

	public String getStartdatetrans() {
		return startdatetrans;
	}

	public void setStartdatetrans(String startdatetrans) {
		this.startdatetrans = startdatetrans;
	}

	public String getEnddatetrans() {
		return enddatetrans;
	}

	public void setEnddatetrans(String enddatetrans) {
		this.enddatetrans = enddatetrans;
	}

	public String getCreationdatetrans() {
		return creationdatetrans;
	}

	public void setCreationdatetrans(String creationdatetrans) {
		this.creationdatetrans = creationdatetrans;
	}

	public Date getPlanned_start() {
		return planned_start;
	}

	public void setPlanned_start(Date planned_start) {
		this.planned_start = planned_start;
	}

	public Date getPlanned_completion() {
		return planned_completion;
	}

	public void setPlanned_completion(Date planned_completion) {
		this.planned_completion = planned_completion;
	}

	public Date getActual_start_date() {
		return actual_start_date;
	}

	public void setActual_start_date(Date actual_start_date) {
		this.actual_start_date = actual_start_date;
	}

	public Date getActual_completion_date() {
		return actual_completion_date;
	}

	public void setActual_completion_date(Date actual_completion_date) {
		this.actual_completion_date = actual_completion_date;
	}

	public String getPlannedSdateTrans() {
		return plannedSdateTrans;
	}

	public void setPlannedSdateTrans(String plannedSdateTrans) {
		this.plannedSdateTrans = plannedSdateTrans;
	}

	public String getPlannedEdateTrans() {
		return plannedEdateTrans;
	}

	public void setPlannedEdateTrans(String plannedEdateTrans) {
		this.plannedEdateTrans = plannedEdateTrans;
	}

	public String getActaulStartTrans() {
		return actaulStartTrans;
	}

	public void setActaulStartTrans(String actaulStartTrans) {
		this.actaulStartTrans = actaulStartTrans;
	}

	public String getActualEndTrans() {
		return actualEndTrans;
	}

	public void setActualEndTrans(String actualEndTrans) {
		this.actualEndTrans = actualEndTrans;
	}
	
	
	
	

	
	
	
}

