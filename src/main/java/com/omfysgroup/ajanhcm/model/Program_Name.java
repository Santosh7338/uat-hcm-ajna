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
@Table(name="PROGRAM_NAME")
public class Program_Name {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_name_seq")
	@SequenceGenerator(name = "program_name_seq", sequenceName = "PROGRAM_NAME_SEQ", allocationSize = 1)
	
	@Column(name ="PROG_NAME_ID")
	private int prog_name_id;
	
	@Column(name = "PROGRAM_NAME")
	private String program_name;
	
	@Column(name = "PROGRAM_LEVEL_ID")
	private int prog_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = false)
	private Date last_update_date;

	
	
	public int getProg_name_id() {
		return prog_name_id;
	}

	public void setProg_name_id(int prog_name_id) {
		this.prog_name_id = prog_name_id;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	

	public int getProg_id() {
		return prog_id;
	}

	public void setProg_id(int prog_id) {
		this.prog_id = prog_id;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}


}
