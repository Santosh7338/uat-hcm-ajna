package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ASSESSMENT_LINES")
public class Assessment_Lines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TrainingAssLines")
	@SequenceGenerator(name = "TrainingAssLines", sequenceName = "TRAININGASSLINES", allocationSize = 1)
	private int assLineId;
	
	@ManyToOne
	@JoinColumn(name="ASSID")
	private Assessment assid;
	
	@ManyToOne
	@JoinColumn(name="ASSESSOR")
	private Employee_Master assessor;
	
	@Column(name="COMPENTENCIES")
	private String compentencies;
	
	@Column(name="REQRAT")
	private int reuiredRating;
	
	@Column(name="CURRAT")
	private int currentRating;
	
	@Column(name="GAP")
	private int gap;
	
	@Column(name="REAMRK")
	private String remark;
	
	@Column(name="AVGREQ")
	private double avgreq;
	
	@Column(name="AVGCUR")
	private double avgCurrent;
	
	@Column(name="AVGGAP")
	private double avggap;
	
	@Column(name="CURRLEVPER")
	private double currLevPercentage;

	public int getAssLineId() {
		return assLineId;
	}

	public void setAssLineId(int assLineId) {
		this.assLineId = assLineId;
	}

	public Assessment getAssid() {
		return assid;
	}

	public void setAssid(Assessment assid) {
		this.assid = assid;
	}

	

	public Employee_Master getAssessor() {
		return assessor;
	}

	public void setAssessor(Employee_Master assessor) {
		this.assessor = assessor;
	}

	

	public String getCompentencies() {
		return compentencies;
	}

	public void setCompentencies(String compentencies) {
		this.compentencies = compentencies;
	}

	public int getReuiredRating() {
		return reuiredRating;
	}

	public void setReuiredRating(int reuiredRating) {
		this.reuiredRating = reuiredRating;
	}

	public int getCurrentRating() {
		return currentRating;
	}

	public void setCurrentRating(int currentRating) {
		this.currentRating = currentRating;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public double getAvgreq() {
		return avgreq;
	}

	public void setAvgreq(double avgreq) {
		this.avgreq = avgreq;
	}

	public double getAvgCurrent() {
		return avgCurrent;
	}

	public void setAvgCurrent(double avgCurrent) {
		this.avgCurrent = avgCurrent;
	}

	public double getAvggap() {
		return avggap;
	}

	public void setAvggap(double avggap) {
		this.avggap = avggap;
	}

	public double getCurrLevPercentage() {
		return currLevPercentage;
	}

	public void setCurrLevPercentage(double currLevPercentage) {
		this.currLevPercentage = currLevPercentage;
	}
	
}
