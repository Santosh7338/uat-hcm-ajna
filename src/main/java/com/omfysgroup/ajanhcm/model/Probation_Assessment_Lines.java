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
@Table(name = "PROBATION_ASSESSMENT_LINES")
public class Probation_Assessment_Lines {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prb_assessment_lines1")
	@SequenceGenerator(name = "prb_assessment_lines1", sequenceName = "PROBATION_ASSESSMENT_LINES1", allocationSize = 1)
	@Column(name = "PAL_NO")
	private int pal_no;

	@ManyToOne
	@JoinColumn(name = "PR_ID")
	private ProbationRequest pr_id;

	@ManyToOne
	@JoinColumn(name = "PARA_ASS_ID")
	private Parameters_Assess para_ass_id;

	@Column(name = "RATING")
	private int rating;

	@Column(name = "REMARK")
	private String remark;
	
	@Column(name="SUBMITTED_BY")
	private int submitted_by;

	public int getSubmitted_by() {
		return submitted_by;
	}

	public void setSubmitted_by(int submitted_by) {
		this.submitted_by = submitted_by;
	}

	public int getPal_no() {
		return pal_no;
	}

	public void setPal_no(int pal_no) {
		this.pal_no = pal_no;
	}

	public ProbationRequest getPr_id() {
		return pr_id;
	}

	public void setPr_id(ProbationRequest pr_id) {
		this.pr_id = pr_id;
	}

	
	public Parameters_Assess getPara_ass_id() {
		return para_ass_id;
	}

	public void setPara_ass_id(Parameters_Assess para_ass_id) {
		this.para_ass_id = para_ass_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
