package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "EDUCATION_DETAILS")
public class Education_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "EDUCATION_DETAILS_SEQ", allocationSize = 1)

	@Column(name = "EDU_ID")
	private int edu_id;

	@Column(name = "HIGHEST_EDUCATION")
	private String highest_education;
	
	@Column(name = "PROGRAM_NAME")
	private String program_name;

	@Column(name = "STREAM")
	private String stream;
	
	@Column(name = "COLLEGE_NAME")
	private String college_name;

	@Column(name = "PERCENTAGE")
	private String percentage;

	@Column(name = "CGPA")
	private int cgpa;

	@Column(name = "PASS_OUT_YEAR")
	private String pass_out_year;

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date ;

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date;

	@Column(name = "IS_DELETED")
	private String is_deleted;
	
	@Column(name = "PROGRAM_LEVEL")
	private String education_level;
	
	@Column(name = "UNIVERSITY_BOARD")
	private String university_board;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;
	
	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public int getEdu_id() {
		return edu_id;
	}

	public void setEdu_id(int edu_id) {
		this.edu_id = edu_id;
	}

	public String getHighest_education() {
		return highest_education;
	}

	public void setHighest_education(String highest_education) {
		this.highest_education = highest_education;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public int getCgpa() {
		return cgpa;
	}

	public void setCgpa(int cgpa) {
		this.cgpa = cgpa;
	}

	
	public String getPass_out_year() {
		return pass_out_year;
	}

	public void setPass_out_year(String pass_out_year) {
		this.pass_out_year = pass_out_year;
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

	public String getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public String getEducation_level() {
		return education_level;
	}

	public void setEducation_level(String education_level) {
		this.education_level = education_level;
	}

	public String getUniversity_board() {
		return university_board;
	}

	public void setUniversity_board(String university_board) {
		this.university_board = university_board;
	}

	
	
}
