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
@Table(name="KT_PLAN_HEADER")
public class KtPlan_Header {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ktplans_header_seq")
	@SequenceGenerator(name = "ktplans_header_seq", sequenceName = "KTPLAN_HEADER_SEQ", allocationSize = 1)
	
	@Column(name = "KT_HEADERID")
    private int ktHeaderId;
	
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@ManyToOne
	@JoinColumn(name="KT_GIVERS")
	private Employee_Master kt_giverhead ;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLAN_START_DATE", updatable = false)
	private Date planned_start;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PLAN_END_DATE", updatable = false)
	private Date planned_end;
	
	@ManyToOne
	@JoinColumn(name="KT_TAKER")
	private Employee_Master kt_takerhead ;
	
	@ManyToOne
	@JoinColumn(name="EXIT_IDS")
	private MarkExitScreen exit_id;
	
	@ManyToOne
	@JoinColumn(name="FR_NOS")
	private Functional_Reporting fr_idHead;
	
	@ManyToOne
	@JoinColumn(name="AR_NOS")
	private Administrative_Reporting ar_idHead;
	
	@Column(name="KTSTATUS")
	private String ktstatushead;
	
	@Column(name="ADMIN_ID")
	private int adminid;
	
	@Column(name="FUNCTIONAL_ID")
	private int functionalid;
	
	@DateTimeFormat(pattern="dd/mm/yyyy hh:ss:mm")
	@Column(name="LAST_UPDATED_DATE",updatable=true)
	private Date last_updated_date; 
	
	
	@Transient
	private String plannedStartTrans;
	
	@Transient
	private String plannedEndTrans;
	
	@Transient
	private String actualStartTrans;
	
	@Transient
	private String actualEndTrans;
	
	@Transient
	private String empname;

	public int getKtHeaderId() {
		return ktHeaderId;
	}

	public void setKtHeaderId(int ktHeaderId) {
		this.ktHeaderId = ktHeaderId;
	}

	public Employee_Master getKt_giverhead() {
		return kt_giverhead;
	}

	public void setKt_giverhead(Employee_Master kt_giverhead) {
		this.kt_giverhead = kt_giverhead;
	}

	public Date getPlanned_start() {
		return planned_start;
	}

	public void setPlanned_start(Date planned_start) {
		this.planned_start = planned_start;
	}

	public Date getPlanned_end() {
		return planned_end;
	}

	public void setPlanned_end(Date planned_end) {
		this.planned_end = planned_end;
	}

	public Employee_Master getKt_takerhead() {
		return kt_takerhead;
	}

	public void setKt_takerhead(Employee_Master kt_takerhead) {
		this.kt_takerhead = kt_takerhead;
	}

	public MarkExitScreen getExit_id() {
		return exit_id;
	}

	public void setExit_id(MarkExitScreen exit_id) {
		this.exit_id = exit_id;
	}

	public Functional_Reporting getFr_idHead() {
		return fr_idHead;
	}

	public void setFr_idHead(Functional_Reporting fr_idHead) {
		this.fr_idHead = fr_idHead;
	}

	public Administrative_Reporting getAr_idHead() {
		return ar_idHead;
	}

	public void setAr_idHead(Administrative_Reporting ar_idHead) {
		this.ar_idHead = ar_idHead;
	}

	public String getKtstatushead() {
		return ktstatushead;
	}

	public void setKtstatushead(String ktstatushead) {
		this.ktstatushead = ktstatushead;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPlannedStartTrans() {
		return plannedStartTrans;
	}

	public void setPlannedStartTrans(String plannedStartTrans) {
		this.plannedStartTrans = plannedStartTrans;
	}

	public String getPlannedEndTrans() {
		return plannedEndTrans;
	}

	public void setPlannedEndTrans(String plannedEndTrans) {
		this.plannedEndTrans = plannedEndTrans;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getActualStartTrans() {
		return actualStartTrans;
	}

	public void setActualStartTrans(String actualStartTrans) {
		this.actualStartTrans = actualStartTrans;
	}

	public String getActualEndTrans() {
		return actualEndTrans;
	}

	public void setActualEndTrans(String actualEndTrans) {
		this.actualEndTrans = actualEndTrans;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public int getFunctionalid() {
		return functionalid;
	}

	public void setFunctionalid(int functionalid) {
		this.functionalid = functionalid;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	

	
	
	
	
}
