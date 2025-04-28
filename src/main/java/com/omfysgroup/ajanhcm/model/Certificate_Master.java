package com.omfysgroup.ajanhcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CERTIFICATION_MASTER")
public class Certificate_Master {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificate_mstr_seq")
	@SequenceGenerator(name = "certificate_mstr_seq", sequenceName = "CERTIFICATION_MASTER_SEQ", allocationSize = 1)
	
	@Column(name = "CER_MSTER_ID")
	private int cert_mstr_id;
	
	@Column(name = "CERTIFICATE_ID")
	private String certif_id;
	
	@Column(name = "CERTIFICATION_NAME")
	private String certificate_name;
	
	@Column(name = "CERTIFICATION_TYPE")
	private String certificate_type;
	
	@Column(name = "PRACTICE")
	private String practice;
	
	@Column(name = "TECHNOLOGY")
	private String technology;
	
	@Column(name = "CERTIFYING_AUTHORITY")
	private String certify_authority;
	
	@Column(name = "CERTIFICATION_MODE")
	private String certification_mode;
	
	@Column(name = "COMPETENCIES")
	private String competency;
	
	@Column(name = "CERTIFICATION")
	private String certificate;
	
	@Column(name = "REMARKS")
	private String remark;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "CREATION_DATE", updatable = false)
	private Date creation_date;
	
	@Column(name = "IS_ACTIVE")
	private String is_activate;
	
	@Column(name = "PAID_NOTPAID")
	private String paid_notpaid;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATED_DATE", updatable = false)
	private Date last_updated_date;

	public int getCert_mstr_id() {
		return cert_mstr_id;
	}

	public void setCert_mstr_id(int cert_mstr_id) {
		this.cert_mstr_id = cert_mstr_id;
	}

	public String getCertif_id() {
		return certif_id;
	}

	public void setCertif_id(String certif_id) {
		this.certif_id = certif_id;
	}

	public String getCertificate_name() {
		return certificate_name;
	}

	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}

	public String getCertificate_type() {
		return certificate_type;
	}

	public void setCertificate_type(String certificate_type) {
		this.certificate_type = certificate_type;
	}

	public String getPractice() {
		return practice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getCertify_authority() {
		return certify_authority;
	}

	public void setCertify_authority(String certify_authority) {
		this.certify_authority = certify_authority;
	}

	public String getCertification_mode() {
		return certification_mode;
	}

	public void setCertification_mode(String certification_mode) {
		this.certification_mode = certification_mode;
	}

	public String getCompetency() {
		return competency;
	}

	public void setCompetency(String competency) {
		this.competency = competency;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getIs_activate() {
		return is_activate;
	}

	public void setIs_activate(String is_activate) {
		this.is_activate = is_activate;
	}

	public Date getLast_updated_date() {
		return last_updated_date;
	}

	public void setLast_updated_date(Date last_updated_date) {
		this.last_updated_date = last_updated_date;
	}

	public String getPaid_notpaid() {
		return paid_notpaid;
	}

	public void setPaid_notpaid(String paid_notpaid) {
		this.paid_notpaid = paid_notpaid;
	}
	
	
}
