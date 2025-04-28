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
@Table(name="COMPETENCY_GROUP_APR")
public class Comp_Group_Apr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Comp_Group_Apr_seq")
	@SequenceGenerator(name = "Comp_Group_Apr_seq", sequenceName = "COMPETENCY_GROUP_APR_SEQ", allocationSize = 1)
	
	@Column(name = "CGA_NO")
	private int cga_no;
	
	@Column(name = "COMPETENCY_GROUP_NAME")
	private String competency_group_name;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE" , updatable = false)
	private Date creation_date;
	
	@Column(name="CREATED_BY")
	private int created_by;

	public int getCga_no() {
		return cga_no;
	}

	public void setCga_no(int cga_no) {
		this.cga_no = cga_no;
	}

	public String getCompetency_group_name() {
		return competency_group_name;
	}

	public void setCompetency_group_name(String competency_group_name) {
		this.competency_group_name = competency_group_name;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	@Override
	public String toString() {
		return "Comp_Group_Apr [cga_no=" + cga_no + ", competency_group_name=" + competency_group_name
				+ ", creation_date=" + creation_date + ", created_by=" + created_by + "]";
	}
	
	

}
