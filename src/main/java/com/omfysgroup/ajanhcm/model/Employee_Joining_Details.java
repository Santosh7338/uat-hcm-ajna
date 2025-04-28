package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee_Joining_Details {

	private int id;
	
	private String employee_status;
	
	private Date joining_date;
	
	private String joining_date1;
	
	private  int designation_id;
	
	private  int role_id;
	
	private  int grade_id;

	private  int department_id;
	
	private int emp_id;
	
	private Long ctc;
	
	private Long gross_salary;
	
	private Long basic_salary;
	
	private String pf_number;
	
	private Long uan_number;

	private Long esic_number;
	
	private Long bank_ac_number;
	
	private String bank_name;
	
	private String ifsc;
	
	private Date probation_date;
		
	private String prev_emp_status;
	
	private String new_designation;
	
	private String pf_applicable;
	
	private String esic_applicable;
	
	private String branch_name;
	
	private String pan_no;
	
	private String aadhar_card;
	
	private String employment;
	
	private int created_by;

	private Date creation_date;

	private int last_updated_by;

	private Date last_update_date;
	
	private String is_deleted;

	private String carrier_goals;
		
	private String extra_curricular;
		
	private String previous_interview;
		
	private String mojorP_handled;
		
	private String key_result_achieved;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public String getJoining_date1() {
		return joining_date1;
	}

	public void setJoining_date1(String joining_date1) {
		this.joining_date1 = joining_date1;
	}

	public int getDesignation_id() {
		return designation_id;
	}

	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public Long getCtc() {
		return ctc;
	}

	public void setCtc(Long ctc) {
		this.ctc = ctc;
	}

	public Long getGross_salary() {
		return gross_salary;
	}

	public void setGross_salary(Long gross_salary) {
		this.gross_salary = gross_salary;
	}

	public Long getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(Long basic_salary) {
		this.basic_salary = basic_salary;
	}

	public String getPf_number() {
		return pf_number;
	}

	public void setPf_number(String pf_number) {
		this.pf_number = pf_number;
	}

	public Long getUan_number() {
		return uan_number;
	}

	public void setUan_number(Long uan_number) {
		this.uan_number = uan_number;
	}

	public Long getEsic_number() {
		return esic_number;
	}

	public void setEsic_number(Long esic_number) {
		this.esic_number = esic_number;
	}

	public Long getBank_ac_number() {
		return bank_ac_number;
	}

	public void setBank_ac_number(Long bank_ac_number) {
		this.bank_ac_number = bank_ac_number;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Date getProbation_date() {
		return probation_date;
	}

	public void setProbation_date(Date probation_date) {
		this.probation_date = probation_date;
	}

	public String getPrev_emp_status() {
		return prev_emp_status;
	}

	public void setPrev_emp_status(String prev_emp_status) {
		this.prev_emp_status = prev_emp_status;
	}

	public String getNew_designation() {
		return new_designation;
	}

	public void setNew_designation(String new_designation) {
		this.new_designation = new_designation;
	}

	public String getPf_applicable() {
		return pf_applicable;
	}

	public void setPf_applicable(String pf_applicable) {
		this.pf_applicable = pf_applicable;
	}

	public String getEsic_applicable() {
		return esic_applicable;
	}

	public void setEsic_applicable(String esic_applicable) {
		this.esic_applicable = esic_applicable;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public String getAadhar_card() {
		return aadhar_card;
	}

	public void setAadhar_card(String aadhar_card) {
		this.aadhar_card = aadhar_card;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
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

	public String getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getCarrier_goals() {
		return carrier_goals;
	}

	public void setCarrier_goals(String carrier_goals) {
		this.carrier_goals = carrier_goals;
	}

	public String getExtra_curricular() {
		return extra_curricular;
	}

	public void setExtra_curricular(String extra_curricular) {
		this.extra_curricular = extra_curricular;
	}

	public String getPrevious_interview() {
		return previous_interview;
	}

	public void setPrevious_interview(String previous_interview) {
		this.previous_interview = previous_interview;
	}

	public String getMojorP_handled() {
		return mojorP_handled;
	}

	public void setMojorP_handled(String mojorP_handled) {
		this.mojorP_handled = mojorP_handled;
	}

	public String getKey_result_achieved() {
		return key_result_achieved;
	}

	public void setKey_result_achieved(String key_result_achieved) {
		this.key_result_achieved = key_result_achieved;
	}

	@Override
	public String toString() {
		return "Employee_Joining_Details [id=" + id + ", employee_status=" + employee_status + ", joining_date="
				+ joining_date + ", joining_date1=" + joining_date1 + ", designation_id=" + designation_id
				+ ", role_id=" + role_id + ", grade_id=" + grade_id + ", department_id=" + department_id + ", emp_id="
				+ emp_id + ", ctc=" + ctc + ", gross_salary=" + gross_salary + ", basic_salary=" + basic_salary
				+ ", pf_number=" + pf_number + ", uan_number=" + uan_number + ", esic_number=" + esic_number
				+ ", bank_ac_number=" + bank_ac_number + ", bank_name=" + bank_name + ", ifsc=" + ifsc
				+ ", probation_date=" + probation_date + ", prev_emp_status=" + prev_emp_status + ", new_designation="
				+ new_designation + ", pf_applicable=" + pf_applicable + ", esic_applicable=" + esic_applicable
				+ ", branch_name=" + branch_name + ", pan_no=" + pan_no + ", aadhar_card=" + aadhar_card
				+ ", employment=" + employment + ", created_by=" + created_by + ", creation_date=" + creation_date
				+ ", last_updated_by=" + last_updated_by + ", last_update_date=" + last_update_date + ", is_deleted="
				+ is_deleted + ", carrier_goals=" + carrier_goals + ", extra_curricular=" + extra_curricular
				+ ", previous_interview=" + previous_interview + ", mojorP_handled=" + mojorP_handled
				+ ", key_result_achieved=" + key_result_achieved + "]";
	}

	
	
}
