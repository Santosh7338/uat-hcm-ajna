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


@Entity
@Table(name="TRAINEE_TRAINING_SHEET_LINES")
public class Trainee_Training_Sh_Lines {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training__shl_lines")
	@SequenceGenerator(name = "training__shl_lines", sequenceName = "TRAINEE_TR_SH_LINES", allocationSize = 1)
	private int tr_sh_lines_id;
	
	@ManyToOne
	@JoinColumn(name="TR_SH_ID")
	private TraineeTrainingSheet tr_sh_id;
	
	@ManyToOne
	@JoinColumn(name="COMP_GR")
	private Compentency_Group comp_gr;
	
	@ManyToOne
	@JoinColumn(name="COMP_ID")
	private Compentency_Master comp_id;
	
	
	
//	@Column(name="SELECTEDCOMP")
//	private String selectedComp;
	
//	@Column(name="NAME_OF_TOPICS")
//	private String name_of_topics;
	
//	@Column(name="STRAT_TIME")
//	private String start_time;
//	
//	@Column(name="END_TIME")
//	private String end_time;
	
//	@Column(name="TRAINGING_TYPE")
//	private String training_type;
	
	@Column(name="START_DATE")
	private Date start_date;
//	
	@Column(name="END_DATE")
	private Date end_date;
	
	
//	@ManyToOne
//	@JoinColumn(name="Trainer")
//	private Employee_Master trainer;
	
//	@Column(name="STATUS")
//	private String status;
	
	@Transient
	private String StartDateStrFormate;
	
	@Transient
	private String EndDateStrFormate;

	public int getTr_sh_lines_id() {
		return tr_sh_lines_id;
	}

	public void setTr_sh_lines_id(int tr_sh_lines_id) {
		this.tr_sh_lines_id = tr_sh_lines_id;
	}

	public TraineeTrainingSheet getTr_sh_id() {
		return tr_sh_id;
	}

	public void setTr_sh_id(TraineeTrainingSheet tr_sh_id) {
		this.tr_sh_id = tr_sh_id;
	}

//	public String getName_of_topics() {
//		return name_of_topics;
//	}
//
//	public void setName_of_topics(String name_of_topics) {
//		this.name_of_topics = name_of_topics;
//	}
//
//	public String getStart_time() {
//		return start_time;
//	}
//
//	public void setStart_time(String start_time) {
//		this.start_time = start_time;
//	}
//
//	public String getEnd_time() {
//		return end_time;
//	}
//
//	public void setEnd_time(String end_time) {
//		this.end_time = end_time;
//	}
//
//	public String getTraining_type() {
//		return training_type;
//	}
//
//	public void setTraining_type(String training_type) {
//		this.training_type = training_type;
//	}
//
	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
//
	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Compentency_Group getComp_gr() {
		return comp_gr;
	}

	public void setComp_gr(Compentency_Group comp_gr) {
		this.comp_gr = comp_gr;
	}

	public String getStartDateStrFormate() {
		return StartDateStrFormate;
	}

	public void setStartDateStrFormate(String startDateStrFormate) {
		StartDateStrFormate = startDateStrFormate;
	}

	public String getEndDateStrFormate() {
		return EndDateStrFormate;
	}

	public void setEndDateStrFormate(String endDateStrFormate) {
		EndDateStrFormate = endDateStrFormate;
	}

	

//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
	public Compentency_Master getComp_id() {
		return comp_id;
	}

	public void setComp_id(Compentency_Master comp_id) {
		this.comp_id = comp_id;
	}
//
//	public String getSelectedComp() {
//		return selectedComp;
//	}

//	public void setSelectedComp(String selectedComp) {
//		this.selectedComp = selectedComp;
//	}	
//	
	
	
}