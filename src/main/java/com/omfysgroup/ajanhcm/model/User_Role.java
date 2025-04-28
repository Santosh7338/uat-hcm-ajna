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
@Table(name = "USER_ROLE")
public class User_Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userroleidseq")
	@SequenceGenerator(name = "userroleidseq", sequenceName = "USER_ROLE_SEQ", allocationSize = 1)
	@Column(name = "USERROLEID")
	private int userroleid;
	
	@Column(name = "USERROLE")
	private String userrole;
	
	@Column(name = "ISACTIVATED")
	private String isactivated;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYEE")
	private Employee_Master employee;
	
	@Column(name = "CREATED_BY")
	private Integer created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE")
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY")
	private Integer last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE")
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
	

	public int getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(int userroleid) {
		this.userroleid = userroleid;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public Employee_Master getEmployee() {
		return employee;
	}

	public void setEmployee(Employee_Master employee) {
		this.employee = employee;
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

	public String getIsactivated() {
		return isactivated;
	}

	public void setIsactivated(String isactivated) {
		this.isactivated = isactivated;
	}

	public void setCreated_by(Integer created_by) {
		this.created_by = created_by;
	}

	public void setLast_updated_by(Integer last_updated_by) {
		this.last_updated_by = last_updated_by;
	}
	
	
	
}
