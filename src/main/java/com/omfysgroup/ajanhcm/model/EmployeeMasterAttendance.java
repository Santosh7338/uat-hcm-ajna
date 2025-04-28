package com.omfysgroup.ajanhcm.model;

public class EmployeeMasterAttendance {
	
	private String emp_id;
	private String created_by;
	private String creation_date;
	private String email;
	private String emp_code;
	private String emp_deact_date;
	private String emp_first_name;
	private String emp_last_name;
	private String is_deleted;
	private String is_activated;
	private String last_update_date;
	private String last_update_by;
	private String otp;
	private String password;
	private String photo_name;
	private String profile_id;
	private String project_role_id;
	private String user_id;
	private String saltkey;
	private String upload_photo;
	private String mytestcloumn;
	private String status;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getEmp_deact_date() {
		return emp_deact_date;
	}

	public void setEmp_deact_date(String emp_deact_date) {
		this.emp_deact_date = emp_deact_date;
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

	public String getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(String last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getLast_update_by() {
		return last_update_by;
	}

	public void setLast_update_by(String last_update_by) {
		this.last_update_by = last_update_by;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getProject_role_id() {
		return project_role_id;
	}

	public void setProject_role_id(String project_role_id) {
		this.project_role_id = project_role_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSaltkey() {
		return saltkey;
	}

	public void setSaltkey(String saltkey) {
		this.saltkey = saltkey;
	}

	public String getUpload_photo() {
		return upload_photo;
	}

	public void setUpload_photo(String upload_photo) {
		this.upload_photo = upload_photo;
	}

	public String getMytestcloumn() {
		return mytestcloumn;
	}

	public void setMytestcloumn(String mytestcloumn) {
		this.mytestcloumn = mytestcloumn;
	}
	
	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "EmployeeMasterAttendance [emp_id=" + emp_id + ", created_by=" + created_by + ", creation_date="
				+ creation_date + ", email=" + email + ", emp_code=" + emp_code + ", emp_deact_date=" + emp_deact_date
				+ ", emp_first_name=" + emp_first_name + ", emp_last_name=" + emp_last_name + ", is_deleted="
				+ is_deleted + ", is_activated=" + is_activated + ", last_update_date=" + last_update_date
				+ ", last_update_by=" + last_update_by + ", otp=" + otp + ", password=" + password + ", photo_name="
				+ photo_name + ", profile_id=" + profile_id + ", project_role_id=" + project_role_id + ", user_id="
				+ user_id + ", saltkey=" + saltkey + ", upload_photo=" + upload_photo + ", mytestcloumn=" + mytestcloumn
				+ ", status=" + status + "]";
	}

	


}
