package com.omfysgroup.ajanhcm.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ATTENDANCE_MODULE")
public class Attendance_Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "ATTENDANCE_MODULE_SEQ", allocationSize = 1)
	
	@Column(name="SLNO")
	private int slno;
	
	@Column(name="START_DATE")
	private Date start_date;
	
	@Column(name="END_DATE")
	private Date end_date;
	
	@Column(name="START_TIME")
	private String start_time;
	
	@Column(name="END_TIME")
	private String end_time;
	
	@Column(name="MIN_CON_PRESENT")
	private int min_con_present;
	
	@Column(name="MIN_CON_HALF_DAY")
	private int min_con_half_day;
	
	@Column(name="GRACE_PERIOD")
	private int grace_period;
	
	@Column(name="NO_OF_EVENTS")
	private int no_of_events;
	
	@Column(name="PL")
	private String pl;
	
	@Column(name="CL")
	private String cl;
	
	@Column(name="MINUTES")
	private int minutes;
	

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public int getMin_con_present() {
		return min_con_present;
	}

	public void setMin_con_present(int min_con_present) {
		this.min_con_present = min_con_present;
	}

	public int getMin_con_half_day() {
		return min_con_half_day;
	}

	public void setMin_con_half_day(int min_con_half_day) {
		this.min_con_half_day = min_con_half_day;
	}

	public int getGrace_period() {
		return grace_period;
	}

	public void setGrace_period(int grace_period) {
		this.grace_period = grace_period;
	}

	public int getNo_of_events() {
		return no_of_events;
	}

	public void setNo_of_events(int no_of_events) {
		this.no_of_events = no_of_events;
	}

	public String getPl() {
		return pl;
	}

	public void setPl(String pl) {
		this.pl = pl;
	}

	public String getCl() {
		return cl;
	}

	public void setCl(String cl) {
		this.cl = cl;
	}

	public int getSlno() {
		return slno;
	}

	public void setSlno(int sl_no) {
		this.slno = sl_no;
	}

	@Override
	public String toString() {
		return "Attendance_Module [slno=" + slno + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", min_con_present=" + min_con_present
				+ ", min_con_half_day=" + min_con_half_day + ", grace_period=" + grace_period + ", no_of_events="
				+ no_of_events + ", pl=" + pl + ", cl=" + cl + "]";
	}
}

