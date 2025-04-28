package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TRAINING_COUNT")
public class TrainingCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "TRAINING_COUNT_SEQ", allocationSize = 1)

	@Column(name = "TR_NO")
	private int trNo;
	
	@Column(name = "EMP_ID")
    private int empId;
	
	@Column(name = "TR_ESC_COUNT")
    private int trEscCount;
	
	@Column(name = "UPDATED_DATE")
    private Date updatedDate;
	
	@Column(name = "CREATION_DATE")
    private Date creationDate;

	public int getTrNo() {
		return trNo;
	}

	public void setTrNo(int trNo) {
		this.trNo = trNo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getTrEscCount() {
		return trEscCount;
	}

	public void setTrEscCount(int trEscCount) {
		this.trEscCount = trEscCount;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "TrainingCount [trNo=" + trNo + ", empId=" + empId + ", trEscCount=" + trEscCount + ", updatedDate="
				+ updatedDate + ", creationDate=" + creationDate + "]";
	}
	

}
