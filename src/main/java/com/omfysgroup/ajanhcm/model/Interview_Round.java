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
@Table(name="INTERVIEW_ROUND")
public class Interview_Round {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_round_seq")
	@SequenceGenerator(name = "interview_round_seq", sequenceName = "INTERVIEW_ROUND_SEQ", allocationSize = 1)
	
	@Column(name = "ROUND_ID")
	private int round_id;
	
	@Column(name = "CANDIDATE_ID")
	private int candidate_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "INTERVIEW_DATE")
	private Date interview_date;
	
	@Column(name = "INTERVIEW_STATUS")
	private String interview_status;
	
	@Column(name = "INTERVIEW_RESULT")
	private String interview_result;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = true)
	private Date creation_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = true)
	private Date last_updated_date;
	
	@Column(name="INTERVIEW_ROUND")
	private String interview_round;

	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="INTERVIEW_TIME")
	private String interview_time;
	
	@Column(name="RATING")
	 private String rating;
	
	@Column(name="PANEL_NAME")
	private String panelName;
	
	
	public int getRound_id() {
		return round_id;
	}

	public void setRound_id(int round_id) {
		this.round_id = round_id;
	}

	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public Date getInterview_date() {
		return interview_date;
	}

	public void setInterview_date(Date interview_date) {
		this.interview_date = interview_date;
	}

	public String getInterview_status() {
		return interview_status;
	}

	public void setInterview_status(String interview_status) {
		this.interview_status = interview_status;
	}

	public String getInterview_result() {
		return interview_result;
	}

	public void setInterview_result(String interview_result) {
		this.interview_result = interview_result;
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

	public String getInterview_round() {
		return interview_round;
	}

	public void setInterview_round(String interview_round) {
		this.interview_round = interview_round;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

	public String getInterview_time() {
		return interview_time;
	}

	public void setInterview_time(String interview_time) {
		this.interview_time = interview_time;
	}
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getPanelName() {
		return panelName;
	}

	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}

	@Override
	public String toString() {
		return "Interview_Round [round_id=" + round_id + ", candidate_id=" + candidate_id + ", interview_date="
				+ interview_date + ", interview_status=" + interview_status + ", interview_result=" + interview_result
				+ ", creation_date=" + creation_date + ", last_updated_date=" + last_updated_date + ", interview_round="
				+ interview_round + ", remarks=" + remarks + ", interview_time=" + interview_time + ", rating=" + rating
				+ ", panelName=" + panelName + "]";
	}

	
	
	
	
}