package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="HOLIDAY_CALENDAR")
public class Holiday_Calendar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "HOLIDAY_CALENDAR_SEQ", allocationSize = 1)
	
	@Column(name = "HC_NO")
	private int hc_no;
	
	@Column(name = "FINANCIAL_YEAR")
	private int financial_year;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "HOLIDAY_DATE" , updatable = false)
	private Date holiday_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "HOLIDAY_DAY")
	private String holiday_day;
	
	@Column(name = "HOLIDAY_OCCASION")
	private String holiday_occasion;
	
	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATED_DATE" , updatable = false)
	private Date created_date= new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "LAST_UPDATED_BY", updatable = false)
	private int last_updated_by;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE" , updatable = false)
	private Date last_updated_date= new java.sql.Date(new java.util.Date().getTime());

	public int getHc_no() {
		return hc_no;
	}

	public void setHc_no(int hc_no) {
		this.hc_no = hc_no;
	}

	public int getFinancial_year() {
		return financial_year;
	}

	public void setFinancial_year(int financial_year) {
		this.financial_year = financial_year;
	}

	public Date getHoliday_date() {
		return holiday_date;
	}

	public void setHoliday_date(Date holiday_date) {
		this.holiday_date = holiday_date;
	}

	public String getHoliday_day() {
		return holiday_day;
	}

	public void setHoliday_day(String holiday_day) {
		this.holiday_day = holiday_day;
	}

	public String getHoliday_occasion() {
		return holiday_occasion;
	}

	public void setHoliday_occasion(String holiday_occasion) {
		this.holiday_occasion = holiday_occasion;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	@Override
	public String toString() {
		return "Holiday_Calendar [hc_no=" + hc_no + ", financial_year=" + financial_year + ", holiday_date="
				+ holiday_date + ", holiday_day=" + holiday_day + ", holiday_occasion=" + holiday_occasion
				+ ", created_by=" + created_by + ", created_date=" + created_date + ", last_updated_by="
				+ last_updated_by + ", last_updated_date=" + last_updated_date + "]";
	}

	public Holiday_Calendar(int hc_no, int financial_year, Date holiday_date, String holiday_day,
			String holiday_occasion, int created_by, Date created_date, int last_updated_by, Date last_updated_date) {
		super();
		this.hc_no = hc_no;
		this.financial_year = financial_year;
		this.holiday_date = holiday_date;
		this.holiday_day = holiday_day;
		this.holiday_occasion = holiday_occasion;
		this.created_by = created_by;
		this.created_date = created_date;
		this.last_updated_by = last_updated_by;
		this.last_updated_date = last_updated_date;
	}

	public Holiday_Calendar() {
		super();
		// TODO Auto-generated constructor stub
	}

	
		
}
