package com.omfysgroup.ajanhcm.model;

public class Punch_Data {
	
	private String employee_code;
	private String employee_name;
	private String intime;
	private String outtime;
	private String leavestatus;
	private String devitiontime;
	private String regulirazation;
	private String intimewithminutes;
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getLeavestatus() {
		return leavestatus;
	}
	public void setLeavestatus(String leavestatus) {
		this.leavestatus = leavestatus;
	}
	public String getDevitiontime() {
		return devitiontime;
	}
	public void setDevitiontime(String devitiontime) {
		this.devitiontime = devitiontime;
	}
	public String getRegulirazation() {
		return regulirazation;
	}
	public void setRegulirazation(String regulirazation) {
		this.regulirazation = regulirazation;
	}
	public String getIntimewithminutes() {
		return intimewithminutes;
	}
	public void setIntimewithminutes(String intimewithminutes) {
		this.intimewithminutes = intimewithminutes;
	}
	@Override
	public String toString() {
		return "Punch_Data [employee_code=" + employee_code + ", employee_name=" + employee_name + ", intime=" + intime
				+ ", outtime=" + outtime + ", leavestatus=" + leavestatus + ", devitiontime=" + devitiontime
				+ ", regulirazation=" + regulirazation + ", intimewithminutes=" + intimewithminutes + "]";
	}
	
	
	

}
