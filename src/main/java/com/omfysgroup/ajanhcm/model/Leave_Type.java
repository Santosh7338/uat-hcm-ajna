package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_TYPE")
public class Leave_Type {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LEAVE_TYPE_SEQ", allocationSize = 1)

	@Column(name = "L_NO")
	private int l_no;

	@Column(name = "LEAVE_TYPE")
	private String leave_type;

	@Column(name = "DEFAULT_VALUE")
	private float default_value;

	public int getL_no() {
		return l_no;
	}

	public void setL_no(int l_no) {
		this.l_no = l_no;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public float getDefault_value() {
		return default_value;
	}

	public void setDefault_value(float default_value) {
		this.default_value = default_value;
	}
	
	public Leave_Type(int l_no, String leave_type, float default_value) {
		super();
		this.l_no = l_no;
		this.leave_type = leave_type;
		this.default_value = default_value;
	}

	@Override
	public String toString() {
		return "Leave_Type [l_no=" + l_no + ", leave_type=" + leave_type + ", default_value=" + default_value + "]";
	}

	public Leave_Type() {
		super();
		// TODO Auto-generated constructor stub
	}

}
