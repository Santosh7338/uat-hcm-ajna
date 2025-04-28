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
@Table(name="PRE_EDUCATION_DETAILS")
public class Pre_Educational_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_educational_details_seq")
	@SequenceGenerator(name = "pre_educational_details_seq", sequenceName = "PRE_EDUCATION_DETAILS_SEQ", allocationSize = 1)
	
	@Column(name = "EDUCATION_ID")
    private int preEdu_id;
	
	
	@ManyToOne
	@JoinColumn(name = "PROGRAM_LEVEL")
	private Program_Level program_level;
	
	@ManyToOne
	@JoinColumn(name = "PROGRAM_NAME")
	private Program_Name program_name;
	
	@Column(name = "SPECIALIZATION")
	private String specialization;
	
	@ManyToOne
	@JoinColumn(name = "BOARDS_UNIVERSITY")
	private Education_Board board;
	
	@Column(name = "COLLEGE_NAME")
	private String college_name;
	
	@Column(name = "PASSING_YEAR")
	private String passing_year;
	
	@Column(name = "PERCENTAGES")
	private String percentage;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE", updatable = false)
	private Date last_update_date;
	
	@Column(name = "PERSONAL_EMP_ID")
	private int personal_id;

	public int getPreEdu_id() {
		return preEdu_id;
	}

	public void setPreEdu_id(int preEdu_id) {
		this.preEdu_id = preEdu_id;
	}

	public Program_Level getProgram_level() {
		return program_level;
	}

	public void setProgram_level(Program_Level program_level) {
		this.program_level = program_level;
	}

	public Program_Name getProgram_name() {
		return program_name;
	}

	public void setProgram_name(Program_Name program_name) {
		this.program_name = program_name;
	}

	public Education_Board getBoard() {
		return board;
	}

	public void setBoard(Education_Board board) {
		this.board = board;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getPassing_year() {
		return passing_year;
	}

	public void setPassing_year(String passing_year) {
		this.passing_year = passing_year;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}
	
	
}
