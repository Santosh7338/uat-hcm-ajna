package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ADD_MEETING")
public class Meeting {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meeting_seq")
	@SequenceGenerator(name = "meeting_seq", sequenceName = "ADD_MEETING_SEQ", allocationSize = 1)
    @Column(name="MEETING_ID")
	private int meetingId;
    @Column(name="PANEL_ID")
    private int panelId;
    @Column(name="INTERV_MODE")
    private String mode;
    @Column(name="MEETING_LINK")
    private String meetingLink;
    @Column(name="MEETING_NO")
    private String meetingNo;
    @Column(name="MEETING_PASSWORD")
    private String meetingPassword;
    @Column(name="ADDRESS")
    private String address;
    @Transient
    private String panelName;
	public int getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}
	public int getPanelId() {
		return panelId;
	}
	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getMeetingLink() {
		return meetingLink;
	}
	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}
	public String getMeetingNo() {
		return meetingNo;
	}
	public void setMeetingNo(String meetingNo) {
		this.meetingNo = meetingNo;
	}
	public String getMeetingPassword() {
		return meetingPassword;
	}
	public void setMeetingPassword(String meetingPassword) {
		this.meetingPassword = meetingPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPanelName() {
		return panelName;
	}
	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}
	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", panelId=" + panelId + ", mode=" + mode + ", meetingLink="
				+ meetingLink + ", meetingNo=" + meetingNo + ", meetingPassword=" + meetingPassword + ", address="
				+ address + ", panelName=" + panelName + "]";
	}
    
		
	
    
}
