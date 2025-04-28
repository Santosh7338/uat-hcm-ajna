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
@Table(name = "PROJECT_MAIN_MENU")

public class Project_Main_Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prg_main_menu_seq")
	@SequenceGenerator(name = "prg_main_menu_seq", sequenceName = "PROJECT_MAIN_MENU_SEQ", allocationSize = 1)
	@Column(name="MAIN_MENU_ID")
	private int main_menu_id;
	
	@Column(name="PROFILE_ID")
	private int profile_id;
	
	/*@Column(name="PROJECT_ROLE_ID")
	private int project_role_id;*/
	
	@Column(name="MAIN_MENU_NAME")
	private String main_menu_name;
	
	@Column(name ="MAIN_MENU_CTRLR_NAME")
	private String main_menu_ctrlr_name;
	
	@Column(name ="MAIN_MENU_ACTION_NAME")
	private String main_menu_action_name;
	
	@Column(name ="MAIN_MENU_ICON")
	private String main_menu_icon;
	
	@Column(name ="PM_USER_ROLE")
	private String pm_user_role;
	
	@Column(name ="ROLEISACTIVATED")
	private String roleisactivated;
	
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
	
	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;

	public int getMain_menu_id() {
		return main_menu_id;
	}

	public void setMain_menu_id(int main_menu_id) {
		this.main_menu_id = main_menu_id;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public String getMain_menu_name() {
		return main_menu_name;
	}

	public void setMain_menu_name(String main_menu_name) {
		this.main_menu_name = main_menu_name;
	}

	public String getMain_menu_ctrlr_name() {
		return main_menu_ctrlr_name;
	}

	public void setMain_menu_ctrlr_name(String main_menu_ctrlr_name) {
		this.main_menu_ctrlr_name = main_menu_ctrlr_name;
	}

	public String getMain_menu_action_name() {
		return main_menu_action_name;
	}

	public void setMain_menu_action_name(String main_menu_action_name) {
		this.main_menu_action_name = main_menu_action_name;
	}

	public String getMain_menu_icon() {
		return main_menu_icon;
	}

	public void setMain_menu_icon(String main_menu_icon) {
		this.main_menu_icon = main_menu_icon;
	}

	public String getPm_user_role() {
		return pm_user_role;
	}

	public void setPm_user_role(String pm_user_role) {
		this.pm_user_role = pm_user_role;
	}

	public String getRoleisactivated() {
		return roleisactivated;
	}

	public void setRoleisactivated(String roleisactivated) {
		this.roleisactivated = roleisactivated;
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

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}
}