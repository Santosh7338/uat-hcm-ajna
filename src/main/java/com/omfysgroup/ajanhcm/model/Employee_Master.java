package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "EMPLOYEE_MASTER")

public class Employee_Master implements  Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "EMPLOYEE_MASTER_SEQ", allocationSize = 1)

	@Column(name = "EMP_ID")
	private int emp_id;

	@Column(name = "EMP_CODE")
	private String emp_code;

	@Column(name = "EMP_FIRST_NAME")
	private String emp_first_name;

	@Column(name = "EMP_LAST_NAME")
	private String emp_last_name;

	@Column(name = "USER_ID")
	private int user_id;

	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "OTP")
	private String otp;
	
	//santosh add
	@Column(name="EARLYLATE_COMINGSTATUS")
	private String earlylate_comingstatus;
		
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "IS_DELETED")
	private String is_deleted;

	@Column(name = "IS_ACTIVATED")
	private String is_activated;
	
	@Column(name="ODAPPLICABLE")
	private String od_applicable;

	@Column(name = "PROFILE_ID")
	private int profile_id;
	
	@Column(name = "UPLOAD_PHOTO")
	private byte[] upload_photo;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PHOTO_NAME")
	private String photo_name;
	
	@Column(name="EMP_DEACT_DATE")
	private Date emp_deact_date;
	
	@Column(name="SALTKEY")
	private String saltkey;
	
	@Column(name="ISTTEMAIL")
	private String isttemail;
	
	public String getEarlylate_comingstatus() {
		return earlylate_comingstatus;
	}

	public void setEarlylate_comingstatus(String earlylate_comingstatus) {
		this.earlylate_comingstatus = earlylate_comingstatus;
	}
	

	public String getOd_applicable() {
		return od_applicable;
	}

	public void setOd_applicable(String od_applicable) {
		this.od_applicable = od_applicable;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Date getEmp_deact_date() {
		return emp_deact_date;
	}

	public void setEmp_deact_date(Date emp_deact_date) {
		this.emp_deact_date = emp_deact_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmp_first_name() {
		return emp_first_name;
	}

	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}

	public String getEmp_last_name() {
		return emp_last_name;
	}

	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
	}

	public byte[] getUpload_photo() {
		return upload_photo;
	}

	public void setUpload_photo(byte[] upload_photo) {
		this.upload_photo = upload_photo;
	}
	
	public String getSaltkey() {
		return saltkey;
	}

	public void setSaltkey(String saltkey) {
		this.saltkey = saltkey;
	}

	@Override
	public String toString() {
		return "Employee_Master [emp_id=" + emp_id + ", emp_code=" + emp_code + ", emp_first_name=" + emp_first_name
				+ ", emp_last_name=" + emp_last_name + ", user_id=" + user_id + ", password=" + password + ", otp="
				+ otp + ", created_by=" + created_by + ", creation_date=" + creation_date + ", last_updated_by="
				+ last_updated_by + ", last_update_date=" + last_update_date + ", is_deleted=" + is_deleted
				+ ", is_activated=" + is_activated + ", profile_id=" + profile_id + ", upload_photo="
				+ Arrays.toString(upload_photo) + ", email=" + email + ", photo_name=" + photo_name + ", getOtp()="
				+ getOtp() + ", getEmail()=" + getEmail() + ", getPhoto_name()=" + getPhoto_name()
				+ ", getProfile_id()=" + getProfile_id() + ", getEmp_id()=" + getEmp_id() + ", getEmp_code()="
				+ getEmp_code() + ", getEmp_first_name()=" + getEmp_first_name() + ", getEmp_last_name()="
				+ getEmp_last_name() + ", getUser_id()=" + getUser_id() + ", getPassword()=" + getPassword()
				+ ", getCreated_by()=" + getCreated_by() + ", getCreation_date()=" + getCreation_date()
				+ ", getLast_updated_by()=" + getLast_updated_by() + ", getLast_update_date()=" + getLast_update_date()
				+ ", getIs_deleted()=" + getIs_deleted() + ", getIs_activated()=" + getIs_activated()
				+ ", getUpload_photo()=" + Arrays.toString(getUpload_photo()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Employee_Master(int emp_id, String emp_code, String emp_first_name, String emp_last_name, int user_id,
			String password, String otp, int created_by, Date creation_date, int last_updated_by, Date last_update_date,
			String is_deleted, String is_activated, int profile_id, byte[] upload_photo, String email,
			String photo_name) {
		super();
		this.emp_id = emp_id;
		this.emp_code = emp_code;
		this.emp_first_name = emp_first_name;
		this.emp_last_name = emp_last_name;
		this.user_id = user_id;
		this.password = password;
		this.otp = otp;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
		this.is_deleted = is_deleted;
		this.is_activated = is_activated;
		this.profile_id = profile_id;
		this.upload_photo = upload_photo;
		this.email = email;
		this.photo_name = photo_name;
	}

	public Employee_Master() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIsttemail() {
		return isttemail;
	}

	public void setIsttemail(String isttemail) {
		this.isttemail = isttemail;
	}
	
	

}
