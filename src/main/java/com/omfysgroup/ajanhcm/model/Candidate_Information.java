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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import oracle.sql.BLOB;

@Entity
@Table(name="CANDIDATE_INFORMATION")
public class Candidate_Information {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_information_seq")
	@SequenceGenerator(name = "candidate_information_seq", sequenceName = "CANDIDATE_INFORMATION_SEQ", allocationSize = 1)
	
	@Column(name = "CANDIDATE_ID")
	private int candidate_id;
	
	@Column(name="CANDIDATE_NAME")
	private String candidate_name;
	
	@Column(name="TECHNOLOGY")
	private String technology;
	
	@Column(name="CANDIDATE_TYPE")
	private String candidate_type;
	
	@Column(name="EXPERIENCE_IN_YRS")
	private String experience;
	
	@Column(name="CURRENT_CTC_LAKHS")
	private String current_ctc_lakhs;
	
	@Column(name="CURRENT_CTC_THOUSAND")
	private String current_ctc_thousand;
	
	@Column(name="EXPECTED_CTC_LAKHS")
	private String expected_ctc_lakhs;
	
	@Column(name="EXPECTED_CTC_THOUSAND")
	private String expected_ctc_thousand;
	
	@Column(name="NOTICE_PERIOD")
	private String notice_period;
	
//	@Column(name="INTERVIEW_SCHEDULED")
//	private String interview_scheduled;
//	
//	@Column(name="INTERVIEW_ROUND")
//	private String interview_round;
//	
//	@Column(name="INTERVIEW_DATE")
//	private Date interview_date;
//	
//	
	@Column(name="PANEL_NAME")
	private String panel_name;
	
	@Column(name="STATUS")
	private String status;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date;

	@Column(name="CREATED_BY")
	private int created_by;
	
	@Column(name="UPDATED_BY")
	private int updated_by;

	@Column(name="DOCUMENT_UPLOAD")
	private byte[] document_upload;
	
	@Column(name = "FILE_NAME")
	private String file_name;
	
	@Column(name = "FILE_SIZE")
	private int file_size;
	
	@Column(name = "FILE_TYPE")
	private String file_type;
	
	@Column(name="MOBILE_NO")
	private String mobile_no;
	
	//role
	//Updated code
	@Column(name="ROLE")
	private String role;
	
	//designation
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="EMAIL")
	private String email;
	
	//interviewTime
	@Column(name="INTERVIEW_TIME")
	private String interviewTime;
	
	//state
	@Column(name="STATE")
	private String state;
	
	//district
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="SOURCE")
	private String source;
	
	
	@Transient
	private String interview_date_str;
	
	@Transient
	private String creation_date_str;

	@Transient
	private String panel_name_str;
	
	@Transient
	private String created_by_str;
	
	@Transient
	private String interview_Round;
	
	@Transient
	private String remark ;
	
	@Transient
	private String interview_time;
	
	@Transient
	private String interview_result;
	
	@Transient
	private String rating ;
	
	@Transient
    private boolean flag ;

	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public String getCandidate_name() {
		return candidate_name;
	}

	public void setCandidate_name(String candidate_name) {
		this.candidate_name = candidate_name;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getCandidate_type() {
		return candidate_type;
	}

	public void setCandidate_type(String candidate_type) {
		this.candidate_type = candidate_type;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCurrent_ctc_lakhs() {
		return current_ctc_lakhs;
	}

	public void setCurrent_ctc_lakhs(String current_ctc_lakhs) {
		this.current_ctc_lakhs = current_ctc_lakhs;
	}

	public String getCurrent_ctc_thousand() {
		return current_ctc_thousand;
	}

	public void setCurrent_ctc_thousand(String current_ctc_thousand) {
		this.current_ctc_thousand = current_ctc_thousand;
	}

	public String getExpected_ctc_lakhs() {
		return expected_ctc_lakhs;
	}

	public void setExpected_ctc_lakhs(String expected_ctc_lakhs) {
		this.expected_ctc_lakhs = expected_ctc_lakhs;
	}

	public String getExpected_ctc_thousand() {
		return expected_ctc_thousand;
	}

	public void setExpected_ctc_thousand(String expected_ctc_thousand) {
		this.expected_ctc_thousand = expected_ctc_thousand;
	}

	public String getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(String notice_period) {
		this.notice_period = notice_period;
	}

	public String getPanel_name() {
		return panel_name;
	}

	public void setPanel_name(String panel_name) {
		this.panel_name = panel_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	public byte[] getDocument_upload() {
		return document_upload;
	}

	public void setDocument_upload(byte[] document_upload) {
		this.document_upload = document_upload;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getInterview_date_str() {
		return interview_date_str;
	}

	public void setInterview_date_str(String interview_date_str) {
		this.interview_date_str = interview_date_str;
	}

	public String getCreation_date_str() {
		return creation_date_str;
	}

	public void setCreation_date_str(String creation_date_str) {
		this.creation_date_str = creation_date_str;
	}

	public String getPanel_name_str() {
		return panel_name_str;
	}

	public void setPanel_name_str(String panel_name_str) {
		this.panel_name_str = panel_name_str;
	}

	public String getCreated_by_str() {
		return created_by_str;
	}

	public void setCreated_by_str(String created_by_str) {
		this.created_by_str = created_by_str;
	}

	public String getInterview_Round() {
		return interview_Round;
	}

	public void setInterview_Round(String interview_Round) {
		this.interview_Round = interview_Round;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInterview_time() {
		return interview_time;
	}

	public void setInterview_time(String interview_time) {
		this.interview_time = interview_time;
	}

	public String getInterview_result() {
		return interview_result;
	}

	public void setInterview_result(String interview_result) {
		this.interview_result = interview_result;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Candidate_Information [candidate_id=" + candidate_id + ", candidate_name=" + candidate_name
				+ ", technology=" + technology + ", candidate_type=" + candidate_type + ", experience=" + experience
				+ ", current_ctc_lakhs=" + current_ctc_lakhs + ", current_ctc_thousand=" + current_ctc_thousand
				+ ", expected_ctc_lakhs=" + expected_ctc_lakhs + ", expected_ctc_thousand=" + expected_ctc_thousand
				+ ", notice_period=" + notice_period + ", panel_name=" + panel_name + ", status=" + status
				+ ", creation_date=" + creation_date + ", last_update_date=" + last_update_date + ", created_by="
				+ created_by + ", updated_by=" + updated_by + ", document_upload=" + Arrays.toString(document_upload)
				+ ", file_name=" + file_name + ", file_size=" + file_size + ", file_type=" + file_type + ", mobile_no="
				+ mobile_no + ", role=" + role + ", designation=" + designation + ", email=" + email
				+ ", interviewTime=" + interviewTime + ", state=" + state + ", district=" + district + ", source="
				+ source + ", interview_date_str=" + interview_date_str + ", creation_date_str=" + creation_date_str
				+ ", panel_name_str=" + panel_name_str + ", created_by_str=" + created_by_str + ", interview_Round="
				+ interview_Round + ", remark=" + remark + ", interview_time=" + interview_time + ", interview_result="
				+ interview_result + ", rating=" + rating + ", flag=" + flag + "]";
	}

		
	
	}
