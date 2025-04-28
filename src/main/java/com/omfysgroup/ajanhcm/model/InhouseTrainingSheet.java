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
@Table(name="INHOUSETRAININGSHEET")
public class InhouseTrainingSheet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inhouserTrShSeq")
	@SequenceGenerator(name = "inhouserTrShSeq", sequenceName = "INHOUSETRAININGSEQ", allocationSize = 1)
	private int intrsh;
	
	@ManyToOne
	@JoinColumn(name="TR_SH_ID")
	private TraineeTrainingSheet tr_sh_id;
	
	@ManyToOne
	@JoinColumn(name="COMP")
	private Compentency_Master comp_id;
	
	@ManyToOne
	@JoinColumn(name="TRAINER")
	private Employee_Master trainer;
	
	@Column(name="NAME_OF_TOPICS")
	private String name_of_topics;
	
	@Column(name="STRAT_TIME")
	private String start_time;
	
	@Column(name="END_TIME")
	private String end_time;
	
	@Column(name="TRAINGING_TYPE")
	private String trainingType;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="STATUS")
	private String status;
	
	
	
	@Transient
	private String startDateStrFormate;
	
	@Transient
	private String endDateStrFormate;
	
	@Transient
	private Date actualStartDate;
	
	@Transient
	private Date actualEndDate;
	
	@Transient
	private String acStartDateStrFormate;
	
	@Transient
	private String acEndDateStrFormate;
	

	public int getIntrsh() {
		return intrsh;
	}

	public void setIntrsh(int intrsh) {
		this.intrsh = intrsh;
	}

	public TraineeTrainingSheet getTr_sh_id() {
		return tr_sh_id;
	}

	public void setTr_sh_id(TraineeTrainingSheet tr_sh_id) {
		this.tr_sh_id = tr_sh_id;
	}

	public Compentency_Master getComp_id() {
		return comp_id;
	}

	public void setComp_id(Compentency_Master comp_id) {
		this.comp_id = comp_id;
	}

	public String getName_of_topics() {
		return name_of_topics;
	}

	public void setName_of_topics(String name_of_topics) {
		this.name_of_topics = name_of_topics;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee_Master getTrainer() {
		return trainer;
	}

	public void setTrainer(Employee_Master trainer) {
		this.trainer = trainer;
	}

	public String getStartDateStrFormate() {
		return startDateStrFormate;
	}

	public void setStartDateStrFormate(String startDateStrFormate) {
		this.startDateStrFormate = startDateStrFormate;
	}

	public String getEndDateStrFormate() {
		return endDateStrFormate;
	}

	public void setEndDateStrFormate(String endDateStrFormate) {
		this.endDateStrFormate = endDateStrFormate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getAcStartDateStrFormate() {
		return acStartDateStrFormate;
	}

	public void setAcStartDateStrFormate(String acStartDateStrFormate) {
		this.acStartDateStrFormate = acStartDateStrFormate;
	}

	public String getAcEndDateStrFormate() {
		return acEndDateStrFormate;
	}

	public void setAcEndDateStrFormate(String acEndDateStrFormate) {
		this.acEndDateStrFormate = acEndDateStrFormate;
	}

	
	
}
