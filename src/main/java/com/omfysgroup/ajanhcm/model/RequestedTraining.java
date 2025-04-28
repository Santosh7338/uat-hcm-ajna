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

@Entity
@Table(name = "REQUESTEDTRAINING")
public class RequestedTraining {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tr_seq")
	@SequenceGenerator(name = "tr_seq", sequenceName = "TR_REQUEST_SEQ", allocationSize = 1)
	private int retr_id;
	
	@Column(name ="TRAINING_TOPIC")
	private String training_Topic;
	
	@Column(name ="TRAINING_TYPE")
	private String training_type;
	
	@Column(name = "TRAINING_MODE")
	private String training_Mode;
	
	@Column(name = "TRAINERNAME")
	private String trainer_Name;
	
	@Column(name="TRAINEREMAIL")
	private String trainer_Mail;
	
	@Column(name ="TRAINERMOB")
	private Long trainer_Mob;
	
	@Column(name="COMPETENCIES")
	private String compentencies;
	
	@Column(name ="WEBLINK")
	private String weblink;
	
	@Column(name ="STARTDATE")
	private Date startDate;
	
	@Column(name ="ENDDATE")
	private Date endDate;
	
	@Column(name="COST")
	private String cost;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "HOURS")
	private int hours;
	
	@Column(name = "DAY")
	private int day;
	
	@Column(name = "MINUTE")
	private int miniute;
	
	@ManyToOne
	@JoinColumn(name = "REQUESTED_BY")
	private Employee_Master requested_by;
	
	@ManyToOne
	@JoinColumn(name = "TR_COORDINATOR")
	private Employee_Master trainer_Coordinator;
	
	public int getRetr_id() {
		return retr_id;
	}

	public void setRetr_id(int retr_id) {
		this.retr_id = retr_id;
	}

	public String getTraining_Topic() {
		return training_Topic;
	}

	public void setTraining_Topic(String training_Topic) {
		this.training_Topic = training_Topic;
	}

	public String getTraining_type() {
		return training_type;
	}

	public void setTraining_type(String training_type) {
		this.training_type = training_type;
	}

	public String getTraining_Mode() {
		return training_Mode;
	}

	public void setTraining_Mode(String training_Mode) {
		this.training_Mode = training_Mode;
	}

	public String getTrainer_Name() {
		return trainer_Name;
	}

	public void setTrainer_Name(String trainer_Name) {
		this.trainer_Name = trainer_Name;
	}

	public String getTrainer_Mail() {
		return trainer_Mail;
	}

	public void setTrainer_Mail(String trainer_Mail) {
		this.trainer_Mail = trainer_Mail;
	}

	public Long getTrainer_Mob() {
		return trainer_Mob;
	}

	public void setTrainer_Mob(Long trainer_Mob) {
		this.trainer_Mob = trainer_Mob;
	}

	public String getCompentencies() {
		return compentencies;
	}

	public void setCompentencies(String compentencies) {
		this.compentencies = compentencies;
	}

	public String getWeblink() {
		return weblink;
	}

	public void setWeblink(String weblink) {
		this.weblink = weblink;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee_Master getRequested_by() {
		return requested_by;
	}

	public void setRequested_by(Employee_Master requested_by) {
		this.requested_by = requested_by;
	}

	public Employee_Master getTrainer_Coordinator() {
		return trainer_Coordinator;
	}

	public void setTrainer_Coordinator(Employee_Master trainer_Coordinator) {
		this.trainer_Coordinator = trainer_Coordinator;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMiniute() {
		return miniute;
	}

	public void setMiniute(int miniute) {
		this.miniute = miniute;
	}
}