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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="PERSONAL_DETAILS")
public class Personal_Details 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "PERSONAL_DETAILS_SEQ", allocationSize = 1)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "FIRST_NAME")
	private String first_name;
	
	@Column(name = "MIDDLE_NAME")
	private String middle_name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@Column(name = "GENDER")
	private String gender;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MARITAL_STATUS")
	private String marital_status;
	
	@Column(name = "RELIGION")
	private String religion;
	
	@Column(name = "SPOUSE_NAME")
	private String spouse_name;
	
	@Column(name = "CONTACT_NUMBER")
	private Long contact_number;
	
	@Column(name = "EMERGENCY_NUMBER")
	private Long emergency_number;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee_Master emp_id;
	
	@Column(name = "DOB")
	private Date dob;
		
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date= new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY" , updatable=true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE" , updatable = true)
	private Date last_update_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "IS_DELETED")
	private String is_deleted;
	
	@Column(name = "BIRTH_PLACE")
	private String birth_place;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "MARRIAGE_DATE" , updatable = true)
	private Date marrriage_date;
	
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
	
	@Column(name = "VISION")
	private String vision;
	
	@Column(name = "PHYSICAL_DISABILITY")
	private String physical_disability;
	
	@Column(name = "CORP_EMAIL")
	private String corporate_email;
	
	public String getBirth_place() {
		return birth_place;
	}

	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}

	public Date getMarrriage_date() {
		return marrriage_date;
	}

	public void setMarrriage_date(Date marrriage_date) {
		this.marrriage_date = marrriage_date;
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

	public String getPhysical_disability() {
		return physical_disability;
	}

	public void setPhysical_disability(String physical_disability) {
		this.physical_disability = physical_disability;
	}

	public String getCorporate_email() {
		return corporate_email;
	}

	public void setCorporate_email(String corporate_email) {
		this.corporate_email = corporate_email;
	}

	public void setContact_number(Long contact_number) {
		this.contact_number = contact_number;
	}

	
	
	public String getState_domicile() {
		return state_domicile;
	}

	public void setState_domicile(String state_domicile) {
		this.state_domicile = state_domicile;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "STATE_DOMICILE")
	private String state_domicile;
	
	@Column(name = "DISTRICT")
	private String district;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getSpouse_name() {
		return spouse_name;
	}

	public void setSpouse_name(String spouse_name) {
		this.spouse_name = spouse_name;
	}

	public long getContact_number() {
		return contact_number;
	}

	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}

	public Long getEmergency_number() {
		return emergency_number;
	}

	public void setEmergency_number(Long emergency_number) {
		this.emergency_number = emergency_number;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Personal_Details [id=" + id + ", first_name=" + first_name + ", middle_name=" + middle_name
				+ ", last_name=" + last_name + ", gender=" + gender + ", email=" + email + ", marital_status="
				+ marital_status + ", religion=" + religion + ", spouse_name=" + spouse_name + ", contact_number="
				+ contact_number + ", emergency_number=" + emergency_number + ", emp_id=" + emp_id + ", dob=" + dob
				+ ", created_by=" + created_by + ", creation_date=" + creation_date + ", last_updated_by="
				+ last_updated_by + ", last_update_date=" + last_update_date + ", is_deleted=" + is_deleted
				+ ", birth_place=" + birth_place + ", marrriage_date=" + marrriage_date + ", nationality_self="
				+ nationality_self + ", blood_group=" + blood_group + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + ", vision=" + vision + ", physical_disability=" + physical_disability
				+ ", corporate_email=" + corporate_email + "]";
	}
	

}
