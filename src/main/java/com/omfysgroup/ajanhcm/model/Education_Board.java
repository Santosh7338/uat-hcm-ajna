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
@Table(name="EDUCATIONAL_BOARDS")
public class Education_Board {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "educational_seq")
	@SequenceGenerator(name = "educational_seq", sequenceName = "EDUCATIONAL_BOARDS_SEQ", allocationSize = 1)
	
	@Column(name ="BOARD_ID")
	private int edu_id;
	
	@Column(name = "BOARD_NAME")
	private String board_name;
	
	@Column(name = "PROGRAM_ID")
	private int progl_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = false)
	private Date last_update_date;

	public int getEdu_id() {
		return edu_id;
	}

	public void setEdu_id(int edu_id) {
		this.edu_id = edu_id;
	}

	

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	public int getProgl_id() {
		return progl_id;
	}

	public void setProgl_id(int progl_id) {
		this.progl_id = progl_id;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	
}
