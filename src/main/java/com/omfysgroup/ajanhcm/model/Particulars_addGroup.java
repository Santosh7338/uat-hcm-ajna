package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PARTICULAR_ADD_GRP")
public class Particulars_addGroup {
	
@Id	
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "part_add_seq")
@SequenceGenerator(name = "part_add_seq", sequenceName = "PART_ADD_SEQ", allocationSize = 1)

private int part_id;

@Column(name="PART_NAME")
private String part_name;

@Column(name="IS_ACTTIVATED")
private String is_activated;



public int getPart_id() {
	return part_id;
}

public void setPart_id(int part_id) {
	this.part_id = part_id;
}

public String getPart_name() {
	return part_name;
}

public void setPart_name(String part_name) {
	this.part_name = part_name;
}

public String getIs_activated() {
	return is_activated;
}

public void setIs_activated(String is_activated) {
	this.is_activated = is_activated;
}


}
