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
@Table(name="TRAINING_SHEET_LINE")
public class Training_Sheet_Lines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "training__shl_seq")
	@SequenceGenerator(name = "training__shl_seq", sequenceName = "TRAINING_SHEET_LINES_SEQ", allocationSize = 1)
	private int tr_lines_id;
	
	@ManyToOne
	@JoinColumn(name="TR_SH_ID")
	private Training_Master tr_sh_id;
	
	@ManyToOne
	@JoinColumn(name="ASSIGNED_TO")
	private Employee_Master assigned_to_emp;
	
	@ManyToOne
	@JoinColumn(name="COMP_M_ID")
	private Compentency_Master comp_m_id;
	
	@Column(name="NAMES_OF_TOPICS")
	private String nameOfTopics;
	
	@Column(name="PL_START_DATE")
	private Date plStartDate;
	
	@Column(name="PL_END_DATE")
	private Date plEndDate;
	
	@Column(name="ACTUAL_START_DATE")
	private Date actualStDate;
	
	@Column(name="ACTUAL_END_DATE")
	private Date actualEndDate;
	
	@Column(name="START_TIME")
	private String start_time;
	
	@Column(name="END_TIME")
	private String end_time;
	
	@Column(name="TRAINING_TYPE")
	private String training_type;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="trainerStatus")
	private String trainerStatus;
	
	@Column(name="TOTAL_TIME_REQUIRES")
	private String total_time_requires;
	
	@Column(name="DEVIATION")
	private Float deviation;
	
	@Column(name="DISABLEDSTRING")
	private String disabledString;
	
	@Transient
	private String plStartDateStrFormate;
	
	@Transient
	private String plEndDateStrFormate;
	
	@Transient
	private String acStartDateStrFormate;
	
	@Transient
	private String acEndDateStrFormate;
	
	@Transient
	private Date plannnedStartDate;
	
	@Transient
	private Date plannnedEndDate;
	
	@Transient
	private Date actualStartDate;
	
	@Transient
	private Date actualEndDate1;
	
	@Transient
	private String assignedToFirstName;
	
	@Transient
	private String assignedToLastName;
	
	@Transient
	private String compentenice;
	
	@Transient
	private String compGroupName;
	
	@Transient
	private String trainerName;
	
	@Transient
	private String traineeName;
	
	@Transient
	private String trainerEmpCode;
	
	@Transient
	private String traineeEmpCode;
	
	
	public Float getDeviation() {
		return deviation;
	}

	public void setDeviation(Float deviation) {
		this.deviation = deviation;
	}

	public int getTr_lines_id() {
		return tr_lines_id;
	}

	public void setTr_lines_id(int tr_lines_id) {
		this.tr_lines_id = tr_lines_id;
	}

	public Training_Master getTr_sh_id() {
		return tr_sh_id;
	}

	public void setTr_sh_id(Training_Master tr_sh_id) {
		this.tr_sh_id = tr_sh_id;
	}
	
	public Employee_Master getAssigned_to_emp() {
		return assigned_to_emp;
	}

	public void setAssigned_to_emp(Employee_Master assigned_to_emp) {
		this.assigned_to_emp = assigned_to_emp;
	}

	public String getNameOfTopics() {
		return nameOfTopics;
	}

	public void setNameOfTopics(String nameOfTopics) {
		this.nameOfTopics = nameOfTopics;
	}

	public Date getPlStartDate() {
		return plStartDate;
	}

	public void setPlStartDate(Date plStartDate) {
		this.plStartDate = plStartDate;
	}

	public Date getPlEndDate() {
		return plEndDate;
	}

	public void setPlEndDate(Date plEndDate) {
		this.plEndDate = plEndDate;
	}

	public Date getActualStDate() {
		return actualStDate;
	}

	public void setActualStDate(Date actualStDate) {
		this.actualStDate = actualStDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
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

	public String getTraining_type() {
		return training_type;
	}

	public void setTraining_type(String training_type) {
		this.training_type = training_type;
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

	public String getTotal_time_requires() {
		return total_time_requires;
	}

	public void setTotal_time_requires(String total_time_requires) {
		this.total_time_requires = total_time_requires;
	}

	public String getDisabledString() {
		return disabledString;
	}

	public void setDisabledString(String disabledString) {
		this.disabledString = disabledString;
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

	public String getTrainerStatus() {
		return trainerStatus;
	}

	public void setTrainerStatus(String trainerStatus) {
		this.trainerStatus = trainerStatus;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate1() {
		return actualEndDate1;
	}

	public void setActualEndDate1(Date actualEndDate1) {
		this.actualEndDate1 = actualEndDate1;
	}

	public String getAssignedToFirstName() {
		return assignedToFirstName;
	}

	public void setAssignedToFirstName(String assignedToFirstName) {
		this.assignedToFirstName = assignedToFirstName;
	}

	public String getAssignedToLastName() {
		return assignedToLastName;
	}

	public void setAssignedToLastName(String assignedToLastName) {
		this.assignedToLastName = assignedToLastName;
	}

	public Compentency_Master getComp_m_id() {
		return comp_m_id;
	}

	public void setComp_m_id(Compentency_Master comp_m_id) {
		this.comp_m_id = comp_m_id;
	}

	public String getCompentenice() {
		return compentenice;
	}

	public void setCompentenice(String compentenice) {
		this.compentenice = compentenice;
	}

	public String getCompGroupName() {
		return compGroupName;
	}

	public void setCompGroupName(String compGroupName) {
		this.compGroupName = compGroupName;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTrainerEmpCode() {
		return trainerEmpCode;
	}

	public void setTrainerEmpCode(String trainerEmpCode) {
		this.trainerEmpCode = trainerEmpCode;
	}

	public String getTraineeEmpCode() {
		return traineeEmpCode;
	}

	public void setTraineeEmpCode(String traineeEmpCode) {
		this.traineeEmpCode = traineeEmpCode;
	}		
		
}
