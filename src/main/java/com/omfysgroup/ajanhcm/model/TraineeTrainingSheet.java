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

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="TRAINEE_TRAINING_SHEET_MASTER")
public class TraineeTrainingSheet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traineetrsh_seq")
	@SequenceGenerator(name = "traineetrsh_seq", sequenceName = "TRAINEETRSH_SEQ", allocationSize = 1)
	private int tr_sh_id;
	
	@ManyToOne
	@JoinColumn(name="TRAINEE")
	private Employee_Master trainee;
	
	@Column(name="TRAINING_CODE")
	private String tr_code;
	
//	@ManyToOne
//	@JoinColumn(name="TRAINER")
//	private Employee_Master trainer_id;
	
//	@ManyToOne
//	@JoinColumn(name="COMP_MS_GR")
//	private Compentency_Master comp_gr;
	
//	@ManyToOne
//	@JoinColumn(name="COMP_GR")
//	private Compentency_Group compgr;
	
	@Column(name="PLANSTARTDATE")
	private Date planStartDate;
	
	@Column(name="PLANENDDATE")
	private Date planEndDate;
	
//	@ManyToOne
//	@JoinColumn(name="FR_ID")
//	private Functional_Reporting fr_id;
//	
//	@ManyToOne
//	@JoinColumn(name="AR_ID")
//	private Administrative_Reporting ar_id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="TR_TYPE")
	private String tr_type;
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="CREATION_DATE",updatable=false)
	private Date creation_date=new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name="LAST_UPDATED_BY",updatable = true)
	private int last_updated_by;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="LAST_UPDATE_DATE",updatable=true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DEVIATION")
	private Float deviation;
	
	@Column(name="REDBUTTON")
	private String redButtonFlag;
	
	@Column(name="AMBERBUTTON")
	private String amberButtonFlag;
	
	@Column(name="GREENBUTTON")
	private String greenButtonFlag;
	
	@Column(name="TRCOMMENT")
	private String trcomment;
	
	@Transient
	private Date plannnedStartDate;
	
	@Transient
	private Date plannnedEndDate;
	
	@Transient
	private String plStartDateStrFormate;
	
	@Transient
	private String plEndDateStrFormate;
	
	@Transient
	private Date actualStartDate;
	
	@Transient
	private Date actualEndDate;
	
	@Transient
	private String actualStartDateStrFormate;
	
	@Transient
	private String actualEndDateStrFormate;
	
	
	
	public int getTr_sh_id() {
		return tr_sh_id;
	}

	public void setTr_sh_id(int tr_sh_id) {
		this.tr_sh_id = tr_sh_id;
	}

	public Employee_Master getTrainee() {
		return trainee;
	}

	public void setTrainee(Employee_Master trainee) {
		this.trainee = trainee;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTr_type() {
		return tr_type;
	}

//	public Functional_Reporting getFr_id() {
//		return fr_id;
//	}
//
//	public void setFr_id(Functional_Reporting fr_id) {
//		this.fr_id = fr_id;
//	}
//
//	public Administrative_Reporting getAr_id() {
//		return ar_id;
//	}
//
//	public void setAr_id(Administrative_Reporting ar_id) {
//		this.ar_id = ar_id;
//	}


	public void setTr_type(String tr_type) {
		this.tr_type = tr_type;
	}

//	public Employee_Master getTrainer_id() {
//		return trainer_id;
//	}
//
//	public void setTrainer_id(Employee_Master trainer_id) {
//		this.trainer_id = trainer_id;
//	}

	public Float getDeviation() {
		return deviation;
	}

	public void setDeviation(Float deviation) {
		this.deviation = deviation;
	}

	public String getRedButtonFlag() {
		return redButtonFlag;
	}

	public void setRedButtonFlag(String redButtonFlag) {
		this.redButtonFlag = redButtonFlag;
	}

	public String getAmberButtonFlag() {
		return amberButtonFlag;
	}

	public void setAmberButtonFlag(String amberButtonFlag) {
		this.amberButtonFlag = amberButtonFlag;
	}

	public String getGreenButtonFlag() {
		return greenButtonFlag;
	}

	public void setGreenButtonFlag(String greenButtonFlag) {
		this.greenButtonFlag = greenButtonFlag;
	}

	public String getTrcomment() {
		return trcomment;
	}

	public void setTrcomment(String trcomment) {
		this.trcomment = trcomment;
	}

	public Date getPlannnedStartDate() {
		return plannnedStartDate;
	}

	public void setPlannnedStartDate(Date plannnedStartDate) {
		this.plannnedStartDate = plannnedStartDate;
	}

	public Date getPlannnedEndDate() {
		return plannnedEndDate;
	}

	public void setPlannnedEndDate(Date plannnedEndDate) {
		this.plannnedEndDate = plannnedEndDate;
	}

	public String getPlStartDateStrFormate() {
		return plStartDateStrFormate;
	}

	public void setPlStartDateStrFormate(String plStartDateStrFormate) {
		this.plStartDateStrFormate = plStartDateStrFormate;
	}

	public String getPlEndDateStrFormate() {
		return plEndDateStrFormate;
	}

	public void setPlEndDateStrFormate(String plEndDateStrFormate) {
		this.plEndDateStrFormate = plEndDateStrFormate;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
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

	public String getActualStartDateStrFormate() {
		return actualStartDateStrFormate;
	}

	public void setActualStartDateStrFormate(String actualStartDateStrFormate) {
		this.actualStartDateStrFormate = actualStartDateStrFormate;
	}

	public String getActualEndDateStrFormate() {
		return actualEndDateStrFormate;
	}

	public void setActualEndDateStrFormate(String actualEndDateStrFormate) {
		this.actualEndDateStrFormate = actualEndDateStrFormate;
	}

	public String getTr_code() {
		return tr_code;
	}

	public void setTr_code(String tr_code) {
		this.tr_code = tr_code;
	}

	@Override
	public String toString() {
		return "TraineeTrainingSheet [tr_sh_id=" + tr_sh_id + ", trainee=" + trainee + ", tr_code=" + tr_code
				+ ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + ", title=" + title
				+ ", tr_type=" + tr_type + ", created_by=" + created_by + ", creation_date=" + creation_date
				+ ", last_updated_by=" + last_updated_by + ", last_update_date=" + last_update_date + ", status="
				+ status + ", deviation=" + deviation + ", redButtonFlag=" + redButtonFlag + ", amberButtonFlag="
				+ amberButtonFlag + ", greenButtonFlag=" + greenButtonFlag + ", trcomment=" + trcomment
				+ ", plannnedStartDate=" + plannnedStartDate + ", plannnedEndDate=" + plannnedEndDate
				+ ", plStartDateStrFormate=" + plStartDateStrFormate + ", plEndDateStrFormate=" + plEndDateStrFormate
				+ ", actualStartDate=" + actualStartDate + ", actualEndDate=" + actualEndDate
				+ ", actualStartDateStrFormate=" + actualStartDateStrFormate + ", actualEndDateStrFormate="
				+ actualEndDateStrFormate + "]";
	}

	

}
