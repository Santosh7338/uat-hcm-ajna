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
@Table(name ="EVALUATION_CHILD")
public class Evaluation_Child {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eva_ch_seq")
	@SequenceGenerator(name = "eva_ch_seq", sequenceName ="EVALUATION_CHILD_SEQ", allocationSize = 1)
	@Column(name = "EVAL_CHILD_ID")
	private int eval_child_id;
	
	
	@Column(name ="CRIEMP_ID")
	private int criemp_id;

	@Column(name = "EMPLOYEE_LIST")
	private String employee_id;
	
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee_Master emp_id;
	
	@Column(name ="EMPLOYEE_CODE")
	private String emp_code;

	@Column(name = "INCIDENT_TYPE")
	private String incident_type;	

	@Column(name = "INCIDENT_DETAILS")
	private String incident_details;	
	
	@Column(name = "RATING_TYPE")
	private String rating_type;	
	
	
	
	@Column(name ="IS_ACTIVATED")
	private String is_activated;
	
	@Column(name ="CRIINC_COUNT")
	private int criinc_count;
	
	@Column(name ="APPROVER_ID1")
	private int approver_id1;
	
	@Column(name = "APPROVER_ID2")
	private int approver_id2;

	@Column(name = "APPROVER_TYPE1")
	private String approver_type1;
	
	@Column(name = "APPROVER_TYPE2")
	private String approver_type2;

	@Column(name = "STATUS1")
	private String status1;
	
	@Column(name = "STATUS2")
	private String status2;
	
    @Column(name = "LEAVE_STATUS")
	private String leave_Status;
    
    @Column(name ="REPORT_CRITI_ID")
	private int report_criti_id;
    
    
    
    @DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "START_DATE" , updatable = false)
	private Date start_date;

	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "END_DATE" , updatable = false)
	private Date end_date;
    
	
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date;
	
	
	@Column(name="FUNCTIONAL_ID")
	private int functional;
	
	
	@Column(name="ADMINISTRATIVE_ID")
	private int admin;
	
	@Column(name ="HR_ID")
	private int hr_id;
	
	@Column(name ="FUNCTIONAL_COMMENT")
	private String  fr_comment;
	
	@Column(name ="ADMIN_COMMENT")
	private String ar_comment;
	
	@Column(name ="HR_COMMENT")
	private String hr_comment;
	
	
	@Transient
	private String creationdatetrans;
	
	@Transient
	private String startdatetrans;

	@Transient
	private String enddatetrans;
	
	
	

	public int getReport_criti_id() {
		return report_criti_id;
	}

	public void setReport_criti_id(int report_criti_id) {
		this.report_criti_id = report_criti_id;
	}

	public int getEval_child_id() {
		return eval_child_id;
	}

	public void setEval_child_id(int eval_child_id) {
		this.eval_child_id = eval_child_id;
	}

	public int getCriemp_id() {
		return criemp_id;
	}

	public void setCriemp_id(int criemp_id) {
		this.criemp_id = criemp_id;
	}

	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getIncident_type() {
		return incident_type;
	}

	public void setIncident_type(String incident_type) {
		this.incident_type = incident_type;
	}

	public String getIncident_details() {
		return incident_details;
	}

	public void setIncident_details(String incident_details) {
		this.incident_details = incident_details;
	}

	public String getRating_type() {
		return rating_type;
	}

	public void setRating_type(String rating_type) {
		this.rating_type = rating_type;
	}

	public String getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
	}

	public int getCriinc_count() {
		return criinc_count;
	}

	public void setCriinc_count(int criinc_count) {
		this.criinc_count = criinc_count;
	}

	public int getApprover_id1() {
		return approver_id1;
	}

	public void setApprover_id1(int approver_id1) {
		this.approver_id1 = approver_id1;
	}

	public int getApprover_id2() {
		return approver_id2;
	}

	public void setApprover_id2(int approver_id2) {
		this.approver_id2 = approver_id2;
	}

	public String getApprover_type1() {
		return approver_type1;
	}

	public void setApprover_type1(String approver_type1) {
		this.approver_type1 = approver_type1;
	}

	public String getApprover_type2() {
		return approver_type2;
	}

	public void setApprover_type2(String approver_type2) {
		this.approver_type2 = approver_type2;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public String getLeave_Status() {
		return leave_Status;
	}

	public void setLeave_Status(String leave_Status) {
		this.leave_Status = leave_Status;
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

	public int getFunctional() {
		return functional;
	}

	public void setFunctional(int functional) {
		this.functional = functional;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getHr_id() {
		return hr_id;
	}

	public void setHr_id(int hr_id) {
		this.hr_id = hr_id;
	}

	public String getFr_comment() {
		return fr_comment;
	}

	public void setFr_comment(String fr_comment) {
		this.fr_comment = fr_comment;
	}

	public String getAr_comment() {
		return ar_comment;
	}

	public void setAr_comment(String ar_comment) {
		this.ar_comment = ar_comment;
	}

	public String getHr_comment() {
		return hr_comment;
	}

	public void setHr_comment(String hr_comment) {
		this.hr_comment = hr_comment;
	}

	public String getCreationdatetrans() {
		return creationdatetrans;
	}

	public void setCreationdatetrans(String creationdatetrans) {
		this.creationdatetrans = creationdatetrans;
	}

	public String getStartdatetrans() {
		return startdatetrans;
	}

	public void setStartdatetrans(String startdatetrans) {
		this.startdatetrans = startdatetrans;
	}

	public String getEnddatetrans() {
		return enddatetrans;
	}

	public void setEnddatetrans(String enddatetrans) {
		this.enddatetrans = enddatetrans;
	}

	




	
	
	
	
}
