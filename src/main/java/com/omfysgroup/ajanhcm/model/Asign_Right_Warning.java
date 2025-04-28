package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ASIGN_RIGHTS_WARNING_MGMT")
public class Asign_Right_Warning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asign_right_seq")
	@SequenceGenerator(name = "asign_right_seq", sequenceName = "ASIGN_RIGHTS_WARNING_MGMT_SEQ", allocationSize = 1)
	
@Column(name = "ASIGN_RIGHTS_ID")	
public int asign_Right_Id;

@Column(name = "MENU")		
public String menu;

@Column(name = "SUB_MENU")	
public String sub_Menu;

@Column(name = "EMPLOYEE_NAME")	
public String employee_Name;

@Column(name = "EMPLOYEE_ID")	
public int employee_Id;

public int getAsign_Right_Id() {
	return asign_Right_Id;
}

public void setAsign_Right_Id(int asign_Right_Id) {
	this.asign_Right_Id = asign_Right_Id;
}

public String getMenu() {
	return menu;
}

public void setMenu(String menu) {
	this.menu = menu;
}

public String getSub_Menu() {
	return sub_Menu;
}

public void setSub_Menu(String sub_Menu) {
	this.sub_Menu = sub_Menu;
}

public String getEmployee_Name() {
	return employee_Name;
}

public void setEmployee_Name(String employee_Name) {
	this.employee_Name = employee_Name;
}

public int getEmployee_Id() {
	return employee_Id;
}

public void setEmployee_Id(int employee_Id) {
	this.employee_Id = employee_Id;
}

@Override
public String toString() {
	return "Asign_Right_Warning [asign_Right_Id=" + asign_Right_Id + ", menu=" + menu + ", sub_Menu=" + sub_Menu
			+ ", employee_Name=" + employee_Name + ", employee_Id=" + employee_Id + "]";
}







}
