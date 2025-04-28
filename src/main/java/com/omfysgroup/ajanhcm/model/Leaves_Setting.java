package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "LEAVES_SETTING")
public class Leaves_Setting {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "LEAVES_SETTING_SEQ", allocationSize = 1)

	@Column(name = "LS_ID")
	private int ls_id;

	@Column(name = "LEAVES_COMBINATION_ALLOW")
	private String leaves_combination_allow;

	@Column(name = "PRIOR_DAYS")
	private int prior_days;

	@Column(name = "AFTER_DAYS")
	private int after_days;

	@Column(name = "FR_TIMELINE")
	private int fr_timeline;

	@Column(name = "MGNT_TIMELINE")
	private int mgnt_timeline;

	@Column(name = "AR_TIMELINE")
	private int ar_timeline;

	@Column(name = "PREFIX_WEEKEND")
	private String prefix_weekend;

	@Column(name = "SUFFIX_WEEKEND")
	private String suffix_weekend;

	@Column(name = "PREFIX_HOLIDAYS")
	private String prefix_holidays;

	@Column(name = "SUFFIX_HOLIDAYS")
	private String suffix_holidays;

	@Column(name = "MGNT_APPROVAL_LEAVES")
	private int mgnt_approval_leaves;

	@Column(name = "MGNT_APPROVAL")
	private String MGNT_APPROVAL;

	@Column(name = "APPROVAL_FROM")
	private Date approval_from;

	@Column(name = "APPROVAL_UPTO")
	private Date approval_upto;
	
	@Column(name = "LEAVE_TYPE")
	private int leave_type;

	@Column(name = "LEAVES_COMBINATION")
	private String leaves_combination;
	
	/*@Column(name = "CONVERT_TO_DAY_BEFORE_DAYS")     //commented By Pritee
	private int convert_to_day_before_days;*/

	@Transient
	private String approval_from_str;

	@Transient
	private String approval_upto_str;

	@Transient
	private String leaveTypeString;

	@Transient
	private String leaveComboString;
	


	public String getLeaveComboString() {
		return leaveComboString;
	}

	public void setLeaveComboString(String leaveComboString) {
		this.leaveComboString = leaveComboString;
	}

	public String getLeaveTypeString() {
		return leaveTypeString;
	}

	public void setLeaveTypeString(String leaveTypeString) {
		this.leaveTypeString = leaveTypeString;
	}

	public String getApproval_from_str() {
		return approval_from_str;
	}

	public void setApproval_from_str(String approval_from_str) {
		this.approval_from_str = approval_from_str;
	}

	public String getApproval_upto_str() {
		return approval_upto_str;
	}

	public void setApproval_upto_str(String approval_upto_str) {
		this.approval_upto_str = approval_upto_str;
	}

	

	public int getLs_id() {
		return ls_id;
	}

	public void setLs_id(int ls_id) {
		this.ls_id = ls_id;
	}

	public int getPrior_days() {
		return prior_days;
	}

	public void setPrior_days(int prior_days) {
		this.prior_days = prior_days;
	}

	public int getAfter_days() {
		return after_days;
	}

	public void setAfter_days(int after_days) {
		this.after_days = after_days;
	}

	public int getFr_timeline() {
		return fr_timeline;
	}

	public void setFr_timeline(int fr_timeline) {
		this.fr_timeline = fr_timeline;
	}

	public int getMgnt_timeline() {
		return mgnt_timeline;
	}

	public void setMgnt_timeline(int mgnt_timeline) {
		this.mgnt_timeline = mgnt_timeline;
	}

	public int getAr_timeline() {
		return ar_timeline;
	}

	public void setAr_timeline(int ar_timeline) {
		this.ar_timeline = ar_timeline;
	}

	public String getPrefix_weekend() {
		return prefix_weekend;
	}

	public void setPrefix_weekend(String prefix_weekend) {
		this.prefix_weekend = prefix_weekend;
	}

	public String getSuffix_weekend() {
		return suffix_weekend;
	}

	public void setSuffix_weekend(String suffix_weekend) {
		this.suffix_weekend = suffix_weekend;
	}

	public String getPrefix_holidays() {
		return prefix_holidays;
	}

	public void setPrefix_holidays(String prefix_holidays) {
		this.prefix_holidays = prefix_holidays;
	}

	public String getSUFFIX_HOLIDAYS() {
		return suffix_holidays;
	}

	public void setSUFFIX_HOLIDAYS(String suffix_holidays) {
		this.suffix_holidays = suffix_holidays;
	}

	public int getMgnt_approval_leaves() {
		return mgnt_approval_leaves;
	}

	public void setMgnt_approval_leaves(int mgnt_approval_leaves) {
		this.mgnt_approval_leaves = mgnt_approval_leaves;
	}

	public Date getApproval_from() {
		return approval_from;
	}

	public void setApproval_from(Date approval_from) {
		this.approval_from = approval_from;
	}

	public Date getApproval_upto() {
		return approval_upto;
	}

	public void setApproval_upto(Date approval_upto) {
		this.approval_upto = approval_upto;
	}

	public int getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(int leave_type) {
		this.leave_type = leave_type;
	}

	public String getLeaves_combination() {
		return leaves_combination;
	}

	public void setLeaves_combination(String leaves_combination) {
		this.leaves_combination = leaves_combination;
	}

	public String getLeaves_combination_allow() {
		return leaves_combination_allow;
	}

	public void setLeaves_combination_allow(String leaves_combination_allow) {
		this.leaves_combination_allow = leaves_combination_allow;
	}

	public String getSuffix_holidays() {
		return suffix_holidays;
	}

	public void setSuffix_holidays(String suffix_holidays) {
		this.suffix_holidays = suffix_holidays;
	}

	public String getMGNT_APPROVAL() {
		return MGNT_APPROVAL;
	}

	public void setMGNT_APPROVAL(String mGNT_APPROVAL) {
		MGNT_APPROVAL = mGNT_APPROVAL;
	}
	
	/*public int getConvert_to_day_before_days() {
		return convert_to_day_before_days;
	}

	public void setConvert_to_day_before_days(int convert_to_day_before_days) {
		this.convert_to_day_before_days = convert_to_day_before_days;
	}*/

	public Leaves_Setting(int ls_id, int prior_days, int after_days, int fr_timeline, int mgnt_timeline,
			int ar_timeline, String prefix_weekend, String suffix_weekend, String prefix_holidays,
			String sUFFIX_HOLIDAYS, int mgnt_approval_leaves, Date approval_from, Date approval_upto, int leave_type,
			String leaves_combination) {
		super();
		this.ls_id = ls_id;
		this.prior_days = prior_days;
		this.after_days = after_days;
		this.fr_timeline = fr_timeline;
		this.mgnt_timeline = mgnt_timeline;
		this.ar_timeline = ar_timeline;
		this.prefix_weekend = prefix_weekend;
		this.suffix_weekend = suffix_weekend;
		this.prefix_holidays = prefix_holidays;
		this.suffix_holidays = sUFFIX_HOLIDAYS;
		this.mgnt_approval_leaves = mgnt_approval_leaves;
		this.approval_from = approval_from;
		this.approval_upto = approval_upto;
		this.leave_type = leave_type;
		this.leaves_combination = leaves_combination;
	}
	
	

	

	public Leaves_Setting() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Leaves_Setting [ls_id=" + ls_id + ", prior_days=" + prior_days + ", after_days=" + after_days
				+ ", fr_timeline=" + fr_timeline + ", mgnt_timeline=" + mgnt_timeline + ", ar_timeline=" + ar_timeline
				+ ", prefix_weekend=" + prefix_weekend + ", suffix_weekend=" + suffix_weekend + ", prefix_holidays="
				+ prefix_holidays + ", SUFFIX_HOLIDAYS=" + suffix_holidays + ", mgnt_approval_leaves="
				+ mgnt_approval_leaves + ", approval_from=" + approval_from + ", approval_upto=" + approval_upto
				+ ", leave_type=" + leave_type + ", leaves_combination=" + leaves_combination + "]";
	}

}
