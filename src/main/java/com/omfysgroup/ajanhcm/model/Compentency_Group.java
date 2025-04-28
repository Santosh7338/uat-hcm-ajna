package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COMPENTENCY_GROUP")
public class Compentency_Group 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_gr_seq")
	@SequenceGenerator(name = "comp_gr_seq", sequenceName = "COMP_GROUP_SEQ", allocationSize = 1)
	
	private int comp_gr_id;
	
	@Column(name="COMP_NAME")
	private String comp_name;
	
	@Column(name="ABBREVIATION")
	private String abbreviation;
	
	@Column(name="IS_ACTIVATED")
	private String is_activated;

	public int getComp_gr_id() {
		return comp_gr_id;
	}

	public void setComp_gr_id(int comp_gr_id) {
		this.comp_gr_id = comp_gr_id;
	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getIs_activated() {
		return is_activated;
	}

	public void setIs_activated(String is_activated) {
		this.is_activated = is_activated;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}	
	
	
	
}
