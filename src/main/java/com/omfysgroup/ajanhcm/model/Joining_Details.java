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
@Table(name="JOINING_DETAILS")
public class Joining_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "JOINING_DETAILS_SEQ", allocationSize = 1)
	
	
	@Column(name = "ID")
	private int id;
	
	@Column(name = "EMPLOYEE_STATUS")
	private String employee_status;
	
	@Column(name = "JOINING_DATE")
	private Date joining_date;
	
	@Transient
	private String joining_date1;
	
	@ManyToOne
	@JoinColumn(name="DESIGNATION_ID")
	private  Designation_Master designation_id;
	
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private  Role_Master role_id;
	
	@ManyToOne
	@JoinColumn(name="GRADE_ID")
	private  Grade_Level_Master grade_id;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private  Department_Master department_id;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee_Master emp_id;
	
	@Column(name = "CTC")
	private Long ctc;
	
	@Column(name = "GROSS_SALARY")
	private Long gross_salary;
	
	@Column(name = "BASIC_SALARY")
	private Long basic_salary;
	
	@Column(name = "PF_NUMBER")
	private String pf_number;
	
	@Column(name = "UAN_NUMBER")
	private Long uan_number;

	@Column(name = "ESIC_NUMBER")
	private Long esic_number;
	
	@Column(name = "BANK_AC_NUMBER")
	private Long bank_ac_number;
	
	@Column(name = "BANK_NAME")
	private String bank_name;
	
	@Column(name = "IFSC")
	private String ifsc;
	
	@Column(name = "PROBATION_DATE")
	private Date probation_date;
	
	@Transient
	private String probation_date1;
	
	@Column(name = "PREV_EMP_STATUS")
	private String prev_emp_status;
	
	@Column(name = "NEW_DESIGNATION")
	private String new_designation;
	
	@Column(name = "PF_APPLICABLE")
	private String pf_applicable;
	
	@Column(name = "ESIC_APPLICABLE")
	private String esic_applicable;
	
	@Column(name = "BRANCH_NAME")
	private String branch_name;
	
	@Column(name = "PAN_NO")
	private String pan_no;
	
	@Column(name = "AADHAR_CARD")
	private String aadhar_card;
	
	@Column(name = "EMPLOYMENT")
	private String employment;
	
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date;

	@Column(name = "LAST_UPDATED_BY" , updatable=true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date;
	
	@Column(name = "IS_DELETED")
	private String is_deleted;

	@Column(name = "CARRIER_GOAL")
	private String carrier_goals;
		
	@Column(name = "EXTRA_ACTIVITY")
	private String extra_curricular;
		
	@Column(name = "PREVIOUS_INTERVIEW")
	private String previous_interview;
		
	@Column(name = "MAJOR_PROJECT")
	private String mojorP_handled;
		
	@Column(name = "KEY_ACHIEVEMENTS")
	private String key_result_achieved;
	
	@Transient
	private String marital_status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJoining_date1() {
		return joining_date1;
	}

	public void setJoining_date1(String joining_date1) {
		this.joining_date1 = joining_date1;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}
	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public Designation_Master getDesignation_id() {
		return designation_id;
	}

	public void setDesignation_id(Designation_Master designation_id) {
		this.designation_id = designation_id;
	}

	public Role_Master getRole_id() {
		return role_id;
	}

	public void setRole_id(Role_Master role_id) {
		this.role_id = role_id;
	}

	public Grade_Level_Master getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(Grade_Level_Master grade_id) {
		this.grade_id = grade_id;
	}

	public Department_Master getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Department_Master department_id) {
		this.department_id = department_id;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
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

	public String getAadhar_card() {
		return aadhar_card;
	}

	public void setAadhar_card(String aadhar_card) {
		this.aadhar_card = aadhar_card;
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

	public Date getProbation_date() {
		return probation_date;
	}

	public void setProbation_date(Date probation_date) {
		this.probation_date = probation_date;
	}

	public String getProbation_date1() {
		return probation_date1;
	}

	public void setProbation_date1(String probation_date1) {
		this.probation_date1 = probation_date1;
	}

	public String getPrev_emp_status() {
		return prev_emp_status;
	}

	public void setPrev_emp_status(String prev_emp_status) {
		this.prev_emp_status = prev_emp_status;
	}

	@Transient
	private int e_id;
	@Transient
	private String fname;
	@Transient
	private String lname;
	
	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNew_designation() {
		return new_designation;
	}

	public void setNew_designation(String new_designation) {
		this.new_designation = new_designation;
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
	
	

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	@Override
	public String toString() {
		return "Joining_Details [id=" + id + ", employee_status=" + employee_status + ", joining_date=" + joining_date
				+ ", joining_date1=" + joining_date1 + ", designation_id=" + designation_id + ", role_id=" + role_id
				+ ", grade_id=" + grade_id + ", department_id=" + department_id + ", emp_id=" + emp_id + ", ctc=" + ctc
				+ ", gross_salary=" + gross_salary + ", basic_salary=" + basic_salary + ", pf_number=" + pf_number
				+ ", uan_number=" + uan_number + ", esic_number=" + esic_number + ", bank_ac_number=" + bank_ac_number
				+ ", bank_name=" + bank_name + ", ifsc=" + ifsc + ", probation_date=" + probation_date
				+ ", probation_date1=" + probation_date1 + ", prev_emp_status=" + prev_emp_status + ", new_designation="
				+ new_designation + ", pf_applicable=" + pf_applicable + ", esic_applicable=" + esic_applicable
				+ ", branch_name=" + branch_name + ", pan_no=" + pan_no + ", aadhar_card=" + aadhar_card
				+ ", employment=" + employment + ", created_by=" + created_by + ", creation_date=" + creation_date
				+ ", last_updated_by=" + last_updated_by + ", last_update_date=" + last_update_date + ", is_deleted="
				+ is_deleted + ", carrier_goals=" + carrier_goals + ", extra_curricular=" + extra_curricular
				+ ", previous_interview=" + previous_interview + ", mojorP_handled=" + mojorP_handled
				+ ", key_result_achieved=" + key_result_achieved + ", e_id=" + e_id + ", fname=" + fname + ", lname="
				+ lname + "]";
	}


}
