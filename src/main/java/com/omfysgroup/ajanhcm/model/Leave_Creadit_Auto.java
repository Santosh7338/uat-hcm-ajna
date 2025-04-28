package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LEAVE_CREADIT_AUTO")
public class Leave_Creadit_Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LEAVE_CREADIT_AUTO_SEQ", allocationSize = 1)
	
	@Column(name="SL_NO")
	private int slno;
	
	@Column(name="LEAVE_TYPE")
	private String leavetype;
	
	@Column(name="MIN_PRESENT_DAYS")
	private int minpresentdays;
	
	@Column(name="MAX_PRESENT_DAYS")
	private int maxpresnetdays;
	
	@Column(name="EMPLOYEE_TYPE")
	private String employeetype;
	
	@Column(name="CREADIT_FREQUENCY")
	private String creditfrequency;
	
	@Column(name="LEAVE_CREDITED")
	private float leavecreadited;
	
	public float getLeavecreadited() {
		return leavecreadited;
	}

	public void setLeavecreadited(float leavecreadited) {
		this.leavecreadited = leavecreadited;
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	
	public int getMinpresentdays() {
		return minpresentdays;
	}

	public void setMinpresentdays(int minpresentdays) {
		this.minpresentdays = minpresentdays;
	}

	public int getMaxpresnetdays() {
		return maxpresnetdays;
	}

	public void setMaxpresnetdays(int maxpresnetdays) {
		this.maxpresnetdays = maxpresnetdays;
	}

	public String getEmployeetype() {
		return employeetype;
	}

	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}

	public String getCreditfrequency() {
		return creditfrequency;
	}

	public void setCreditfrequency(String creditfrequency) {
		this.creditfrequency = creditfrequency;
	}

	@Override
	public String toString() {
		return "Credit_Leaves_Auto [slno=" + slno + ", leavetype=" + leavetype + ", leavedaytype=" 
				+ ", minpresentdays=" + minpresentdays + ", maxpresnetdays=" + maxpresnetdays + ", employeetype="
				+ employeetype + ", creditfrequency=" + creditfrequency + "]";
	}

}
