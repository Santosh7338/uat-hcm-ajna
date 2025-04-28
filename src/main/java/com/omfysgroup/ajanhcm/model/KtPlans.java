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
@Table(name="KT_PLANS")
public class KtPlans {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kt_plans_seq")
	@SequenceGenerator(name = "kt_plans_seq", sequenceName = "KT_PLANS_SEQ", allocationSize = 1)
	
	@Column(name = "KT_ID")
    private int ktid;
	
	@Column(name="PROJECT_NAME")
	private String projectname;
	
	@Column(name="PROJECT_TOPIC")
	private String projecttopic;
	
	@Column(name="PROJECT_SUB_TOPIC")
	private String projectsubtopic;
	
	@ManyToOne
	@JoinColumn(name="KT_TAKERS")
	private Employee_Master kttakers ;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLANNED_START_DATE", updatable = true)
	private Date plannedstartdate;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLANNED_END_DATE", updatable = true)
	private Date plannedenddate;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ACTUAL_START_DATE", updatable = true)
	private Date actualstartdate;//=new java.sql.Date(new java.util.Date().getTime());
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ACTUAL_END_DATE", updatable = true)
	private Date actualenddate;//=new java.sql.Date(new java.util.Date().getTime());
	
	@ManyToOne
	@JoinColumn(name="KT_GIVER")
	private Employee_Master ktgiver ;
	
	@Column(name="KT_STATUS")
	private String ktstatus;
	
	@Column(name = "REMARKS")
	private String remarks;
	
	@ManyToOne
	@JoinColumn(name="EXIT_ID")
	private MarkExitScreen exit_id;
	
	@ManyToOne
	@JoinColumn(name="FR_ID")
	private Functional_Reporting fr_id;
	
	@ManyToOne
	@JoinColumn(name="AR_ID")
	private Administrative_Reporting ar_id;
	
	@Column(name="AR_COMMENTS")
	private String ar_comment;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="LAST_UPDATE_DATE",updatable=true)
	private Date last_update_date; //new java.sql.Date(new java.util.Date().getTime());
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="CREATION_DATE",updatable=true)
	private Date creation_date;//=new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name="KT_HEADERID")
	private int ktheader_id;
	
	@Column(name="KT_TAKER_STATUS")
	private String kt_takerStatus;
	
	@Column(name="KT_GIVER_STATUS")
	private String kt_giver_Status;
	
	@Column(name="ADMINISTATIVE_ID")
	private int administrative;
	
	@Column(name="FUNCTIONAL_ID")
	private int functional;
	
	@Transient
	private String plannedSdate;
	
	@Transient
	private String plannedEdate;
	
	@Transient
	private String actualSdate;
	
	@Transient
	private String actualEdate;
	
	public Employee_Master getKttakers() {
		return kttakers;
	}

	public void setKttakers(Employee_Master kttakers) {
		this.kttakers = kttakers;
	}

	public int getKtid() {
		return ktid;
	}
	
	public MarkExitScreen getExit_id() {
		return exit_id;
	}

	public void setExit_id(MarkExitScreen exit_id) {
		this.exit_id = exit_id;
	}

	public void setKtid(int ktid) {
		this.ktid = ktid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getProjecttopic() {
		return projecttopic;
	}

	public void setProjecttopic(String projecttopic) {
		this.projecttopic = projecttopic;
	}

	public String getProjectsubtopic() {
		return projectsubtopic;
	}

	public void setProjectsubtopic(String projectsubtopic) {
		this.projectsubtopic = projectsubtopic;
	}


	public Date getPlannedstartdate() {
		return plannedstartdate;
	}

	public void setPlannedstartdate(Date plannedstartdate) {
		this.plannedstartdate = plannedstartdate;
	}

	public Date getPlannedenddate() {
		return plannedenddate;
	}

	public void setPlannedenddate(Date plannedenddate) {
		this.plannedenddate = plannedenddate;
	}

	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Employee_Master getKtgiver() {
		return ktgiver;
	}

	public void setKtgiver(Employee_Master ktgiver) {
		this.ktgiver = ktgiver;
	}

	public String getKtstatus() {
		return ktstatus;
	}

	public void setKtstatus(String ktstatus) {
		this.ktstatus = ktstatus;
	}

	public Date getActualstartdate() {
		return actualstartdate;
	}

	public void setActualstartdate(Date actualstartdate) {
		this.actualstartdate = actualstartdate;
	}

	public Date getActualenddate() {
		return actualenddate;
	}

	public void setActualenddate(Date actualenddate) {
		this.actualenddate = actualenddate;
	}

	public String getPlannedSdate() {
		return plannedSdate;
	}

	public void setPlannedSdate(String plannedSdate) {
		this.plannedSdate = plannedSdate;
	}

	public String getPlannedEdate() {
		return plannedEdate;
	}

	public void setPlannedEdate(String plannedEdate) {
		this.plannedEdate = plannedEdate;
	}

	public String getActualSdate() {
		return actualSdate;
	}

	public void setActualSdate(String actualSdate) {
		this.actualSdate = actualSdate;
	}

	public String getActualEdate() {
		return actualEdate;
	}

	public void setActualEdate(String actualEdate) {
		this.actualEdate = actualEdate;
	}

	public Functional_Reporting getFr_id() {
		return fr_id;
	}

	public void setFr_id(Functional_Reporting fr_id) {
		this.fr_id = fr_id;
	}

	public Administrative_Reporting getAr_id() {
		return ar_id;
	}

	public void setAr_id(Administrative_Reporting ar_id) {
		this.ar_id = ar_id;
	}

	public String getAr_comment() {
		return ar_comment;
	}

	public void setAr_comment(String ar_comment) {
		this.ar_comment = ar_comment;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getKtheader_id() {
		return ktheader_id;
	}

	public void setKtheader_id(int ktheader_id) {
		this.ktheader_id = ktheader_id;
	}

	public String getKt_takerStatus() {
		return kt_takerStatus;
	}

	public void setKt_takerStatus(String kt_takerStatus) {
		this.kt_takerStatus = kt_takerStatus;
	}

	public String getKt_giver_Status() {
		return kt_giver_Status;
	}

	public void setKt_giver_Status(String kt_giver_Status) {
		this.kt_giver_Status = kt_giver_Status;
	}

	public int getAdministrative() {
		return administrative;
	}

	public void setAdministrative(int administrative) {
		this.administrative = administrative;
	}

	public int getFunctional() {
		return functional;
	}

	public void setFunctional(int functional) {
		this.functional = functional;
	}

	
	
}
