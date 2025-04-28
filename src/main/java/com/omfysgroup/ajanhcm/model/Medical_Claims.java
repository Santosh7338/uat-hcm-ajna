package com.omfysgroup.ajanhcm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICAL_CLAIMS")
public class Medical_Claims implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicalclaimstrg")
	@SequenceGenerator(name = "medicalclaimstrg", sequenceName = "MEDICAL_CLAIMS_SEQ", allocationSize = 1)
	@Column(name = "MDID")
	private int mdid;
	
	@Column(name = "EMP_ID")
	private int emp_id;
	
	@Column(name = "MARITAL_STATUS")
	private String marital_status;
	
	@Column(name = "PER_INSURANCE_DOC")
	private String per_insurance_doc;
	
	@Column(name = "FAMILY_INSURANCE_DOC")
	private String family_insurance_doc;

	public int getMdid() {
		return mdid;
	}

	public void setMdid(int mdid) {
		this.mdid = mdid;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}

	public String getPer_insurance_doc() {
		return per_insurance_doc;
	}

	public void setPer_insurance_doc(String per_insurance_doc) {
		this.per_insurance_doc = per_insurance_doc;
	}

	public String getFamily_insurance_doc() {
		return family_insurance_doc;
	}

	public void setFamily_insurance_doc(String family_insurance_doc) {
		this.family_insurance_doc = family_insurance_doc;
	}
	
	

}
