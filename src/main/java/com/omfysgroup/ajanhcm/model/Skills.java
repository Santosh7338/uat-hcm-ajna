package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADD_SKILLS")
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
	@SequenceGenerator(name = "skill_seq", sequenceName = "ADD_SKILLS_SEQ", allocationSize = 1)
    @Column(name="SKILL_ID")
   private int skill_Id;
    @Column(name="SKILLS")
   private String skills_Name;
    @Column(name="TECHNOLOGY")
   private String technology; 
    
	public int getSkill_Id() {
		return skill_Id;
	}
	public void setSkill_Id(int skill_Id) {
		this.skill_Id = skill_Id;
	}
	public String getSkills_Name() {
		return skills_Name;
	}
	public void setSkills_Name(String skills_Name) {
		this.skills_Name = skills_Name;
	}
	
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	@Override
	public String toString() {
		return "Skills [skill_Id=" + skill_Id + ", skills_Name=" + skills_Name + ", technology=" + technology + "]";
	}
	

    
	
}
