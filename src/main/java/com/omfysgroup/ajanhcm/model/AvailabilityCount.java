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
@Table(name = "AVAILABILITY_COUNT")
public class AvailabilityCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "AVAILABILITY_COUNT_SEQ", allocationSize = 1)

	@Column(name = "AT_NO")
	private int atNo;
	
	@Column(name = "EMP_ID")
    private int empId;
	
	@Column(name = "AVL_COUNT")
    private int avlCount;
	
	@Column(name = "UPDATED_DATE")
    private Date updatedDate;
	
	@Column(name = "CREATE_DATE")
    private Date createDate;

	public int getAtNo() {
		return atNo;
	}

	public void setAtNo(int atNo) {
		this.atNo = atNo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getAvlCount() {
		return avlCount;
	}

	public void setAvlCount(int avlCount) {
		this.avlCount = avlCount;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "AvailabilityCount [atNo=" + atNo + ", empId=" + empId + ", avlCount=" + avlCount + ", updatedDate="
				+ updatedDate + ", createDate=" + createDate + "]";
	}
	
	

}
