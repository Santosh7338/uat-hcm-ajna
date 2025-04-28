package com.omfysgroup.ajanhcm.model;

import java.util.Date;
import java.util.List;

public class LeaveDetails {
	
	private int LR_No;
	
	private int LR_Id;
	
	private String applicant_Name;
	
	private String leave_type;
	
	private Date application_Date;
	
	private Date start_date;
	
	private Date end_date;
	
	private String reason_for_leave;
	
	private String knowledge_transfer_summary;
	
	private String charge_hand_over_to;
	
	private String functional_comment;
	
	private String administrative_comment;
	
	private String management_comment;
	
	private String appEmail;
	
	private String empCode;
	
	private List<String> fr_comment;
	
	private String day_type;
	
	private String reason;

	public int getLR_No() {
		return LR_No;
	}

	public void setLR_No(int lR_No) {
		LR_No = lR_No;
	}

	public int getLR_Id() {
		return LR_Id;
	}

	public void setLR_Id(int lR_Id) {
		LR_Id = lR_Id;
	}

	public String getApplicant_Name() {
		return applicant_Name;
	}

	public void setApplicant_Name(String applicant_Name) {
		this.applicant_Name = applicant_Name;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public Date getApplication_Date() {
		return application_Date;
	}

	public void setApplication_Date(Date application_Date) {
		this.application_Date = application_Date;
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

	public String getReason_for_leave() {
		return reason_for_leave;
	}

	public void setReason_for_leave(String reason_for_leave) {
		this.reason_for_leave = reason_for_leave;
	}

	public String getKnowledge_transfer_summary() {
		return knowledge_transfer_summary;
	}

	public void setKnowledge_transfer_summary(String knowledge_transfer_summary) {
		this.knowledge_transfer_summary = knowledge_transfer_summary;
	}

	public String getCharge_hand_over_to() {
		return charge_hand_over_to;
	}

	public void setCharge_hand_over_to(String charge_hand_over_to) {
		this.charge_hand_over_to = charge_hand_over_to;
	}

	public String getFunctional_comment() {
		return functional_comment;
	}

	public void setFunctional_comment(String functional_comment) {
		this.functional_comment = functional_comment;
	}

	public String getAdministrative_comment() {
		return administrative_comment;
	}

	public void setAdministrative_comment(String administrative_comment) {
		this.administrative_comment = administrative_comment;
	}

	public String getManagement_comment() {
		return management_comment;
	}

	public void setManagement_comment(String management_comment) {
		this.management_comment = management_comment;
	}

	public String getAppEmail() {
		return appEmail;
	}

	public void setAppEmail(String appEmail) {
		this.appEmail = appEmail;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	

	public List<String> getFr_comment() {
		return fr_comment;
	}

	public void setFr_comment(List<String> fr_comment) {
		this.fr_comment = fr_comment;
	}

	public String getDay_type() {
		return day_type;
	}

	public void setDay_type(String day_type) {
		this.day_type = day_type;
	}
	

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "LeaveDetails [LR_No=" + LR_No + ", LR_Id=" + LR_Id + ", applicant_Name=" + applicant_Name
				+ ", leave_type=" + leave_type + ", application_Date=" + application_Date + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", reason_for_leave=" + reason_for_leave + ", knowledge_transfer_summary="
				+ knowledge_transfer_summary + ", charge_hand_over_to=" + charge_hand_over_to + ", functional_comment="
				+ functional_comment + ", administrative_comment=" + administrative_comment + ", management_comment="
				+ management_comment + ", appEmail=" + appEmail + ", empCode=" + empCode + ", fr_comment=" + fr_comment
				+ ", day_type=" + day_type + ", reason=" + reason + "]";
	}

	
}
