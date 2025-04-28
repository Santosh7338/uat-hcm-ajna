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
@Table(name="PRE_PERSONAL_DETAILS")
public class PreJoinigPersonal {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_personal_details_seq")
	@SequenceGenerator(name = "pre_personal_details_seq", sequenceName = "PRE_PERSONAL_DETAILS_SEQ", allocationSize = 1)
	
	@Column(name = "PERSONAL_ID")
    private int pre_emp_id;
	
	@ManyToOne
	@JoinColumn(name = "DESIGNATION")
	private Designation_Master designation;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT")
	private Department_Master departments;
	
	@ManyToOne
	@JoinColumn(name = "GRADE")
	private Grade_Level_Master grade;
	
	@ManyToOne
	@JoinColumn(name = "ROLE")
	private Role_Master role;
	
	@Column(name = "EMPLOYMENT_MODE")
	private String employment_mode;
	
	@Column(name = "FIRST_NAME")
	private String first_name;
	
	@Column(name = "MIDDLE_NAME")
	private String middle_name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@Column(name = "EMAIL_ID")
	private String email_id;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobile_number;
	
	@Column(name = "EMERGENCY_NUMBER")
	private String emergency_number;
	
	@Column(name = "RELIGIONS")
	private String religions;
	
	@Column(name = "PLACE_OF_BIRTH")
	private String place_of_birth;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "DATE_OF_BIRTH", updatable = true)
	private Date date_of_birth;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "MARITAL_STATUS")
	private String marital_status;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "MARRIAGE_DATE", updatable = true)
	private Date marriage_date;
	
	@Column(name = "STATE_OF_DOMICILE")
	private String state_of_domicile;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "NATIONALITY_SELF")
	private String nationality_self;
	
	@Column(name = "BLOOD_GROUP")
	private String blood_group;
	
	@Column(name = "AGE")
	private String age;
	
	@Column(name = "HEIGHT")
	private String height;
	
	@Column(name = "WEIGHT")
	private String weight;
	
	@Column(name = "SPECTACLES")
	private String vision;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "DATE_OF_JOINING", updatable = true)
	private Date date_of_joining;
	
	@Column(name = "PASSPORT_PHOTO")
	private byte[] passport_photo;
	
	@Column(name = "CORRESPONDENCE_ADD")
	private String corresponding_add;
	
	@Column(name = "PERMANENT_ADD")
	private String permanent_add;
	
	@Column(name = "PHYSICAL_DISABILITY")
	private String physical_disability;
	
    @Column(name = "PRE_ID")
	private int pre_id;
	
    @Column(name = "JOINING_STATUS")
	private String joining_status;
    
    @Column(name = "EMP_STATUS")
   	private String employee_status;
    
    @Column(name = "CARRIER_GOALS")
	private String carrier_goals;
	
	@Column(name = "EXTRA_ACTIVITY")
	private String extra_curricular;
	
	@Column(name = "PREVIOUS_INTERVIEW")
	private String previous_interview;
	
	@Column(name = "MAJOR_PROJECT_HANDLED")
	private String mojorP_handled;
	
	@Column(name = "KEY_ACHIEVEMENT")
	private String key_result_achieved;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable =false)
	private Date creation_date;
	
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE", updatable =true)
	private Date last_updated_date;
	
	@Transient
	private String joiningdateTrans;
	
	@Transient
	private String birthdateTrans;
	
	@Transient
	private String marriagedateTrans;
	
	@Transient
	private String creationdateTrans;
	
	@Transient
	private String lastupdatedateTrans;
	

	public String getJoining_status() {
		return joining_status;
	}

	public void setJoining_status(String joining_status) {
		this.joining_status = joining_status;
	}

	public int getPre_id() {
		return pre_id;
	}

	public void setPre_id(int pre_id) {
		this.pre_id = pre_id;
	}

	
	public int getPre_emp_id() {
		return pre_emp_id;
	}

	public void setPre_emp_id(int pre_emp_id) {
		this.pre_emp_id = pre_emp_id;
	}

	public Designation_Master getDesignation() {
		return designation;
	}

	public void setDesignation(Designation_Master designation) {
		this.designation = designation;
	}

	public Department_Master getDepartments() {
		return departments;
	}

	public void setDepartments(Department_Master departments) {
		this.departments = departments;
	}

	public Grade_Level_Master getGrade() {
		return grade;
	}

	public void setGrade(Grade_Level_Master grade) {
		this.grade = grade;
	}

	public Role_Master getRole() {
		return role;
	}

	public void setRole(Role_Master role) {
		this.role = role;
	}

	public String getEmployment_mode() {
		return employment_mode;
	}

	public void setEmployment_mode(String employment_mode) {
		this.employment_mode = employment_mode;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmergency_number() {
		return emergency_number;
	}

	public void setEmergency_number(String emergency_number) {
		this.emergency_number = emergency_number;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public String getReligions() {
		return religions;
	}

	public void setReligions(String religions) {
		this.religions = religions;
	}

	public String getPlace_of_birth() {
		return place_of_birth;
	}

	public void setPlace_of_birth(String place_of_birth) {
		this.place_of_birth = place_of_birth;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getState_of_domicile() {
		return state_of_domicile;
	}

	public void setState_of_domicile(String state_of_domicile) {
		this.state_of_domicile = state_of_domicile;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNationality_self() {
		return nationality_self;
	}

	public void setNationality_self(String nationality_self) {
		this.nationality_self = nationality_self;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	public byte[] getPassport_photo() {
		return passport_photo;
	}

	public void setPassport_photo(byte[] passport_photo) {
		this.passport_photo = passport_photo;
	}

	public String getCorresponding_add() {
		return corresponding_add;
	}

	public void setCorresponding_add(String corresponding_add) {
		this.corresponding_add = corresponding_add;
	}

	public String getPermanent_add() {
		return permanent_add;
	}

	public void setPermanent_add(String permanent_add) {
		this.permanent_add = permanent_add;
	}

	public String getPhysical_disability() {
		return physical_disability;
	}

	public void setPhysical_disability(String physical_disability) {
		this.physical_disability = physical_disability;
	}

	public Date getMarriage_date() {
		return marriage_date;
	}

	public void setMarriage_date(Date marriage_date) {
		this.marriage_date = marriage_date;
	}

	public String getEmployee_status() {
		return employee_status;
	}

	public void setEmployee_status(String employee_status) {
		this.employee_status = employee_status;
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

	public String getJoiningdateTrans() {
		return joiningdateTrans;
	}

	public void setJoiningdateTrans(String joiningdateTrans) {
		this.joiningdateTrans = joiningdateTrans;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	public String getBirthdateTrans() {
		return birthdateTrans;
	}

	public void setBirthdateTrans(String birthdateTrans) {
		this.birthdateTrans = birthdateTrans;
	}

	public String getMarriagedateTrans() {
		return marriagedateTrans;
	}

	public void setMarriagedateTrans(String marriagedateTrans) {
		this.marriagedateTrans = marriagedateTrans;
	}

	public String getCreationdateTrans() {
		return creationdateTrans;
	}

	public void setCreationdateTrans(String creationdateTrans) {
		this.creationdateTrans = creationdateTrans;
	}

	public String getLastupdatedateTrans() {
		return lastupdatedateTrans;
	}

	public void setLastupdatedateTrans(String lastupdatedateTrans) {
		this.lastupdatedateTrans = lastupdatedateTrans;
	}
	
	
	
	
	
	
	
	
	
	

}
