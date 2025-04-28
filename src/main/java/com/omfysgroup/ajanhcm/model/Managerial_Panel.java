package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="INTERVIEW_PANELS")
public class Managerial_Panel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "interview_panel_seq")
	@SequenceGenerator(name = "interview_panel_seq", sequenceName = "INTERVIEW_PANELS_SEQ", allocationSize = 1)
	@Column(name="PANEL_ID")
	private int Panel_Id;
	@Column(name="CANDIDATE_ID")
	private int candidate_Id;
	@Column(name="PANEL_NAME")
	private String panelName;
	@Column(name="INTERVIEW_ROUND")
	private String interviewRound;
	public int getPanel_Id() {
		return Panel_Id;
	}
	public void setPanel_Id(int panel_Id) {
		Panel_Id = panel_Id;
	}
	public int getCandidate_Id() {
		return candidate_Id;
	}
	public void setCandidate_Id(int candidate_Id) {
		this.candidate_Id = candidate_Id;
	}
	public String getPanelName() {
		return panelName;
	}
	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}
	public String getInterviewRound() {
		return interviewRound;
	}
	public void setInterviewRound(String interviewRound) {
		this.interviewRound = interviewRound;
	}
	@Override
	public String toString() {
		return "Managerial_Panel [Panel_Id=" + Panel_Id + ", candidate_Id=" + candidate_Id + ", panelName=" + panelName
				+ ", interviewRound=" + interviewRound + "]";
	}
	
	
	
	
	
}
	
	
	
	