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
@Table(name="CURRENT_COMPENSATION_DETAILS")
public class Current_CompensationDetails {

	
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curr_comp")
		@SequenceGenerator(name = "curr_comp", sequenceName = "CURRENT_COMPENSATION_DETAILS_", allocationSize = 1)
		
		@Column(name = "CURR_COMP_ID")
	    private int curr_com_id;
		
		@Column(name = "CURRENT_ORGANISATION")
	    private String curr_organisation;
		
		@Column(name = "COMPEN_HEAD")
		private String compensation_Head;
		
		@Column(name = "PERIOD")
		private String periods;
		
		@Column(name = "MONTHLY")
		private int monthly;
		
		@Column(name = "ANNUALLY")
		private int anually;
		
		@Column(name = "MONTHLY_TOTAL")
		private int total_monthly;
		
		@Column(name = "ANNUAL_TOTAL")
		private int total_annually;
		
		@Column(name="EMP_ID")
		private int emp_id;
		
		
		@Column(name = "PRE_ID")
		private int persnl_id;
		
		@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
		@Column(name = "LAST_UPDATED_DATE", updatable = false)
		private Date last_updated_date;

		public int getCurr_com_id() {
			return curr_com_id;
		}

		public void setCurr_com_id(int curr_com_id) {
			this.curr_com_id = curr_com_id;
		}

		public String getCurr_organisation() {
			return curr_organisation;
		}

		public void setCurr_organisation(String curr_organisation) {
			this.curr_organisation = curr_organisation;
		}

		public String getCompensation_Head() {
			return compensation_Head;
		}

		public void setCompensation_Head(String compensation_Head) {
			this.compensation_Head = compensation_Head;
		}

		public String getPeriods() {
			return periods;
		}

		public void setPeriods(String periods) {
			this.periods = periods;
		}


		public int getMonthly() {
			return monthly;
		}

		public void setMonthly(int monthly) {
			this.monthly = monthly;
		}

		public int getAnually() {
			return anually;
		}

		public void setAnually(int anually) {
			this.anually = anually;
		}

		public int getTotal_monthly() {
			return total_monthly;
		}

		public void setTotal_monthly(int total_monthly) {
			this.total_monthly = total_monthly;
		}

		public int getTotal_annually() {
			return total_annually;
		}

		public void setTotal_annually(int total_annually) {
			this.total_annually = total_annually;
		}

		public int getEmp_id() {
			return emp_id;
		}

		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}

		public int getPersnl_id() {
			return persnl_id;
		}

		public void setPersnl_id(int persnl_id) {
			this.persnl_id = persnl_id;
		}

		public Date getLast_updated_date() {
			return last_updated_date;
		}

		public void setLast_updated_date(Date last_updated_date) {
			this.last_updated_date = last_updated_date;
		}

		

}
