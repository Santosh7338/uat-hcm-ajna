package com.omfysgroup.ajanhcm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class Candidate_Interview {
	private int candidate_id;
	private String candidate_name;
	private String technology;
	private String candidate_type;
	private String mobile;
	private String interview_round;
	private String tech_interview_date;
	private String interview_result;
	private String panalist_name;
	private String notice_period;
	private String experience;
	private String current_ctc_lakhs;
	private String current_ctc_thousand;
	private String expected_ctc_lakhs;
	private String expected_ctc_thousand;
	private String status;
	private String creation_date;
	private String remark;
	private String role;
	private String designation;
	private String email;
	private String state;
	private String district;
	private String interviewTime;
	private String firstName;
	private String LastName;
	private int empId;
	private int freshersCount;
	private int experiancedCount;
	private String current_ctc;
	private String expected_ctc;
	private int technicalScheduled;
	private int technicalCleared;
	private int managerialScheduled;
	private int technicalRejected;
	private int hrScheduled;
	private int managerialCleared;
	private int managerialRejected;
	private int hrCleared;
	private int hrReacted;
	private int selected;
	private int rating;
	private String rate;
	private int joining;
	private int notJoining;
	private int notAttended;
	private String source;
	private String skill;
	private int createdBy;
	private List<String> managerialPanels;
	
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getInterview_round() {
		return interview_round;
	}
	public void setInterview_round(String interview_round) {
		this.interview_round = interview_round;
	}
	public String getTech_interview_date() {
		return tech_interview_date;
	}
	public void setTech_interview_date(String tech_interview_date) {
		this.tech_interview_date = tech_interview_date;
	}
	public String getInterview_result() {
		return interview_result;
	}
	public void setInterview_result(String interview_result) {
		this.interview_result = interview_result;
	}
	public String getPanalist_name() {
		return panalist_name;
	}
	public void setPanalist_name(String panalist_name) {
		this.panalist_name = panalist_name;
	}
	public String getNotice_period() {
		return notice_period;
	}
	public void setNotice_period(String notice_period) {
		this.notice_period = notice_period;
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
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getFreshersCount() {
		return freshersCount;
	}
	public void setFreshersCount(int freshersCount) {
		this.freshersCount = freshersCount;
	}
	public int getExperiancedCount() {
		return experiancedCount;
	}
	public void setExperiancedCount(int experiancedCount) {
		this.experiancedCount = experiancedCount;
	}
	public String getCurrent_ctc() {
		return current_ctc;
	}
	public void setCurrent_ctc(String current_ctc) {
		this.current_ctc = current_ctc;
	}
	public String getExpected_ctc() {
		return expected_ctc;
	}
	public void setExpected_ctc(String expected_ctc) {
		this.expected_ctc = expected_ctc;
	}
	public int getTechnicalScheduled() {
		return technicalScheduled;
	}
	public void setTechnicalScheduled(int technicalScheduled) {
		this.technicalScheduled = technicalScheduled;
	}
	public int getTechnicalCleared() {
		return technicalCleared;
	}
	public void setTechnicalCleared(int technicalCleared) {
		this.technicalCleared = technicalCleared;
	}
	public int getManagerialScheduled() {
		return managerialScheduled;
	}
	public void setManagerialScheduled(int managerialScheduled) {
		this.managerialScheduled = managerialScheduled;
	}
	public int getTechnicalRejected() {
		return technicalRejected;
	}
	public void setTechnicalRejected(int technicalRejected) {
		this.technicalRejected = technicalRejected;
	}
	public int getHrScheduled() {
		return hrScheduled;
	}
	public void setHrScheduled(int hrScheduled) {
		this.hrScheduled = hrScheduled;
	}
	public int getManagerialCleared() {
		return managerialCleared;
	}
	public void setManagerialCleared(int managerialCleared) {
		this.managerialCleared = managerialCleared;
	}
	public int getManagerialRejected() {
		return managerialRejected;
	}
	public void setManagerialRejected(int managerialRejected) {
		this.managerialRejected = managerialRejected;
	}
	public int getHrCleared() {
		return hrCleared;
	}
	public void setHrCleared(int hrCleared) {
		this.hrCleared = hrCleared;
	}
	public int getHrReacted() {
		return hrReacted;
	}
	public void setHrReacted(int hrReacted) {
		this.hrReacted = hrReacted;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public List<String> getManagerialPanels() {
		return managerialPanels;
	}
	public void setManagerialPanels(List<String> managerialPanels) {
		this.managerialPanels = managerialPanels;
	}
	
	
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	
	public int getJoining() {
		return joining;
	}
	public void setJoining(int joining) {
		this.joining = joining;
	}
	public int getNotJoining() {
		return notJoining;
	}
	public void setNotJoining(int notJoining) {
		this.notJoining = notJoining;
	}
	public int getNotAttended() {
		return notAttended;
	}
	public void setNotAttended(int notAttended) {
		this.notAttended = notAttended;
	}
	
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		return "Candidate_Interview [candidate_id=" + candidate_id + ", candidate_name=" + candidate_name
				+ ", technology=" + technology + ", candidate_type=" + candidate_type + ", mobile=" + mobile
				+ ", interview_round=" + interview_round + ", tech_interview_date=" + tech_interview_date
				+ ", interview_result=" + interview_result + ", panalist_name=" + panalist_name + ", notice_period="
				+ notice_period + ", experience=" + experience + ", current_ctc_lakhs=" + current_ctc_lakhs
				+ ", current_ctc_thousand=" + current_ctc_thousand + ", expected_ctc_lakhs=" + expected_ctc_lakhs
				+ ", expected_ctc_thousand=" + expected_ctc_thousand + ", status=" + status + ", creation_date="
				+ creation_date + ", remark=" + remark + ", role=" + role + ", designation=" + designation + ", email="
				+ email + ", state=" + state + ", district=" + district + ", interviewTime=" + interviewTime
				+ ", firstName=" + firstName + ", LastName=" + LastName + ", empId=" + empId + ", freshersCount="
				+ freshersCount + ", experiancedCount=" + experiancedCount + ", current_ctc=" + current_ctc
				+ ", expected_ctc=" + expected_ctc + ", technicalScheduled=" + technicalScheduled
				+ ", technicalCleared=" + technicalCleared + ", managerialScheduled=" + managerialScheduled
				+ ", technicalRejected=" + technicalRejected + ", hrScheduled=" + hrScheduled + ", managerialCleared="
				+ managerialCleared + ", managerialRejected=" + managerialRejected + ", hrCleared=" + hrCleared
				+ ", hrReacted=" + hrReacted + ", selected=" + selected + ", rating=" + rating + ", rate=" + rate
				+ ", joining=" + joining + ", notJoining=" + notJoining + ", notAttended=" + notAttended + ", source="
				+ source + ", skill=" + skill + ", createdBy=" + createdBy + ", managerialPanels=" + managerialPanels
				+ "]";
	}
	
	
	
	
	
	
	
}
