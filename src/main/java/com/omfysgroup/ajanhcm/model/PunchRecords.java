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
@Table(name = "PUNCH_RECORDS")
public class PunchRecords implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "PUNCH_RECORDS_SEQ", allocationSize = 1)

	@Column(name = "PUNCH_RECORDS_ID")
	private int punch_records_id;

	@Column(name = "EMP_CODE")
	private String emp_code;

	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;

	@Column(name = "EMP_NAME")
	private String emp_name;

	@Column(name = "SHIFT")
	private String shift;

	@Column(name = "IN_TIME")
	private String in_time;

	@Column(name = "OUT_TIME")
	private String out_time;

	@Column(name = "WORK_DURATION")
	private String work_duration;

	@Column(name = "OT")
	private String ot;

	@Column(name = "TOTAL_DURATION")
	private String total_duration;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "CREATED_BY")
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;

	@Column(name = "LAST_UPDATED_BY")
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date;

	@Column(name = "FILE_UPLOAD_DATE")
	private Date file_upload_date;

	@Transient
	private String file_upload_date1;

	public String getFile_upload_date1() {
		return file_upload_date1;
	}

	public void setFile_upload_date1(String file_upload_date1) {
		this.file_upload_date1 = file_upload_date1;
	}

	public int getPunch_records_id() {
		return punch_records_id;
	}

	public void setPunch_records_id(int punch_records_id) {
		this.punch_records_id = punch_records_id;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getIn_time() {
		return in_time;
	}

	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getWork_duration() {
		return work_duration;
	}

	public void setWork_duration(String work_duration) {
		this.work_duration = work_duration;
	}

	public String getOt() {
		return ot;
	}

	public void setOt(String ot) {
		this.ot = ot;
	}

	public String getTotal_duration() {
		return total_duration;
	}

	public void setTotal_duration(String total_duration) {
		this.total_duration = total_duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Date getFile_upload_date() {
		return file_upload_date;
	}

	public void setFile_upload_date(Date file_upload_date) {
		this.file_upload_date = file_upload_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PunchRecords [punch_records_id=" + punch_records_id + ", emp_code=" + emp_code + ", emp_id=" + emp_id
				+ ", emp_name=" + emp_name + ", shift=" + shift + ", in_time=" + in_time + ", out_time=" + out_time
				+ ", work_duration=" + work_duration + ", ot=" + ot + ", total_duration=" + total_duration + ", status="
				+ status + ", remarks=" + remarks + ", created_by=" + created_by + ", creation_date=" + creation_date
				+ ", last_updated_by=" + last_updated_by + ", last_update_date=" + last_update_date
				+ ", file_upload_date=" + file_upload_date + "]";
	}

	public PunchRecords(int punch_records_id, String emp_code, Employee_Master emp_id, String emp_name, String shift,
			String in_time, String out_time, String work_duration, String ot, String total_duration, String status,
			String remarks, int created_by, Date creation_date, int last_updated_by, Date last_update_date,
			Date file_upload_date) {
		super();
		this.punch_records_id = punch_records_id;
		this.emp_code = emp_code;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.shift = shift;
		this.in_time = in_time;
		this.out_time = out_time;
		this.work_duration = work_duration;
		this.ot = ot;
		this.total_duration = total_duration;
		this.status = status;
		this.remarks = remarks;
		this.created_by = created_by;
		this.creation_date = creation_date;
		this.last_updated_by = last_updated_by;
		this.last_update_date = last_update_date;
		this.file_upload_date = file_upload_date;
	}

	public PunchRecords() {
		super();
		// TODO Auto-generated constructor stub
	}

}
