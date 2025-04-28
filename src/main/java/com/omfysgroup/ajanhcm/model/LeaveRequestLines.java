package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;
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
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "LEAVE_REQUEST_LINES")
public class LeaveRequestLines implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LEAVE_REQUEST_LINES_SEQ", allocationSize = 1)

	@Column(name = "LRL_NO")
	private int lrl_no;

	@Column(name = "LR_ID")
	private int lr_id;

	@Column(name = "EMP_ID")
	private int emp_id;

	@Column(name = "MONTH")
	private int month;

	@Column(name = "YEAR")
	private int year;

	@Column(name = "EMP_CODE")
	private String emp_code;

	@Column(name = "LEAVE_TYPE")
	private int leave_type;

	@Column(name = "START_DATE")
	private Date start_date;

	@Column(name = "END_DATE")
	private Date end_date;

	@Column(name = "ADMIN_START_DATE")
	private Date admin_start_date;

	@Column(name = "ADMIN_END_DATE")
	private Date admin_end_date;

	@Column(name = "LEAVE_COUNT")
	private float leave_count;

	@Column(name = "ADMIN_LEAVE_COUNT")
	private float admin_leave_count;

	@ManyToOne
	@JoinColumn(name = "CHARGE_HAND_OVER_TO")
	private Employee_Master charge_hand_over_to;

	@Column(name = "KNOWLEDGE_TRANSFER_SUMMARY")
	private String knowledge_transfer_summary;

	@Column(name = "REASON_FOR_LEAVE")
	private String reason_for_leave;

	@Column(name = "DAY_TYPE")
	private String day_type;

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name ="REASON")
	private String reason;

	@Transient
	private String start_date1;

	@Transient
	private String end_date1;

	@Transient
	private String admin_start_date1;

	@Transient
	private String admin_end_date1;
	
	@Transient
	private String leave_type_str;
	
	
	
	@Transient
	private String newMailSubject;
	
	@Transient
	private String first_name;
	
	@Transient
	private String last_name;
	
	@Transient
	private String email;
	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Employee_Master getCharge_hand_over_to() {
		return charge_hand_over_to;
	}

	public void setCharge_hand_over_to(Employee_Master charge_hand_over_to) {
		this.charge_hand_over_to = charge_hand_over_to;
	}

	public String getKnowledge_transfer_summary() {
		return knowledge_transfer_summary;
	}

	public void setKnowledge_transfer_summary(String knowledge_transfer_summary) {
		this.knowledge_transfer_summary = knowledge_transfer_summary;
	}

	public String getReason_for_leave() {
		return reason_for_leave;
	}

	public void setReason_for_leave(String reason_for_leave) {
		this.reason_for_leave = reason_for_leave;
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

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDay_type() {
		return day_type;
	}

	public void setDay_type(String day_type) {
		this.day_type = day_type;
	}

	public Date getAdmin_start_date() {
		return admin_start_date;
	}

	public void setAdmin_start_date(Date admin_start_date) {
		this.admin_start_date = admin_start_date;
	}

	public Date getAdmin_end_date() {
		return admin_end_date;
	}

	public void setAdmin_end_date(Date admin_end_date) {
		this.admin_end_date = admin_end_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public float getAdmin_leave_count() {
		return admin_leave_count;
	}

	public void setAdmin_leave_count(float admin_leave_count) {
		this.admin_leave_count = admin_leave_count;
	}

	public String getStart_date1() {
		return start_date1;
	}

	public void setStart_date1(String start_date1) {
		this.start_date1 = start_date1;
	}

	public String getEnd_date1() {
		return end_date1;
	}

	public void setEnd_date1(String end_date1) {
		this.end_date1 = end_date1;
	}

	public String getAdmin_start_date1() {
		return admin_start_date1;
	}

	public void setAdmin_start_date1(String admin_start_date1) {
		this.admin_start_date1 = admin_start_date1;
	}

	public String getAdmin_end_date1() {
		return admin_end_date1;
	}

	public void setAdmin_end_date1(String admin_end_date1) {
		this.admin_end_date1 = admin_end_date1;
	}

	public String getLeave_type_str() {
		return leave_type_str;
	}

	public void setLeave_type_str(String leave_type_str) {
		this.leave_type_str = leave_type_str;
	}
	

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	
	
	public LeaveRequestLines(int lrl_no, int lr_id, int emp_id, int month, int year, String emp_code, int leave_type,
			Date start_date, Date end_date, Date admin_start_date, Date admin_end_date, float leave_count,
			float admin_leave_count, Employee_Master charge_hand_over_to, String knowledge_transfer_summary,
			String reason_for_leave, String day_type, int created_by, Date creation_date, int last_updated_by,
			Date last_update_date, String reason, String start_date1, String end_date1, String admin_start_date1,
			String admin_end_date1, String leave_type_str, String newMailSubject, String first_name, String last_name,
			String email) {
		super();
		this.lrl_no = lrl_no;
		this.lr_id = lr_id;
		this.emp_id = emp_id;
		this.month = month;
		this.year = year;
		this.emp_code = emp_code;
		this.leave_type = leave_type;
		this.start_date = start_date;
		this.end_date = end_date;
		this.admin_start_date = admin_start_date;
		this.admin_end_date = admin_end_date;
		this.leave_count = leave_count;
		this.admin_leave_count = admin_leave_count;
		this.charge_hand_over_to = charge_hand_over_to;
		this.knowledge_transfer_summary = knowledge_transfer_summary;
		this.reason_for_leave = reason_for_leave;
		this.day_type = day_type;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
		this.reason = reason;
		this.start_date1 = start_date1;
		this.end_date1 = end_date1;
		this.admin_start_date1 = admin_start_date1;
		this.admin_end_date1 = admin_end_date1;
		this.leave_type_str = leave_type_str;
		this.newMailSubject = newMailSubject;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "LeaveRequestLines [lrl_no=" + lrl_no + ", lr_id=" + lr_id + ", emp_id=" + emp_id + ", month=" + month
				+ ", year=" + year + ", emp_code=" + emp_code + ", leave_type=" + leave_type + ", start_date="
				+ start_date + ", end_date=" + end_date + ", admin_start_date=" + admin_start_date + ", admin_end_date="
				+ admin_end_date + ", leave_count=" + leave_count + ", admin_leave_count=" + admin_leave_count
				+ ", charge_hand_over_to=" + charge_hand_over_to + ", knowledge_transfer_summary="
				+ knowledge_transfer_summary + ", reason_for_leave=" + reason_for_leave + ", day_type=" + day_type
				+ ", created_by=" + created_by + ", creation_date=" + creation_date + ", last_updated_by="
				+ last_updated_by + ", last_update_date=" + last_update_date + ", reason=" + reason + ", start_date1="
				+ start_date1 + ", end_date1=" + end_date1 + ", admin_start_date1=" + admin_start_date1
				+ ", admin_end_date1=" + admin_end_date1 + ", leave_type_str=" + leave_type_str + ", newMailSubject="
				+ newMailSubject + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + "]";
	}

	public LeaveRequestLines() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNewMailSubject() {
		return newMailSubject;
	}

	public void setNewMailSubject(String newMailSubject) {
		this.newMailSubject = newMailSubject;
	}

}
