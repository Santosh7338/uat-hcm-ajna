package com.omfysgroup.ajanhcm.model;


public class Od_mail {

	private int emp_id;
	private String emp_code;
	private String emp_first_name;
	private String emp_last_name;
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Od_mail [emp_id=" + emp_id + ", emp_code=" + emp_code + ", emp_first_name=" + emp_first_name
				+ ", emp_last_name=" + emp_last_name + ", email=" + email + "]";
	}

	public Od_mail() {
		super();
		
	}

}
