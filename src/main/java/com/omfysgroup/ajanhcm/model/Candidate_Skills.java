package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CANDIDATE_SKILLS")

public class Candidate_Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_skill_seq")
	@SequenceGenerator(name = "candidate_skill_seq", sequenceName = "CANDIDATE_SKILLS_SEQ", allocationSize = 1)
	
	
@Column(name="CANDIDATE_SKILLS_ID")
public int candidateSkill_Id;
@Column(name="CANDIDATE_ID")	
public int candidate_Id;
@Column(name="SKILLS")
public String skills;
public int getCandidateSkill_Id() {
	return candidateSkill_Id;
}
public void setCandidateSkill_Id(int candidateSkill_Id) {
	this.candidateSkill_Id = candidateSkill_Id;
}
public int getCandidate_Id() {
	return candidate_Id;
}
public void setCandidate_Id(int candidate_Id) {
	this.candidate_Id = candidate_Id;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
@Override
public String toString() {
	return "Candidate_Skills [candidateSkill_Id=" + candidateSkill_Id + ", candidate_Id=" + candidate_Id + ", skills="
			+ skills + "]";
}




}
