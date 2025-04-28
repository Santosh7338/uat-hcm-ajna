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
@Table(name="PRE_BANK_DETAILS")
public class Pre_Bank_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_bank_seq")
	@SequenceGenerator(name = "pre_bank_seq", sequenceName = "PRE_BANK_DETAILS_SEQ", allocationSize = 1)
	
	@Column(name = "BANK_ID")
    private int bank_id;
	
	@Column(name = "PF_APPLICABLE")
    private String pf_applicable;
	
	@Column(name = "UAN_NUMBER")
    private String uan_number;
	
	@Column(name = "ESIC_APPLICABLE")
    private String esic_applicable;
	
	@Column(name = "INSURANCE_NUMBER")
	private String insurance_number;
	
	@Column(name = "BANK_NAME")
	private String bank_name;
	
	@Column(name = "BRANCH_NAME")
	private String branch_name;
	
	@Column(name = "ACCOUNT_NUMBER")
	private String account_number;
	
	@Column(name = "IFSC_CODE")
	private String ifsc_code;
	
	@Column(name = "PERSONAL_ID")
	private int personal_id;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy hh:mm:ss")
	@Column(name = "LAST_UPDATE_DATE", updatable = false)
	private Date last_update_date;

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getPf_applicable() {
		return pf_applicable;
	}

	public void setPf_applicable(String pf_applicable) {
		this.pf_applicable = pf_applicable;
	}

	public String getUan_number() {
		return uan_number;
	}

	public void setUan_number(String uan_number) {
		this.uan_number = uan_number;
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

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public int getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public Date getLast_update_date() {
		return last_update_date;
	}

	public void setLast_update_date(Date last_update_date) {
		this.last_update_date = last_update_date;
	}
	
	
}
