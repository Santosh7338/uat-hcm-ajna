package com.omfysgroup.ajanhcm.model;

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
@Table(name = "LEAVE_CREDIT_SETTING")
public class Leave_Credit_Setting {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LEAVE_CREDIT_SETTING_SEQ", allocationSize = 1)

	@Column(name = "LC_NO")
	private int lc_no;

	@Column(name = "GRADE_ID")
	private int grade_id;

	@Column(name = "DESIGNATION_ID")
	private int designation_id;

	@Column(name = "LEAVE_TYPE_ID")
	private int leave_type_id;

	@Column(name = "CREDIT_FREQUENCY")
	private String credit_frequency;

	@Column(name = "NO_OF_LEAVES")
	private float no_of_leaves;

	@Column(name = "START_DATE")
	private Date start_date;

	@Column(name = "END_DATE")
	private Date end_date;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATED_DATE", updatable = false)
	private Date created_date = new java.sql.Date(new java.util.Date().getTime());

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@Column(name = "LAST_UPDATED_BY", updatable = false)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE", updatable = false)
	private Date last_updated_date = new java.sql.Date(new java.util.Date().getTime());

	@Transient
	private String approval_from_str;
	@Transient
	private String approval_upto_str;
	@Transient
	private String designation_str;
	@Transient
	private String leavetype_str;

	public String getDesignation_str() {
		return designation_str;
	}

	public void setDesignation_str(String designation_str) {
		this.designation_str = designation_str;
	}

	public String getLeavetype_str() {
		return leavetype_str;
	}

	public void setLeavetype_str(String leavetype_str) {
		this.leavetype_str = leavetype_str;
	}

	public String getApproval_from_str() {
		return approval_from_str;
	}

	public void setApproval_from_str(String approval_from_str) {
		this.approval_from_str = approval_from_str;
	}

	public String getApproval_upto_str() {
		return approval_upto_str;
	}

	public void setApproval_upto_str(String approval_upto_str) {
		this.approval_upto_str = approval_upto_str;
	}

	public int getLc_no() {
		return lc_no;
	}

	public void setLc_no(int lc_no) {
		this.lc_no = lc_no;
	}

	public int getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(int grade_id) {
		this.grade_id = grade_id;
	}

	public int getDesignation_id() {
		return designation_id;
	}

	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}

	public int getLeave_type_id() {
		return leave_type_id;
	}

	public void setLeave_type_id(int leave_type_id) {
		this.leave_type_id = leave_type_id;
	}

	public String getCredit_frequency() {
		return credit_frequency;
	}

	public void setCredit_frequency(String credit_frequency) {
		this.credit_frequency = credit_frequency;
	}

	public float getNo_of_leaves() {
		return no_of_leaves;
	}

	public void setNo_of_leaves(float no_of_leaves) {
		this.no_of_leaves = no_of_leaves;
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

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
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
		return "Leave_Credit_Setting [lc_no=" + lc_no + ", grade_id=" + grade_id + ", designation_id=" + designation_id
				+ ", leave_tyhp_id=" + leave_type_id + ", credit_frequency=" + credit_frequency + ", no_of_leaves="
				+ no_of_leaves + ", start_date=" + start_date + ", end_date=" + end_date + ", created_date="
				+ created_date + ", created_by=" + created_by + ", last_updated_by=" + last_updated_by
				+ ", last_updated_date=" + last_updated_date + "]";
	}

	public Leave_Credit_Setting(int lc_no, int grade_id, int designation_id, int leave_hp_id, String credit_frequency,
			int no_of_leaves, Date start_date, Date end_date, Date created_date, int created_by, int last_updated_by,
			Date last_updated_date) {
		super();
		this.lc_no = lc_no;
		this.grade_id = grade_id;
		this.designation_id = designation_id;
		this.leave_type_id = leave_type_id;
		this.credit_frequency = credit_frequency;
		this.no_of_leaves = no_of_leaves;
		this.start_date = start_date;
		this.end_date = end_date;
		this.created_date = created_date;
		this.created_by = created_by;
		this.last_updated_by = last_updated_by;
		this.last_updated_date = last_updated_date;
	}

	public Leave_Credit_Setting() {
		super();
		// TODO Auto-generated constructor stub
	}

}
