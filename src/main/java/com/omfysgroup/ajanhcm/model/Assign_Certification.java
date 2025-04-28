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
@Table(name="ASSIGN_CERTIFICATION")
public class Assign_Certification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificate_assign_seq")
	@SequenceGenerator(name = "certificate_assign_seq", sequenceName = "ASSIGN_CERTIFICATION_SEQ", allocationSize = 1)
	
	@Column(name = "ASSIGN_ID")
	private int assign_id;
	
	@Column(name = "CERTIFICATE_NAME")
	private String certificate_name;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee_Master emp_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLANNED_START_DATE", updatable = true)
	private Date planned_start;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLANNED_END_DATE", updatable = true)
	private Date planned_completion;
	
	@Column(name = "PAID_UNPAID")
	private String paid_unpaid;
	
	@Column(name ="COSTT")
	private int cost;
	
	@Column(name = "ONLINE_OFFLINE")
	private String online_offline;
	
	@Column(name = "CERF_AUTHORITY")
	private String certifi_authority;
	
	@Column(name = "STATUS")
	private String certificate_status;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "AR")
	private int administrative_authority;
	
	@Column(name = "CERTIFICATE_ID")
	private String certificate_id;
	
	@Column(name = "FR")
	private int functional_authority;
	
	@Column(name = "IS_ACTIVE")
	private String is_activate;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE", updatable = true)
	private Date last_updated_date;
	
	@Column(name = "EXAM_APPLICABLE")
	private String exam_applicability;
	
	@Column(name = "MASTER_ID")
	private int master_id;
	
	@Column(name = "COMPETENCY")
	private String competencies;
	
	@Column(name = "DOCUMENT_UPLOAD")
	private byte[] document_upload;
	
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
	
	@Transient
	private String employee_name;
	
	@Transient
	private String email;

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public int getAssign_id() {
		return assign_id;
	}

	public void setAssign_id(int assign_id) {
		this.assign_id = assign_id;
	}

	public String getCertificate_name() {
		return certificate_name;
	}

	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
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

	public String getPaid_unpaid() {
		return paid_unpaid;
	}

	public void setPaid_unpaid(String paid_unpaid) {
		this.paid_unpaid = paid_unpaid;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getOnline_offline() {
		return online_offline;
	}

	public void setOnline_offline(String online_offline) {
		this.online_offline = online_offline;
	}

	public String getCertifi_authority() {
		return certifi_authority;
	}

	public void setCertifi_authority(String certifi_authority) {
		this.certifi_authority = certifi_authority;
	}

	public String getCertificate_status() {
		return certificate_status;
	}

	public void setCertificate_status(String certificate_status) {
		this.certificate_status = certificate_status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getAdministrative_authority() {
		return administrative_authority;
	}

	public void setAdministrative_authority(int administrative_authority) {
		this.administrative_authority = administrative_authority;
	}

	public String getCertificate_id() {
		return certificate_id;
	}

	public void setCertificate_id(String certificate_id) {
		this.certificate_id = certificate_id;
	}

	public int getFunctional_authority() {
		return functional_authority;
	}

	public void setFunctional_authority(int functional_authority) {
		this.functional_authority = functional_authority;
	}

	public String getIs_activate() {
		return is_activate;
	}

	public void setIs_activate(String is_activate) {
		this.is_activate = is_activate;
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

	public String getExam_applicability() {
		return exam_applicability;
	}

	public void setExam_applicability(String exam_applicability) {
		this.exam_applicability = exam_applicability;
	}

	public int getMaster_id() {
		return master_id;
	}

	public void setMaster_id(int master_id) {
		this.master_id = master_id;
	}

	public byte[] getDocument_upload() {
		return document_upload;
	}

	public void setDocument_upload(byte[] document_upload) {
		this.document_upload = document_upload;
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

	public String getCompetencies() {
		return competencies;
	}

	public void setCompetencies(String competencies) {
		this.competencies = competencies;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	

}
