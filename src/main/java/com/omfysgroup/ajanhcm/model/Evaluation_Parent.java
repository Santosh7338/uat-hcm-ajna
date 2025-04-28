
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
@Table(name ="EVALUATION_PARENT")
public class Evaluation_Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "eva_pa_seq")
	@SequenceGenerator(name = "eva_pa_seq", sequenceName ="EVALUATION_PARENT_SEQ", allocationSize = 1)
	@Column(name = "EVAL_PARENT_ID")
	private int eval_parent_id;

	@Column(name = "EMPLOYEE_LIST")
	private int employee_list;
	
	
	@Column(name = "ASSESS_MASTER_ID")
	private int assess_master_id;
	
	@Column(name ="EMPLOYEE_CODE")
	private String emp_code;
	
	@Column(name ="EMPLOYEE_NAME")
	private String employee_name;
	
	@Column(name = "EVALUATION_PURPOSE")
	private String evaluation_purpose;
	
	@Column(name = "EVALUATION_OTHER")
	private String evaluation_other;
	
	
	@Column(name ="IS_ACTIVATED")
	private String is_activated;
	
	@Column(name ="EVALUATION_STATUS")
	private String evaluation_status;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ASSESS_START_DATE" , updatable = false)
	private Date assessment_start_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ASSESS_END_DATE" , updatable = false)
	private Date assessment_end_date;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "ASSESS_COMPLETION_DATE" , updatable = false)
	private Date assess_completion_date; 
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "PUBLISH_DATE" , updatable = true)
	private Date publish_date;
	
	
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
	private String ass_startdatetrans;
	
	@Transient
	private String ass_endatetrans;
	
	@Transient
	private String ass_comple_datetrans;
	
	@Transient
	private String creationdatetrans;
	
	@Transient
	private String publisheddatetrans;

	public int getEval_parent_id() {
		return eval_parent_id;
	}

	public void setEval_parent_id(int eval_parent_id) {
		this.eval_parent_id = eval_parent_id;
	}

	public int getEmployee_list() {
		return employee_list;
	}

	public void setEmployee_list(int employee_list) {
		this.employee_list = employee_list;
	}

	public int getAssess_master_id() {
		return assess_master_id;
	}

	public void setAssess_master_id(int assess_master_id) {
		this.assess_master_id = assess_master_id;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEvaluation_purpose() {
		return evaluation_purpose;
	}

	public void setEvaluation_purpose(String evaluation_purpose) {
		this.evaluation_purpose = evaluation_purpose;
	}

	public String getEvaluation_other() {
		return evaluation_other;
	}

	public void setEvaluation_other(String evaluation_other) {
		this.evaluation_other = evaluation_other;
	}

	public String getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
	}

	public String getEvaluation_status() {
		return evaluation_status;
	}

	public void setEvaluation_status(String evaluation_status) {
		this.evaluation_status = evaluation_status;
	}

	public Date getAssessment_start_date() {
		return assessment_start_date;
	}

	public void setAssessment_start_date(Date assessment_start_date) {
		this.assessment_start_date = assessment_start_date;
	}

	public Date getAssessment_end_date() {
		return assessment_end_date;
	}

	public void setAssessment_end_date(Date assessment_end_date) {
		this.assessment_end_date = assessment_end_date;
	}

	public Date getAssess_completion_date() {
		return assess_completion_date;
	}

	public void setAssess_completion_date(Date assess_completion_date) {
		this.assess_completion_date = assess_completion_date;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
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

	public String getAss_startdatetrans() {
		return ass_startdatetrans;
	}

	public void setAss_startdatetrans(String ass_startdatetrans) {
		this.ass_startdatetrans = ass_startdatetrans;
	}

	public String getAss_endatetrans() {
		return ass_endatetrans;
	}

	public void setAss_endatetrans(String ass_endatetrans) {
		this.ass_endatetrans = ass_endatetrans;
	}

	public String getAss_comple_datetrans() {
		return ass_comple_datetrans;
	}

	public void setAss_comple_datetrans(String ass_comple_datetrans) {
		this.ass_comple_datetrans = ass_comple_datetrans;
	}

	public String getCreationdatetrans() {
		return creationdatetrans;
	}

	public void setCreationdatetrans(String creationdatetrans) {
		this.creationdatetrans = creationdatetrans;
	}

	public String getPublisheddatetrans() {
		return publisheddatetrans;
	}

	public void setPublisheddatetrans(String publisheddatetrans) {
		this.publisheddatetrans = publisheddatetrans;
	}
	
	
	
	
	
	
}
	