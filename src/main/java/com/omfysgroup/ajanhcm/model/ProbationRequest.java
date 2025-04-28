package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PROBATION_REQUEST")
public class ProbationRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "probation_seq")
	@SequenceGenerator(name = "probation_seq", sequenceName = "PROBATION_REQUEST_SEQ", allocationSize = 1)

	@Column(name = "PR_ID")
	private int pr_id;

	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee_Master emp_id;

	@Column(name = "STATUS")
	private String status;

	@ManyToOne
	@JoinColumn(name = "AR_ID")
	private Employee_Master ar_id;

	@Column(name = "CREATED_BY", updatable = false)
	private int created_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date = new java.sql.Date(new java.util.Date().getTime());

	@Transient
	private String creation_date1;
	
	public String getCreation_date1() {
		return creation_date1;
	}

	public void setCreation_date1(String creation_date1) {
		this.creation_date1 = creation_date1;
	}

	@Column(name = "LAST_UPDATED_BY", updatable = true)
	private int last_updated_by;

	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = true)
	private Date last_update_date = new java.sql.Date(new java.util.Date().getTime());
	
	@Column(name = "AVG_RATE")
	private float avg_rate;

	@Column(name = "PER_RATE")
	private float per_rate;

	@Column(name = "SPE_REMARK")
	private String spe_remark;

	@Column(name = "PROB_EXTENSION")
	private String prob_extension;

	@Column(name = "PROB_DISCONTINUE")
	private String prob_discontinue;

	@Column(name = "CONFIRM")
	private String confirm;

	@Column(name = "EXTENSION_DATE")
	private Date extension_date;
	
	@Transient
	private String extension_date1;

	@Column(name = "DISCONTINUE_DATE")
	private Date discontinue_date;
	
	@Transient
	private String discontinue_date1;

	
	@Column(name = "AVG_RATE_HR")
	private float avg_rate_hr;
	
	@Column(name= "DESIGION_HR")
	private String desigion_hr;
	
	
	@Column(name= "DESIGION_AR")
	private String desigion_ar;
	
	@Column(name = "PER_RATE_HR")
	private float per_rate_hr;

	@Column(name = "SPE_REMARK_HR")
	private String spe_remark_hr;

	@Column(name = "PROB_EXTENSION_HR")
	private String prob_extension_hr;

	@Column(name = "PROB_DISCONTINUE_HR")
	private String prob_discontinue_hr;

	@Column(name = "CONFIRM_HR")
	private String confirm_hr;

	@Column(name = "EXTENSION_DATE_HR")
	private Date extension_date_hr;
	
	@Transient
	private String extension_date_hr1;

	@Column(name = "DISCONTINUE_DATE_HR")
	private Date discontinue_date_hr;

	@Transient
	private String discontinue_date_hr1;

	@Column(name = "CONFIRM_DATE")
	private Date confirm_date;
	
	@Transient
	private String confirm_date1;

	@Column(name = "PROMOTION")
	private String promotion;
	
	@ManyToOne
	@JoinColumn(name = "DESIGNATION_ID")
	private Designation_Master designation;
	
	@Column(name = "CTC_INCREMENT")
	private String ctc_increment;
	
	@Column(name = "INCREASED_CTC")
	private float increased_ctc;

	public float getAvg_rate_hr() {
		return avg_rate_hr;
	}

	public void setAvg_rate_hr(float avg_rate_hr) {
		this.avg_rate_hr = avg_rate_hr;
	}

	public float getPer_rate_hr() {
		return per_rate_hr;
	}

	public void setPer_rate_hr(float per_rate_hr) {
		this.per_rate_hr = per_rate_hr;
	}

	public String getSpe_remark_hr() {
		return spe_remark_hr;
	}

	public void setSpe_remark_hr(String spe_remark_hr) {
		this.spe_remark_hr = spe_remark_hr;
	}

	public String getProb_extension_hr() {
		return prob_extension_hr;
	}

	public String getDesigion_ar() {
		return desigion_ar;
	}

	public void setDesigion_ar(String desigion_ar) {
		this.desigion_ar = desigion_ar;
	}
	
	public void setProb_extension_hr(String prob_extension_hr) {
		this.prob_extension_hr = prob_extension_hr;
	}

	public String getProb_discontinue_hr() {
		return prob_discontinue_hr;
	}

	public void setProb_discontinue_hr(String prob_discontinue_hr) {
		this.prob_discontinue_hr = prob_discontinue_hr;
	}

	public String getConfirm_hr() {
		return confirm_hr;
	}

	public void setConfirm_hr(String confirm_hr) {
		this.confirm_hr = confirm_hr;
	}

	public Date getExtension_date_hr() {
		return extension_date_hr;
	}

	public void setExtension_date_hr(Date extension_date_hr) {
		this.extension_date_hr = extension_date_hr;
	}

	public Date getDiscontinue_date_hr() {
		return discontinue_date_hr;
	}

	public void setDiscontinue_date_hr(Date discontinue_date_hr) {
		this.discontinue_date_hr = discontinue_date_hr;
	}

	public String getDesigion_hr() {
		return desigion_hr;
	}

	public void setDesigion_hr(String desigion_hr) {
		this.desigion_hr = desigion_hr;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public Designation_Master getDesignation() {
		return designation;
	}

	public void setDesignation(Designation_Master designation) {
		this.designation = designation;
	}

	public String getCtc_increment() {
		return ctc_increment;
	}

	public void setCtc_increment(String ctc_increment) {
		this.ctc_increment = ctc_increment;
	}

	public float getIncreased_ctc() {
		return increased_ctc;
	}

	public void setIncreased_ctc(float increased_ctc) {
		this.increased_ctc = increased_ctc;
	}


	public float getAvg_rate() {
		return avg_rate;
	}

	public void setAvg_rate(float avg_rate) {
		this.avg_rate = avg_rate;
	}

	public float getPer_rate() {
		return per_rate;
	}

	public void setPer_rate(float per_rate) {
		this.per_rate = per_rate;
	}

	public String getSpe_remark() {
		return spe_remark;
	}

	public void setSpe_remark(String spe_remark) {
		this.spe_remark = spe_remark;
	}

	public String getProb_extension() {
		return prob_extension;
	}

	public void setProb_extension(String prob_extension) {
		this.prob_extension = prob_extension;
	}

	public String getProb_discontinue() {
		return prob_discontinue;
	}

	public void setProb_discontinue(String prob_discontinue) {
		this.prob_discontinue = prob_discontinue;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getExtension_date() {
		return extension_date;
	}

	public void setExtension_date(Date extension_date) {
		this.extension_date = extension_date;
	}

	public Date getDiscontinue_date() {
		return discontinue_date;
	}

	public void setDiscontinue_date(Date discontinue_date) {
		this.discontinue_date = discontinue_date;
	}

	public Date getConfirm_date() {
		return confirm_date;
	}

	public void setConfirm_date(Date confirm_date) {
		this.confirm_date = confirm_date;
	}

	public int getPr_id() {
		return pr_id;
	}

	public void setPr_id(int pr_id) {
		this.pr_id = pr_id;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee_Master getAr_id() {
		return ar_id;
	}

	public void setAr_id(Employee_Master aR_ID) {
		ar_id = aR_ID;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(int last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}

	public String getExtension_date1() {
		return extension_date1;
	}

	public void setExtension_date1(String extension_date1) {
		this.extension_date1 = extension_date1;
	}

	public String getDiscontinue_date1() {
		return discontinue_date1;
	}

	public void setDiscontinue_date1(String discontinue_date1) {
		this.discontinue_date1 = discontinue_date1;
	}

	public String getExtension_date_hr1() {
		return extension_date_hr1;
	}

	public void setExtension_date_hr1(String extension_date_hr1) {
		this.extension_date_hr1 = extension_date_hr1;
	}

	public String getDiscontinue_date_hr1() {
		return discontinue_date_hr1;
	}

	public void setDiscontinue_date_hr1(String discontinue_date_hr1) {
		this.discontinue_date_hr1 = discontinue_date_hr1;
	}

	public String getConfirm_date1() {
		return confirm_date1;
	}

	public void setConfirm_date1(String confirm_date1) {
		this.confirm_date1 = confirm_date1;
	}

	@Override
	public String toString() {
		return "ProbationRequest [pr_id=" + pr_id + ", emp_id=" + emp_id + ", status=" + status + ", ar_id=" + ar_id
				+ ", created_by=" + created_by + ", creation_date=" + creation_date + ", last_updated_by="
				+ last_updated_by + ", last_update_date=" + last_update_date + ", avg_rate=" + avg_rate + ", per_rate="
				+ per_rate + ", spe_remark=" + spe_remark + ", prob_extension=" + prob_extension + ", prob_discontinue="
				+ prob_discontinue + ", confirm=" + confirm + ", extension_date=" + extension_date
				+ ", discontinue_date=" + discontinue_date + ", avg_rate_hr=" + avg_rate_hr + ", per_rate_hr="
				+ per_rate_hr + ", spe_remark_hr=" + spe_remark_hr + ", prob_extension_hr=" + prob_extension_hr
				+ ", prob_discontinue_hr=" + prob_discontinue_hr + ", confirm_hr=" + confirm_hr + ", extension_date_hr="
				+ extension_date_hr + ", discontinue_date_hr=" + discontinue_date_hr + ", confirm_date=" + confirm_date
				+ ", promotion=" + promotion + ", designation=" + designation + ", ctc_increment=" + ctc_increment
				+ ", increased_ctc=" + increased_ctc + "]";
	}

	public ProbationRequest(int pr_id, Employee_Master emp_id, String status, Employee_Master ar_id, int created_by,
			Date creation_date, int last_updated_by, Date last_update_date, float avg_rate, float per_rate,
			String spe_remark, String prob_extension, String prob_discontinue, String confirm, Date extension_date,
			Date discontinue_date, float avg_rate_hr, float per_rate_hr, String spe_remark_hr, String prob_extension_hr,
			String prob_discontinue_hr, String confirm_hr, Date extension_date_hr, Date discontinue_date_hr,
			Date confirm_date, String promotion, Designation_Master designation, String ctc_increment,
			float increased_ctc) {
				super();
				this.pr_id = pr_id;
				this.emp_id = emp_id;
				this.status = status;
				this.ar_id = ar_id;
				this.created_by = created_by;
				this.creation_date = creation_date;
				this.last_updated_by = last_updated_by;
				this.last_update_date = last_update_date;
				this.avg_rate = avg_rate;
				this.per_rate = per_rate;
				this.spe_remark = spe_remark;
				this.prob_extension = prob_extension;
				this.prob_discontinue = prob_discontinue;
				this.confirm = confirm;
				this.extension_date = extension_date;
				this.discontinue_date = discontinue_date;
				this.avg_rate_hr = avg_rate_hr;
				this.per_rate_hr = per_rate_hr;
				this.spe_remark_hr = spe_remark_hr;
				this.prob_extension_hr = prob_extension_hr;
				this.prob_discontinue_hr = prob_discontinue_hr;
				this.confirm_hr = confirm_hr;
				this.extension_date_hr = extension_date_hr;
				this.discontinue_date_hr = discontinue_date_hr;
				this.confirm_date = confirm_date;
				this.promotion = promotion;
				this.designation = designation;
				this.ctc_increment = ctc_increment;
				this.increased_ctc = increased_ctc;
	}

	public ProbationRequest() {
		// TODO Auto-generated constructor stub
	}

	

}
