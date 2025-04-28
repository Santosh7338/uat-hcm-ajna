package com.omfysgroup.ajanhcm.model;


import java.io.Serializable;
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
@Table(name="TRAINING_SHEET_MASTER")
public class Training_Master implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training_seq")
	@SequenceGenerator(name = "training_seq", sequenceName = "TRAINING_MASTER_SEQ", allocationSize = 1)
	private int tr_id;
	
	@ManyToOne
	@JoinColumn(name="TRAINEE_ID")
	private Employee_Master trainee_id;
	
	@ManyToOne
	@JoinColumn(name="TRAINER_ID")
	private Employee_Master trainer_id;
	
//	@ManyToOne
//	@JoinColumn(name="FR_ID")
//	private Functional_Reporting fr_id;
	
	@ManyToOne
	@JoinColumn(name="AR_ID")
	private Administrative_Reporting ar_id;
	
	@ManyToOne
	@JoinColumn(name="Comp_Gr_Id")
	private Compentency_Group comp_group;
	
	@Column(name = "TRAINING_CODE")
	private String tr_code;
	
	@Column(name="Subject")
	private String subject;
	
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
	
	@Column(name="TR_SH_TYPE")
	private String tr_sh_type;
	
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
	
	@Column(name="TRAINING_TYPE")
	private String training_type;
	
	

	@Transient
	private Date plannnedStartDate;
	
	@Transient
	private Date plannnedEndDate;
	
	@Transient
	private String plStartDateStrFormate;
	
	@Transient
	private String plEndDateStrFormate;
	
	@Transient
	private String acStartDateStrFormate;
	
	@Transient
	private String acEndDateStrFormate;
	
	@Transient
	private String traineeFirstName;
	
	@Transient
	private String traineeLastName;
	
	@Transient
	private String trainerFirstName;
	
	@Transient
	private String trainerLastName;
	
	@Transient
	private String CompetencyGroup;
	
	public int getTr_id() {
		return tr_id;
	}

	public void setTr_id(int tr_id) {
		this.tr_id = tr_id;
	}

	public Employee_Master getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(Employee_Master trainee_id) {
		this.trainee_id = trainee_id;
	}

	public Employee_Master getTrainer_id() {
		return trainer_id;
	}
	
	
	public void setTrainer_id(Employee_Master trainer_id) {
		this.trainer_id = trainer_id;
	}
	
	public Compentency_Group getComp_group() {
		return comp_group;
	}

	public void setComp_group(Compentency_Group comp_group) {
		this.comp_group = comp_group;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public String getTraineeFirstName() {
		return traineeFirstName;
	}

	public void setTraineeFirstName(String traineeFirstName) {
		this.traineeFirstName = traineeFirstName;
	}

	public String getTraineeLastName() {
		return traineeLastName;
	}

	public void setTraineeLastName(String traineeLastName) {
		this.traineeLastName = traineeLastName;
	}

	public String getTrainerFirstName() {
		return trainerFirstName;
	}

	public void setTrainerFirstName(String trainerFirstName) {
		this.trainerFirstName = trainerFirstName;
	}

	public String getTrainerLastName() {
		return trainerLastName;
	}

	public void setTrainerLastName(String trainerLastName) {
		this.trainerLastName = trainerLastName;
	}

	public String getTr_sh_type() {
		return tr_sh_type;
	}

	public void setTr_sh_type(String tr_sh_type) {
		this.tr_sh_type = tr_sh_type;
	}

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

	public String getTrcomment() {
		return trcomment;
	}

	public void setTrcomment(String trcomment) {
		this.trcomment = trcomment;
	}

//	public Functional_Reporting getFr_id() {
//		return fr_id;
//	}
//
//	public void setFr_id(Functional_Reporting fr_id) {
//		this.fr_id = fr_id;
//	}

	public Administrative_Reporting getAr_id() {
		return ar_id;
	}

	public void setAr_id(Administrative_Reporting ar_id) {
		this.ar_id = ar_id;
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

	public String getCompetencyGroup() {
		return CompetencyGroup;
	}

	public void setCompetencyGroup(String competencyGroup) {
		CompetencyGroup = competencyGroup;
	}

	public String getTr_code() {
		return tr_code;
	}

	public void setTr_code(String tr_code) {
		this.tr_code = tr_code;
	}

	public String getTraining_type() {
		return training_type;
	}

	public void setTraining_type(String training_type) {
		this.training_type = training_type;
	}
		
}
