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
@Table(name="EVAL_COUNSELING_SESSION")
public class Eval_Counseling_Session {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="eval_coun_ses_seq")
	@SequenceGenerator(name = "eval_coun_ses_seq", sequenceName = "EVAL_COUNSELING_SESSION_SEQ", allocationSize = 1)
	
	@Column(name = "COUN_SESSION_ID")
	private int coun_session_id;
	
	
	@Column(name ="CONEMP_ID")
	private int conemp_id;
	
	
	@Column(name = "REPORT_COUN_ID")
	private int report_coun_id;
	
	
	@Column(name="EMPLOYEE_NAME")
	private String employee_name;
	
	@Column(name ="EMPLOYEE_CODE")
	private String emp_code;
	
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee_Master emp_id;
	
	@Column(name="INCIDENT")
	private String incident;
	
	@Column(name="INCIDENT_TYPE")
	private String incident_type;
	
	@Column(name="COUNSELOR_NAME")
	private String counselor_name;
	
	@Column(name = "COUN_SES_DESC")
	private String coun_ses_desc;
	
	@Column(name = "RATING_TYPE")
	private String rating_type;	
	
	@Column(name ="CONS_COUNT")
	private int cons_count;
	
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
    
    @DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "START_DATE" , updatable = false)
	private Date start_date;

	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "END_DATE" , updatable = false)
	private Date end_date;
    
    
    @Column(name ="IS_ACTIVATED")
	private String is_activated;
    
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
	
	
	@Transient
	private String creationdatetrans;

	
	@Transient
	private String min_startdatetrans;


	@Transient
	private String max_enddatetrans;


	public int getCoun_session_id() {
		return coun_session_id;
	}


	public void setCoun_session_id(int coun_session_id) {
		this.coun_session_id = coun_session_id;
	}


	public int getConemp_id() {
		return conemp_id;
	}


	public void setConemp_id(int conemp_id) {
		this.conemp_id = conemp_id;
	}


	public int getReport_coun_id() {
		return report_coun_id;
	}


	public void setReport_coun_id(int report_coun_id) {
		this.report_coun_id = report_coun_id;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}


	public String getEmp_code() {
		return emp_code;
	}


	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}


	public Employee_Master getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}


	public String getIncident() {
		return incident;
	}


	public void setIncident(String incident) {
		this.incident = incident;
	}


	public String getIncident_type() {
		return incident_type;
	}


	public void setIncident_type(String incident_type) {
		this.incident_type = incident_type;
	}


	public String getCounselor_name() {
		return counselor_name;
	}


	public void setCounselor_name(String counselor_name) {
		this.counselor_name = counselor_name;
	}


	public String getCoun_ses_desc() {
		return coun_ses_desc;
	}


	public void setCoun_ses_desc(String coun_ses_desc) {
		this.coun_ses_desc = coun_ses_desc;
	}


	public String getRating_type() {
		return rating_type;
	}


	public void setRating_type(String rating_type) {
		this.rating_type = rating_type;
	}


	public int getCons_count() {
		return cons_count;
	}


	public void setCons_count(int cons_count) {
		this.cons_count = cons_count;
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


	public String getIs_activated() {
		return is_activated;
	}


	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
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


	public String getCreationdatetrans() {
		return creationdatetrans;
	}


	public void setCreationdatetrans(String creationdatetrans) {
		this.creationdatetrans = creationdatetrans;
	}


	public String getMin_startdatetrans() {
		return min_startdatetrans;
	}


	public void setMin_startdatetrans(String min_startdatetrans) {
		this.min_startdatetrans = min_startdatetrans;
	}


	public String getMax_enddatetrans() {
		return max_enddatetrans;
	}


	public void setMax_enddatetrans(String max_enddatetrans) {
		this.max_enddatetrans = max_enddatetrans;
	}
	
	
	
	

	






}








