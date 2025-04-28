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
@Table(name="EARLY_LATE_NOTIFICATIONS")
public class Early_Late_Notifications 
{
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ear_notif_seq")
@SequenceGenerator(name = "ear_notif_seq", sequenceName = "EARLY_LATE_NOTIFICATIONS_SEQ", allocationSize = 1)

@Column(name = "NOTIFICATION_ID")
private int notification_id;


@ManyToOne
@JoinColumn(name = "EMPLOYEE_ID")
private Employee_Master emp_id;
	



@Column(name = "ATTENDANCE_REG_ID")
private int attendance_reg_id;	
	


@Column(name = "APPROVER_ID")
private int approver_id;

@Column(name = "APPROVER_TYPE")
private String approver_type;

@Column(name = "STATUS")
private String STATUS;

@Column(name = "CREATED_BY", updatable = false)
private int created_by;

@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
@Column(name = "CREATED_DATE", updatable = false)
private Date creation_date ;

@Column(name = "LAST_UPDATED_BY", updatable = true)
private int last_updated_by;

@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
@Column(name = "LAST_UPDATE_DATE", updatable = true)
private Date last_update_date ;

public int getNotification_id() {
	return notification_id;
}

public void setNotification_id(int notification_id) {
	this.notification_id = notification_id;
}

public Employee_Master getEmp_id() {
	return emp_id;
}

public void setEmp_id(Employee_Master emp_id) {
	this.emp_id = emp_id;
}

public int getAttendance_reg_id() {
	return attendance_reg_id;
}

public void setAttendance_reg_id(int attendance_reg_id) {
	this.attendance_reg_id = attendance_reg_id;
}

public int getApprover_id() {
	return approver_id;
}

public void setApprover_id(int approver_id) {
	this.approver_id = approver_id;
}

public String getApprover_type() {
	return approver_type;
}

public void setApprover_type(String approver_type) {
	this.approver_type = approver_type;
}

public String getSTATUS() {
	return STATUS;
}

public void setSTATUS(String sTATUS) {
	STATUS = sTATUS;
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
