package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRE_J")
public class PreJoining_Bloodgroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_joining_bg_seq")
	@SequenceGenerator(name = "pre_joining_bg_seq", sequenceName = "PRE_JOINING_BLOODGROUP_SEQ", allocationSize = 1)
	
	@Column(name = "PRE_BLOODGROUP_ID")
    private int pre_bg_id;
	
	@Column(name = "PRE_BLOODGROUP_NAME")
	private String pre_bg_name;

	public int getPre_bg_id() {
		return pre_bg_id;
	}

	public void setPre_bg_id(int pre_bg_id) {
		this.pre_bg_id = pre_bg_id;
	}

	public String getPre_bg_name() {
		return pre_bg_name;
	}

	public void setPre_bg_name(String pre_bg_name) {
		this.pre_bg_name = pre_bg_name;
	}
		
	
	
	

}
