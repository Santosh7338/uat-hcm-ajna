package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "OD_REPORT_LWP")
public class od_report_lwp {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "od_report_lwp_seq")
		@SequenceGenerator(name = "od_report_lwp_seq", sequenceName = "OD_REPORT_LWP_SEQ", allocationSize = 1)
		@Column(name = "SR_NO")
		private int sr_no;

		@Column(name = "LRL_NO")
		private int lrl_no;

		@Column(name = "LR_ID")
		private int lr_id;

		@Column(name = "EMP_ID")
		private int emp_id;
		
		@Column(name = "EMP_CODE")
		private String emp_code;

		@Column(name = "LEAVE_TYPE")
		private int leave_type;

		@Column(name = "START_DATE")
		private Date start_date;

		@Column(name = "END_DATE")
		private Date end_date;

		@Column(name = "LEAVE_COUNT")
		private float leave_count;

		
		@Column(name = "REASON_FOR_LEAVE")
		private String reason_for_leave;

		@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
		@Column(name = "LAST_UPDATE_DATE", updatable = true)
		private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
		
		@Column(name = "DAY_TYPE")
		private String day_type;
		
		@Column(name = "STATUS")
		private String status;
		
		@Transient
		private String empId;
		
		@Transient
		private String firstname;
		
		@Transient
		private String lastname;
		
		@Transient
		private String leavetype;

		public int getSr_no() {
			return sr_no;
		}

		public void setSr_no(int sr_no) {
			this.sr_no = sr_no;
		}

		public int getLrl_no() {
			return lrl_no;
		}

		public void setLrl_no(int lrl_no) {
			this.lrl_no = lrl_no;
		}

		public int getLr_id() {
			return lr_id;
		}

		public void setLr_id(int lr_id) {
			this.lr_id = lr_id;
		}

		public int getEmp_id() {
			return emp_id;
		}

		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}

		public String getEmp_code() {
			return emp_code;
		}

		public void setEmp_code(String emp_code) {
			this.emp_code = emp_code;
		}

		public int getLeave_type() {
			return leave_type;
		}

		public void setLeave_type(int leave_type) {
			this.leave_type = leave_type;
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

		public float getLeave_count() {
			return leave_count;
		}

		public void setLeave_count(float leave_count) {
			this.leave_count = leave_count;
		}

		public String getReason_for_leave() {
			return reason_for_leave;
		}

		public void setReason_for_leave(String reason_for_leave) {
			this.reason_for_leave = reason_for_leave;
		}

		public Date getLast_update_date() {
			return last_update_date;
		}

		public void setLast_update_date(Date last_update_date) {
			this.last_update_date = last_update_date;
		}

		public String getDay_type() {
			return day_type;
		}

		public void setDay_type(String day_type) {
			this.day_type = day_type;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getEmpId() {
			return empId;
		}

		public void setEmpId(String empId) {
			this.empId = empId;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getLeavetype() {
			return leavetype;
		}

		public void setLeavetype(String leavetype) {
			this.leavetype = leavetype;
		}

		@Override
		public String toString() {
			return "od_report_lwp [sr_no=" + sr_no + ", lrl_no=" + lrl_no + ", lr_id=" + lr_id + ", emp_id=" + emp_id
					+ ", emp_code=" + emp_code + ", leave_type=" + leave_type + ", start_date=" + start_date
					+ ", end_date=" + end_date + ", leave_count=" + leave_count + ", reason_for_leave="
					+ reason_for_leave + ", last_update_date=" + last_update_date + ", day_type=" + day_type
					+ ", status=" + status + ", empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname
					+ ", leavetype=" + leavetype + "]";
		}
		

	
}
