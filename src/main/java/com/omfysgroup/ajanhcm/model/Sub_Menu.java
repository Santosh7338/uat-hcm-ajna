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
@Table(name="SUB_MENU")
public class Sub_Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "SUB_MENU_SEQ", allocationSize = 1)
	
	
	@Column(name = "SUB_MENU_ID")
	private int sub_menu_id;
	
	@Column(name = "SUB_MENU_NAME")
	private String SUB_MENU_NAME;
	
	@Column(name = "SUB_MENU_CTRLR_NAME")
	private String sub_menu_ctrlr_name;
	
	@Column(name = "SUB_MENU_ACTION_NAME")
	private String sub_menu_action_name;
	
	@Column(name = "SUB_MENU_ICON")
	private String sub_menu_icon;
	
	@Column(name = "ATTRIBUTE1")
	private String attribute1;
	
	@Column(name = "ATTRIBUTE2")
	private String attribute2;
	
	@Column(name = "ATTRIBUTE3")
	private String attribute3;
	
	@Column(name = "ATTRIBUTE4")
	private String attribute4;
	
	@Column(name = "ATTRIBUTE5")
	private String attribute5;
	
	@ManyToOne
	@JoinColumn(name = "MAIN_MENU_ID")
	private Main_Menu main_menu_id;
	
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

	public int getSub_menu_id() {
		return sub_menu_id;
	}

	public void setSub_menu_id(int sub_menu_id) {
		this.sub_menu_id = sub_menu_id;
	}

	public String getSUB_MENU_NAME() {
		return SUB_MENU_NAME;
	}

	public void setSUB_MENU_NAME(String sUB_MENU_NAME) {
		SUB_MENU_NAME = sUB_MENU_NAME;
	}

	public String getSub_menu_ctrlr_name() {
		return sub_menu_ctrlr_name;
	}

	public void setSub_menu_ctrlr_name(String sub_menu_ctrlr_name) {
		this.sub_menu_ctrlr_name = sub_menu_ctrlr_name;
	}

	public String getSub_menu_action_name() {
		return sub_menu_action_name;
	}

	public void setSub_menu_action_name(String sub_menu_action_name) {
		this.sub_menu_action_name = sub_menu_action_name;
	}

	public String getSub_menu_icon() {
		return sub_menu_icon;
	}

	public void setSub_menu_icon(String sub_menu_icon) {
		this.sub_menu_icon = sub_menu_icon;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public Main_Menu getMain_menu_id() {
		return main_menu_id;
	}

	public void setMain_menu_id(Main_Menu main_menu_id) {
		this.main_menu_id = main_menu_id;
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
	
	
}
