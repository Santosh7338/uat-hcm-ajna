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
@Table(name="PROGRAM_LEVEL")
public class Program_Level {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "program_seq")
	@SequenceGenerator(name = "program_seq", sequenceName = "PROGRAM_LEVEL_SEQ", allocationSize = 1)
	
	@Column(name ="P_LEVEL_ID")
	private int prog_level_id;
	
	@Column(name = "PROGRAM_LEVEL_NAME")
	private String program_level_name;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = false)
	private Date last_update_date;
	
	

	public int getProg_level_id() {
		return prog_level_id;
	}

	public void setProg_level_id(int prog_level_id) {
		this.prog_level_id = prog_level_id;
	}

	public String getProgram_level_name() {
		return program_level_name;
	}

	public void setProgram_level_name(String program_level_name) {
		this.program_level_name = program_level_name;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}


	
	
}
