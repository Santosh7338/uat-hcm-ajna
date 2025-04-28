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
@Table(name ="EVALUATION_ADDROW")
public class Evaluation_AddRow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="eva_addrow_seq")
	@SequenceGenerator(name = "eva_addrow_seq", sequenceName ="EVALUATION_ADDROW_SEQ", allocationSize = 1)
	@Column(name = "EVAL_ADDROW_ID")
	private int eval_addrow_id;
	
	@Column(name = "EVAL_PARENT_ID")
	private int eval_parent_id;
	
	@Column(name = "ASSESS_MASTER_ID")
	private int assess_master_id;

	@Column(name ="PARAMETER_TYPE")
	private String parameter_type;

	@Column(name = "PARAMETER_VALUE")
	private String parameter_value;
	
	@Column(name ="EVALUATION_TYPE")
	private String evaluation_type;
	
	@Column(name ="EVALUATOR")
	private String evaluator;

	
	
	@Column(name ="SET_TARGET")
	private int set_target;
	
	@Column(name ="RATING_OUT_OF")
	private int rating_out_of;
	
	
	@Column(name = "RATING_TYPE")
	private String rating_type;
	
	@Column(name = "REMARKS")
	private String remarks;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;
	
	@Column(name="EMPLOYEE_ID")
	private int employee_id;
	
	@Column( name="EVALUATION_STATUS")
    private String evaluation_status ;
	
    @Transient
	private String email;
    
    @Transient
	private String firstname;
    
    @Transient
	private String last_name;
    
    @Transient
   	private String employee_code;
    
    @Transient
    private String  employee_fullname;
    
    @Transient
    private String evaluator_name;
    
    @Transient
    private String actual_rating_per;
    

	public int getAssess_master_id() {
		return assess_master_id;
	}

	public void setAssess_master_id(int assess_master_id) {
		this.assess_master_id = assess_master_id;
	}

	public int getEval_addrow_id() {
		return eval_addrow_id;
	}

	public void setEval_addrow_id(int eval_addrow_id) {
		this.eval_addrow_id = eval_addrow_id;
	}

	public int getEval_parent_id() {
		return eval_parent_id;
	}

	public void setEval_parent_id(int eval_parent_id) {
		this.eval_parent_id = eval_parent_id;
	}

	public String getParameter_type() {
		return parameter_type;
	}

	public void setParameter_type(String parameter_type) {
		this.parameter_type = parameter_type;
	}

	public String getParameter_value() {
		return parameter_value;
	}

	public void setParameter_value(String parameter_value) {
		this.parameter_value = parameter_value;
	}

	public String getEvaluation_type() {
		return evaluation_type;
	}

	public void setEvaluation_type(String evaluation_type) {
		this.evaluation_type = evaluation_type;
	}

	public String getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}

	
	public int getSet_target() {
		return set_target;
	}

	public void setSet_target(int set_target) {
		this.set_target = set_target;
	}

	public int getRating_out_of() {
		return rating_out_of;
	}

	public void setRating_out_of(int rating_out_of) {
		this.rating_out_of = rating_out_of;
	}

	

	public String getRating_type() {
		return rating_type;
	}

	public void setRating_type(String rating_type) {
		this.rating_type = rating_type;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEvaluation_status() {
		return evaluation_status;
	}

	public void setEvaluation_status(String evaluation_status) {
		this.evaluation_status = evaluation_status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}

	public String getEmployee_fullname() {
		return employee_fullname;
	}

	public void setEmployee_fullname(String employee_fullname) {
		this.employee_fullname = employee_fullname;
	}

	public String getEvaluator_name() {
		return evaluator_name;
	}

	public void setEvaluator_name(String evaluator_name) {
		this.evaluator_name = evaluator_name;
	}

	public String getActual_rating_per() {
		return actual_rating_per;
	}

	public void setActual_rating_per(String actual_rating_per) {
		this.actual_rating_per = actual_rating_per;
	}
    

	
	
	
}


