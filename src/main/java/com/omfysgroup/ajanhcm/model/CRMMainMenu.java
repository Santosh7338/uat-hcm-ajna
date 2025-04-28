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
@Table(name = "CRM_MAIN_MENU")
public class CRMMainMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "crmmainmenuseq")
	@SequenceGenerator(name = "crmmainmenuseq", sequenceName = "CRM_MAIN_MENU_SEQ", allocationSize = 1)

	@Column(name = "MAIN_MENU_ID")
	private int mainmenuid;

	@Column(name = "PROFILE_ID")
	private int profileid;

	@Column(name = "MAIN_MENU_NAME")
	private String mainmenuname;

	@Column(name = "MAIN_MENU_CTRLR_NAME")
	private String mainmenuctrlrname;

	@Column(name = "MAIN_MENU_ACTION_NAME")
	private String mainmenuactionname;

	@Column(name = "MAIN_MENU_ICON")
	private String mainmenuicon;

	@Column(name = "ENABLE_FLAG")
	private String enableflag;

	@Column(name = "CREATED_BY", updatable = false)
	private int createdby;
	
	@Column(name = "CRM_USER_TYPE")
	private String crm_user_type;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creationdate = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int lastupdatedby;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date lastupdatedate = new java.sql.Date(new java.util.Date().getTime());
	
	@ManyToOne
	@JoinColumn(name = "EMPID")
	private Employee_Master empid;
	
	@Column(name = "ROLEISACTIVATED")
	private String roleisactivated;

	public int getMainmenuid() {
		return mainmenuid;
	}

	public void setMainmenuid(int mainmenuid) {
		this.mainmenuid = mainmenuid;
	}

	public int getProfileid() {
		return profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public String getMainmenuname() {
		return mainmenuname;
	}

	public void setMainmenuname(String mainmenuname) {
		this.mainmenuname = mainmenuname;
	}

	public String getMainmenuctrlrname() {
		return mainmenuctrlrname;
	}

	public void setMainmenuctrlrname(String mainmenuctrlrname) {
		this.mainmenuctrlrname = mainmenuctrlrname;
	}

	public String getMainmenuactionname() {
		return mainmenuactionname;
	}

	public void setMainmenuactionname(String mainmenuactionname) {
		this.mainmenuactionname = mainmenuactionname;
	}

	public String getMainmenuicon() {
		return mainmenuicon;
	}

	public void setMainmenuicon(String mainmenuicon) {
		this.mainmenuicon = mainmenuicon;
	}

	public String getEnableflag() {
		return enableflag;
	}

	public void setEnableflag(String enableflag) {
		this.enableflag = enableflag;
	}

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public String getCrm_user_type() {
		return crm_user_type;
	}

	public void setCrm_user_type(String crm_user_type) {
		this.crm_user_type = crm_user_type;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public int getLastupdatedby() {
		return lastupdatedby;
	}

	public void setLastupdatedby(int lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	public Date getLastupdatedate() {
		return lastupdatedate;
	}

	public void setLastupdatedate(Date lastupdatedate) {
		this.lastupdatedate = lastupdatedate;
	}

	

	

	public String getRoleisactivated() {
		return roleisactivated;
	}

	public Employee_Master getEmpid() {
		return empid;
	}

	public void setEmpid(Employee_Master empid) {
		this.empid = empid;
	}

	public void setRoleisactivated(String roleisactivated) {
		this.roleisactivated = roleisactivated;
	}
}
