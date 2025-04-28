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
@Table(name="ASSIGN_VIDEO_COURSES")
public class Assign_Video_Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "video_assign_seq")
	@SequenceGenerator(name = "video_assign_seq", sequenceName = "ASSIGN_VIDEO_COURSES_SEQ", allocationSize = 1)
	
	@Column(name = "ASSIGN_COURSE_ID")
	private int assign_course_id;
	
	@Column(name = "COURSE_NAME")
	private String course_name;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee_Master employee_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLANNED_START_DATE", updatable = true)
	private Date planned_start_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLANNED_END_DATE", updatable = true)
	private Date planned_end_date;
	
	@Column(name = "PAID_NONPAID")
	private String paid_nonpaid;
	
	@Column(name ="COURSE_COST")
	private int course_cost;
	
	@Column(name = "ONLINE_OFFLINE")
	private String online_offline;
	
	@Column(name = "CERFYING_AUTHORITY")
	private String cerfying_authority;
	
	@Column(name = "COURSE_STATUS")
	private String course_status;
	
	@Column(name = "COURSE_REMARKS")
	private String course_remarks;
	
	@Column(name = "AR")
	private int administrative_authority;
	
	@Column(name = "COURSES_ID")
	private String courses_id;
	
	@Column(name = "FR")
	private int functional_authority;
	
	@Column(name = "IS_ACTIVE")
	private String is_active;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE", updatable = true)
	private Date last_updated_date;
	
	@Column(name = "EXAM_APPLICABLE")
	private String exam_applicable;
	
	@Column(name = "COURSE_MASTER_ID")
	private int course_master_id;
	
	@Column(name = "COURSES_COMPETENCY")
	private String courses_competency;
	
//	@Column(name = "DOCUMENT_UPLOAD")
//	private byte[] document_upload;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ACTUAL_START_DATE", updatable = true)
	private Date actual_start_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ACTUAL_END_DATE", updatable = true)
	private Date actual_completion_date;
	
	@Column(name = "TOTAL_PERCENTAGE")
	private int total_percentage;
	
	@Transient
	private String plannedSdateTrans;
	
	@Transient
	private String plannedEdateTrans;
	
	@Transient
	private String actaulStartTrans;
	
	@Transient
	private String actualEndTrans;
	
	@Transient
	private String employee_name;
	
	@Transient
	private String email_address;
	
	@Transient
	private String completion_date_certificate;
	
	
	
	

	public int getAssign_course_id() {
		return assign_course_id;
	}

	public void setAssign_course_id(int assign_course_id) {
		this.assign_course_id = assign_course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public Employee_Master getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Employee_Master employee_id) {
		this.employee_id = employee_id;
	}

	public Date getPlanned_start_date() {
		return planned_start_date;
	}

	public void setPlanned_start_date(Date planned_start_date) {
		this.planned_start_date = planned_start_date;
	}

	public Date getPlanned_end_date() {
		return planned_end_date;
	}

	public void setPlanned_end_date(Date planned_end_date) {
		this.planned_end_date = planned_end_date;
	}

	public String getPaid_nonpaid() {
		return paid_nonpaid;
	}

	public void setPaid_nonpaid(String paid_nonpaid) {
		this.paid_nonpaid = paid_nonpaid;
	}

	public int getCourse_cost() {
		return course_cost;
	}

	public void setCourse_cost(int course_cost) {
		this.course_cost = course_cost;
	}

	public String getOnline_offline() {
		return online_offline;
	}

	public void setOnline_offline(String online_offline) {
		this.online_offline = online_offline;
	}

	public String getCerfying_authority() {
		return cerfying_authority;
	}

	public void setCerfying_authority(String cerfying_authority) {
		this.cerfying_authority = cerfying_authority;
	}

	public String getCourse_status() {
		return course_status;
	}

	public void setCourse_status(String course_status) {
		this.course_status = course_status;
	}

	public String getCourse_remarks() {
		return course_remarks;
	}

	public void setCourse_remarks(String course_remarks) {
		this.course_remarks = course_remarks;
	}

	public int getAdministrative_authority() {
		return administrative_authority;
	}

	public void setAdministrative_authority(int administrative_authority) {
		this.administrative_authority = administrative_authority;
	}

	public String getCourses_id() {
		return courses_id;
	}

	public void setCourses_id(String courses_id) {
		this.courses_id = courses_id;
	}

	public int getFunctional_authority() {
		return functional_authority;
	}

	public void setFunctional_authority(int functional_authority) {
		this.functional_authority = functional_authority;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	public String getExam_applicable() {
		return exam_applicable;
	}

	public void setExam_applicable(String exam_applicable) {
		this.exam_applicable = exam_applicable;
	}

	public int getCourse_master_id() {
		return course_master_id;
	}

	public void setCourse_master_id(int course_master_id) {
		this.course_master_id = course_master_id;
	}

	public String getCourses_competency() {
		return courses_competency;
	}

	public void setCourses_competency(String courses_competency) {
		this.courses_competency = courses_competency;
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

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public int getTotal_percentage() {
		return total_percentage;
	}

	public void setTotal_percentage(int total_percentage) {
		this.total_percentage = total_percentage;
	}

	public String getCompletion_date_certificate() {
		return completion_date_certificate;
	}

	public void setCompletion_date_certificate(String completion_date_certificate) {
		this.completion_date_certificate = completion_date_certificate;
	}
	
	
}
