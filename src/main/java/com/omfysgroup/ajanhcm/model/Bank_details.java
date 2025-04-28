package com.omfysgroup.ajanhcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_DETAILS")
public class Bank_details {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_details_seq")
	@SequenceGenerator(name = "bank_details_seq", sequenceName = "BANK_DETAILS_SEQ", allocationSize = 1)
	
	@Column(name = "BANK_ID")
	private int bank_id;
	
	@Column(name = "BANK_NAME")
	private String bank_name;
	
	@Column(name = "BRANCH_NAME")
	private String branch_name;
	
	@Column(name = "ACCOUNT_NUMBER")
	private String acco_number;
	
	@Column(name = "IFSC_CODE")
	private String ifsc_code;
	
	@Column(name = "PF_APPLICABLE")
	private String pf_applicable;
	
	@Column(name = "UAN_NUMBER")
	private String uan_numbee;
	
	@Column(name = "ESIC_APPLICABLE")
	private String esic_applicable;
	
	@Column(name = "INSURANCE_NUMBER")
	private String insurance_number;

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getAcco_number() {
		return acco_number;
	}

	public void setAcco_number(String acco_number) {
		this.acco_number = acco_number;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getPf_applicable() {
		return pf_applicable;
	}

	public void setPf_applicable(String pf_applicable) {
		this.pf_applicable = pf_applicable;
	}

	public String getUan_numbee() {
		return uan_numbee;
	}

	public void setUan_numbee(String uan_numbee) {
		this.uan_numbee = uan_numbee;
	}

	public String getEsic_applicable() {
		return esic_applicable;
	}

	public void setEsic_applicable(String esic_applicable) {
		this.esic_applicable = esic_applicable;
	}

	public String getInsurance_number() {
		return insurance_number;
	}

	public void setInsurance_number(String insurance_number) {
		this.insurance_number = insurance_number;
	}
	
	
	
}
