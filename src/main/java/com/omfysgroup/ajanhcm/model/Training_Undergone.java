package com.omfysgroup.ajanhcm.model;

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

@Entity
@Table(name="TRAINING_UNDERGONE")
public class Training_Undergone {
   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_seq")
	@SequenceGenerator(name = "training_seq", sequenceName = "TRAINING_UNDERGONE_SEQ", allocationSize = 1)
	
	@Column(name = "TRAINING_ID")
    private int training_id;
	
	@Column(name = "INSTITUTE_NAME")
    private String institute_name;
	
	@Column(name = "COURSES")
    private String courses_name;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "START_DATE", updatable = false)
	private Date start_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "END_DATE", updatable = false)
	private Date end_date;
	
	@Column(name = "NATURE_TRAINING")
	private String nature_training;
	
	@Column(name = "PERSONAL_ID")
	private int personal_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = false)
	private Date last_date;
	
	@Transient
	private String startTrans; 
	
	@Transient
	private String endTrans;
	
	public String getCourses_name() {
		return courses_name;
	}

	public void setCourses_name(String courses_name) {
		this.courses_name = courses_name;
	}
	
	public int getTraining_id() {
		return training_id;
	}

	public void setTraining_id(int training_id) {
		this.training_id = training_id;
	}

	public String getInstitute_name() {
		return institute_name;
	}

	public void setInstitute_name(String institute_name) {
		this.institute_name = institute_name;
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

	public String getNature_training() {
		return nature_training;
	}

	public void setNature_training(String nature_training) {
		this.nature_training = nature_training;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date last_date) {
		this.last_date = last_date;
	}

	public String getStartTrans() {
		return startTrans;
	}

	public void setStartTrans(String startTrans) {
		this.startTrans = startTrans;
	}

	public String getEndTrans() {
		return endTrans;
	}

	public void setEndTrans(String endTrans) {
		this.endTrans = endTrans;
	}
	
	
}
