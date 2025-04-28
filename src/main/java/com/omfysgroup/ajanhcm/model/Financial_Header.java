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
@Table(name="FINANCIAL_HEADER")
public class Financial_Header {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_header_seq")
	@SequenceGenerator(name = "financial_header_seq", sequenceName = "FINANCIAL_HEADER_SEQ", allocationSize = 1)
	
	@Column(name="FINA_HEADER_ID")
	private int headerid;
	
	@Column(name="TOTAL1")
	private int total1;
	
	@Column(name="TOTAL2")
	private int total2;
	
	@Column(name="NET_PAID")
	private int net_paid;
	
	@Column(name="NET_TAKEN")
	private int net_taken;
	
	@Column(name="FINANCIAL_CLEARANCE")
	private String financial_clearance;
	
	@Column(name="REMARKS")
	private String financial_remarks;
	
	@Column(name="ADDITIONAL_REMARKS")
	private String additional_remarks;
	
	@ManyToOne
	@JoinColumn(name="EXIT_ID")
	private MarkExitScreen exit_id;
	
	@ManyToOne
	@JoinColumn(name = "EMPID")
	private Employee_Master emp_id;
	
	

	public int getHeaderid() {
		return headerid;
	}

	public void setHeaderid(int headerid) {
		this.headerid = headerid;
	}

	public int getTotal1() {
		return total1;
	}

	public void setTotal1(int total1) {
		this.total1 = total1;
	}

	public int getTotal2() {
		return total2;
	}

	public void setTotal2(int total2) {
		this.total2 = total2;
	}

	public int getNet_paid() {
		return net_paid;
	}

	public void setNet_paid(int net_paid) {
		this.net_paid = net_paid;
	}

	public int getNet_taken() {
		return net_taken;
	}

	public void setNet_taken(int net_taken) {
		this.net_taken = net_taken;
	}

	public String getFinancial_clearance() {
		return financial_clearance;
	}

	public void setFinancial_clearance(String financial_clearance) {
		this.financial_clearance = financial_clearance;
	}

	public String getFinancial_remarks() {
		return financial_remarks;
	}

	public void setFinancial_remarks(String financial_remarks) {
		this.financial_remarks = financial_remarks;
	}

	public String getAdditional_remarks() {
		return additional_remarks;
	}

	public void setAdditional_remarks(String additional_remarks) {
		this.additional_remarks = additional_remarks;
	}

	public MarkExitScreen getExit_id() {
		return exit_id;
	}

	public void setExit_id(MarkExitScreen exit_id) {
		this.exit_id = exit_id;
	}

	public Employee_Master getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Employee_Master emp_id) {
		this.emp_id = emp_id;
	}

	
	
	

}
