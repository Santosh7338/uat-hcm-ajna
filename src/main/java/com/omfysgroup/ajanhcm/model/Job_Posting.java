package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_POSTING")
public class Job_Posting {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_posting_seq")
	@SequenceGenerator(name = "job_posting_seq", sequenceName = "JOB_POSTING_SEQ", allocationSize = 1)
	@Column(name = "JOB_POSTING_ID")
	public int job_posting_id;
	@Column(name = "SOURCES")
	public String sources;
	@Column(name = "TECHNOLOGY")
	public String technology;
	@Column(name = "CANDIDATE_TYPE")
	public String candidateType;
	@Column(name = "SPECIALIZATION")
	public String specialization;
	@Column(name = "ROLE")
	public String role;
	@Column(name = "DESIGNATION")
	public String designation;
	@Column(name = "CTC")
	public String ctc;
	@Column(name = "SKILLS")
	public String skills;
	@Column(name = "JOB_LOCATION")
	public String job_location;
	@Column(name = "EXPERIENCE")
	public String experience;
	@Column(name = "HIGHEST_QUALIFICATION")
	public String highest_qualification;
	@Column(name = "PERCENTAGE_CRITERIA")
	public String percentage_criteria;
	@Column(name = "STATUS")
	public String status;
	@Column(name = "NOTICE_PERIOD")
	public String notice_period;
	@Column(name = "JOB_DESCRIPTION")
	public String job_description;
	@Column(name = "POSTED_BY")
	public String posted_by;
	@Column(name = "UPDATED_BY")
	public Date updated_by;
	@Column(name = "BOND_APPLICABLE")
	public String bondApplicable;
	@Column(name = "POSTED_DATE")
	public String postedDate;
	@Column(name = "JOB_OPENINGS")
	public String job_Openings;
	@Column(name = "ROLE_ID")
	public String role_id;
	@Column(name = "POSITION")
	public String Position;
	@Column(name = "JOB_SUMMARY")
    public String job_summary;
	@Column(name = "RESPONSIBLITIES")
    public String responsiblities;
	@Column(name = "REQUIRED_CANDIDATE_PROFILE")
    public String required_candidate_profile;
	@Column(name = "KEY_SKILLS_REQUIREMENT")
    public String key_skill_requirement;

	public int getJob_posting_id() {
		return job_posting_id;
	}

	public void setJob_posting_id(int job_posting_id) {
		this.job_posting_id = job_posting_id;
	}

	public String getSources() {
		return sources;
	}

	public void setSources(String sources) {
		this.sources = sources;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getCandidateType() {
		return candidateType;
	}

	public void setCandidateType(String candidateType) {
		this.candidateType = candidateType;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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

	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getJob_location() {
		return job_location;
	}

	public void setJob_location(String job_location) {
		this.job_location = job_location;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getHighest_qualification() {
		return highest_qualification;
	}

	public void setHighest_qualification(String highest_qualification) {
		this.highest_qualification = highest_qualification;
	}

	public String getPercentage_criteria() {
		return percentage_criteria;
	}

	public void setPercentage_criteria(String percentage_criteria) {
		this.percentage_criteria = percentage_criteria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(String notice_period) {
		this.notice_period = notice_period;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getPosted_by() {
		return posted_by;
	}

	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}

	public Date getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Date updated_by) {
		this.updated_by = updated_by;
	}

	public String getBondApplicable() {
		return bondApplicable;
	}

	public void setBondApplicable(String bondApplicable) {
		this.bondApplicable = bondApplicable;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public String getJob_Openings() {
		return job_Openings;
	}

	public void setJob_Openings(String job_Openings) {
		this.job_Openings = job_Openings;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getJob_summary() {
		return job_summary;
	}

	public void setJob_summary(String job_summary) {
		this.job_summary = job_summary;
	}

	public String getResponsiblities() {
		return responsiblities;
	}

	public void setResponsiblities(String responsiblities) {
		this.responsiblities = responsiblities;
	}

	public String getRequired_candidate_profile() {
		return required_candidate_profile;
	}

	public void setRequired_candidate_profile(String required_candidate_profile) {
		this.required_candidate_profile = required_candidate_profile;
	}

	public String getKey_skill_requirement() {
		return key_skill_requirement;
	}

	public void setKey_skill_requirement(String key_skill_requirement) {
		this.key_skill_requirement = key_skill_requirement;
	}

	@Override
	public String toString() {
		return "Job_Posting [job_posting_id=" + job_posting_id + ", sources=" + sources + ", technology=" + technology
				+ ", candidateType=" + candidateType + ", specialization=" + specialization + ", role=" + role
				+ ", designation=" + designation + ", ctc=" + ctc + ", skills=" + skills + ", job_location="
				+ job_location + ", experience=" + experience + ", highest_qualification=" + highest_qualification
				+ ", percentage_criteria=" + percentage_criteria + ", status=" + status + ", notice_period="
				+ notice_period + ", job_description=" + job_description + ", posted_by=" + posted_by + ", updated_by="
				+ updated_by + ", bondApplicable=" + bondApplicable + ", postedDate=" + postedDate + ", job_Openings="
				+ job_Openings + ", role_id=" + role_id + "]";
	}

}
