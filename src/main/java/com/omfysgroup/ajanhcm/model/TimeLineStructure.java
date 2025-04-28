package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TIMELINE_STRUCTURE")
public class TimeLineStructure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "TIMELINE_STRUCTURE_SEQ", allocationSize = 1)

	@Column(name = "ID")
	private int id;

	@Column(name = "FUNCTIONAL")
	private int functional;

	@Column(name = "ADMINISTRATIVE")
	private int administrative;

	@Column(name = "MANAGEMENT")
	private int management;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFunctional() {
		return functional;
	}

	public void setFunctional(int functional) {
		this.functional = functional;
	}

	public int getAdministrative() {
		return administrative;
	}

	public void setAdministrative(int administrative) {
		this.administrative = administrative;
	}

	public int getManagement() {
		return management;
	}

	public void setManagement(int management) {
		this.management = management;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TimeLineStructure [id=" + id + ", functional=" + functional + ", administrative=" + administrative
				+ ", management=" + management + "]";
	}

	public TimeLineStructure(int id, int functional, int administrative, int management) {
		super();
		this.id = id;
		this.functional = functional;
		this.administrative = administrative;
		this.management = management;
	}

	public TimeLineStructure() {
		super();
		// TODO Auto-generated constructor stub
	}

}
